package com.petedunlap.upbright;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

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

    private Object foo = new Object();
    private Handler mHandler = new Handler();
    public BrightnessService() {
        super("BrightnessServiceName");
    }





//    private boolean checkForPermissions() {
//        if (isPermissionGranted(WRITE_SETTINGS,  "write_external_storage_rationale", Permissions.WRITE_SETTINGS_RESULT_CODE)) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean isPermissionGranted(String permission, int rationaleResId, int requestCode) {
//        if (mPermissionUtil.permissionNotGranted(this, permission)) {
//            if (mPermissionUtil.shouldShowPermissionRationale(this, permission)) {
//                Timber.d("Showing rationale for permission");
//                AlertUtil.alertDialogDisplay(this, R.string.permission_error, rationaleResId, R.string.ok, (dialogInterface, i) -> mPermissionUtil.requestPermissions(this, new String[]{permission}, requestCode));
//            } else {
//                Timber.d("Requesting permission");
//                mPermissionUtil.requestPermissions(this, new String[]{permission}, requestCode);
//            }
//            return false;
//        } else {
//            Timber.d("Permission granted");
//            return true;
//        }
//    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case Permissions.WRITE_SETTINGS_RESULT_CODE:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // Timber.d("Write external storage permission granted");
//                    // CHANGE ANDROID BRIGHTNESS
//                    // startWebView();
//                    android.provider.Settings.System.putInt(getContentResolver(),
//                            android.provider.Settings.System.SCREEN_BRIGHTNESS, 0);
//                } else {
//                    // Timber.d("Write external storage permission denied");
//                    // AlertUtil.alertDialogDisplay(this, R.string.permission_error, R.string.write_external_storage_denied, R.string.ok, (dialogInterface, i) -> dialogInterface.dismiss());
//                }
//        }
//    }




//    ContextCompat.checkSelfPermission(MainActivity.this, permission) != PackageManager.PERMISSION_GRANTED






    @Override
    protected void onHandleIntent(Intent workIntent) {
        // Gets data from the incoming Intent

        String dataString = workIntent.getDataString();

        Log.v("HHHHH", "service started");
        final Intent dialogIntent = new Intent(this, EmptyActivity.class);
        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);



//
//        if (checkForPermissions()) {
//            // CHANGE ANDROID BRIGHTNESS
//            android.provider.Settings.System.putInt(getContentResolver(),
//                    android.provider.Settings.System.SCREEN_BRIGHTNESS, 0);
//
//        }



        mHandler.postDelayed(new Runnable() {
            public void run() {
                startActivity(dialogIntent);
            }
        }, 5000);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (emptyView != null) windowManager.removeView(emptyView);
    }
}