package com.healthcare.controller;

import com.healthcare.DTO.BookingDTO;
import com.healthcare.DTO.LoginDTO;
import com.healthcare.DTO.UserDTO;
import com.healthcare.exception.WeCareExceptions;
import com.healthcare.service.BookingService;
import com.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    public BookingService bookingService;
    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<Boolean> loginUser(@RequestBody LoginDTO loginDTO) throws WeCareExceptions {
        return new ResponseEntity<>(userService.loginUser(loginDTO),HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserProfile(@PathVariable String userId){
        return new ResponseEntity<>(userService.getUserProfile(userId),HttpStatus.OK);
    }
    @GetMapping("/booking/{userId}")
    public List<BookingDTO> showMyAppointments(@PathVariable String userId){
        return bookingService.findBookingByUserId(userId);
    }


}
