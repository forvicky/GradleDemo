package com.zdd.gradledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zdd.mylibrary.LibraryUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LibraryUtil.getLibraryName();
    }
}
