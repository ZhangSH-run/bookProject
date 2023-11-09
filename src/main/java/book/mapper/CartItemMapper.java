package book.mapper;

import book.pojo.CartItem;

import java.util.List;

public interface CartItemMapper {

    List<CartItem> getCartItemByUserId(Integer id);
}
