package book.controller;

import book.pojo.Order;
import book.pojo.User;
import book.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("checkout")
    public String checkout(HttpSession session){
        User user = (User) session.getAttribute("user");
        Order order = new Order();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowStr = sdf.format(now);
        order.setOrderNo(UUID.randomUUID().toString() + "_" + nowStr);
        order.setOrderDate(now);
        order.setOrderUser(user);
        order.setOrderMoney(user.getCart().getTotalMoney());
        order.setOrderStatus(0);
        orderService.addOrder(order,user.getCart());
        return "redirect:order.html";
    }

    @GetMapping("order.html")
    public String oredrHtml(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Order> orderList = orderService.getOrderList(user);
        user.setOrderList(orderList);
        session.setAttribute("user",user);
        return "order/order";
    }


}
