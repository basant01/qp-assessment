package com.grocery.booking.Controller.Impl;

import com.grocery.booking.Model.GroceryItem;
import com.grocery.booking.Service.GroceryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminControllerImpl {

    @Autowired
    private GroceryService groceryService;

    @PostMapping("/grocery-items")
    public ResponseEntity<String> addGroceryItem(@RequestBody GroceryItem groceryItem) {

        groceryService.addItem(groceryItem);
        return ResponseEntity.ok("Grocery item added successfully.");
    }

    @GetMapping("/grocery-items")
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {

        List<GroceryItem> groceryItems = groceryService.getAllItems();
        return ResponseEntity.ok(groceryItems);
    }

    @PutMapping("/grocery-items/{itemId}")
    public ResponseEntity<String> updateGroceryItem(@PathVariable Long itemId, @RequestBody GroceryItem updatedItem) {

        groceryService.updateItem(itemId, updatedItem);
        return ResponseEntity.ok("Grocery item updated successfully.");
    }

    @DeleteMapping("/grocery-items/{itemId}")
    public ResponseEntity<String> removeGroceryItem(@PathVariable Long itemId) {

        groceryService.removeItem(itemId);
        return ResponseEntity.ok("Grocery item removed successfully.");
    }

    @PostMapping("/grocery-items/{itemId}/manage-inventory")
    public ResponseEntity<String> manageInventory(@PathVariable Long itemId, @RequestParam int quantity) {

        groceryService.updateInventory(itemId, quantity);
        return ResponseEntity.ok("Inventory managed successfully.");
    }
}
