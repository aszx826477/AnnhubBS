// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request;

import com.bumptech.glide.request.target.Target;
import java.util.concurrent.Future;

public interface FutureTarget extends Future, Target
{
    void clear();
}
