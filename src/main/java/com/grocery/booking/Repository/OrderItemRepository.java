package com.grocery.booking.Repository;

import com.grocery.booking.Model.GroceryItem;
import com.grocery.booking.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
