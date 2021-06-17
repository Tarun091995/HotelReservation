package com.myproduct.reservation.controller;

import com.myproduct.reservation.model.AdminUser;
import com.myproduct.reservation.model.Reservation;
import com.myproduct.reservation.service.ReservationService;
import com.myproduct.reservation.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Hello world")
@RequestMapping("/rest")

public class AdminUserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "Hello World",method = RequestMethod.GET)
    public ResponseEntity<String> helloWorld()
    {
        return  new ResponseEntity<String>("hello world", HttpStatus.OK);
    }

    @RequestMapping(value = "/createUser",method = RequestMethod.POST)
    @ApiOperation("Create Users")
    @CrossOrigin(origins = "http://localhost:4200")

    public @ResponseBody
    ResponseEntity createUser(@RequestBody AdminUser user)
    {
        System.out.println("User Name"+user.getOwnerName());
        System.out.println("Phone Number"+user.getPhoneNumber());
        System.out.println("Email"+user.getEmailaddress());
        System.out.println("Password"+user.getPassword());
        AdminUser userfromdb = usersService.createUser(user);
        return  new ResponseEntity<AdminUser>(userfromdb,HttpStatus.OK);
    }

    @Autowired
    public ReservationService reservationService;
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/fetchAllReservations",method = RequestMethod.GET)
    @ApiOperation("fetch all Reservations")

    public @ResponseBody ResponseEntity fetchAllReservations()
    {
        List<Reservation> allreservations = reservationService.listAllReservations();
        return new ResponseEntity<List<Reservation>>(allreservations,HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/fetchindividualreservation",method = RequestMethod.GET)
    @ApiOperation("fetch individual Reservations")
    public @ResponseBody ResponseEntity fetchReservationsforIndividuals(String phoneNumber)
    {
        Reservation fetchReservationForIndividual = reservationService.listIndividualReservations(phoneNumber);
        return new ResponseEntity<Reservation>(fetchReservationForIndividual,HttpStatus.OK);
    }


}
