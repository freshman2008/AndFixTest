package com.hs.andfixtest.andfix;

import com.hs.andfixtest.andfix.BasePatch;
import com.hs.andfixtest.util.MyOkHttpClient;
import com.hs.andfixtest.util.OnCommonResponse;
import com.hs.andfixtest.util.OnDownloadListener;

import java.io.File;

public class RequestCenter {
    private static final String UPDATE_PATCH_URL = "http://192.168.8.67:3000/users/getPatchInfo";
//    private static final String DOWNLOAD_PATCH_URL = "http://192.168.8.67:3000/images/1.png";

    public static void requestPatchUpdateInfo(OnCommonResponse listener) {
        MyOkHttpClient.getAsync(UPDATE_PATCH_URL, listener);
    }

    public static void downloadFile(String url, String path, String fileName, OnDownloadListener listener) {
        MyOkHttpClient.download(url, path, fileName, listener);
    }
}
