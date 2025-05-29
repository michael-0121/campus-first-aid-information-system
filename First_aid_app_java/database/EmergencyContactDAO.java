package database;

import models.EmergencyContact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmergencyContactDAO {
    public List<EmergencyContact> getAllEmergencyContacts() {
        List<EmergencyContact> contacts = new ArrayList<>();
        String query = "SELECT * FROM emergency_contacts";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EmergencyContact contact = new EmergencyContact(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone_number")
                );
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}