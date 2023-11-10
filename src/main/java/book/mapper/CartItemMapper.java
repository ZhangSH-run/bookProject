package book.mapper;

import book.pojo.CartItem;

import java.util.List;

public interface CartItemMapper {

    List<CartItem> getCartItemByUserId(Integer id);

    void addCartItem(CartItem cartItem);

    void updateCartItem(CartItem cartItem);

    void delCartItem(CartItem cartItem);
}
