// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.gifdecoder;

import java.util.ArrayList;
import java.util.List;

public class GifHeader
{
    int bgColor;
    int bgIndex;
    GifFrame currentFrame;
    int frameCount;
    List frames;
    int[] gct;
    boolean gctFlag;
    int gctSize;
    int height;
    int loopCount;
    int pixelAspect;
    int status;
    int width;
    
    public GifHeader() {
        this.gct = null;
        this.status = 0;
        this.frameCount = 0;
        this.frames = new ArrayList();
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getNumFrames() {
        return this.frameCount;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public int getWidth() {
        return this.width;
    }
}
