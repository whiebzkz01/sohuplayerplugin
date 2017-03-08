package com.sohuvideo.opensdk.demo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.webkit.URLUtil;
import android.widget.RemoteViews;

import com.android.sohu.sdk.common.toolbox.LogUtils;
import com.android.sohu.sdk.common.toolbox.StringUtils;
import com.sohu.lib.net.request.RequestManager;
import com.sohu.lib.net.request.listener.ImageResponseListener;
import com.sohuvideo.push.model.PushMessageData;

/**
 * Created by hixon on 11/30/15.
 */
public class PushNotification {
    public static final String TAG = PushNotification.class.getSimpleName();
    public static final String TAG_PUSH_NOTIFICATION = "pushNotification";
    private PushMessageData data;

    public PushNotification(Context context, PushMessageData data) {
        this.data = data;
    }

    public void showNotification(final Context context) {
        final NotificationManager notificationManager = (NotificationManager) context.getApplicationContext()
                .getSystemService(Context.NOTIFICATION_SERVICE);

        if (StringUtils.isBlank(data.getPic_url())) {
            Notification notification = getNotification(context, null);
            if (notification == null) {
                return;
            }
            LogUtils.d(TAG, "showNotification : pic_url is blank.");
            notificationManager.notify(getNotificationTag(), getNotificationId(), notification);
        } else {
            int width = context.getResources().getDimensionPixelSize(R.dimen.push_icon_width);
            int height = context.getResources().getDimensionPixelSize(R.dimen.push_icon_heigh);
            if (!URLUtil.isValidUrl(data.getPic_url())) {
                Notification notification = getNotification(context, null);
                if (notification == null) {
                    return;
                }
                LogUtils.d(TAG, "showNotification : pic_url is invalid.");
                notificationManager.notify(getNotificationTag(), getNotificationId(), notification);
            }
            RequestManager manager = new RequestManager();
            manager.startImageRequestAsync(data.getPic_url(), width, height, new ImageResponseListener() {
                @Override
                public void onSuccess(Bitmap bitmap, boolean b) {
                    Notification notification = getNotification(context, bitmap);
                    if (notification == null) {
                        return;
                    }
                    notificationManager.notify(getNotificationTag(), getNotificationId(), notification);
                }

                @Override
                public void onFailure() {
                    LogUtils.d(TAG, "showNotification : get pic_url failed.");
                    Notification notification = getNotification(context, null);
                    if (notification == null) {
                        return;
                    }
                    notificationManager.notify(getNotificationTag(), getNotificationId(), notification);
                }
            });
        }

    }

    public void cancelNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getApplicationContext()
                .getSystemService(Context.NOTIFICATION_SERVICE);
        if (StringUtils.isEmpty(getNotificationTag())) {
            notificationManager.cancel(getNotificationId());
        } else {
            notificationManager.cancel(getNotificationTag(), getNotificationId());
        }
    }

    public static void cancelAllNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getApplicationContext()
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
    }

    public Notification getNotification(Context context, Bitmap bmp) {
        if (data == null) {
            return null;
        }

        Intent broadCastIntent = new Intent();
        broadCastIntent.setAction(AppConstants.PUSH_ACTION_JUMP);
        broadCastIntent.putExtra(AppConstants.PUSH_DATA_EXTRA, data);

        String desc = data.getContent();
        if (TextUtils.isEmpty(desc)) {
            desc = "";
        }
        String title = data.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = context.getString(R.string.app_name);
        }
        PendingIntent contentIntent = PendingIntent.getBroadcast(context, getNotificationId(), broadCastIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        /**
         * 用builder方式构造notification布局，setSmallIcon setLargeIcon时SmallIcon会 出现在右侧
         */
        long time = System.currentTimeMillis() + DateUtils.DAY_IN_MILLIS * 10;
        Notification notification = new Notification(R.mipmap.ic_launcher, desc, time);
        RemoteViews views = getRemoteView(context, title, desc, bmp);
        if (views != null) {
            notification.contentView = views;
        } else {
            return null;
        }
        notification.contentIntent = contentIntent;
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        return notification;
    }

    private RemoteViews getRemoteView(Context context, String title, String des, Bitmap bmp) {
        final RemoteViews rv = new RemoteViews(context.getPackageName(),
                R.layout.notification_layout);
        rv.setTextViewText(R.id.txtTitle, title);
        rv.setTextViewText(R.id.txtContent, des);
        if (bmp != null) {
            rv.setImageViewBitmap(R.id.imgTitle, bmp);
        }
        return rv;
    }

    public String getNotificationTag() {
        return TAG_PUSH_NOTIFICATION;
    }


    public int getNotificationId() {
        return (int)data.getId();
    }

}
