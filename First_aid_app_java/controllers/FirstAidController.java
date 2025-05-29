package controllers;

import database.FirstAidDAO;
import models.FirstAidTip;

import java.util.List;

public class FirstAidController {
    private FirstAidDAO firstAidDAO = new FirstAidDAO();

    public List<FirstAidTip> getAllFirstAidTips() {
        return firstAidDAO.getAllFirstAidTips();
    }
}