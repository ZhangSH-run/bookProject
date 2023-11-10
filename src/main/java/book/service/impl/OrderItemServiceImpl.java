package book.service.impl;

import book.mapper.OrderItemMapper;
import book.pojo.OrderItem;
import book.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItem> getOrderItemList(Integer orderId) {
        List<OrderItem> orderItemList = orderItemMapper.getOrderItemByOrderId(orderId);
        return orderItemList;
    }

    @Override
    public void addOrderItem(OrderItem orderItem) {
        orderItemMapper.addOrderItem(orderItem);
    }


}
