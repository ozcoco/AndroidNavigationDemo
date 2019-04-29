package com.map;

import android.os.Bundle;

public interface ILifeCycle {

    void onCreate(Bundle savedInstanceState);

    void onSaveInstanceState(Bundle outState);

    void onResume();

    void onPause();

    void onDestroy();
}
