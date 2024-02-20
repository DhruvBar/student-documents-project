package com.documents.service;
import com.documents.model.AdminDetails;

public interface AdminService {

    AdminDetails createUser(AdminDetails admin);

    public boolean checkId(int adminId);

    public boolean checkPassword(String password);

    public boolean checkEmail(String email);
}
