package com.example.notes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
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
