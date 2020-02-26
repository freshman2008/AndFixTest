package com.hs.andfixtest.andfix;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;
import com.hs.andfixtest.util.Utils;

public class AndFixPatchManager {
    private static AndFixPatchManager instance = null;
    private PatchManager mPatchManager;

    private AndFixPatchManager() {

    }

    public static AndFixPatchManager getInstance() {
        if (instance == null) {
            synchronized (AndFixPatchManager.class) {
                if (instance == null) {
                    instance = new AndFixPatchManager();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化AndFix方法
     *
     * @param context
     */
    public void initPatch(Context context) {
        mPatchManager = new PatchManager(context);
        mPatchManager.init(Utils.getVersionName(context));//current version
        mPatchManager.loadPatch();
    }

    /**
     * 加载patch文件
     *
     * @param path
     */
    public void addPatch(String path) {
        if (mPatchManager != null) {
            try {
                mPatchManager.addPatch(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
