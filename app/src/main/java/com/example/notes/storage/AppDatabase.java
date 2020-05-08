package com.example.notes.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.notes.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NotesDAO notesDAO();
}
