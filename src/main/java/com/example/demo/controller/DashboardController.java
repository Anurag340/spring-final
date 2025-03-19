package com.example.demo.controller;

import com.example.demo.model.Team;
import com.example.demo.model.Organizations;
import com.example.demo.model.UserPersonals;
import com.example.demo.model.User;
import com.example.demo.model.useruploads;
import com.example.demo.service.DashboardService;
import com.example.demo.service.DashboardService.UserWithPdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = { "*", "http://localhost:5173","https://luxysmile-dashboard.vercel.app"})
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
    @GetMapping("/org-login")
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
        User user = dashboardService.findUserByName(name);
        if (name != null && !name.isEmpty()) {
            if (user != null) {
            user.setindvid(indvid);
            user.setName(name);
            dashboardService.updateUser(user);
            } else {
            User newUser = new User();
            newUser.setorgid(orgid);
            newUser.setindvid(indvid);
            newUser.setName(name);
            List<Team> teams = dashboardService.getTeamByOrgId(orgid);
            if (teams != null && !teams.isEmpty()) {
                Team team = teams.get(0); // Assuming you want the first team in the list
                newUser.setunitno(team.getunitno());
                newUser.setdepartment(team.getdepartment());
                Organizations org = dashboardService.findOrganizations(orgid);
                if (org != null) {
                    newUser.setorgname(org.getOrgname());
                }
            }
            dashboardService.addUser(newUser);
            }
        }
        return dashboardService.registerUserPersonals(userPersonal);
    }

    @PostMapping("/update-img")
    public useruploads updateImg(@RequestBody useruploads userupload) {
        int indvid = userupload.getindvid();
        String imgname = userupload.getImgname();
        return dashboardService.updateImg(indvid, imgname);
    }

    @PostMapping("/update-pdf")
    public useruploads updatePdf(@RequestBody useruploads userupload) {
        int indvid = userupload.getindvid();
        String pdfname = userupload.getPdfname();
        return dashboardService.updatePdf(indvid, pdfname);
    }

    @GetMapping("/get-records")
    public List<UserWithPdf> getRecords(@RequestParam int orgid) {
        return dashboardService.getRecords(orgid);
    }

    @PostMapping("/bulk-register")
    public List<User> bulkRegister(@RequestBody List<User> users) {
        for (User user : users) {
            String unitno = user.getunitno();
            String department = user.getdepartment();
            int orgid = user.getorgid();

            // Check if a team with the same unitno and orgid exists
            List<Team> existingTeams = dashboardService.getTeams(orgid);
            boolean teamExists = existingTeams.stream()
                .anyMatch(team -> team.getunitno().equals(unitno) && team.getorgid() == orgid);

            // If no such team exists, save it as a new team record
            if (!teamExists) {
                Team newTeam = new Team();
                newTeam.setorgid(orgid);
                newTeam.setunitno(unitno);
                newTeam.setdepartment(department);
                dashboardService.addTeam(newTeam);
            }
        }
       return dashboardService.registerUsers(users);
    }
}
