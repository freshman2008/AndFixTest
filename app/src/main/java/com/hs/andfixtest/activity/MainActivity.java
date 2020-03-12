package com.hs.andfixtest.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hs.andfixtest.R;
import com.hs.andfixtest.andfix.AndFixPatchManager;
import com.hs.andfixtest.andfix.MyService;
import com.hs.andfixtest.util.Utils;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final String SUFFIX = ".apatch";
    private String mPathDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            mPathDir = getExternalCacheDir().getAbsolutePath() + "/apatch";
            File file = new File(mPathDir);
            if (file == null || !file.exists()) {
                file.mkdir();
            }

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.printLog();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndFixPatchManager.getInstance().addPatch(getPatchName());
            }
        });

        startPatchService();
    }

    private void startPatchService() {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    private String getPatchName() {
        return mPathDir.concat("/hs").concat(SUFFIX);
    }
}
