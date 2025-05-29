package views;

import controllers.EmergencyContactController;
import models.EmergencyContact;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EmergencyContactsPanel extends JPanel {
    public EmergencyContactsPanel() {
        setLayout(new BorderLayout());

        // 1. Get the contacts from your controller
        EmergencyContactController controller = new EmergencyContactController();
        List<EmergencyContact> contacts = controller.getAllEmergencyContacts();

        // 2. Build an HTML string to style your contacts
        StringBuilder sb = new StringBuilder();
        sb.append("<html>")
                .append("<body style='font-family:SansSerif; font-size:14px; line-height:1.5; margin:10px;'>")
                .append("<h2 style='color:#2196F3; font-size:18px;'>Emergency Contacts</h2>")
                .append("<ul>");

        for (EmergencyContact contact : contacts) {
            sb.append("<li>")
                    .append("<strong>").append(contact.getName()).append(":</strong> ")
                    .append(contact.getPhoneNumber())
                    .append("</li>");
        }

        sb.append("</ul>")
                .append("</body></html>");

        // 3. Create a non-editable text pane to display the HTML
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setEditable(false);
        textPane.setText(sb.toString());
        textPane.setCaretPosition(0); // Ensure it starts at the top

        // 4. Wrap the text pane in a scroll pane
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // 5. Add to this panel
        add(scrollPane, BorderLayout.CENTER);
    }
}
