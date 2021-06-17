package com.myproduct.reservation.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

//what does integer say??
@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> , JpaSpecificationExecutor<Reservation> {

    @Query(value = "select count(*) from Reservation res where res.reservationTime = ?1")
    public int getCountOfReservationsForTime(Timestamp startTime);

    @Query(value = "select res from Reservation res where res.confirmationCode = ?1 ")
    public Reservation getReservationDetailsForConfirmationCode(String confirmationCode);

    @Query(value = "select res from Reservation res where res.phoneNumber = ?1 ")
    public Reservation getReservationDetails(String PhoneNumber);

    @Query(value = "select res from Reservation res where res.id = ?1" )
    public Reservation getReservationById(long id);
}
