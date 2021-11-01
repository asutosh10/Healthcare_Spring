package com.healthcare.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usertable")
public class UserEntity {
    @Id
    @GenericGenerator(name = "sequence_user_id", strategy = "com.healthcare.utility.UserIdGenerator")
    @GeneratedValue(generator = "sequence_user_id")
//    @OneToOne

    private String userId;
    private String name;
    private String password;
    private char gender;
    private LocalDate dateOfBirth;
    private long mobileNo;
    private String email;
    private int pincode;
    private String city;
    private String state;
    private String country;
}
