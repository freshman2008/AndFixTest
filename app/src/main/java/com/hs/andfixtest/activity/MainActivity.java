package com.hs.andfixtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.fixlib.andfix.AndFixPatchManager;
import com.example.fixlib.andfix.MyService;
import com.hs.andfixtest.R;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final String SUFFIX = ".apatch";
    private String mPathDir;
    public static Handler mHandler = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startPatchService();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printLog();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPathDir = getExternalCacheDir().getAbsolutePath() + "/apatch";
                File file = new File(mPathDir);
                if (file == null || !file.exists()) {
                    file.mkdir();
                }
                AndFixPatchManager.getInstance().addPatch(mPathDir.concat("/hs").concat(SUFFIX));
            }
        });
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1001) {
                    Log.d("hello", "startPatchService");
                    startPatchService();
                }
            }
        };
    }

    public void startPatchService() {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public static void printLog() {
        String error = null;
        Log.i("hello", error);
    }
}
