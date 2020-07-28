package com.example.demo.services;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public void addRoleToUse(String username,String roleName);
    public AppUser findUserByUsername(String username);
}
