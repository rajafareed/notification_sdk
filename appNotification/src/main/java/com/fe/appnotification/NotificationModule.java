package com.fe.appnotification;

import android.content.Context;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

public class NotificationModule {

    public static void initializeFirebase(Context context) {
        if (FirebaseApp.getApps(context).isEmpty()) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setApiKey("AIzaSyDIj0uxxxvRplSnhKeTzaWCfesZH2AA9dI")
                    .setApplicationId("1:590518950252:android:3d8a285c539311fdaf7b49")
                    .setProjectId("parent-app-eb9dd")// e.g., "1:1234567890:android:abcdef"// Optional, required if using Firebase Storage
                    .build();

            FirebaseApp.initializeApp(context, options);
            getFcmToken();

        }
    }

    private static final String TAG = "LibraryTAG";

    public static void getFcmToken() {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.e(TAG, "Fetching FCM token failed", task.getException());
                        return;
                    }

                    // Get the FCM token
                    String token = task.getResult();
                    Log.d(TAG, "FCM Token: " + token);

                    // You can store this token or pass it to your library's consumer
                });
    }
}
