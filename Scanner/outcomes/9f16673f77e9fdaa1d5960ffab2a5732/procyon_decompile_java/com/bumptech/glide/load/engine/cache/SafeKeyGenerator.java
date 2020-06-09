// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;

class SafeKeyGenerator
{
    private final LruCache loadIdToSafeHash;
    
    SafeKeyGenerator() {
        this.loadIdToSafeHash = new LruCache(1000);
    }
    
    public String getSafeKey(final Key key) {
        Object o = this.loadIdToSafeHash;
        synchronized (o) {
            String s2;
            final String s = s2 = (String)this.loadIdToSafeHash.get(key);
            // monitorexit(o)
            if (s == null) {
                o = "SHA-256";
                try {
                    final MessageDigest instance = MessageDigest.getInstance((String)o);
                    key.updateDiskCacheKey(instance);
                    final byte[] digest = instance.digest();
                    try {
                        s2 = (String)(o = Util.sha256BytesToHex(digest));
                    }
                    catch (NoSuchAlgorithmException o) {
                        ((NoSuchAlgorithmException)o).printStackTrace();
                    }
                    catch (UnsupportedEncodingException o) {
                        ((UnsupportedEncodingException)o).printStackTrace();
                    }
                }
                catch (NoSuchAlgorithmException ex) {}
                catch (UnsupportedEncodingException ex2) {}
                o = s2;
                synchronized (this.loadIdToSafeHash) {
                    this.loadIdToSafeHash.put(key, o);
                    return (String)o;
                }
            }
            o = s;
            return (String)o;
        }
    }
}
