package com.example.notes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.notes.fragments.ListFragment;
import com.example.notes.fragments.SettingsFragment;
import com.example.notes.storage.NotesRepository;
import com.example.notes.storage.SettingsRepository;
import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    private Repository repository;

    private SettingsRepository settingsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        repository = new NotesRepository(this);
        settingsRepository = new SettingsRepository(this);
        setContentView(R.layout.activity_main);
        openListView();
    }

    private void openListView() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, ListFragment.newInstance(), ListFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }

    private void openSettingsView() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, SettingsFragment.newInstance(), SettingsFragment.class.getSimpleName());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                openSettingsView();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public Repository getRepository() {
        return repository;
    }

    public SettingsRepository getSettingsRepository() {
        return settingsRepository;
    }
}
