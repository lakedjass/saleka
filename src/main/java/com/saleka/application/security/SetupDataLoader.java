package com.saleka.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = true;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        //Creation des permissions accepté sur l'application
        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege= createPrivilegeIfNotFound("WRITE_PRIVILEGE");
        Privilege deletePrivilege= createPrivilegeIfNotFound("DELETE_PRIVILEGE");

        //attribution des privilieges de base selon le role
        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege, deletePrivilege);
        List<Privilege> heroPrivileges = Arrays.asList(readPrivilege, writePrivilege);

        createRoleIfNotFound("ADMIN", adminPrivileges);
        createRoleIfNotFound("HERO", heroPrivileges);
        createRoleIfNotFound("USER", Arrays.asList(readPrivilege));

        //récupération des roles pour créer quelques utilisateurs dans la bd utilisateurs
        Role adminRole = roleRepository.findByName("ADMIN");
        Role heroRole = roleRepository.findByName("HERO");
        Role userRole = roleRepository.findByName("USER");

        //Création des utiliasteurs avec chacun un role à des fins de test
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        user1.setFirstName("saleka");
        user1.setLastName("saleka");
        user1.setPassword(passwordEncoder.encode("admin"));
        user1.setEmail("admin@saleka.com");
        user1.setRoles(Arrays.asList(adminRole));
        user1.setEnabled(true);

        user2.setFirstName("user");
        user2.setLastName("user");
        user2.setPassword(passwordEncoder.encode("user"));
        user2.setEmail("user@saleka.com");
        user2.setRoles(Arrays.asList(userRole));
        user2.setEnabled(true);

        user3.setFirstName("hero");
        user3.setLastName("hero");
        user3.setPassword(passwordEncoder.encode("hero"));
        user3.setEmail("hero@saleka.com");
        user3.setRoles(Arrays.asList(heroRole));
        user3.setEnabled(true);

        List<User> listUsers = new ArrayList<>();
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);

        userRepository.saveAll(listUsers);

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

}