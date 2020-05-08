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
import com.example.notes.Repository;
import com.example.notes.Note;
import com.example.notes.R;
import com.example.notes.storage.SettingsRepository;

public class NoteFragment extends Fragment {

    private Note note;

    private Repository repository;

    private SettingsRepository settingsRepository;

    private EditText noteText;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, null);

        repository = ((MainActivity) getActivity()).getRepository();
        settingsRepository = ((MainActivity) getActivity()).getSettingsRepository();
        int id = getArguments().getInt("id");
        note = repository.getNote(id);

        noteText = view.findViewById(R.id.noteText);
        noteText.setText(note.getText());

        view.findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                note.setText(noteText.getText().toString());
                repository.addNote(note);
                getActivity().onBackPressed();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if(settingsRepository.isDarkModeEnabled()){
            getView().findViewById(R.id.background).setBackgroundColor(getResources().getColor(R.color.dark));
        } else {
            getView().findViewById(R.id.background).setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    public static NoteFragment newInstance(int id) {
        Bundle args = new Bundle();
        args.putInt("id", id);
        NoteFragment fragment = new NoteFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
