package com.documents.controller;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.documents.model.AdminDetails;
import com.documents.repository.AdminRepo;
import com.documents.service.AdminService;

@Controller
@RestController
public class AdminController {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public boolean checkAdmin(int adminId, String password) {
        boolean f = adminService.checkId(adminId);
        if(f)
        {
            boolean f1 = adminService.checkPassword(password);
            if(f1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    @PostMapping("/addAdmin")
    public boolean addAdmin(@RequestBody AdminDetails admin) {
        boolean f = adminService.checkId(admin.getAdminId());
        if(f)
        {
            return false;
        }
        else
        {
            adminRepo.save(admin);
            return true;
        }
    }

    
}
