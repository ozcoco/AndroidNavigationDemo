package org.oz.test.ui.bt;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;

import com.yf.btp.PrinterService;

import org.oz.test.R;
import org.oz.test.base.controller.BaseController;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public class BluetoothController extends BaseController<BluetoothFragment> implements ServiceConnection, BluetoothContract.View {


    private PrinterService mPrinterService;


    @Override
    public void print() {

        if (getFragment() == null) return;

        final Context context = getFragment().getContext();

        if (context == null) return;

        new Thread(() -> {

            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_btm);

            mPrinterService.printBitmap(bitmap);

        }).start();

    }

    @Override
    public void pickPrinter() {

        if (getFragment() == null) return;

        final Context context = getFragment().getContext();

        if (context == null) return;

        mPrinterService.setPickedPrinterCallback(dev -> {

            showMessage(dev.getName());

        });

        mPrinterService.pickPrinter(context);

    }


    @Override
    public void onServiceConnected(ComponentName className, IBinder service) {

        PrinterService.LocalBinder binder = (PrinterService.LocalBinder) service;

        mPrinterService = binder.getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName className) {
        mPrinterService = null;
    }


    private void bindService() {

        if (getFragment() == null) return;

        final Context context = getFragment().getContext();

        if (context == null) return;

        context.startService(new Intent(context, PrinterService.class));

        Intent intent = new Intent(context, PrinterService.class);

        context.bindService(intent, this, Context.BIND_AUTO_CREATE); // bindService

    }

    private void unbindService() {

        if (getFragment() == null) return;

        final Context context = getFragment().getContext();

        if (context == null) return;

        context.unbindService(this);

        context.stopService(new Intent(context, PrinterService.class));
    }


    BluetoothController(@NonNull BluetoothFragment fragment) {
        super(fragment);
    }

    @Override
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {
        super.onAny(owner, event);
    }


    @Override
    public void onCreate() {
        super.onCreate();

        bindService();
    }

    @Override
    public void onStart() {
        super.onStart();

    }


    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
        unbindService();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();


    }

}
