package com.petedunlap.upbright;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by petedunlap on 6/14/17.
 */

public class BrightnessService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

//    private WindowManager windowManager;
//    private ImageView emptyView;


    public BrightnessService() {
        super("BrightnessServiceName");
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        // Gets data from the incoming Intent

        String dataString = workIntent.getDataString();

//        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
//        emptyView = new ImageView(this);
//        emptyView.setImageResource(R.drawable.floating);
//
//        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.TYPE_TOAST,
//                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                PixelFormat.TRANSLUCENT);
//
//        params.gravity = Gravity.TOP | Gravity.LEFT;
//        params.x = 0;
//        params.y = 100;
//
//        windowManager.addView(emptyView, params);



//        Settings.ACTION_MANAGE_OVERLAY_PERMISSION


//        WindowManager.LayoutParams layout = getWindow().getAttributes();
//        layout.screenBrightness = 0;
//        getWindow().setAttributes(layout);
        Log.v("HHHHH", "service started");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (emptyView != null) windowManager.removeView(emptyView);
    }
}