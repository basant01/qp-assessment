package com.grocery.booking.Service;

import com.grocery.booking.Model.OrderItem;
import com.grocery.booking.Model.UserOrder;

import java.util.List;

public interface UserOrderService {

    List<UserOrder> getAllOrders();

    UserOrder getOrderById(Long orderId);

    UserOrder createOrder(UserOrder userOrder);

    UserOrder updateOrder(Long orderId, UserOrder updatedOrder);

    void deleteOrder(Long orderId);

    List<OrderItem> getOrderItemsByOrderId(Long orderId);

}
