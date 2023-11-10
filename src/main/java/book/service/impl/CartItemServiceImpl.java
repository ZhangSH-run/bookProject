package book.service.impl;

import book.mapper.CartItemMapper;
import book.pojo.Book;
import book.pojo.Cart;
import book.pojo.CartItem;
import book.pojo.User;
import book.service.BookService;
import book.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemMapper cartItemMapper;
    @Autowired
    private BookService bookService;
    @Override
    public Cart getCart(User user) {
        List<CartItem> cartItemList = cartItemMapper.getCartItemByUserId(user.getId());
        Map<Integer,CartItem> cartItemMap = new HashMap<>();
        for (CartItem cartItem : cartItemList){
            // 封装book属性
            Integer bookId = cartItem.getBook().getId();
            Book book = bookService.getBookById(bookId);
            cartItem.setBook(book);

            cartItemMap.put(cartItem.getId(),cartItem);
        }
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);
        return cart;
    }
}
