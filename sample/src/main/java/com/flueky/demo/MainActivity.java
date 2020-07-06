package com.flueky.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.flueky.android.yunba_demo.R;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;

import io.yunba.android.manager.YunBaManager;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private EditText edtAlias;
    private EditText edtChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAlias = findViewById(R.id.activity_main_edt_alias);
        edtChannel = findViewById(R.id.activity_main_edt_channel);
    }

    public void subcrib(View v) {

        YunBaManager.setAlias(getApplicationContext(), "t1", new IMqttActionListener() {

            @Override
            public void onSuccess(IMqttToken arg0) {
                Log.d(TAG, "Subscribe alias succeed");
            }

            @Override
            public void onFailure(IMqttToken arg0, Throwable arg1) {
                Log.d(TAG, "Subscribe alias failed");
                Log.d(TAG, "onFailure: " + arg1.getMessage());
            }
        });
    }

    public void push(View v) {
        YunBaManager.publishToAlias(this, "t1", "123", new IMqttActionListener() {
            @Override
            public void onSuccess(IMqttToken iMqttToken) {

                Log.d(TAG, "publish to alias succeed");
            }

            @Override
            public void onFailure(IMqttToken iMqttToken, Throwable throwable) {
                Log.d(TAG, "publish to alias failed");
                Log.d(TAG, "onFailure: " + throwable.getMessage());

            }
        });
    }
}
