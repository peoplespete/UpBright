package com.petedunlap.upbright;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;

import static android.view.WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
import static android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;

public class EmptyActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.v("HELLO", "dddd");
                    //permission accepted
                    android.provider.Settings.System.putInt(getContentResolver(),
                            android.provider.Settings.System.SCREEN_BRIGHTNESS, 0);

                } else {
                    Log.v("HELLO", "DARN IT");
                    // permission denied,
                }
                return;
            }

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();

        // Let touches go through to apps/activities underneath.
        window.addFlags(FLAG_NOT_TOUCHABLE);
        window.addFlags(FLAG_NOT_FOCUSABLE);
        setContentView(R.layout.activity_empty);

//        WindowManager.LayoutParams layout = getWindow().getAttributes();
//        layout.screenBrightness = 0;
//        getWindow().setAttributes(layout);
//        Log.v("CLOSING ACTIVITY", "really");

//        ContextCompat.checkSelfPermission(EmptyActivity, Manifest.permission.WRITE_SETTINGS
//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_SETTINGS}, 1);


//        finish();
        mHandler.postDelayed(new Runnable() {
            public void run() {
//                EmptyActivity.this.finish();
            }
        }, 2000);


//        finish();

    }


//    private static final int DELAYED_MESSAGE = 1;
//
//    private Handler handler;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        handler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                if(msg.what == DELAYED_MESSAGE) {
//                    EmptyActivity.this.finish();
//                }
//                super.handleMessage(msg);
//            }
//        };
//        Intent brightnessIntent = this.getIntent();
//        float brightness = brightnessIntent.getFloatExtra("brightness value", 0);
//        WindowManager.LayoutParams lp = getWindow().getAttributes();
//        lp.screenBrightness = brightness;
//        getWindow().setAttributes(lp);
//
//        Message message = handler.obtainMessage(DELAYED_MESSAGE);
//        //this next line is very important, you need to finish your activity with slight delay
//        handler.sendMessageDelayed(message,1000);
//    }
//

}
