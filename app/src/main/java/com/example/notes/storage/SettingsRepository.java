package com.example.notes.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsRepository {

    private final SharedPreferences sharedPreferences;
    private static final String DARK_MODE = "dark_mode";

    public SettingsRepository(Context context) {
        sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    public boolean isDarkModeEnabled() {
        return sharedPreferences.getBoolean(DARK_MODE, false);
    }

    public void setDarkModeEnabled(boolean isEnabled) {
        sharedPreferences.edit().putBoolean(DARK_MODE, isEnabled).apply();
    }
}
