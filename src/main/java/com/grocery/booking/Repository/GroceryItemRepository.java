package com.grocery.booking.Repository;

import com.grocery.booking.Model.GroceryItem;
import com.grocery.booking.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
    List<GroceryItem> findByInventoryGreaterThan(int inventory);
}
