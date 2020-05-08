package com.example.notes.storage;

import android.content.Context;

import androidx.room.Room;

import com.example.notes.Note;
import com.example.notes.Repository;

import java.util.List;

public class NotesRepository implements Repository {

    private final Context context;

    private final AppDatabase appDatabase;

    public NotesRepository(Context context) {
        this.context = context;
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "notes-database")
                .allowMainThreadQueries()
                .build();

    }

    @Override
    public void addNote(Note note) {
        appDatabase.notesDAO().add(note);
    }

    @Override
    public List<Note> getNotes() {
        return appDatabase.notesDAO().getAll();
    }

    @Override
    public Note getNote(int id) {
        if(id == -1)
            return new Note("");

        return appDatabase.notesDAO().getNote(id);
    }
}
