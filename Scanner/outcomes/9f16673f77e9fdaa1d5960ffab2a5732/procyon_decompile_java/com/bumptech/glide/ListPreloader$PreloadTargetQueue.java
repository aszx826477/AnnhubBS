// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.util.Util;
import java.util.Queue;

final class ListPreloader$PreloadTargetQueue
{
    private final Queue queue;
    
    public ListPreloader$PreloadTargetQueue(final int n) {
        this.queue = Util.createQueue(n);
        for (int i = 0; i < n; ++i) {
            this.queue.offer(new ListPreloader$PreloadTarget(null));
        }
    }
    
    public ListPreloader$PreloadTarget next(final int n, final int n2) {
        final ListPreloader$PreloadTarget listPreloader$PreloadTarget = this.queue.poll();
        this.queue.offer(listPreloader$PreloadTarget);
        listPreloader$PreloadTarget.photoWidth = n;
        listPreloader$PreloadTarget.photoHeight = n2;
        return listPreloader$PreloadTarget;
    }
}
