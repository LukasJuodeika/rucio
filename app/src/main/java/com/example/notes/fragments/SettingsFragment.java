package com.example.notes.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.notes.MainActivity;
import com.example.notes.R;
import com.example.notes.storage.SettingsRepository;

public class SettingsFragment extends Fragment {

    private SettingsRepository settingsRepository;

    private Switch darkModeSwitch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, null);
        settingsRepository = ((MainActivity) getActivity()).getSettingsRepository();
        darkModeSwitch = rootView.findViewById(R.id.dar_mode_switch);
        darkModeSwitch.setChecked(settingsRepository.isDarkModeEnabled());
        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                settingsRepository.setDarkModeEnabled(isChecked);
                updateMode();
            }
        });
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateMode();
    }

    private void updateMode() {
        if(settingsRepository.isDarkModeEnabled()){
            getView().findViewById(R.id.background).setBackgroundColor(getResources().getColor(R.color.dark));
        } else {
            getView().findViewById(R.id.background).setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    public static SettingsFragment newInstance() {
        Bundle args = new Bundle();
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
