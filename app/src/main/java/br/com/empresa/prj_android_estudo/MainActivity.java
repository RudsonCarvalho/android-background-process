package br.com.empresa.prj_android_estudo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import service.PullingService;

public class MainActivity extends AppCompatActivity {

    private final static String TAG_LOG = "[MainActivity]";

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG_LOG, String.valueOf(count++) + " onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();


        Intent intent = new Intent(this, PullingService.class);
        startService(intent);


        Log.i(TAG_LOG, String.valueOf(count++) + " onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG_LOG, String.valueOf(count++) + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG_LOG, String.valueOf(count++) + " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG_LOG, String.valueOf(count++) + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG_LOG, String.valueOf(count++) + " onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG_LOG, String.valueOf(count++) + " onRestart");
    }

}
