package com.hs.andfixtest.activity;

import android.content.Intent;
import android.os.Bundle;
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
    }

    private void startPatchService() {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public static void printLog() {
        String error = "bug fixed.";
        Log.i("hello", error);
    }
}
