package com.example.buddyandme;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private String userName, userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        userName = getIntent().getStringExtra("USER_NAME");
        userEmail = getIntent().getStringExtra("USER_EMAIL");
        if (userName == null) userName = "Guest";
        if (userEmail == null) userEmail = "unknown@email.com";

        TextView txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText(getString(R.string.welcome_user, userName));

        LinearLayout cardFindLocation = findViewById(R.id.cardFindLocation);
        LinearLayout cardSavedPlaces = findViewById(R.id.cardSavedPlaces);
        LinearLayout cardMapView = findViewById(R.id.cardMapView);
        LinearLayout cardSearch = findViewById(R.id.cardSearch);
        LinearLayout cardSettings = findViewById(R.id.cardSettings);
        LinearLayout cardProfile = findViewById(R.id.cardProfile);

        cardFindLocation.setOnClickListener(v -> showModuleToast(R.string.module_find_location));
        cardSavedPlaces.setOnClickListener(v -> showModuleToast(R.string.module_saved_places));
        cardMapView.setOnClickListener(v -> showModuleToast(R.string.module_map_view));
        cardSearch.setOnClickListener(v -> showModuleToast(R.string.module_search));
        cardSettings.setOnClickListener(v -> showModuleToast(R.string.module_settings));

        cardProfile.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
            intent.putExtra("USER_NAME", userName);
            intent.putExtra("USER_EMAIL", userEmail);
            startActivity(intent);
        });
    }

    private void showModuleToast(int moduleNameRes) {
        String moduleName = getString(moduleNameRes);
        Toast.makeText(this, getString(R.string.module_clicked, moduleName), Toast.LENGTH_SHORT).show();
    }
}
