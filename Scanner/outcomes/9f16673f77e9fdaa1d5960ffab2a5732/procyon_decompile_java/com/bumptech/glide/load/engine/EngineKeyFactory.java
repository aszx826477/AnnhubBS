// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Key;

class EngineKeyFactory
{
    public EngineKey buildKey(final String s, final Key key, final int n, final int n2, final ResourceDecoder resourceDecoder, final ResourceDecoder resourceDecoder2, final Transformation transformation, final ResourceEncoder resourceEncoder, final ResourceTranscoder resourceTranscoder, final Encoder encoder) {
        return new EngineKey(s, key, n, n2, resourceDecoder, resourceDecoder2, transformation, resourceEncoder, resourceTranscoder, encoder);
    }
}
