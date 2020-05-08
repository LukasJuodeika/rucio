package com.example.notes;

public class Note {
    private int id;

    private String text;

    public Note(String text) {
        this.text = text;
    }

    public Note(
            String title,
            int id
    ) {
        this.text = title;
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }
}
