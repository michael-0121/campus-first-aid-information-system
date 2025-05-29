package views;

import controllers.FirstAidController;
import models.FirstAidTip;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FirstAidPanel extends JPanel {

    public FirstAidPanel() {
        setLayout(new BorderLayout());

        // 1. Get the tips from your controller
        FirstAidController controller = new FirstAidController();
        List<FirstAidTip> tips = controller.getAllFirstAidTips();

        // 2. Build an HTML string to style your tips
        StringBuilder sb = new StringBuilder();
        sb.append("<html>")
                .append("<body style='font-family:SansSerif; font-size:14px; line-height:1.5; margin:10px;'>")
                .append("<h2 style='color:#2196F3; font-size:18px;'>First Aid Tips</h2>")
                .append("<ul>");

        for (FirstAidTip tip : tips) {
            sb.append("<li>")
                    .append("<strong>").append(tip.getTitle()).append(":</strong> ")
                    .append(tip.getDescription())
                    .append("</li>");
        }

        sb.append("</ul>")
                .append("</body></html>");

        // 3. Create a non-editable text pane to display the HTML
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setEditable(false);
        textPane.setText(sb.toString());
        textPane.setCaretPosition(0); // Scroll to top by default

        // 4. Put the text pane in a scroll pane
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // 5. Add to this panel
        add(scrollPane, BorderLayout.CENTER);
    }
}
