package com.example.kalkulator;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataManager {

    private static final String HISTORY_PREF = "history_pref";
    private static final String HISTORY_KEY = "history_key";

    // Method to add history data
    public static void addHistoryData(Context context, String history) {
        SharedPreferences preferences = context.getSharedPreferences(HISTORY_PREF, Context.MODE_PRIVATE);
        Set<String> historySet = preferences.getStringSet(HISTORY_KEY, new HashSet<>());
        historySet.add(history);
        preferences.edit().putStringSet(HISTORY_KEY, historySet).apply();
    }

    // Method to get history data
    public static List<String> getHistoryData(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(HISTORY_PREF, Context.MODE_PRIVATE);
        Set<String> historySet = preferences.getStringSet(HISTORY_KEY, new HashSet<>());
        return new ArrayList<>(historySet);
    }
}
