package com.myproduct.reservation.controller;

import com.myproduct.reservation.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Admin Controller")
@RequestMapping("/rest")
    public class LoginController {

        @Autowired
        private UsersService usersService;

        @RequestMapping(value = "login",method = RequestMethod.POST)
        @ApiOperation("Authenticate the user")
        @CrossOrigin(origins = "http://localhost:4200")

         public @ResponseBody
        ResponseEntity authentication( @RequestParam("emailaddress") String emailaddress,@RequestParam("password") String password)
        {
           boolean isValid =  usersService.authenticate(emailaddress,password);
           if (isValid)
           {
               return new ResponseEntity<Boolean>(isValid,HttpStatus.OK);
           }
           else
           {
               return new ResponseEntity<Boolean>(isValid,HttpStatus.UNAUTHORIZED);
           }
        }

    }
