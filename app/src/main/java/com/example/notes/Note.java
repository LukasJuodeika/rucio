package com.example.notes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String text;

    private String date;

    public Note(String text, String date) {
        this.text = text;
        this.date = date;
    }

    public Note(
            String title,
            int id,
            String date
    ) {
        this.text = title;
        this.id = id;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }
}
