package com.sohuvideo.opensdk.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.sohuvideo.push.model.PushMessageData;

/**
 * Created by hixon on 12/7/15.
 */
public class PushTransparentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Context appContext = getApplicationContext();
        if (intent != null && appContext != null) {
            PushMessageData data = (PushMessageData) intent.getSerializableExtra(AppConstants.PUSH_DATA_EXTRA);
            Toast.makeText(appContext, "已经处理Action跳转: " + data.getAction(), Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
