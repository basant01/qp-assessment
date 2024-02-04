package com.grocery.booking.Repository;

import com.grocery.booking.Model.GroceryItem;
import com.grocery.booking.Model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
}
