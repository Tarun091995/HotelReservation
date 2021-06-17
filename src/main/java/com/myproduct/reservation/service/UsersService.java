package com.myproduct.reservation.service;

import com.myproduct.reservation.model.AdminUser;
import com.myproduct.reservation.model.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    public AdminUser createUser(AdminUser user)
    {
        AdminUser users = adminUserRepository.save(user);
        return user;
    }

    public  Boolean authenticate(String emailaddress, String password)
    {
           AdminUser userfromdb = adminUserRepository.findAdminUserByEmailAddress(emailaddress);
            if (userfromdb != null && userfromdb.getPassword().equals(password))
            {
                return true;
            }
            return false;

    }

}
