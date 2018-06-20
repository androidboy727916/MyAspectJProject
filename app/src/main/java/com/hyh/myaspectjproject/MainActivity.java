package com.hyh.myaspectjproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xdja.permissionlibrary.annotation.HuPermission;


public class MainActivity extends AppCompatActivity {
    @HuPermission(permissions = {"android.permission.WRITE_EXTERNAL_STORAGE"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
