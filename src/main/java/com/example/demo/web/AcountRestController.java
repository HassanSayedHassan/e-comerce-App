package com.example.demo.web;


import com.example.demo.dao.UserRepository;
import com.example.demo.entities.AppUser;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcountRestController {
    @Autowired
    private AccountService accountService;
    private UserRepository userRepository;
    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterForm user) {
        if (!user.getPassword().equals(user.getRepassword())) {
            throw new RuntimeException("error password...");
        } else if (accountService.findUserByUsername(user.getUsername()) != null) {
            throw new RuntimeException("user already exist");
        } else {
            AppUser appUser = new AppUser();
            appUser.setPassword(user.getPassword());
            appUser.setUsername(user.getUsername());
            appUser = accountService.saveUser(appUser);
            accountService.addRoleToUse(user.getUsername(),"USER");
            return appUser;
        }
    }

    }

