package com.example.demo.controller;

import com.example.demo.model.Team;
import com.example.demo.model.Organizations;
import com.example.demo.model.UserPersonals;
import com.example.demo.model.User;
import com.example.demo.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = { "*", "http://localhost:5173" })
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/get-teams")
    public List<Team> getTeams(@RequestParam int orgid) {
        return dashboardService.getTeams(orgid);
    }

    @PostMapping("/add-team")
    public Team addTeam(@RequestBody Team team) {
        return dashboardService.addTeam(team);
    }

    // Check if the organization exists in the organizations table
    @PostMapping("/org-login")
    public Organizations findOrganization(@RequestParam int orgid) {
        return dashboardService.findOrganizations(orgid);
    }

    @GetMapping("/get-individual-details")
    public User getIndividualDetails(@RequestParam int indvid) {
        return dashboardService.getIndividualDetails(indvid);
    }

    // Register a new organization and populate users table
    @PostMapping("/org-register")
    public Organizations registerOrganization(@RequestBody Organizations org) {
        int orgid = (int)(Math.random() * 9000) + 1000;
        org.setOrgid(orgid);

        String orgname = org.getOrgname();
        User user = new User();
        user.setorgid(orgid);
        user.setorgname(orgname);
        dashboardService.addUser(user);

        return dashboardService.registerOrganizations(org);
    }

    // Register a team and populate users table
    @PostMapping("/register-team")
    public void registerTeam(@RequestBody Team team) {
        int orgid = team.getorgid();
        String unitno = team.getunitno();
        String department = team.getdepartment();

         dashboardService.updateUserDetails(orgid, unitno, department);
    }

    // Register an individual and populate users table
    @PostMapping("/individual-register")
    public UserPersonals registerUserPersonals(@RequestBody UserPersonals userPersonal) {
        int indvid = (int)(Math.random() * 9000) + 1000;
        userPersonal.setIndvid(indvid);
        String name = userPersonal.getName();
        int orgid = userPersonal.getorgid();
        User user = dashboardService.findUserByOrgid(orgid);
        if (user != null) {
            user.setindvid(indvid);
            user.setName(name);
            dashboardService.updateUser(user);
        }
        return dashboardService.registerUserPersonals(userPersonal);
    }
}
