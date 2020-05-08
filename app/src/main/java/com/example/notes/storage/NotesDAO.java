package com.example.notes.storage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.notes.Note;

import java.util.List;

@Dao
public interface NotesDAO {

    @Query("SELECT * FROM note WHERE id == :id")
    Note getNote(int id);

    @Query("SELECT * FROM note")
    List<Note> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Note note);
}
