package com.example.notes;

import java.util.ArrayList;
import java.util.List;

public class MockRepository {
    List<Note> list = new ArrayList<Note>();

    public MockRepository() {
        list.add(new Note("title1", 1));
        list.add(new Note("title1", 2));
        list.add(new Note("title1", 3));
        list.add(new Note("tidfdf", 4));
        list.add(new Note("tidfdf", 5));
        list.add(new Note("tidfdf", 6));
        list.add(new Note("tidfdf", 7));
        list.add(new Note("tidfdf", 8));
    }


    public Note getNote(int id) {
        if(id == -1)
            return new Note("");

        for (Note note: list) {
           if(note.getId() == id)
               return note;
        }
        return null;
    }

    public void addNote(Note note) {
        for(Note item: list){
           if(item.getId() == note.getId())
           {
               item.setText(note.getText());
               return;
           }
        }
        list.add(note);
    }

    public List<Note> getNotes() {
        return list;
    }
}