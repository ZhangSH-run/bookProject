package book.pojo;

import java.util.Map;
import java.util.Set;

public class Cart {
    private Map<Integer,CartItem> cartItemMap;
    private Double totalMoney;
    private Integer totalCount;
    private Integer totalBookCount;

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0){
            for (CartItem cartItem : cartItemMap.values()){
                totalBookCount += cartItem.getBuyCount();
            }
        }
        return totalBookCount;
    }

    public Cart() {
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney = 0.0;
        if (cartItemMap != null && cartItemMap.size() > 0){
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer, CartItem> map : entries){
                CartItem cartItem = map.getValue();
                totalMoney += cartItem.getXj();
            }
        }
        return totalMoney;
    }

    public Integer getTotalCount() {
        totalCount = 0;
        if (cartItemMap != null){
            totalCount = cartItemMap.size();
        }
        return totalCount;
    }
}
