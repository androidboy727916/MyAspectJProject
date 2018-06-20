package com.hyh.myaspectjproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.xdja.permissionlibrary.annotation.HuPermission;


public class MainActivity extends AppCompatActivity {
    @HuPermission(permissions = {"android.permission.WRITE_EXTERNAL_STORAGE"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 这是申请权限是否成功回掉
     * @param requestCode
     * @param permissions
     * @param grantResults 不等于0就是没有申请成功
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
