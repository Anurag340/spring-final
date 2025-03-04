package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DashboardService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private UserPersonalRepository userPersonalRepository;

    public User getIndividualDetails(int indvid) {
        Optional<User> user = userRepository.findByIndvid(indvid);
        return user.orElse(null);
    }

    public User registerIndividual(User user) {
        return userRepository.save(user);
    }
    
    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<Team> getTeams(int orgid) {
        return teamRepository.findByOrgid(orgid);
    }

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team registerTeam(Team team) {
        return teamRepository.save(team);
    }

    public Organizations registerOrganizations(Organizations org) {
        return organizationRepository.save(org);
    }

    public Organizations findOrganizations(int orgid) {
        Optional<Organizations> org = organizationRepository.findByOrgid(orgid);
        return org.orElse(null);
    }

    public UserPersonals registerUserPersonals(UserPersonals userPersonal) {
        return userPersonalRepository.save(userPersonal);
    }

    public void updateUserDetails(int orgid, String unitno, String department) {
        // Implementation of the method
        Optional<User> userOptional = userRepository.findByOrgid(orgid);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setunitno(unitno);
            user.setdepartment(department);
            userRepository.save(user);
        }
    }

    public User findUserByOrgid(int orgid) {
        Optional<User> user = userRepository.findByOrgid(orgid);
        return user.orElse(null);
    }

    public void updateUser(User user) {
        // Implementation of updateUser method
        userRepository.save(user);
    }

    public User findUserByName(String name) {
        // Implementation of the method
        Optional<User> userOptional = userRepository.findByName(name);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public List<Team> getTeamByOrgId(int orgid) {
        
        return teamRepository.findByOrgid(orgid);
    }
}
