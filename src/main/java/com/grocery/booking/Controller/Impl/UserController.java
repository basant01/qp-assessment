package com.grocery.booking.Controller.Impl;

import com.grocerybooking.assessment.dtos.CreateOrderRequest;
import com.grocerybooking.assessment.model.GroceryItem;
import com.grocerybooking.assessment.model.UserOrder;
import com.grocerybooking.assessment.service.GroceryItemService;
import com.grocerybooking.assessment.service.UserOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

	private final GroceryItemService groceryItemService;
	private final UserOrderService userOrderService;

	@GetMapping("/grocery-items")
	public List<GroceryItem> getAllGroceryItems() {
		return groceryItemService.getAllItems();
	}

	@PostMapping("/create-order")
	public UserOrder  createOrder(@RequestBody CreateOrderRequest request) {
		return userOrderService.createOrder(request.getItemIds());
	}

}
