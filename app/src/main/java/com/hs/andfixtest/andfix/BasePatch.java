package com.hs.andfixtest.andfix;

import java.io.Serializable;

public class BasePatch implements Serializable {
    public int code;
    public String message;
    public PatchInfo data;
}
