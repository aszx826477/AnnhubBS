// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;

interface EngineJobListener
{
    void onEngineJobCancelled(final EngineJob p0, final Key p1);
    
    void onEngineJobComplete(final Key p0, final EngineResource p1);
}
