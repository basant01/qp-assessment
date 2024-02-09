package com.grocery.booking.Service.Impl;

import com.grocery.booking.Model.OrderItem;
import com.grocery.booking.Model.UserOrder;
import com.grocery.booking.Repository.OrderItemRepository;
import com.grocery.booking.Repository.UserOrderRepository;
import com.grocery.booking.Service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<UserOrder> getAllOrders() {
        return userOrderRepository.findAll();
    }

    @Override
    public UserOrder getOrderById(Long orderId) {
        Optional<UserOrder> optionalUserOrder = userOrderRepository.findById(orderId);
        return optionalUserOrder.orElse(null);
    }

    @Override
    public UserOrder createOrder(UserOrder userOrder) {
        return userOrderRepository.save(userOrder);
    }

    @Override
    public UserOrder updateOrder(Long orderId, UserOrder updatedOrder) {
       // updatedOrder.setId(orderId);
        return userOrderRepository.save(updatedOrder);
    }

    @Override
    public void deleteOrder(Long orderId) {
        userOrderRepository.deleteById(orderId);
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderItemId(orderId);
    }
}
