package models;

public class FirstAidTip {
    private int id;
    private String title;
    private String description;

    public FirstAidTip(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
}