package com.sohuvideo.opensdk.demo;

import com.android.sohu.sdk.common.toolbox.LogUtils;
import com.android.sohu.sdk.common.toolbox.StringUtils;
import com.google.gson.Gson;
import com.sohuvideo.push.SohuPushMessageService;
import com.sohuvideo.push.model.PushMessageData;

import org.json.JSONObject;

public class MyPushService extends SohuPushMessageService {
    public static final String TAG = MyPushService.class.getSimpleName();
    
    @Override
    protected void onMessageReceived(String message) {
        if (StringUtils.isNotBlank(message)) {
            Gson gson = new Gson();
            try {
                JSONObject jsObj = new JSONObject(message);
                String str = jsObj.getString("extra");
                if (StringUtils.isBlank(str)) {
                    return;
                }
                PushMessageData data = gson.fromJson(str, PushMessageData.class);
                if (data != null) {
                    showNotification(data);
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "parse message failure: " + e.getMessage());
            }
        }

    }
    
    private void showNotification(PushMessageData message) {
        if (message == null) {
            LogUtils.e(TAG, "showNotification message == null!!!!");
            return;
        }
        LogUtils.d(TAG, "PushService showNotification : " + message.getContent());
        
        PushNotification pushNotification = new PushNotification(this, message);
        pushNotification.showNotification(this);
    }

}
