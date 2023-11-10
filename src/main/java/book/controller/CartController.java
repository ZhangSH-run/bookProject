package book.controller;

import book.pojo.Book;
import book.pojo.Cart;
import book.pojo.CartItem;
import book.pojo.User;
import book.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Collection;


@Controller
public class CartController {
    @Autowired
    private CartItemService cartItemService;
    @GetMapping("cartIndex")
    public String cartIndex(){
        return "cart/cart";
    }

    @GetMapping("cartInfo")
    @ResponseBody
    public Cart cartInfo(HttpSession session){
        User user = (User) session.getAttribute("user");
        Cart cart = cartItemService.getCart(user);

        //为异步调用时赋值
        cart.getTotalBookCount();
        cart.getTotalMoney();
        cart.getTotalCount();
        user.setCart(cart);
        session.setAttribute("user",user);

        return cart;
    }

    @GetMapping("addCart")
    public String addCart(Integer bookId, HttpSession session){
        User user = (User) session.getAttribute("user");
        CartItem cartItem = new CartItem(new Book(bookId),1,user);
        cartItemService.addOrUpdateCartItem(cartItem,user.getCart());
        return "redirect:cartIndex";
    }
    @PostMapping("editCart")
    @ResponseBody
    public String editCart(Integer cartItemId,Integer buyCount){
        cartItemService.updateCartItem(new CartItem(cartItemId,buyCount));
        return "";
    }

    @PostMapping("delCartItem")
    @ResponseBody
    public String delCartItem(Integer cartItemId){
        cartItemService.delCartItem(new CartItem(cartItemId));
        return "";
    }

    @GetMapping("delCart")
    public String delCart(HttpSession session){
        User user = (User) session.getAttribute("user");
        Collection<CartItem> cartItems = user.getCart().getCartItemMap().values();
        for (CartItem cartItem : cartItems){
            cartItemService.delCartItem(cartItem);
        }
        return "redirect:cartIndex";
    }

}
