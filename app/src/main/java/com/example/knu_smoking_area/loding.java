package com.example.knu_smoking_area;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class loding extends AppCompatActivity {
    Animation anim;
    ImageView img_splash;
    SharedPreferences sf;
    FirebaseDatabase db;
    DatabaseReference mdr;
    String saved_id,saved_pw,changed_pw,saved_family;

    // 메인액티비티 수정입니다

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loding);
        startLoading();

    }
    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);

            }
        }, 3000);
    }

}