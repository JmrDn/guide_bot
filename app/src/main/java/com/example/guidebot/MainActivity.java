package com.example.guidebot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guidebot.Fragments.MapFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    CardView locationBtn, pulseBtn, voiceBtn, cameraBtn;
    AppCompatButton logoutBtn;

 

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        locationBtn = findViewById(R.id.location);
        pulseBtn = findViewById(R.id.pulse);
        voiceBtn = findViewById(R.id.voice);
        cameraBtn = findViewById(R.id.camera);
        logoutBtn = findViewById(R.id.logout_Button);

        logoutBtn.setOnClickListener(v->{
            Toast.makeText(getApplicationContext(), "Successfully log out", Toast.LENGTH_LONG).show();
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(),Login.class));
        });
        
        locationBtn.setOnClickListener(v->{
            goToMapActivity();
        });
        
        pulseBtn.setOnClickListener(v->{
            goToPulseRateActivity();
        });
        
        voiceBtn.setOnClickListener(v->{
            goToVoiceActivity();
        });
        cameraBtn.setOnClickListener(v->{
            goToLiveCameraActivity();
        });
        
       
    }

    private void goToLiveCameraActivity() {
        startActivity(new Intent(getApplicationContext(), LiveCameraActivity.class));
    }

    private void goToVoiceActivity() {
        startActivity(new Intent(getApplicationContext(), VoiceActivity.class));
    }

    private void goToPulseRateActivity() {
        startActivity(new Intent(getApplicationContext(), PulseRateActivity.class));
    }

    private void goToMapActivity() {
        startActivity(new Intent(getApplicationContext(), MapActivity.class));
    }


}