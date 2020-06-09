// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import android.widget.AbsListView;
import java.util.List;
import com.bumptech.glide.request.target.Target;
import android.widget.AbsListView$OnScrollListener;

public class ListPreloader implements AbsListView$OnScrollListener
{
    private boolean isIncreasing;
    private int lastEnd;
    private int lastFirstVisible;
    private int lastStart;
    private final int maxPreload;
    private final ListPreloader$PreloadSizeProvider preloadDimensionProvider;
    private final ListPreloader$PreloadModelProvider preloadModelProvider;
    private final ListPreloader$PreloadTargetQueue preloadTargetQueue;
    private int totalItemCount;
    
    public ListPreloader(final int maxPreload) {
        this.isIncreasing = true;
        this.preloadModelProvider = new ListPreloader$1(this);
        this.preloadDimensionProvider = new ListPreloader$2(this);
        this.maxPreload = maxPreload;
        this.preloadTargetQueue = new ListPreloader$PreloadTargetQueue(maxPreload + 1);
    }
    
    public ListPreloader(final ListPreloader$PreloadModelProvider preloadModelProvider, final ListPreloader$PreloadSizeProvider preloadDimensionProvider, final int maxPreload) {
        this.isIncreasing = true;
        this.preloadModelProvider = preloadModelProvider;
        this.preloadDimensionProvider = preloadDimensionProvider;
        this.maxPreload = maxPreload;
        this.preloadTargetQueue = new ListPreloader$PreloadTargetQueue(maxPreload + 1);
    }
    
    private void cancelAll() {
        for (int i = 0; i < this.maxPreload; ++i) {
            Glide.clear(this.preloadTargetQueue.next(0, 0));
        }
    }
    
    private void preload(final int n, final int n2) {
        int max;
        int min;
        if (n < n2) {
            max = Math.max(this.lastEnd, n);
            min = n2;
        }
        else {
            max = n2;
            min = Math.min(this.lastStart, n);
        }
        final int min2 = Math.min(this.totalItemCount, min);
        final int min3 = Math.min(this.totalItemCount, Math.max(0, max));
        if (n < n2) {
            for (int i = min3; i < min2; ++i) {
                this.preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i), i, true);
            }
        }
        else {
            for (int j = min2 - 1; j >= min3; --j) {
                this.preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(j), j, false);
            }
        }
        this.lastStart = min3;
        this.lastEnd = min2;
    }
    
    private void preload(final int n, final boolean isIncreasing) {
        if (this.isIncreasing != isIncreasing) {
            this.isIncreasing = isIncreasing;
            this.cancelAll();
        }
        int maxPreload;
        if (isIncreasing) {
            maxPreload = this.maxPreload;
        }
        else {
            maxPreload = -this.maxPreload;
        }
        this.preload(n, maxPreload + n);
    }
    
    private void preloadAdapterPosition(final List list, final int n, final boolean b) {
        final int size = list.size();
        if (b) {
            for (int i = 0; i < size; ++i) {
                this.preloadItem(list.get(i), n, i);
            }
        }
        else {
            for (int j = size - 1; j >= 0; --j) {
                this.preloadItem(list.get(j), n, j);
            }
        }
    }
    
    private void preloadItem(final Object o, final int n, final int n2) {
        final int[] preloadSize = this.preloadDimensionProvider.getPreloadSize(o, n, n2);
        if (preloadSize != null) {
            this.preloadModelProvider.getPreloadRequestBuilder(o).into(this.preloadTargetQueue.next(preloadSize[0], preloadSize[1]));
        }
    }
    
    protected int[] getDimensions(final Object o) {
        throw new IllegalStateException("You must either provide a PreloadDimensionProvider or override getDimensions()");
    }
    
    protected List getItems(final int n, final int n2) {
        throw new IllegalStateException("You must either provide a PreloadModelProvider or override getItems()");
    }
    
    protected GenericRequestBuilder getRequestBuilder(final Object o) {
        throw new IllegalStateException("You must either provide a PreloadModelProvider, or override getRequestBuilder()");
    }
    
    public void onScroll(final AbsListView absListView, final int lastFirstVisible, final int n, final int totalItemCount) {
        this.totalItemCount = totalItemCount;
        final int lastFirstVisible2 = this.lastFirstVisible;
        if (lastFirstVisible > lastFirstVisible2) {
            this.preload(lastFirstVisible + n, true);
        }
        else if (lastFirstVisible < lastFirstVisible2) {
            this.preload(lastFirstVisible, false);
        }
        this.lastFirstVisible = lastFirstVisible;
    }
    
    public void onScrollStateChanged(final AbsListView absListView, final int n) {
    }
}
