 package com.blogspot.guestlion.myloginapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;


 public class MainActivity extends AppCompatActivity {

     Button button, button2, button3, dualcamera;
     FirebaseAuth mAuth;
     FirebaseAuth.AuthStateListener mAuthListener;

     @Override
     protected void onStart() {
         super.onStart();
         mAuth.addAuthStateListener(mAuthListener);
     }

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         // Logout Button Code
         button = (Button) findViewById(R.id.logoutbtn);
         button2 = (Button) findViewById(R.id.button2);
         button3 = (Button) findViewById(R.id.button3);
         dualcamera = (Button) findViewById(R.id.dualcamera);
         mAuth = FirebaseAuth.getInstance();


         mAuthListener = new FirebaseAuth.AuthStateListener() {
             @Override
             public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                 if (firebaseAuth.getCurrentUser() == null) {
                     Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                     startActivity(intent);
                 }
             }
         };

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mAuth.signOut();
             }
         });

         button3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, NavigationDrawerActivity.class);
                 startActivity(intent);
             }
         });

         button2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, CoordinatorLayout.class);
                 startActivity(intent);
             }
         });

         dualcamera.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, DualCamActivity.class);
                 startActivity(intent);
             }
         });

     }



 }
