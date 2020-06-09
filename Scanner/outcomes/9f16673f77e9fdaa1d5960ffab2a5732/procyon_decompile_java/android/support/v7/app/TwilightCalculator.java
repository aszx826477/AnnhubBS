// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

class TwilightCalculator
{
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;
    private static final float C1 = 0.0334196f;
    private static final float C2 = 3.49066E-4f;
    private static final float C3 = 5.236E-6f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = 0.017453292f;
    private static final float J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.4092797f;
    private static final long UTC_2000 = 946728000000L;
    private static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;
    
    static TwilightCalculator getInstance() {
        if (TwilightCalculator.sInstance == null) {
            TwilightCalculator.sInstance = new TwilightCalculator();
        }
        return TwilightCalculator.sInstance;
    }
    
    public void calculateTwilight(final long n, final double n2, final double n3) {
        final float n4 = (n - 946728000000L) / 8.64E7f;
        final float n5 = 0.01720197f * n4 + 6.24006f;
        final double n6 = n5;
        final double n7 = Math.sin(n5) * 0.03341960161924362;
        Double.isNaN(n6);
        final double n8 = 1.796593063 + (n6 + n7 + Math.sin(2.0f * n5) * 3.4906598739326E-4 + Math.sin(3.0f * n5) * 5.236000106378924E-6) + 3.141592653589793;
        final double n9 = -n3 / 360.0;
        final float n10 = 9.0E-4f;
        final double n11 = n4 - n10;
        Double.isNaN(n11);
        final double n12 = n10 + Math.round(n11 - n9);
        Double.isNaN(n12);
        final double n13 = n12 + n9 + Math.sin(n5) * 0.0053 + Math.sin(2.0 * n8) * -0.0069;
        final double asin = Math.asin(Math.sin(n8) * Math.sin(0.4092797040939331));
        final double n14 = 0.01745329238474369 * n2;
        final double n15 = (Math.sin(-0.10471975803375244) - Math.sin(n14) * Math.sin(asin)) / (Math.cos(n14) * Math.cos(asin));
        final long n16 = -1;
        if (n15 >= 1.0) {
            this.state = 1;
            this.sunset = n16;
            this.sunrise = n16;
            return;
        }
        if (n15 <= -1.0) {
            this.state = 0;
            this.sunset = n16;
            this.sunrise = n16;
            return;
        }
        final float n17 = (float)(Math.acos(n15) / 6.283185307179586);
        final double n18 = n17;
        Double.isNaN(n18);
        final double n19 = n18 + n13;
        final double n20 = 8.64E7;
        final long round = Math.round(n19 * n20);
        final long n21 = 946728000000L;
        this.sunset = round + n21;
        final double n22 = n17;
        Double.isNaN(n22);
        this.sunrise = Math.round((n13 - n22) * n20) + n21;
        if (this.sunrise < n && this.sunset > n) {
            this.state = 0;
        }
        else {
            this.state = 1;
        }
    }
}
