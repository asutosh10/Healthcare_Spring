package com.healthcare.repository;

import com.healthcare.DTO.BookingDTO;
import com.healthcare.entity.BookingEntity;
import com.healthcare.entity.CoachEntity;
import com.healthcare.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {
    public Optional<BookingEntity> findByUserId(String userId);

    @Query(value = "select * from bookingtable where user_id= :userId and appointment_date > :today",nativeQuery = true)
    public List<BookingEntity> findBookingByUserId(@Param("userId") String userId, @Param("today") LocalDate today);

    @Query(value = "select * from bookingtable where coach_id= :coachId and appointment_date > :today",nativeQuery = true)
    public List<BookingEntity> findBookingByCoachId(@Param("coachId") String coachId,@Param("today") LocalDate today);

    @Query(value = "select * from bookingtable where user_id= :userId and appointment_date= :appointmentDate and slot= :slot",nativeQuery = true)
    public BookingEntity findAllBookings(@Param("userId") String userId,@Param("appointmentDate") LocalDate appointmentDate,@Param("slot") String slot);

    @Query(value = "select * from bookingtable where booking_id= :bookingId",nativeQuery = true)
    public BookingEntity getOne(@Param("bookingId") int bookingId);
    @Transactional
    @Modifying
    @Query(value = "delete from bookingtable where booking_id= :bookingId ",nativeQuery = true)
    public void deleteById(@Param("bookingId") int bookingId);

    @Query(value = "select * from bookingtable where user_id= :userId",nativeQuery = true)
    public List<BookingEntity> findBookingByUserId(@Param("userId") String userId);

    @Query(value = "select * from bookingtable where coachId= :coachId",nativeQuery = true)
    public List<BookingEntity> findBookingByCoachId(@Param("coachId") String caochId);
    @Transactional
    @Modifying
    @Query(value = "update bookingtable set appointment_date= :appointmentDate,slot= :slot where booking_id=:bookingId",nativeQuery = true)
    public void updateBooking(@Param("bookingId") int bookingId, @Param("appointmentDate") LocalDate appointmentDate,@Param("slot") String slot);
}
