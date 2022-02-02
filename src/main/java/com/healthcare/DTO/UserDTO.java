package com.healthcare.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String userId;
//    @NotNull
//    @Size(min = 3,max = 50)
    private String name;
//    @NotNull
//    @Size(min = 5,max = 10)
    private String password;
    private char gender;
    private LocalDate dateOfBirth;
//    @NotNull
//    @Size(min = 10,max = 10)
    private long mobileNo;
    @Email
    private String email;
//    @NotNull
//    @Size(min = 6,max = 6)
    private int pincode;
//    @NotNull
//    @Size(min = 3,max = 20)
    private String city;
//    @NotNull
//    @Size(min = 3,max = 20)
    private String state;
//    @NotNull
//    @Size(min = 3,max = 20)
    private String country;
}
