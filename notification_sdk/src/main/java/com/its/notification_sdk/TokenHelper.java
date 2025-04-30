package com.its.notification_sdk;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;


public class TokenHelper {
    private static final String TAG = "ITSFCMTOKEN";

    public static void fetchToken() {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "Fetching FCM token failed", task.getException());
                        return;
                    }

                    // Get new FCM registration token
                    String token = task.getResult();

                    // Use the token (e.g., send to server)
                    Log.d(TAG, "FCM Token: " + token);
                });
    }
}
