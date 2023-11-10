package book.controller;

import book.pojo.Cart;
import book.pojo.Order;
import book.pojo.User;
import book.service.CartItemService;
import book.service.OrderService;
import book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private OrderService orderService;

    @PostMapping("login")
    public String login(String uname, String pwd, HttpSession session){
        User user = userService.login(uname, pwd);
        if (user != null){
            //普通用户
            if (user.getRole() == 0){
                Cart cart = cartItemService.getCart(user);
                user.setCart(cart);
                List<Order> orderList = orderService.getOrderList(user);
                user.setOrderList(orderList);
                session.setAttribute("user",user);
                return "redirect:/";
            }else {
                //管理员账户
                session.setAttribute("user",user);
                return "manager/manager";
            }
        }
        return "redirect:/";
    }

    @GetMapping("destory")
    public String destory(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("regist")
    public String regist(String uname, String pwd1, String email, String verifyCode, HttpSession session, HttpServletRequest request){
        Object kaptchaSessionKey = session.getAttribute("KAPTCHA_SESSION_KEY");
        if (kaptchaSessionKey == null || !verifyCode.equals(kaptchaSessionKey)){
            request.setAttribute("KAPTCHA_MESSAGE","验证码错误请重新注册。");
            return "forward:regist.html";
        }else {
            if (kaptchaSessionKey.equals(verifyCode)){
                User user = new User(uname,pwd1,email);
                userService.regist(user);
                return "redirect:login.html";
            }
        }
        return "redirect:/";
    }
    @GetMapping("checkUname")
    @ResponseBody
    public String checkUname(String uname){
        User user = userService.getUserByUsername(uname);
        if (user != null){
            //用户名已经被占用，不可以注册
            return "1";
        }else {
            //用户名可以注册
            return "0";
        }
    }
}
