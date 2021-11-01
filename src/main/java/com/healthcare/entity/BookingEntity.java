package com.healthcare.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookingtable")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int bookingId;
    public String userId;
    public String coachId;
    public String slot;
    public LocalDate appointmentDate;
}
