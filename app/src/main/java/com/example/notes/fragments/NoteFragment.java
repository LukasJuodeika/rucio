package com.example.notes.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.notes.MainActivity;
import com.example.notes.MockRepository;
import com.example.notes.Note;
import com.example.notes.R;

public class NoteFragment extends Fragment {

    private Note note;

    private MockRepository mockRepository;

    private EditText noteText;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, null);

        mockRepository = ((MainActivity) getActivity()).getRepository();
        int id = getArguments().getInt("id");
        note = mockRepository.getNote(id);

        noteText = view.findViewById(R.id.noteText);
        noteText.setText(note.getText());

        view.findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                note.setText(noteText.getText().toString());
                mockRepository.addNote(note);
                getActivity().onBackPressed();
            }
        });

        return view;
    }

    public static NoteFragment newInstance(int id) {
        Bundle args = new Bundle();
        args.putInt("id", id);
        NoteFragment fragment = new NoteFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
