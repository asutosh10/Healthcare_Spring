package com.healthcare.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAppointmentDTO {
    String slot;
    LocalDate dateOfAppointment;
}
