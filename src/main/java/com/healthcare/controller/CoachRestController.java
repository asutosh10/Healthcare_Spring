package com.healthcare.controller;

import com.healthcare.DTO.BookingDTO;
import com.healthcare.DTO.CoachDTO;
import com.healthcare.DTO.LoginDTO;
import com.healthcare.exception.WeCareExceptions;
import com.healthcare.service.BookingService;
import com.healthcare.service.CoachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachRestController {
    @Autowired
    private CoachService coachService;
    @Autowired
    private BookingService bookingService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @PostMapping()
    public ResponseEntity<String> createCoach(@RequestBody CoachDTO coachDTO){
        logger.info("Inside post method of coachController");
        coachService.createCoach(coachDTO);
        return new ResponseEntity<>(coachDTO.getCoachId(), HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<Boolean>  loginCoach(@RequestBody LoginDTO loginDTO) throws WeCareExceptions {
        Boolean aBoolean = coachService.loginCoach(loginDTO);
        return new ResponseEntity<>(aBoolean,HttpStatus.OK);
    }
    @GetMapping("/{coachId}")
    public ResponseEntity<CoachDTO> getCoachProfile(@PathVariable String coachId){
        CoachDTO coachProfile = coachService.getCoachProfile(coachId);
        return new ResponseEntity<>(coachProfile,HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<CoachDTO> showAllCoaches(){
        return coachService.showAllCoaches();
    }
    @GetMapping("booking/{coachId}")
    public List<BookingDTO> showMySchedule(@PathVariable String coachId){
        return bookingService.findBookingByCoachId(coachId);
    }
}
