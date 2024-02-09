package com.grocery.booking.Model;

import com.grocery.booking.Annotation.ValidRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@NoArgsConstructor
@Validated
public class RegistrationRequest {

	private String username;
	private String password;

	@ValidRole
	private String role;
}
