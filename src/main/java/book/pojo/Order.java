package book.pojo;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer id;
    private String orderNo;
    private Date orderDate;
    private User orderUser;
    private Double orderMoney;
    private Integer orderStatus;
    private Integer totalBookCount;

    private List<OrderItem> orderItemList;

    public Order() {
    }

    public Order(Integer id) {
        this.id = id;
    }

    public Order(String orderNo, Date orderDate, User orderUser, Double orderMoney, Integer orderStatus) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderUser = orderUser;
        this.orderMoney = orderMoney;
        this.orderStatus = orderStatus;
    }

    public Order(Integer id, String orderNo, Date orderDate, User orderUser, Double orderMoney, Integer orderStatus) {
        this.id = id;
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderUser = orderUser;
        this.orderMoney = orderMoney;
        this.orderStatus = orderStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void setTotalBookCount(Integer totalBookCount) {
        this.totalBookCount = totalBookCount;
    }

    public Integer getTotalBookCount() {
        return totalBookCount;
    }
}
