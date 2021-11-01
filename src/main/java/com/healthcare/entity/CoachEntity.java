package com.healthcare.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coachtable")
public class CoachEntity {
    @Id
    @GenericGenerator(name = "sequence_coach_id", strategy = "com.healthcare.utility.CoachIdGenerator")
    @GeneratedValue(generator = "sequence_coach_id")
    private String coachId;
    private String name;
    private String password;
    private char gender;
    private LocalDate dateOfBirth;
    private long mobileNo;
    private String speciality;
}
