package com.healthcare.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
     int bookingId;
     String userId;
     String coachId;
     LocalDate appointmentDate;
     String slot;

}
