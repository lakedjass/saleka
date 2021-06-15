package com.saleka.application.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Role, Integer> {
    Privilege findByName(String name);

    void save(Privilege privilege);
}
