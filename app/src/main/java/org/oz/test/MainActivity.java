package org.oz.test;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;


@RuntimePermissions
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityPermissionsDispatcher.onPermissionWithPermissionCheck(this);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }


    @NeedsPermission(Manifest.permission.READ_PHONE_STATE)
    public void onPermission() {



    }


    @OnShowRationale(Manifest.permission.READ_PHONE_STATE)
    public void onPermissionRationale(PermissionRequest request) {

        Toast.makeText(this, "onPermissionRationale", Toast.LENGTH_SHORT).show();

        request.proceed();

    }

    @OnPermissionDenied(Manifest.permission.READ_PHONE_STATE)
    public void onPermissionDenied() {
        Toast.makeText(this, "onPermissionDenied", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(Manifest.permission.READ_PHONE_STATE)
    public void onPermissionNeverAskAgain() {
        Toast.makeText(this, "onPermissionNeverAskAgain", Toast.LENGTH_SHORT).show();
    }

}
