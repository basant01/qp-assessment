package com.grocery.booking.Repository;

import com.grocery.booking.Model.GroceryItem;
import com.grocery.booking.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrderItemId(Long orderItemId);
}
