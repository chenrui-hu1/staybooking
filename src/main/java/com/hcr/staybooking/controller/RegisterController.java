package com.hcr.staybooking.controller;

import com.hcr.staybooking.entity.User;
import com.hcr.staybooking.entity.UserRole;
import com.hcr.staybooking.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private IRegisterService IRegisterService;


    @Autowired
    public RegisterController(IRegisterService IRegisterService) {
        this.IRegisterService = IRegisterService;
    }

    @PostMapping("/register/guest")
    public void registerGuest(@RequestBody User user) {
        IRegisterService.add(user, UserRole.Role_Guest);
    }

    @PostMapping("/register/host")
    public void registerHost(@RequestBody User user) {
        IRegisterService.add(user, UserRole.Role_Host);
    }
}
