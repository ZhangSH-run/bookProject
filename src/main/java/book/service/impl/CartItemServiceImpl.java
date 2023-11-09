package book.service.impl;

import book.mapper.CartItemMapper;
import book.pojo.Cart;
import book.pojo.CartItem;
import book.pojo.User;
import book.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemMapper cartItemMapper;
    @Override
    public Cart getCart(User user) {
        List<CartItem> list = cartItemMapper.getCartItemByUserId(user.getId());
        return null;
    }
}
