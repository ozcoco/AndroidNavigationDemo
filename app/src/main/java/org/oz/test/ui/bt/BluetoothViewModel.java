package org.oz.test.ui.bt;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import java.util.Set;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class BluetoothViewModel extends AndroidViewModel implements BluetoothContract.Model {

    public MutableLiveData<String> content = new MutableLiveData<>();

    public BluetoothViewModel(@NonNull Application application) {
        super(application);

        Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();

        StringBuilder builder = new StringBuilder();

        for (BluetoothDevice dev : bondedDevices) {

            builder.append(dev.getName())
                    .append(':')
                    .append(dev.getAddress())
                    .append('\n')
                    .append("\t\t")
                    .append("Class:")
                    .append(dev.getBluetoothClass().getDeviceClass())
                    .append('\n')
                    .append("\t\t")
                    .append("Major:")
                    .append(dev.getBluetoothClass().getMajorDeviceClass())
                    .append('\n');
        }

        content.setValue(builder.toString());

    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
