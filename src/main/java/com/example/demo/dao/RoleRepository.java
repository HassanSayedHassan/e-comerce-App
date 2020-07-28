package com.example.demo.dao;

import com.example.demo.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole,Long> {
    public AppRole findByRoleName(String roleName);
}
