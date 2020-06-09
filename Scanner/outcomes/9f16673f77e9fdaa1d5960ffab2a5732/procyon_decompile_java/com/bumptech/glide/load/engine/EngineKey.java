// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Key;

class EngineKey implements Key
{
    private static final String EMPTY_LOG_STRING = "";
    private final ResourceDecoder cacheDecoder;
    private final ResourceDecoder decoder;
    private final ResourceEncoder encoder;
    private int hashCode;
    private final int height;
    private final String id;
    private Key originalKey;
    private final Key signature;
    private final Encoder sourceEncoder;
    private String stringKey;
    private final ResourceTranscoder transcoder;
    private final Transformation transformation;
    private final int width;
    
    public EngineKey(final String id, final Key signature, final int width, final int height, final ResourceDecoder cacheDecoder, final ResourceDecoder decoder, final Transformation transformation, final ResourceEncoder encoder, final ResourceTranscoder transcoder, final Encoder sourceEncoder) {
        this.id = id;
        this.signature = signature;
        this.width = width;
        this.height = height;
        this.cacheDecoder = cacheDecoder;
        this.decoder = decoder;
        this.transformation = transformation;
        this.encoder = encoder;
        this.transcoder = transcoder;
        this.sourceEncoder = sourceEncoder;
    }
    
