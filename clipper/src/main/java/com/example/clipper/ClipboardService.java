package com.example.clipper;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class ClipboardService extends IntentService {
    private static String TAG = "ClipboardService";

    public ClipboardService() {
        super(TAG);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Start clipboard service.");
        startService(new Intent(getApplicationContext(), ClipboardService.class));
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
