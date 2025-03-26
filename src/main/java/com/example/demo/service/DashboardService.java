package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

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

    @Autowired
    private UserUploadRepository userUploadRepository;

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

    public List<User> registerUsers(List<User> users) {
        // Implement the logic to register users
        return userRepository.saveAll(users);
    }

    public useruploads updatePdf(int indvid , String pdfname) {
        // Update the pdfname for all records with the same indvid
        List<useruploads> userUploads = userUploadRepository.findAllByIndvid(indvid);
        for (useruploads userUpload : userUploads) {
            userUpload.setPdfname(pdfname);
        }
        return userUploadRepository.saveAll(userUploads).isEmpty() ? null : userUploads.get(0);
        
    }
    
    public useruploads updateImg(int indvid, String imgname) {
        useruploads newUserUpload = new useruploads();
        newUserUpload.setindvid(indvid);
        newUserUpload.setImgname(imgname);
        newUserUpload.setPdfname(null);
        return userUploadRepository.save(newUserUpload);
    }

    public List<UserWithPdf> getRecords(int orgid) {
        List<User> users = userRepository.findByorgid(orgid);
        System.out.println("List of users: " + users);
        List<UserWithPdf> usersWithPdf = new ArrayList<>();
        for (User user : users) {
            Optional<useruploads> userUploadOptional = userUploadRepository.findByindvid(user.getindvid());
            String pdfname = userUploadOptional.map(useruploads::getPdfname).orElse(null);
            usersWithPdf.add(new UserWithPdf(user, pdfname));
        }
        
        return usersWithPdf;
    }

    public static class UserWithPdf {
        private User user;
        private String pdfname;

        public UserWithPdf(User user, String pdfname) {
            this.user = user;
            this.pdfname = pdfname;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getPdfname() {
            return pdfname;
        }

        public void setPdfname(String pdfname) {
            this.pdfname = pdfname;
        }
    }

    public useruploads getImg(int indvid) {
        // Implement the logic to retrieve the image for the given indvid
        // Example:
        return userUploadRepository.findByindvid(indvid).orElse(null);
    }

    public List<useruploads> getAllImgs(int indvid) {
        // Replace with actual implementation
        return userUploadRepository.findAllByIndvid(indvid);
    }
    public Organizations findOrganizationByName(String orgname) {
        // Implement the logic to find an organization by its name
        // Example:
        return organizationRepository.findByOrgname(orgname);
    }
    public Organizations findOrganizationByNameAndLocation(String orgname, String orgloc) {
        // Implement the logic to find the organization by name and location
        // Example:
        return organizationRepository.findByOrgnameAndOrgloc(orgname, orgloc);
    }
}
