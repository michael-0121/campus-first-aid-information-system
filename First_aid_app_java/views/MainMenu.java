package views;

import javax.swing.*;
import java.awt.*;


public class MainMenu extends JFrame {

    public MainMenu() {
        // Basic frame setup
        setTitle("Campus First Aid App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. Apply the Nimbus Look and Feel if available
        applyNimbusLookAndFeel();

        // 2. Create a nice header with a gradient background
        JPanel headerPanel = createGradientHeader(
                new Color(33, 150, 243), // Start color
                new Color(3, 169, 244)   // End color
        );

        // 3. Create your JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("SansSerif", Font.PLAIN, 16));
        // (Optional) Set tab placement on top, left, right, etc.
        // tabbedPane.setTabPlacement(SwingConstants.LEFT);

        // Add the panels (assuming these classes exist in your code)
        tabbedPane.addTab("First Aid Tips", new FirstAidPanel());
        tabbedPane.addTab("Emergency Contacts", new EmergencyContactsPanel());
        tabbedPane.addTab("About", new AboutPanel());

        // 4. Wrap the tabbed pane in a panel with margins
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.add(tabbedPane, BorderLayout.CENTER);

        // 5. Add components to the main frame
        add(headerPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }


    private void applyNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus isn't available, use system default or fallback.
            e.printStackTrace();
        }
    }

    /**
     * Creates a top panel with a vertical gradient background and a title label.
     */
    private JPanel createGradientHeader(Color startColor, Color endColor) {
        // Custom panel that paints a gradient
        JPanel headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                int w = getWidth();
                int h = getHeight();

                // Create a gradient paint from top-left to bottom-right
                GradientPaint gp = new GradientPaint(
                        0, 0, startColor,
                        w, h, endColor
                );
                g2.setPaint(gp);
                g2.fillRect(0, 0, w, h);
                g2.dispose();

                super.paintComponent(g);
            }
        };

        headerPanel.setLayout(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(getWidth(), 70)); // Adjust header height
        headerPanel.setOpaque(false); // Let paintComponent handle the background

        // Title label
        JLabel titleLabel = new JLabel("Campus First Aid App", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        headerPanel.add(titleLabel, BorderLayout.CENTER);
        return headerPanel;
    }

    // Test main method (optional)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }
}

