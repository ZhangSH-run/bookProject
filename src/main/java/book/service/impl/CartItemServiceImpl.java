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

            cartItemMap.put(book.getId(),cartItem);
        }
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);
        return cart;
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemMapper.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemMapper.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
        if (cart != null){
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if (cartItemMap == null){
                cartItemMap = new HashMap<>();
            }
            if (cartItemMap.containsKey(cartItem.getBook().getId())){
                CartItem cartItemValue = cartItemMap.get(cartItem.getBook().getId());
                cartItemValue.setBuyCount(cartItemValue.getBuyCount() + 1);
                this.updateCartItem(cartItemValue);
            }else {
                this.addCartItem(cartItem);
            }
        }else {
            this.addCartItem(cartItem);
        }
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        cartItemMapper.delCartItem(cartItem);
    }
}
