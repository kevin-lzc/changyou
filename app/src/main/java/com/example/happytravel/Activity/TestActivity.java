package com.example.happytravel.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.happytravel.R;

public class TestActivity extends AppCompatActivity {
 @Override
 protected void onCreate(@Nullable Bundle savedInstanceState) {
  setTheme(R.style.AppTheme);
  super.onCreate(savedInstanceState);
  setContentView(R.layout.main_page);
 }
}
