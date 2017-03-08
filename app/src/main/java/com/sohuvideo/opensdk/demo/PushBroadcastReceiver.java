package com.sohuvideo.opensdk.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.android.sohu.sdk.common.toolbox.StringUtils;
import com.sohuvideo.push.model.PushMessageData;

/**
 * Created by hixon on 12/7/15.
 */
public class PushBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        PushMessageData data = (PushMessageData) intent.getSerializableExtra(AppConstants.PUSH_DATA_EXTRA);
        if (!StringUtils.isBlank(data.getAction())) {
            // 处理Action跳转
            Intent i = new Intent(context, PushTransparentActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra(AppConstants.PUSH_DATA_EXTRA, data);
            context.startActivity(i);
        }
    }
}
