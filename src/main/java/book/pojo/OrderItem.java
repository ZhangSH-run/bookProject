package book.pojo;

import java.math.BigDecimal;

public class OrderItem {
    private Integer id;
    private Book book;
    private Integer buyCount;
    private Order orderBean;
    private Double xj;

    public OrderItem() {
    }

    public OrderItem(Integer id) {
        this.id = id;
    }

    public OrderItem(Book book, Integer buyCount, Order orderBean) {
        this.book = book;
        this.buyCount = buyCount;
        this.orderBean = orderBean;
    }

    public OrderItem(Integer id, Book book, Integer buyCount, Order orderBean) {
        this.id = id;
        this.book = book;
        this.buyCount = buyCount;
        this.orderBean = orderBean;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Order getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(Order orderBean) {
        this.orderBean = orderBean;
    }

    public Double getXj() {
        BigDecimal bigDecimalPrice = new BigDecimal("" + this.getBook().getPrice());
        BigDecimal bigDecimalBuyCount = new BigDecimal("" + buyCount);
        BigDecimal bigDecimalXj = bigDecimalPrice.multiply(bigDecimalBuyCount);
        xj = bigDecimalXj.doubleValue();
        return xj;
    }
}