    public boolean equals(final Object o) {
        final boolean b = true;
        if (this == o) {
            return b;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final EngineKey engineKey = (EngineKey)o;
        if (!this.id.equals(engineKey.id)) {
            return false;
        }
        if (!this.signature.equals(engineKey.signature)) {
            return false;
        }
        if (this.height != engineKey.height) {
            return false;
        }
        if (this.width != engineKey.width) {
            return false;
        }
        if (this.transformation == null ^ engineKey.transformation == null) {
            return false;
        }
        final Transformation transformation = this.transformation;
        if (transformation != null && !transformation.getId().equals(engineKey.transformation.getId())) {
            return false;
        }
        if (this.decoder == null ^ engineKey.decoder == null) {
            return false;
        }
        final ResourceDecoder decoder = this.decoder;
        if (decoder != null && !decoder.getId().equals(engineKey.decoder.getId())) {
            return false;
        }
        if (this.cacheDecoder == null ^ engineKey.cacheDecoder == null) {
            return false;
        }
        final ResourceDecoder cacheDecoder = this.cacheDecoder;
        if (cacheDecoder != null && !cacheDecoder.getId().equals(engineKey.cacheDecoder.getId())) {
            return false;
        }
        if (this.encoder == null ^ engineKey.encoder == null) {
            return false;
        }
        final ResourceEncoder encoder = this.encoder;
        if (encoder != null && !encoder.getId().equals(engineKey.encoder.getId())) {
            return false;
        }
        if (this.transcoder == null ^ engineKey.transcoder == null) {
            return false;
        }
        final ResourceTranscoder transcoder = this.transcoder;
        if (transcoder != null && !transcoder.getId().equals(engineKey.transcoder.getId())) {
            return false;
        }
        if (this.sourceEncoder == null ^ engineKey.sourceEncoder == null) {
            return false;
        }
        final Encoder sourceEncoder = this.sourceEncoder;
        return (sourceEncoder == null || sourceEncoder.getId().equals(engineKey.sourceEncoder.getId())) && b;
    }
    
    public Key getOriginalKey() {
        if (this.originalKey == null) {
            this.originalKey = new OriginalKey(this.id, this.signature);
        }
        return this.originalKey;
    }
    
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = this.id.hashCode();
            this.hashCode = this.hashCode * 31 + this.signature.hashCode();
            this.hashCode = this.hashCode * 31 + this.width;
            this.hashCode = this.hashCode * 31 + this.height;
            final int n = this.hashCode * 31;
            final ResourceDecoder cacheDecoder = this.cacheDecoder;
            int hashCode = 0;
            int hashCode2;
            if (cacheDecoder != null) {
                hashCode2 = cacheDecoder.getId().hashCode();
            }
            else {
                hashCode2 = 0;
            }
            this.hashCode = n + hashCode2;
            final int n2 = this.hashCode * 31;
            final ResourceDecoder decoder = this.decoder;
            int hashCode3;
            if (decoder != null) {
                hashCode3 = decoder.getId().hashCode();
            }
            else {
                hashCode3 = 0;
            }
            this.hashCode = n2 + hashCode3;
            final int n3 = this.hashCode * 31;
            final Transformation transformation = this.transformation;
            int hashCode4;
            if (transformation != null) {
                hashCode4 = transformation.getId().hashCode();
            }
            else {
                hashCode4 = 0;
            }
            this.hashCode = n3 + hashCode4;
            final int n4 = this.hashCode * 31;
            final ResourceEncoder encoder = this.encoder;
            int hashCode5;
            if (encoder != null) {
                hashCode5 = encoder.getId().hashCode();
            }
            else {
                hashCode5 = 0;
            }
            this.hashCode = n4 + hashCode5;
            final int n5 = this.hashCode * 31;
            final ResourceTranscoder transcoder = this.transcoder;
            int hashCode6;
            if (transcoder != null) {
                hashCode6 = transcoder.getId().hashCode();
            }
            else {
                hashCode6 = 0;
            }
            this.hashCode = n5 + hashCode6;
            final int n6 = this.hashCode * 31;
            final Encoder sourceEncoder = this.sourceEncoder;
            if (sourceEncoder != null) {
                hashCode = sourceEncoder.getId().hashCode();
            }
            this.hashCode = n6 + hashCode;
        }
        return this.hashCode;
    }
    
    public String toString() {
        if (this.stringKey == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("EngineKey{");
            sb.append(this.id);
            final char c = '+';
            sb.append(c);
            sb.append(this.signature);
            sb.append("+[");
            sb.append(this.width);
            sb.append('x');
            sb.append(this.height);
            sb.append("]+");
            final char c2 = '\'';
            sb.append(c2);
            final ResourceDecoder cacheDecoder = this.cacheDecoder;
            String id;
            if (cacheDecoder != null) {
                id = cacheDecoder.getId();
            }
            else {
                id = "";
            }
            sb.append(id);
            sb.append(c2);
            sb.append(c);
            sb.append(c2);
            final ResourceDecoder decoder = this.decoder;
            String id2;
            if (decoder != null) {
                id2 = decoder.getId();
            }
            else {
                id2 = "";
            }
            sb.append(id2);
            sb.append(c2);
            sb.append(c);
            sb.append(c2);
            final Transformation transformation = this.transformation;
            String id3;
            if (transformation != null) {
                id3 = transformation.getId();
            }
            else {
                id3 = "";
            }
            sb.append(id3);
            sb.append(c2);
            sb.append(c);
            sb.append(c2);
            final ResourceEncoder encoder = this.encoder;
            String id4;
            if (encoder != null) {
                id4 = encoder.getId();
            }
            else {
                id4 = "";
            }
            sb.append(id4);
            sb.append(c2);
            sb.append(c);
            sb.append(c2);
            final ResourceTranscoder transcoder = this.transcoder;
            String id5;
            if (transcoder != null) {
                id5 = transcoder.getId();
            }
            else {
                id5 = "";
            }
            sb.append(id5);
            sb.append(c2);
            sb.append(c);
            sb.append(c2);
            final Encoder sourceEncoder = this.sourceEncoder;
            String id6;
            if (sourceEncoder != null) {
                id6 = sourceEncoder.getId();
            }
            else {
                id6 = "";
            }
            sb.append(id6);
            sb.append(c2);
            sb.append('}');
            this.stringKey = sb.toString();
        }
        return this.stringKey;
    }
    
    public void updateDiskCacheKey(final MessageDigest messageDigest) {
        final byte[] array = ByteBuffer.allocate(8).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        messageDigest.update(this.id.getBytes("UTF-8"));
        messageDigest.update(array);
        final ResourceDecoder cacheDecoder = this.cacheDecoder;
        String id;
        if (cacheDecoder != null) {
            id = cacheDecoder.getId();
        }
        else {
            id = "";
        }
        messageDigest.update(id.getBytes("UTF-8"));
        final ResourceDecoder decoder = this.decoder;
        String id2;
        if (decoder != null) {
            id2 = decoder.getId();
        }
        else {
            id2 = "";
        }
        messageDigest.update(id2.getBytes("UTF-8"));
        final Transformation transformation = this.transformation;
        String id3;
        if (transformation != null) {
            id3 = transformation.getId();
        }
        else {
            id3 = "";
        }
        messageDigest.update(id3.getBytes("UTF-8"));
        final ResourceEncoder encoder = this.encoder;
        String id4;
        if (encoder != null) {
            id4 = encoder.getId();
        }
        else {
            id4 = "";
        }
        messageDigest.update(id4.getBytes("UTF-8"));
        final Encoder sourceEncoder = this.sourceEncoder;
        String id5;
        if (sourceEncoder != null) {
            id5 = sourceEncoder.getId();
        }
        else {
            id5 = "";
        }
        messageDigest.update(id5.getBytes("UTF-8"));
    }
}
