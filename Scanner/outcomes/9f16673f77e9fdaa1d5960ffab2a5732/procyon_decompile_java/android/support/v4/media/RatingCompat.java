// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Parcel;
import android.util.Log;
import android.os.Build$VERSION;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class RatingCompat implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;
    
    static {
        CREATOR = (Parcelable$Creator)new RatingCompat$1();
    }
    
    RatingCompat(final int mRatingStyle, final float mRatingValue) {
        this.mRatingStyle = mRatingStyle;
        this.mRatingValue = mRatingValue;
    }
    
    public static RatingCompat fromRating(final Object mRatingObj) {
        if (mRatingObj != null && Build$VERSION.SDK_INT >= 19) {
            final int ratingStyle = RatingCompatKitkat.getRatingStyle(mRatingObj);
            RatingCompat ratingCompat = null;
            if (RatingCompatKitkat.isRated(mRatingObj)) {
                switch (ratingStyle) {
                    default: {
                        return null;
                    }
                    case 6: {
                        ratingCompat = newPercentageRating(RatingCompatKitkat.getPercentRating(mRatingObj));
                        break;
                    }
                    case 3:
                    case 4:
                    case 5: {
                        ratingCompat = newStarRating(ratingStyle, RatingCompatKitkat.getStarRating(mRatingObj));
                        break;
                    }
                    case 2: {
                        ratingCompat = newThumbRating(RatingCompatKitkat.isThumbUp(mRatingObj));
                        break;
                    }
                    case 1: {
                        ratingCompat = newHeartRating(RatingCompatKitkat.hasHeart(mRatingObj));
                        break;
                    }
                }
            }
            else {
                ratingCompat = newUnratedRating(ratingStyle);
            }
            ratingCompat.mRatingObj = mRatingObj;
            return ratingCompat;
        }
        return null;
    }
    
    public static RatingCompat newHeartRating(final boolean b) {
        float n;
        if (b) {
            n = 1.0f;
        }
        else {
            n = 0.0f;
        }
        return new RatingCompat(1, n);
    }
    
    public static RatingCompat newPercentageRating(final float n) {
        if (n >= 0.0f && n <= 100.0f) {
            return new RatingCompat(6, n);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }
    
    public static RatingCompat newStarRating(final int n, final float n2) {
        float n3 = 0.0f;
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid rating style (");
                sb.append(n);
                sb.append(") for a star rating");
                Log.e("Rating", sb.toString());
                return null;
            }
            case 5: {
                n3 = 5.0f;
                break;
            }
            case 4: {
                n3 = 4.0f;
                break;
            }
            case 3: {
                n3 = 3.0f;
                break;
            }
        }
        if (n2 >= 0.0f && n2 <= n3) {
            return new RatingCompat(n, n2);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }
    
    public static RatingCompat newThumbRating(final boolean b) {
        float n;
        if (b) {
            n = 1.0f;
        }
        else {
            n = 0.0f;
        }
        return new RatingCompat(2, n);
    }
    
    public static RatingCompat newUnratedRating(final int n) {
        switch (n) {
            default: {
                return null;
            }
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6: {
                return new RatingCompat(n, -1.0f);
            }
        }
    }
    
    public int describeContents() {
        return this.mRatingStyle;
    }
    
    public float getPercentRating() {
        if (this.mRatingStyle == 6 && this.isRated()) {
            return this.mRatingValue;
        }
        return -1.0f;
    }
    
    public Object getRating() {
        if (this.mRatingObj == null && Build$VERSION.SDK_INT >= 19) {
            if (this.isRated()) {
                final int mRatingStyle = this.mRatingStyle;
                switch (mRatingStyle) {
                    case 6: {
                        this.mRatingObj = RatingCompatKitkat.newPercentageRating(this.getPercentRating());
                        break;
                    }
                    case 3:
                    case 4:
                    case 5: {
                        this.mRatingObj = RatingCompatKitkat.newStarRating(mRatingStyle, this.getStarRating());
                        return this.mRatingObj;
                    }
                    case 2: {
                        this.mRatingObj = RatingCompatKitkat.newThumbRating(this.isThumbUp());
                        return this.mRatingObj;
                    }
                    case 1: {
                        this.mRatingObj = RatingCompatKitkat.newHeartRating(this.hasHeart());
                        return this.mRatingObj;
                    }
                }
                return null;
            }
            this.mRatingObj = RatingCompatKitkat.newUnratedRating(this.mRatingStyle);
            return this.mRatingObj;
        }
        return this.mRatingObj;
    }
    
    public int getRatingStyle() {
        return this.mRatingStyle;
    }
    
    public float getStarRating() {
        switch (this.mRatingStyle) {
            case 3:
            case 4:
            case 5: {
                if (this.isRated()) {
                    return this.mRatingValue;
                }
                break;
            }
        }
        return -1.0f;
    }
    
    public boolean hasHeart() {
        final int mRatingStyle = this.mRatingStyle;
        boolean b = false;
        if (mRatingStyle != 1) {
            return false;
        }
        if (this.mRatingValue == 1.0f) {
            b = true;
        }
        return b;
    }
    
    public boolean isRated() {
        return this.mRatingValue >= 0.0f;
    }
    
    public boolean isThumbUp() {
        final int mRatingStyle = this.mRatingStyle;
        boolean b = false;
        if (mRatingStyle != 2) {
            return false;
        }
        if (this.mRatingValue == 1.0f) {
            b = true;
        }
        return b;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.mRatingStyle);
        sb.append(" rating=");
        final float mRatingValue = this.mRatingValue;
        String value;
        if (mRatingValue < 0.0f) {
            value = "unrated";
        }
        else {
            value = String.valueOf(mRatingValue);
        }
        sb.append(value);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.mRatingStyle);
        parcel.writeFloat(this.mRatingValue);
    }
}
