package com.myproduct.reservation.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface AdminUserRepository extends JpaRepository<AdminUser,Integer>, JpaSpecificationExecutor<AdminUser> {
    @Query("select u from AdminUser u where u.emailaddress = ?1")
    public AdminUser findAdminUserByEmailAddress(String email_id);
}
