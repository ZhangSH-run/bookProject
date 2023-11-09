package book.service;

import book.pojo.Cart;
import book.pojo.User;

public interface CartItemService {
    Cart getCart(User user);
}
