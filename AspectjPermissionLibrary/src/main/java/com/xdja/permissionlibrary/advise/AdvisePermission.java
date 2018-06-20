package com.xdja.permissionlibrary.advise;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.xdja.permissionlibrary.annotation.HuPermission;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class AdvisePermission implements IAspectj {
    @Around("execution(@com.xdja.permissionlibrary.annotation.HuPermission * *(..)) && @annotation(annot)")
    public Object weavePermission(ProceedingJoinPoint joinPoint, HuPermission annot) throws Throwable {
        Context context = (Context) joinPoint.getTarget();
        Log.e(TAG, "====1");
        if (!(context instanceof Activity)) {
            return null;
        }
        Log.e(TAG, "====2");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] psermissions = annot.permissions();
            if (!validatePermissions(context, psermissions)) {
                ActivityCompat.requestPermissions((Activity) context, psermissions, 1);
            } else {
                ((Activity) context).requestPermissions(psermissions, 1);
            }
        }
        return joinPoint.proceed();
    }

    private boolean validatePermissions(Context context, String... permissions) {
        for (String permission : permissions) {
            int result = ContextCompat.checkSelfPermission(context, permission);
            if (result == PackageManager.PERMISSION_GRANTED) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
