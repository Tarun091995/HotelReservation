package com.myproduct.reservation.service;

import com.myproduct.reservation.common.ConfirmationCodeGenerator;
import com.myproduct.reservation.common.ReservationStatus;
import com.myproduct.reservation.model.Reservation;
import com.myproduct.reservation.model.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    private int maximumTables = 10;

    public Reservation createReservation(Reservation reservation)
    {
        String confirmationCode = ConfirmationCodeGenerator.getAlphaNumericString(8);

        int count  = reservationRepository.getCountOfReservationsForTime(reservation.getReservationTime());
        if(count < 5 )
        {
            reservation.setStatus(ReservationStatus.CONFIRMED);
            reservation.setConfirmationCode(confirmationCode);
        }
        else {
            reservation.setStatus(ReservationStatus.WAITLIST);
            reservation.setConfirmationCode(confirmationCode);
        }

        Reservation reseservationfromdb = reservationRepository.save(reservation);
        return reseservationfromdb;
    }

    public boolean cancelReservation(String confirmationCode)
    {

          Reservation reservationFromDB = reservationRepository.getReservationDetailsForConfirmationCode(confirmationCode);
        reservationFromDB.setStatus(ReservationStatus.CANCELLED);

          reservationRepository.save(reservationFromDB);
          return true;
    }


    public List<Reservation> listAllReservations()
    {
        return reservationRepository.findAll();
    }

    public Reservation listIndividualReservations(String PhoneNumber)
    {
          Reservation reservationDetails = reservationRepository.getReservationDetails(PhoneNumber);
          return reservationDetails;
    }

    public Reservation fetchReservationForId(long id)
    {
        Reservation reservationDetails = reservationRepository.getReservationById(id);
        return reservationDetails;
    }

    public Reservation updateReservation(Reservation reservation)
    {
        Reservation updatedReservation = reservationRepository.save(reservation);
        return  updatedReservation;
    }
}
