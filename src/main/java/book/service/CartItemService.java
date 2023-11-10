package book.service;

import book.pojo.Cart;
import book.pojo.CartItem;
import book.pojo.User;

public interface CartItemService {
    Cart getCart(User user);

    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void addOrUpdateCartItem(CartItem cartItem, Cart cart);

    void delCartItem(CartItem cartItem);
}
