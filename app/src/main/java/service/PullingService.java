package service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by rudsonkiyoshi on 23/11/16.
 */
public class PullingService extends Service {


    private static final String TAG = "HelloService";

    private boolean isRunning  = false;

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate");

        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "Service onStartCommand");

        //Criando uma thread
        new Thread(new Runnable() {
            @Override
            public void run() {

                isRunning = true;

                int count = 0;

                while (isRunning) {
                    try {

                        //fazer algo aqui
                        Thread.sleep(1000);


                    } catch (Exception e) {
                    }

                    if(isRunning){
                        Log.i(TAG, "Service running ".concat(String.valueOf(count++)));
                    }
                }

                //Stop service
                stopSelf();
            }
        }).start();

        return Service.START_STICKY;
    }


    @Override
    public IBinder onBind(Intent arg0) {
        Log.i(TAG, "Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {

        isRunning = false;

        Log.i(TAG, "Service onDestroy");
    }
}
