package com.grocery.booking.Service.Impl;


import com.grocery.booking.Model.GroceryItem;
import com.grocery.booking.Model.OrderItem;
import com.grocery.booking.Repository.GroceryItemRepository;
import com.grocery.booking.Repository.OrderItemRepository;
import com.grocery.booking.Service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;
import java.util.List;
import java.util.Optional;

@Service
public class GroceryServiceImpl implements GroceryService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public List<GroceryItem> getAllItems() {
        try {
            return groceryItemRepository.findAll();
        }catch (DataAccessException e) {
            throw new RuntimeException("Database query failed while retrieving available grocery items", e);
        }
    }

    @Override
    public List<GroceryItem> getAllAvailableItems() {
        try {
            return groceryItemRepository.findByInventoryGreaterThan(0);
        }
        catch (DataAccessException e) {
            throw new RuntimeException("Database query failed while retrieving available grocery items", e);
        }
    }

    @Override
    public GroceryItem getItemById(Long itemId) {
        Optional<GroceryItem> optionalItem = groceryItemRepository.findById(itemId);
        return optionalItem.orElseThrow(() -> new IllegalArgumentException("Item not found with ID: " + itemId));
    }

    @Override
    public void addItem(GroceryItem groceryItem) {
        if (groceryItem == null) {
            throw new IllegalArgumentException("Grocery item cannot be null");
        }
        try {
            groceryItemRepository.save(groceryItem);
        }catch (DataAccessException e) {
            throw new RuntimeException("Database query failed while retrieving available grocery items", e);
        }
    }

    @Override
    public void updateItem(Long itemId, GroceryItem updatedItem) {
        if (updatedItem == null) {
            throw new IllegalArgumentException("Updated grocery item cannot be null");
        }
        //updatedItem.setId(itemId);
        groceryItemRepository.save(updatedItem);
    }

    @Override
    public void removeItem(Long itemId) {
        try {
            groceryItemRepository.deleteById(itemId);
        }catch (DataAccessException e) {
            throw new RuntimeException("Database query failed while removing grocery item", e);
        }
    }

    @Override
    public void updateInventory(Long itemId, int newInventoryLevel) {
        Optional<GroceryItem> optionalItem = groceryItemRepository.findById(itemId);
        if (optionalItem.isPresent()) {
            GroceryItem item = optionalItem.get();
         //   item.setInventory(newInventoryLevel);
            try {
                groceryItemRepository.save(item);
            }
            catch (DataAccessException e) {
                throw new RuntimeException("Database query failed while removing grocery item", e);
            }
        } else {
            throw new IllegalArgumentException("Item not found with ID: " + itemId);
        }
    }

    @Override
    public List<OrderItem> createOrder(List<OrderItem> orderItems) {
        if (orderItems == null || orderItems.isEmpty()) {
            throw new IllegalArgumentException("Order items cannot be null or empty");
        }
        try {
            return orderItemRepository.saveAll(orderItems);
        }catch (DataAccessException e) {
            throw new RuntimeException("Database query failed while removing grocery item", e);
        }
    }

    @Override
    public List<OrderItem> getOrderById(Long orderId) {
        try {
            return orderItemRepository.findByOrderItemId(orderId);
        }catch (DataAccessException e) {
            throw new RuntimeException("Database query failed while removing grocery item", e);
        }
    }

    @Override
    public List<OrderItem> getAllOrders() {
        try {
            return orderItemRepository.findAll();
        }
        catch (DataAccessException e) {
            throw new RuntimeException("Database query failed while removing grocery item", e);
        }
    }



}
