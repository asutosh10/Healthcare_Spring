package com.healthcare.service;

import com.healthcare.DTO.BookingDTO;
import com.healthcare.entity.BookingEntity;
import com.healthcare.entity.CoachEntity;
import com.healthcare.entity.UserEntity;
import com.healthcare.exception.ExceptionConstants;
import com.healthcare.exception.WeCareExceptions;
import com.healthcare.repository.BookingRepository;
import com.healthcare.repository.CoachRepository;
import com.healthcare.repository.UserRepository;
//import com.healthcare.utility.MailUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
//    @Autowired
//    private MailUtility mailUtility;
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private UserRepository userRepository;
    public boolean bookAppointment(String userId, String coachId, LocalDate appointmentDate, String slot) throws WeCareExceptions {
        BookingEntity bookingEntities= bookingRepository.findAllBookings(userId,appointmentDate,slot);
        if (bookingEntities==null){
            BookingEntity bookingEntity=new BookingEntity();
            bookingEntity.setUserId(userId);
            bookingEntity.setCoachId(coachId);
            bookingEntity.setSlot(slot);
            bookingEntity.setAppointmentDate(appointmentDate);
            bookingRepository.save(bookingEntity);
//            UserEntity userEntity=userRepository.getById(userId);
//            CoachEntity coachEntity=coachRepository.getById(coachId);
//            mailUtility.sendSchedulingEmail(userEntity.getName(),coachEntity.getName(),userEntity.getEmail(),bookingEntity.getBookingId(),slot,appointmentDate);
            return true;
        }
        else
             throw new WeCareExceptions(ExceptionConstants.BOOKING_ALREADY_EXISTS.toString());
    }
    public boolean rescheduleAppointment(int bookingId, LocalDate appointmentDate, String slot) throws WeCareExceptions {
        BookingEntity one = bookingRepository.getOne(bookingId);
        if(one == null){
            return false;
//            throw new WeCareExceptions(ExceptionConstants.BOOKING_NOT_FOUND.toString());
                    }
        else{
            bookingRepository.updateBooking(bookingId,appointmentDate,slot);
            return true;
        }

    }
    public void cancelAppointment(Integer bookingId){
        bookingRepository.deleteById(bookingId);
    }
    public BookingDTO findByBookingId(Integer bookingId){
        BookingEntity one = bookingRepository.getOne(bookingId);
        BookingDTO bookingDTO=new BookingDTO();
        bookingDTO.setBookingId(one.getBookingId());
        bookingDTO.setUserId(one.getUserId());
        bookingDTO.setCoachId(one.getCoachId());
        bookingDTO.setAppointmentDate(one.getAppointmentDate());
        bookingDTO.setSlot(one.getSlot());
        return bookingDTO;

    }
    public  List<BookingDTO> findBookingByUserId(String userId){
        List<BookingEntity> bookingByUserId = bookingRepository.findBookingByUserId(userId);
        List<BookingDTO>  bookingDTOS=bookingByUserId.stream().map(bookingEntity ->{
            BookingDTO bookingDTO=new BookingDTO();
            bookingDTO.setBookingId(bookingEntity.getBookingId());
            bookingDTO.setUserId(bookingEntity.getUserId());
            bookingDTO.setCoachId(bookingEntity.getCoachId());
            bookingDTO.setAppointmentDate(bookingEntity.getAppointmentDate());
            bookingDTO.setSlot(bookingEntity.getSlot());
            return bookingDTO;
        } ).collect(Collectors.toList());
        return bookingDTOS;

    }
    public  List<BookingDTO> findBookingByCoachId(String coachId){
        List<BookingEntity> bookingByCoachId = bookingRepository.findBookingByCoachId(coachId);
        List<BookingDTO> bookingDTOS=bookingByCoachId.stream().map(bookingEntity -> {
            BookingDTO bookingDTO=new BookingDTO();
            bookingDTO.setBookingId(bookingEntity.getBookingId());
            bookingDTO.setUserId(bookingEntity.getUserId());
            bookingDTO.setCoachId(bookingEntity.getCoachId());
            bookingDTO.setAppointmentDate(bookingEntity.getAppointmentDate());
            bookingDTO.setSlot(bookingEntity.getSlot());
            return bookingDTO;
        }).collect(Collectors.toList());
        return bookingDTOS;
    }


}
