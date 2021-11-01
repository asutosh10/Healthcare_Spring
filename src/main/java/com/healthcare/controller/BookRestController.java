package com.healthcare.controller;

import com.healthcare.DTO.BookAppointmentDTO;
import com.healthcare.exception.ExceptionConstants;
import com.healthcare.exception.WeCareExceptions;
import com.healthcare.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@RestController
public class BookRestController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/users/{userId}/booking/{coachId}")
    public ResponseEntity<Boolean> bookAppointment(@PathVariable String userId, @PathVariable String coachId, @RequestBody BookAppointmentDTO bookAppointmentDTO) throws WeCareExceptions {
        return new ResponseEntity<>(bookingService.bookAppointment(userId,coachId,bookAppointmentDTO.getDateOfAppointment(),bookAppointmentDTO.getSlot()), HttpStatus.OK);
    }
    @PutMapping("/booking/{bookingId}")
    public ResponseEntity<Boolean> rescheduleAppointment(@PathVariable Integer bookingId, @RequestBody BookAppointmentDTO bookAppointmentDTO) throws WeCareExceptions {
        boolean b = bookingService.rescheduleAppointment(bookingId, bookAppointmentDTO.getDateOfAppointment(), bookAppointmentDTO.getSlot());
        if(b==true){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else{
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//            throw new WeCareExceptions(ExceptionConstants.BOOKING_NOT_FOUND.toString());
            return  new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/booking/{bookingId}")
    public ResponseEntity<?> cancelAppointment(@PathVariable Integer bookingId){
        bookingService.cancelAppointment(bookingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
