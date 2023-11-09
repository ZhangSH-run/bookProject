package book.controller;

import book.pojo.Cart;
import book.pojo.User;
import book.service.CartItemService;
import book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CartItemService cartItemService;

    @PostMapping("login")
    public String login(String uname, String pwd, HttpSession session){
        User user = userService.login(uname, pwd);
        if (user != null){
            //普通用户
            if (user.getRole() == 0){
                Cart cart = cartItemService.getCart(user);
                user.setCart(cart);
                session.setAttribute("user",user);
                return "redirect:bookController.do?oper=index";
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
}
