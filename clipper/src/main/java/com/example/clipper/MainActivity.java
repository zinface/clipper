package com.example.clipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= 26){
            // wifi filter
//            WifiStatusReceiver wifiRecevier = new WifiStatusReceiver();
//            IntentFilter wifiFilter = new IntentFilter();
//            wifiFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//            registerReceiver(wifiRecevier, wifiFilter);

            ClipboardReceiver clipboardReceiver = new ClipboardReceiver();
            IntentFilter clipboardFilter = new IntentFilter();
            clipboardFilter.addAction("clipper.get");
            clipboardFilter.addAction("clipper.set");
            clipboardFilter.addAction("get");
            clipboardFilter.addAction("get");
            registerReceiver(clipboardReceiver, clipboardFilter);

//            Intent serviIntent = new Intent(this, ClipboardService.class);
//            serviIntent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
//            startService(serviIntent);
        }

        Toast.makeText(getApplicationContext(), "剪贴板服务已启动~",Toast.LENGTH_SHORT).show();

//            ComponentName componentName = new ComponentName(getApplicationContext(),"cn.izis.kyteach.receiver.DataReceiverPublic");//参数1-包名 参数2-广播接收者所在的路径名
//            myIntent.setComponent(componentName);
//        <receiver
//          android:name=".ClipboardReceiver"
//          android:enabled="true"
//          android:exported="true">
//            <intent-filter>
//                <data android:scheme="clipper" />
//            </intent-filter>
//            <intent-filter>
//                <action android:name="clipper.get" />
//                <action android:name="clipper.set" />
//                <action android:name="set" />
//                <action android:name="set" />
//            </intent-filter>
//        </receiver>

//        Intent serviceIntent = new Intent(this, ClipboardService.class);
//        startService(serviceIntent);
        Log.d("------------", "Started Clipboard App");
    }
}