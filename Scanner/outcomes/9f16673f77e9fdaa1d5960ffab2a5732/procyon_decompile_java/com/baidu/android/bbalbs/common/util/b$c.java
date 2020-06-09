// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.android.bbalbs.common.util;

import android.telephony.TelephonyManager;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import android.os.Process;
import android.os.SystemClock;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;
import android.provider.Settings$Secure;
import java.util.Iterator;
import android.os.Environment;
import java.util.UUID;
import android.os.Build$VERSION;
import android.util.Log;
import android.content.pm.Signature;
import java.security.Key;
import javax.crypto.Cipher;
import java.util.HashSet;
import android.provider.Settings$System;
import java.security.cert.Certificate;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.io.ByteArrayInputStream;
import org.json.JSONArray;
import android.content.pm.PackageInfo;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import java.util.Comparator;
import java.util.Collections;
import java.util.Arrays;
import com.baidu.android.bbalbs.common.a.d;
import org.json.JSONObject;
import android.text.TextUtils;
import android.content.ComponentName;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import java.io.File;
import java.security.PublicKey;
import android.content.Context;
import android.system.ErrnoException;
import android.system.Os;

class b$c
{
    static boolean a(final String s, final int n) {
        try {
            Os.chmod(s, n);
            return true;
        }
        catch (ErrnoException ex) {
            b((Throwable)ex);
            return false;
        }
    }
}
