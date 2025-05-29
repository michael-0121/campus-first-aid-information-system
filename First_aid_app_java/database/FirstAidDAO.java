package database;

import models.FirstAidTip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FirstAidDAO {
    public List<FirstAidTip> getAllFirstAidTips() {
        List<FirstAidTip> tips = new ArrayList<>();
        String query = "SELECT * FROM first_aid_tips";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FirstAidTip tip = new FirstAidTip(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description")
                );
                tips.add(tip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tips;
    }
}