package com.healthcare.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoachDTO {
    private String coachId;
    @NotNull
    @Size(min = 3,max = 50)
    private String name;
    @NotNull
    @Size(min = 5,max = 10)
    private String password;
    private char gender;
    private LocalDate dateOfBirth;
    @NotNull
    @Size(min = 10,max = 10)
    private long mobileNo;
    @NotNull
    @Size(min = 3,max = 50)
    private String speciality;
}
