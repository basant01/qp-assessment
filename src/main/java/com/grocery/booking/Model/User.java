package com.grocery.booking.Model;

import javax.persistence.*;

import com.grocery.booking.Enum.Role;
import lombok.*;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password; 
    private String role;
}
