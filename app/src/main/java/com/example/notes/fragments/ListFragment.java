package com.example.notes.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.MainActivity;
import com.example.notes.Repository;
import com.example.notes.NotesAdapter;
import com.example.notes.R;
import com.example.notes.storage.SettingsRepository;

public class ListFragment extends Fragment implements NotesAdapter.OnItemClickListener {

    private Repository repository;

    private RecyclerView recyclerView;

    private SettingsRepository settingsRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = ((MainActivity) getActivity()).getRepository();
        settingsRepository = ((MainActivity) getActivity()).getSettingsRepository();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, null);
        setupRecyclerView(rootView);
        rootView.findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNoteDetails(-1);
            }
        });
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        NotesAdapter adapter = new NotesAdapter(getContext(), repository.getNotes(), this);
        recyclerView.setAdapter(adapter);

        if(settingsRepository.isDarkModeEnabled()){
            getView().findViewById(R.id.background).setBackgroundColor(getResources().getColor(R.color.dark));
        } else {
            getView().findViewById(R.id.background).setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void openNoteDetails(int id) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, NoteFragment.newInstance(id), NoteFragment.class.getSimpleName());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onItemClick(int id) {
        openNoteDetails(id);
    }

    public static ListFragment newInstance() {
        Bundle args = new Bundle();
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
