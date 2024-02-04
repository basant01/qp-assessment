package com.grocery.booking.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userOrderId;

    private Long userId;

    @OneToMany(mappedBy = "userOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    private Date orderDate = new Date();

    public void addUserOrderItem(OrderItem userOrderItem) {
        orderItems.add(userOrderItem);
        userOrderItem.setUserOrder(this);
    }
}
