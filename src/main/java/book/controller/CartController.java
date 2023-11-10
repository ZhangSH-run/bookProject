package book.controller;

import book.pojo.Cart;
import book.pojo.User;
import book.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CartController {
    @Autowired
    private CartItemService cartItemService;
    @GetMapping("cartIndex")
    public String cartIndex(){
        return "cart/cart";
    }
}
