package com.example.notes;

import java.util.List;

public interface Repository {
    Note getNote(int id);
    void addNote(Note note);
    List<Note> getNotes();
}