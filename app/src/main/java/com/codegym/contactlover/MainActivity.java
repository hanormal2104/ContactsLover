package com.codegym.contactlover;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import java.net.URI;
import java.util.Random;

public class MainActivity extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        final int count = appWidgetIds.length;
            // Thực hiện vòng lặp for để lấy ra id của widget muốn update từ tất cả các widget của hệ thống.
        for (int i = 0; i < count; i++) {
            int widgetId = appWidgetIds[i];
            // Để đơn giản thì sẽ lưu số điện thoại yêu thích vào một biến String
            // Tất nhiên bạn cũng có thể code để nhập số điện thoại yêu thích trực tiếp từ widget.
            String number = "0983402485";


            // Tiếp theo sẽ tạo một Intent để khởi chạy trình gọi điện thoại của hệ thống, với input là số điện thoại đã lưu ở bước trên
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",number,null));
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            // Lấy ra layout cho ứng dụng widget và đính kèm một trình lắng nghe khi chúng ta click vào widget
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.activity_main);
            remoteViews.setOnClickPendingIntent(R.id.tvContact, pendingIntent);

            // Thông báo cho AppWidgetManager để thực hiện cập nhật app widget hiện tại, với input là id widget và layout đã lấy ra ở bước trên.
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }
}
