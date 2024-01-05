package com.crud.payload;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnlineRegistrationDto {
    private long id;
    @NotEmpty
    @Size(min=2, message = "name should be atleast 2 character")
    private String name;
    @NotEmpty
    @Min(value = 10, message = "Invalid mobile no.")
    @Max(value = 10, message = "Invalid mobile no.")
    private long mobile;
    @NotEmpty
    @Email(message = "Invalid email address")
    private String email;
    private String message;
}
