package com.sohuvideo.opensdk.demo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.sohuvideo.api.SohuPlayerSDK;
import com.sohuvideo.ui_plugin.api.UiPluginInit;
import com.sohuvideo.ui_plugin.fragment.SohuVideoFragment;

/**
 * 主工程
 */
public class MainActivity extends FragmentActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private FragmentManager manager;
    private SohuVideoFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        setUpViews();
    }

    private void setUpViews() {
        mFragment = new SohuVideoFragment();
        FragmentTransaction ts = manager.beginTransaction();
        ts.replace(R.id.id_content_fl, mFragment).commit();
    }

    private void initData() {
        manager = getSupportFragmentManager();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        UiPluginInit.close();
    }
}
