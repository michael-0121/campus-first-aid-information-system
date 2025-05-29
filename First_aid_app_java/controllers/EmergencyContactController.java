package controllers;

import database.EmergencyContactDAO;
import models.EmergencyContact;

import java.util.List;

public class EmergencyContactController {
    private EmergencyContactDAO emergencyContactDAO = new EmergencyContactDAO();

    public List<EmergencyContact> getAllEmergencyContacts() {
        return emergencyContactDAO.getAllEmergencyContacts();
    }
}