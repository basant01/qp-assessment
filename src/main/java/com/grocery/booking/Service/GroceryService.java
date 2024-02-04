package com.grocery.booking.Service;

import com.grocery.booking.Model.GroceryItem;
import com.grocery.booking.Model.OrderItem;

import java.util.List;

    public interface GroceryService {
        List<GroceryItem> getAllItems();

        List<GroceryItem> getAllAvailableItems();

        GroceryItem getItemById(Long itemId);

        void addItem(GroceryItem groceryItem);

        void updateItem(Long itemId, GroceryItem updatedItem);

        void removeItem(Long itemId);

        void updateInventory(Long itemId, int newInventoryLevel);

        List<OrderItem> createOrder(List<OrderItem> orderItems);

        List<OrderItem> getOrderById(Long orderId);

        List<OrderItem> getAllOrders();
    }


