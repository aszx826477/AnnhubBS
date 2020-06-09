// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

import com.baidu.location.d.j;
import java.util.ArrayList;
import android.os.Parcel;
import java.util.HashMap;
import java.util.List;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class BDLocation implements Parcelable
{
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
    public static final Parcelable$Creator CREATOR;
    public static final int GPS_ACCURACY_BAD = 3;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_MID = 2;
    public static final int GPS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_RECTIFY_INDOOR = 1;
    public static final int GPS_RECTIFY_NONE = 0;
    public static final int GPS_RECTIFY_OUTDOOR = 2;
    public static final int INDOOR_LOCATION_NEARBY_SURPPORT_TRUE = 2;
    public static final int INDOOR_LOCATION_SOURCE_BLUETOOTH = 4;
    public static final int INDOOR_LOCATION_SOURCE_MAGNETIC = 2;
    public static final int INDOOR_LOCATION_SOURCE_SMALLCELLSTATION = 8;
    public static final int INDOOR_LOCATION_SOURCE_UNKNOWN = 0;
    public static final int INDOOR_LOCATION_SOURCE_WIFI = 1;
    public static final int INDOOR_LOCATION_SURPPORT_FALSE = 0;
    public static final int INDOOR_LOCATION_SURPPORT_TRUE = 1;
    public static final int INDOOR_NETWORK_STATE_HIGH = 2;
    public static final int INDOOR_NETWORK_STATE_LOW = 0;
    public static final int INDOOR_NETWORK_STATE_MIDDLE = 1;
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerCheckKeyError = 505;
    public static final int TypeServerDecryptError = 162;
    public static final int TypeServerError = 167;
    public static final int USER_INDDOR_TRUE = 1;
    public static final int USER_INDOOR_FALSE = 0;
    public static final int USER_INDOOR_UNKNOW = 255;
    private int A;
    private String B;
    private int C;
    private String D;
    private int E;
    private int F;
    private int G;
    private int H;
    private String I;
    private String J;
    private String K;
    private List L;
    private String M;
    private String N;
    private HashMap O;
    private int P;
    private int Q;
    private int a;
    private String b;
    private double c;
    private double d;
    private boolean e;
    private double f;
    private boolean g;
    private float h;
    private boolean i;
    private float j;
    private boolean k;
    private int l;
    private float m;
    private String n;
    private boolean o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private Address u;
    private String v;
    private String w;
    private String x;
    private boolean y;
    private int z;
    
    static {
        CREATOR = (Parcelable$Creator)new a();
    }
    
    public BDLocation() {
        this.a = 0;
        this.b = null;
        final double f = Double.MIN_VALUE;
        this.c = f;
        this.d = f;
        this.e = false;
        this.f = f;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        final int n = -1;
        this.l = n;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address$Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = n;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = new HashMap();
        this.P = 0;
        this.Q = 0;
    }
    
    private BDLocation(final Parcel parcel) {
        this.a = 0;
        this.b = null;
        final double f = Double.MIN_VALUE;
        this.c = f;
        this.d = f;
        this.e = false;
        this.f = f;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        final int n = -1;
        this.l = n;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address$Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        final int a = 1;
        this.A = a;
        this.B = null;
        this.D = "";
        this.E = n;
        this.F = 0;
        final int g = 2;
        this.G = g;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = new HashMap();
        this.P = 0;
        this.Q = 0;
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readDouble();
        this.d = parcel.readDouble();
        this.f = parcel.readDouble();
        this.h = parcel.readFloat();
        this.j = parcel.readFloat();
        this.l = parcel.readInt();
        this.m = parcel.readFloat();
        this.v = parcel.readString();
        this.z = parcel.readInt();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.B = parcel.readString();
        final String string = parcel.readString();
        final String string2 = parcel.readString();
        final String string3 = parcel.readString();
        final String string4 = parcel.readString();
        final String string5 = parcel.readString();
        final String string6 = parcel.readString();
        parcel.readString();
        this.u = new Address$Builder().country(parcel.readString()).countryCode(parcel.readString()).province(string).city(string2).cityCode(string6).district(string3).street(string4).streetNumber(string5).adcode(parcel.readString()).build();
        final boolean[] array = new boolean[7];
        this.C = parcel.readInt();
        this.D = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.A = parcel.readInt();
        this.M = parcel.readString();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readInt();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.P = parcel.readInt();
        this.N = parcel.readString();
        this.Q = parcel.readInt();
        try {
            parcel.readBooleanArray(array);
            final boolean[] array2 = array;
            try {
                this.e = array2[0];
                final boolean[] array3 = array;
                try {
                    this.g = array3[a];
                    final boolean[] array4 = array;
                    try {
                        this.i = array4[g];
                        this.k = array[3];
                        this.o = array[4];
                        this.t = array[5];
                        this.y = array[6];
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        catch (Exception ex4) {}
        final ArrayList l = new ArrayList();
        parcel.readList((List)l, Poi.class.getClassLoader());
        if (l.size() == 0) {
            this.L = null;
        }
        else {
            this.L = l;
        }
    }
    
    public BDLocation(final BDLocation bdLocation) {
        int i = 0;
        this.a = 0;
        List<Poi> l = null;
        this.b = null;
        final double f = Double.MIN_VALUE;
        this.c = f;
        this.d = f;
        this.e = false;
        this.f = f;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        final int n = -1;
        this.l = n;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address$Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = n;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = new HashMap();
        this.P = 0;
        this.Q = 0;
        this.a = bdLocation.a;
        this.b = bdLocation.b;
        this.c = bdLocation.c;
        this.d = bdLocation.d;
        this.e = bdLocation.e;
        this.f = bdLocation.f;
        this.g = bdLocation.g;
        this.h = bdLocation.h;
        this.i = bdLocation.i;
        this.j = bdLocation.j;
        this.k = bdLocation.k;
        this.l = bdLocation.l;
        this.m = bdLocation.m;
        this.n = bdLocation.n;
        this.o = bdLocation.o;
        this.p = bdLocation.p;
        this.t = bdLocation.t;
        this.u = new Address$Builder().country(bdLocation.u.country).countryCode(bdLocation.u.countryCode).province(bdLocation.u.province).city(bdLocation.u.city).cityCode(bdLocation.u.cityCode).district(bdLocation.u.district).street(bdLocation.u.street).streetNumber(bdLocation.u.streetNumber).adcode(bdLocation.u.adcode).build();
        this.v = bdLocation.v;
        this.w = bdLocation.w;
        this.x = bdLocation.x;
        this.A = bdLocation.A;
        this.z = bdLocation.z;
        this.y = bdLocation.y;
        this.B = bdLocation.B;
        this.C = bdLocation.C;
        this.D = bdLocation.D;
        this.q = bdLocation.q;
        this.r = bdLocation.r;
        this.s = bdLocation.s;
        this.E = bdLocation.E;
        this.F = bdLocation.F;
        this.G = bdLocation.F;
        this.H = bdLocation.H;
        this.I = bdLocation.I;
        this.J = bdLocation.J;
        this.K = bdLocation.K;
        this.P = bdLocation.P;
        this.N = bdLocation.N;
        if (bdLocation.L != null) {
            l = new ArrayList<Poi>();
            while (i < bdLocation.L.size()) {
                final Poi poi = bdLocation.L.get(i);
                l.add(new Poi(poi.getId(), poi.getName(), poi.getRank()));
                ++i;
            }
        }
        this.L = l;
        this.M = bdLocation.M;
        this.O = bdLocation.O;
        this.Q = bdLocation.Q;
    }
    
    public BDLocation(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: astore_2       
        //     2: aload_1        
        //     3: astore_3       
        //     4: aload_0        
        //     5: invokespecial   java/lang/Object.<init>:()V
        //     8: aload_0        
        //     9: iconst_0       
        //    10: putfield        com/baidu/location/BDLocation.a:I
        //    13: iconst_0       
        //    14: istore          4
        //    16: fconst_0       
        //    17: fstore          5
        //    19: aconst_null    
        //    20: astore          6
        //    22: aload_0        
        //    23: aconst_null    
        //    24: putfield        com/baidu/location/BDLocation.b:Ljava/lang/String;
        //    27: ldc2_w          4.9E-324
        //    30: dstore          7
        //    32: aload_0        
        //    33: dload           7
        //    35: putfield        com/baidu/location/BDLocation.c:D
        //    38: aload_0        
        //    39: dload           7
        //    41: putfield        com/baidu/location/BDLocation.d:D
        //    44: aload_0        
        //    45: iconst_0       
        //    46: putfield        com/baidu/location/BDLocation.e:Z
        //    49: aload_0        
        //    50: dload           7
        //    52: putfield        com/baidu/location/BDLocation.f:D
        //    55: aload_0        
        //    56: iconst_0       
        //    57: putfield        com/baidu/location/BDLocation.g:Z
        //    60: aconst_null    
        //    61: astore          9
        //    63: aload_0        
        //    64: fconst_0       
        //    65: putfield        com/baidu/location/BDLocation.h:F
        //    68: aload_0        
        //    69: iconst_0       
        //    70: putfield        com/baidu/location/BDLocation.i:Z
        //    73: aload_0        
        //    74: fconst_0       
        //    75: putfield        com/baidu/location/BDLocation.j:F
        //    78: aload_0        
        //    79: iconst_0       
        //    80: putfield        com/baidu/location/BDLocation.k:Z
        //    83: iconst_m1      
        //    84: istore          10
        //    86: aload_0        
        //    87: iload           10
        //    89: putfield        com/baidu/location/BDLocation.l:I
        //    92: aload_0        
        //    93: ldc             -1.0
        //    95: putfield        com/baidu/location/BDLocation.m:F
        //    98: aload_0        
        //    99: aconst_null    
        //   100: putfield        com/baidu/location/BDLocation.n:Ljava/lang/String;
        //   103: aload_0        
        //   104: iconst_0       
        //   105: putfield        com/baidu/location/BDLocation.o:Z
        //   108: aload_0        
        //   109: aconst_null    
        //   110: putfield        com/baidu/location/BDLocation.p:Ljava/lang/String;
        //   113: aload_0        
        //   114: aconst_null    
        //   115: putfield        com/baidu/location/BDLocation.q:Ljava/lang/String;
        //   118: aload_0        
        //   119: aconst_null    
        //   120: putfield        com/baidu/location/BDLocation.r:Ljava/lang/String;
        //   123: aload_0        
        //   124: aconst_null    
        //   125: putfield        com/baidu/location/BDLocation.s:Ljava/lang/String;
        //   128: aload_0        
        //   129: iconst_0       
        //   130: putfield        com/baidu/location/BDLocation.t:Z
        //   133: new             Lcom/baidu/location/Address$Builder;
        //   136: astore          11
        //   138: aload           11
        //   140: invokespecial   com/baidu/location/Address$Builder.<init>:()V
        //   143: aload           11
        //   145: invokevirtual   com/baidu/location/Address$Builder.build:()Lcom/baidu/location/Address;
        //   148: astore          11
        //   150: aload_0        
        //   151: aload           11
        //   153: putfield        com/baidu/location/BDLocation.u:Lcom/baidu/location/Address;
        //   156: aload_0        
        //   157: aconst_null    
        //   158: putfield        com/baidu/location/BDLocation.v:Ljava/lang/String;
        //   161: aload_0        
        //   162: aconst_null    
        //   163: putfield        com/baidu/location/BDLocation.w:Ljava/lang/String;
        //   166: aload_0        
        //   167: aconst_null    
        //   168: putfield        com/baidu/location/BDLocation.x:Ljava/lang/String;
        //   171: aload_0        
        //   172: iconst_0       
        //   173: putfield        com/baidu/location/BDLocation.y:Z
        //   176: aload_0        
        //   177: iconst_0       
        //   178: putfield        com/baidu/location/BDLocation.z:I
        //   181: iconst_1       
        //   182: istore          12
        //   184: aload_0        
        //   185: iload           12
        //   187: putfield        com/baidu/location/BDLocation.A:I
        //   190: aload_0        
        //   191: aconst_null    
        //   192: putfield        com/baidu/location/BDLocation.B:Ljava/lang/String;
        //   195: aload_0        
        //   196: ldc             ""
        //   198: putfield        com/baidu/location/BDLocation.D:Ljava/lang/String;
        //   201: aload_0        
        //   202: iload           10
        //   204: putfield        com/baidu/location/BDLocation.E:I
        //   207: aload_0        
        //   208: iconst_0       
        //   209: putfield        com/baidu/location/BDLocation.F:I
        //   212: iconst_2       
        //   213: istore          10
        //   215: aload_0        
        //   216: iload           10
        //   218: putfield        com/baidu/location/BDLocation.G:I
        //   221: aload_0        
        //   222: iconst_0       
        //   223: putfield        com/baidu/location/BDLocation.H:I
        //   226: aload_0        
        //   227: aconst_null    
        //   228: putfield        com/baidu/location/BDLocation.I:Ljava/lang/String;
        //   231: aload_0        
        //   232: aconst_null    
        //   233: putfield        com/baidu/location/BDLocation.J:Ljava/lang/String;
        //   236: aload_0        
        //   237: aconst_null    
        //   238: putfield        com/baidu/location/BDLocation.K:Ljava/lang/String;
        //   241: aload_0        
        //   242: aconst_null    
        //   243: putfield        com/baidu/location/BDLocation.L:Ljava/util/List;
        //   246: aload_0        
        //   247: aconst_null    
        //   248: putfield        com/baidu/location/BDLocation.M:Ljava/lang/String;
        //   251: aload_0        
        //   252: aconst_null    
        //   253: putfield        com/baidu/location/BDLocation.N:Ljava/lang/String;
        //   256: new             Ljava/util/HashMap;
        //   259: astore          13
        //   261: aload           13
        //   263: invokespecial   java/util/HashMap.<init>:()V
        //   266: aload_0        
        //   267: aload           13
        //   269: putfield        com/baidu/location/BDLocation.O:Ljava/util/HashMap;
        //   272: aload_0        
        //   273: iconst_0       
        //   274: putfield        com/baidu/location/BDLocation.P:I
        //   277: aload_0        
        //   278: iconst_0       
        //   279: putfield        com/baidu/location/BDLocation.Q:I
        //   282: aload_1        
        //   283: ifnull          3606
        //   286: ldc             ""
        //   288: astore          13
        //   290: aload_1        
        //   291: aload           13
        //   293: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   296: istore          14
        //   298: iload           14
        //   300: ifeq            306
        //   303: goto            3606
        //   306: new             Lorg/json/JSONObject;
        //   309: astore          13
        //   311: aload           13
        //   313: aload_1        
        //   314: invokespecial   org/json/JSONObject.<init>:(Ljava/lang/String;)V
        //   317: ldc_w           "result"
        //   320: astore_3       
        //   321: aload           13
        //   323: aload_3        
        //   324: invokevirtual   org/json/JSONObject.getJSONObject:(Ljava/lang/String;)Lorg/json/JSONObject;
        //   327: astore_3       
        //   328: ldc_w           "error"
        //   331: astore          15
        //   333: aload_3        
        //   334: aload           15
        //   336: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   339: astore          15
        //   341: aload           15
        //   343: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   346: istore          16
        //   348: aload_0        
        //   349: iload           16
        //   351: invokevirtual   com/baidu/location/BDLocation.setLocType:(I)V
        //   354: ldc_w           "time"
        //   357: astore          17
        //   359: aload_3        
        //   360: aload           17
        //   362: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   365: astore_3       
        //   366: aload_0        
        //   367: aload_3        
        //   368: invokevirtual   com/baidu/location/BDLocation.setTime:(Ljava/lang/String;)V
        //   371: bipush          61
        //   373: istore          18
        //   375: iload           16
        //   377: iload           18
        //   379: if_icmpne       692
        //   382: ldc_w           "content"
        //   385: astore_3       
        //   386: aload           13
        //   388: aload_3        
        //   389: invokevirtual   org/json/JSONObject.getJSONObject:(Ljava/lang/String;)Lorg/json/JSONObject;
        //   392: astore_3       
        //   393: ldc_w           "point"
        //   396: astore          6
        //   398: aload_3        
        //   399: aload           6
        //   401: invokevirtual   org/json/JSONObject.getJSONObject:(Ljava/lang/String;)Lorg/json/JSONObject;
        //   404: astore          6
        //   406: ldc_w           "y"
        //   409: astore          9
        //   411: aload           6
        //   413: aload           9
        //   415: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   418: astore          9
        //   420: aload           9
        //   422: invokestatic    java/lang/Double.parseDouble:(Ljava/lang/String;)D
        //   425: dstore          19
        //   427: aload_0        
        //   428: dload           19
        //   430: invokevirtual   com/baidu/location/BDLocation.setLatitude:(D)V
        //   433: ldc_w           "x"
        //   436: astore          9
        //   438: aload           6
        //   440: aload           9
        //   442: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   445: astore          6
        //   447: aload           6
        //   449: invokestatic    java/lang/Double.parseDouble:(Ljava/lang/String;)D
        //   452: dstore          21
        //   454: aload_0        
        //   455: dload           21
        //   457: invokevirtual   com/baidu/location/BDLocation.setLongitude:(D)V
        //   460: ldc_w           "radius"
        //   463: astore          6
        //   465: aload_3        
        //   466: aload           6
        //   468: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   471: astore          6
        //   473: aload           6
        //   475: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //   478: fstore          5
        //   480: aload_0        
        //   481: fload           5
        //   483: invokevirtual   com/baidu/location/BDLocation.setRadius:(F)V
        //   486: ldc_w           "s"
        //   489: astore          6
        //   491: aload_3        
        //   492: aload           6
        //   494: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   497: astore          6
        //   499: aload           6
        //   501: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //   504: fstore          5
        //   506: aload_0        
        //   507: fload           5
        //   509: invokevirtual   com/baidu/location/BDLocation.setSpeed:(F)V
        //   512: ldc_w           "d"
        //   515: astore          6
        //   517: aload_3        
        //   518: aload           6
        //   520: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   523: astore          6
        //   525: aload           6
        //   527: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //   530: fstore          5
        //   532: aload_0        
        //   533: fload           5
        //   535: invokevirtual   com/baidu/location/BDLocation.setDirection:(F)V
        //   538: ldc_w           "n"
        //   541: astore          6
        //   543: aload_3        
        //   544: aload           6
        //   546: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   549: astore          6
        //   551: aload           6
        //   553: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   556: istore          4
        //   558: aload_0        
        //   559: iload           4
        //   561: invokevirtual   com/baidu/location/BDLocation.setSatelliteNumber:(I)V
        //   564: ldc_w           "h"
        //   567: astore          6
        //   569: aload_3        
        //   570: aload           6
        //   572: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //   575: istore          4
        //   577: iload           4
        //   579: ifeq            606
        //   582: ldc_w           "h"
        //   585: astore          6
        //   587: aload_3        
        //   588: aload           6
        //   590: invokevirtual   org/json/JSONObject.getDouble:(Ljava/lang/String;)D
        //   593: dstore          21
        //   595: aload_0        
        //   596: dload           21
        //   598: invokevirtual   com/baidu/location/BDLocation.setAltitude:(D)V
        //   601: goto            606
        //   604: astore          23
        //   606: ldc_w           "in_cn"
        //   609: astore          6
        //   611: aload_3        
        //   612: aload           6
        //   614: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //   617: istore          4
        //   619: iload           4
        //   621: ifeq            651
        //   624: ldc_w           "in_cn"
        //   627: astore          6
        //   629: aload_3        
        //   630: aload           6
        //   632: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   635: astore_3       
        //   636: aload_3        
        //   637: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   640: istore          18
        //   642: aload_2        
        //   643: iload           18
        //   645: invokevirtual   com/baidu/location/BDLocation.setLocationWhere:(I)V
        //   648: goto            662
        //   651: aload_2        
        //   652: iload           12
        //   654: invokevirtual   com/baidu/location/BDLocation.setLocationWhere:(I)V
        //   657: goto            662
        //   660: astore          23
        //   662: aload_2        
        //   663: getfield        com/baidu/location/BDLocation.A:I
        //   666: istore          18
        //   668: iload           18
        //   670: ifne            685
        //   673: ldc_w           "wgs84"
        //   676: astore_3       
        //   677: aload_2        
        //   678: aload_3        
        //   679: invokevirtual   com/baidu/location/BDLocation.setCoorType:(Ljava/lang/String;)V
        //   682: goto            3606
        //   685: ldc_w           "gcj02"
        //   688: astore_3       
        //   689: goto            677
        //   692: sipush          161
        //   695: istore          18
        //   697: iload           16
        //   699: iload           18
        //   701: if_icmpne       3384
        //   704: ldc_w           "content"
        //   707: astore_3       
        //   708: aload           13
        //   710: aload_3        
        //   711: invokevirtual   org/json/JSONObject.getJSONObject:(Ljava/lang/String;)Lorg/json/JSONObject;
        //   714: astore_3       
        //   715: ldc_w           "point"
        //   718: astore          13
        //   720: aload_3        
        //   721: aload           13
        //   723: invokevirtual   org/json/JSONObject.getJSONObject:(Ljava/lang/String;)Lorg/json/JSONObject;
        //   726: astore          13
        //   728: ldc_w           "y"
        //   731: astore          15
        //   733: aload           13
        //   735: aload           15
        //   737: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   740: astore          15
        //   742: aload           15
        //   744: invokestatic    java/lang/Double.parseDouble:(Ljava/lang/String;)D
        //   747: dstore          24
        //   749: aload_0        
        //   750: dload           24
        //   752: invokevirtual   com/baidu/location/BDLocation.setLatitude:(D)V
        //   755: ldc_w           "x"
        //   758: astore          15
        //   760: aload           13
        //   762: aload           15
        //   764: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   767: astore          13
        //   769: aload           13
        //   771: invokestatic    java/lang/Double.parseDouble:(Ljava/lang/String;)D
        //   774: dstore          19
        //   776: aload_0        
        //   777: dload           19
        //   779: invokevirtual   com/baidu/location/BDLocation.setLongitude:(D)V
        //   782: ldc_w           "radius"
        //   785: astore          13
        //   787: aload_3        
        //   788: aload           13
        //   790: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   793: astore          13
        //   795: aload           13
        //   797: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //   800: fstore          26
        //   802: aload_0        
        //   803: fload           26
        //   805: invokevirtual   com/baidu/location/BDLocation.setRadius:(F)V
        //   808: ldc_w           "sema"
        //   811: astore          13
        //   813: aload_3        
        //   814: aload           13
        //   816: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //   819: istore          14
        //   821: iload           14
        //   823: ifeq            1171
        //   826: ldc_w           "sema"
        //   829: astore          13
        //   831: aload_3        
        //   832: aload           13
        //   834: invokevirtual   org/json/JSONObject.getJSONObject:(Ljava/lang/String;)Lorg/json/JSONObject;
        //   837: astore          13
        //   839: ldc_w           "aptag"
        //   842: astore          15
        //   844: aload           13
        //   846: aload           15
        //   848: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //   851: istore          16
        //   853: iload           16
        //   855: ifeq            900
        //   858: ldc_w           "aptag"
        //   861: astore          15
        //   863: aload           13
        //   865: aload           15
        //   867: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   870: astore          15
        //   872: aload           15
        //   874: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   877: istore          27
        //   879: iload           27
        //   881: ifne            893
        //   884: aload_2        
        //   885: aload           15
        //   887: putfield        com/baidu/location/BDLocation.q:Ljava/lang/String;
        //   890: goto            900
        //   893: ldc             ""
        //   895: astore          15
        //   897: goto            884
        //   900: ldc_w           "aptagd"
        //   903: astore          15
        //   905: aload           13
        //   907: aload           15
        //   909: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //   912: istore          16
        //   914: iload           16
        //   916: ifeq            1069
        //   919: ldc_w           "aptagd"
        //   922: astore          15
        //   924: aload           13
        //   926: aload           15
        //   928: invokevirtual   org/json/JSONObject.getJSONObject:(Ljava/lang/String;)Lorg/json/JSONObject;
        //   931: astore          15
        //   933: ldc_w           "pois"
        //   936: astore          17
        //   938: aload           15
        //   940: aload           17
        //   942: invokevirtual   org/json/JSONObject.getJSONArray:(Ljava/lang/String;)Lorg/json/JSONArray;
        //   945: astore          15
        //   947: new             Ljava/util/ArrayList;
        //   950: astore          17
        //   952: aload           17
        //   954: invokespecial   java/util/ArrayList.<init>:()V
        //   957: iconst_0       
        //   958: istore          28
        //   960: aconst_null    
        //   961: astore          29
        //   963: aload           15
        //   965: invokevirtual   org/json/JSONArray.length:()I
        //   968: istore          30
        //   970: iload           28
        //   972: iload           30
        //   974: if_icmpge       1063
        //   977: aload           15
        //   979: iload           28
        //   981: invokevirtual   org/json/JSONArray.getJSONObject:(I)Lorg/json/JSONObject;
        //   984: astore          31
        //   986: ldc_w           "pname"
        //   989: astore          32
        //   991: aload           31
        //   993: aload           32
        //   995: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   998: astore          32
        //  1000: ldc_w           "pid"
        //  1003: astore          33
        //  1005: aload           31
        //  1007: aload           33
        //  1009: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  1012: astore          33
        //  1014: ldc_w           "pr"
        //  1017: astore          34
        //  1019: aload           31
        //  1021: aload           34
        //  1023: invokevirtual   org/json/JSONObject.getDouble:(Ljava/lang/String;)D
        //  1026: dstore          35
        //  1028: new             Lcom/baidu/location/Poi;
        //  1031: astore          31
        //  1033: aload           31
        //  1035: aload           33
        //  1037: aload           32
        //  1039: dload           35
        //  1041: invokespecial   com/baidu/location/Poi.<init>:(Ljava/lang/String;Ljava/lang/String;D)V
        //  1044: aload           17
        //  1046: aload           31
        //  1048: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //  1053: pop            
        //  1054: iload           28
        //  1056: iconst_1       
        //  1057: iadd           
        //  1058: istore          28
        //  1060: goto            963
        //  1063: aload_2        
        //  1064: aload           17
        //  1066: putfield        com/baidu/location/BDLocation.L:Ljava/util/List;
        //  1069: ldc_w           "poiregion"
        //  1072: astore          15
        //  1074: aload           13
        //  1076: aload           15
        //  1078: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  1081: istore          16
        //  1083: iload           16
        //  1085: ifeq            1120
        //  1088: ldc_w           "poiregion"
        //  1091: astore          15
        //  1093: aload           13
        //  1095: aload           15
        //  1097: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  1100: astore          15
        //  1102: aload           15
        //  1104: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //  1107: istore          27
        //  1109: iload           27
        //  1111: ifne            1120
        //  1114: aload_2        
        //  1115: aload           15
        //  1117: putfield        com/baidu/location/BDLocation.r:Ljava/lang/String;
        //  1120: ldc_w           "regular"
        //  1123: astore          15
        //  1125: aload           13
        //  1127: aload           15
        //  1129: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  1132: istore          16
        //  1134: iload           16
        //  1136: ifeq            1171
        //  1139: ldc_w           "regular"
        //  1142: astore          15
        //  1144: aload           13
        //  1146: aload           15
        //  1148: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  1151: astore          13
        //  1153: aload           13
        //  1155: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //  1158: istore          16
        //  1160: iload           16
        //  1162: ifne            1171
        //  1165: aload_2        
        //  1166: aload           13
        //  1168: putfield        com/baidu/location/BDLocation.s:Ljava/lang/String;
        //  1171: ldc_w           "addr"
        //  1174: astore          13
        //  1176: aload_3        
        //  1177: aload           13
        //  1179: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  1182: istore          14
        //  1184: iload           14
        //  1186: ifeq            2373
        //  1189: ldc_w           "addr"
        //  1192: astore          13
        //  1194: aload_3        
        //  1195: aload           13
        //  1197: invokevirtual   org/json/JSONObject.getJSONObject:(Ljava/lang/String;)Lorg/json/JSONObject;
        //  1200: astore          13
        //  1202: iconst_1       
        //  1203: istore          16
        //  1205: goto            1225
        //  1208: astore          23
        //  1210: iconst_0       
        //  1211: istore          14
        //  1213: aconst_null    
        //  1214: astore          13
        //  1216: fconst_0       
        //  1217: fstore          26
        //  1219: iconst_0       
        //  1220: istore          16
        //  1222: aconst_null    
        //  1223: astore          15
        //  1225: aload           13
        //  1227: ifnull          1581
        //  1230: ldc             ""
        //  1232: astore          17
        //  1234: ldc             ""
        //  1236: astore          29
        //  1238: ldc             ""
        //  1240: astore          31
        //  1242: ldc             ""
        //  1244: astore          32
        //  1246: ldc             ""
        //  1248: astore          33
        //  1250: ldc             ""
        //  1252: astore          34
        //  1254: ldc             ""
        //  1256: astore          37
        //  1258: ldc             ""
        //  1260: astore          38
        //  1262: ldc             ""
        //  1264: astore          39
        //  1266: ldc_w           "city"
        //  1269: astore          6
        //  1271: aload           13
        //  1273: aload           6
        //  1275: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  1278: istore          4
        //  1280: iload           4
        //  1282: ifeq            1299
        //  1285: ldc_w           "city"
        //  1288: astore          6
        //  1290: aload           13
        //  1292: aload           6
        //  1294: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  1297: astore          32
        //  1299: ldc_w           "city_code"
        //  1302: astore          6
        //  1304: aload           13
        //  1306: aload           6
        //  1308: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  1311: istore          4
        //  1313: iload           4
        //  1315: ifeq            1332
        //  1318: ldc_w           "city_code"
        //  1321: astore          6
        //  1323: aload           13
        //  1325: aload           6
        //  1327: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  1330: astore          33
        //  1332: ldc_w           "country"
        //  1335: astore          6
        //  1337: aload           13
        //  1339: aload           6
        //  1341: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  1344: istore          4
        //  1346: iload           4
        //  1348: ifeq            1365
        //  1351: ldc_w           "country"
        //  1354: astore          6
        //  1356: aload           13
        //  1358: aload           6
        //  1360: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  1363: astore          17
        //  1365: ldc_w           "country_code"
        //  1368: astore          6
        //  1370: aload           13
        //  1372: aload           6
        //  1374: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  1377: istore          4
        //  1379: iload           4
        //  1381: ifeq            1398
        //  1384: ldc_w           "country_code"
        //  1387: astore          6
        //  1389: aload           13
        //  1391: aload           6
        //  1393: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  1396: astore          29
        //  1398: ldc_w           "province"
        //  1401: astore          6
        //  1403: aload           13
        //  1405: aload           6
        //  1407: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  1410: istore          4
        //  1412: iload           4
        //  1414: ifeq            1431
        //  1417: ldc_w           "province"
        //  1420: astore          6
        //  1422: aload           13
        //  1424: aload           6
        //  1426: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  1429: astore          31
        //  1431: ldc_w           "district"
        //  1434: astore          6
        //  1436: aload           13
        //  1438: aload           6
        //  1440: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  1443: istore          4
        //  1445: iload           4
        //  1447: ifeq            1464
        //  1450: ldc_w           "district"
        //  1453: astore          6
        //  1455: aload           13
        //  1457: aload           6
        //  1459: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  1462: astore          34
        //  1464: ldc_w           "street"
        //  1467: astore          6
        //  1469: aload           13
        //  1471: aload           6
        //  1473: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  1476: istore          4
        //  1478: iload           4
        //  1480: ifeq            1497
        //  1483: ldc_w           "street"
        //  1486: astore          6
        //  1488: aload           13
        //  1490: aload           6
        //  1492: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  1495: astore          37
        //  1497: ldc_w           "street_number"
        //  1500: astore          6
        //  1502: aload           13
        //  1504: aload           6
        //  1506: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  1509: istore          4
        //  1511: iload           4
        //  1513: ifeq            1530
        //  1516: ldc_w           "street_number"
        //  1519: astore          6
        //  1521: aload           13
        //  1523: aload           6
        //  1525: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  1528: astore          38
        //  1530: ldc_w           "adcode"
        //  1533: astore          6
        //  1535: aload           13
        //  1537: aload           6
        //  1539: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  1542: istore          4
        //  1544: iload           4
        //  1546: ifeq            1570
        //  1549: ldc_w           "adcode"
        //  1552: astore          6
        //  1554: aload           13
        //  1556: aload           6
        //  1558: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  1561: astore          6
        //  1563: aload           38
        //  1565: astore          9
        //  1567: goto            2255
        //  1570: aload           38
        //  1572: astore          9
        //  1574: aload           39
        //  1576: astore          6
        //  1578: goto            2255
        //  1581: ldc_w           "addr"
        //  1584: astore          6
        //  1586: aload_3        
        //  1587: aload           6
        //  1589: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  1592: astore          6
        //  1594: ldc_w           ","
        //  1597: astore          13
        //  1599: aload           6
        //  1601: aload           13
        //  1603: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  1606: astore          6
        //  1608: aload           6
        //  1610: arraylength    
        //  1611: istore          14
        //  1613: iload           14
        //  1615: ifle            1627
        //  1618: aload           6
        //  1620: iconst_0       
        //  1621: aaload         
        //  1622: astore          15
        //  1624: goto            1633
        //  1627: iconst_0       
        //  1628: istore          16
        //  1630: aconst_null    
        //  1631: astore          15
        //  1633: iload           14
        //  1635: iload           12
        //  1637: if_icmple       1681
        //  1640: aload           6
        //  1642: iload           12
        //  1644: aaload         
        //  1645: astore          17
        //  1647: goto            1687
        //  1650: astore          23
        //  1652: aload           23
        //  1654: astore          6
        //  1656: aload           15
        //  1658: astore          31
        //  1660: iconst_0       
        //  1661: istore          10
        //  1663: aconst_null    
        //  1664: astore          9
        //  1666: iconst_0       
        //  1667: istore          27
        //  1669: aconst_null    
        //  1670: astore          17
        //  1672: iconst_0       
        //  1673: istore          28
        //  1675: aconst_null    
        //  1676: astore          29
        //  1678: goto            2211
        //  1681: iconst_0       
        //  1682: istore          27
        //  1684: aconst_null    
        //  1685: astore          17
        //  1687: iload           14
        //  1689: iload           10
        //  1691: if_icmple       1739
        //  1694: aload           6
        //  1696: iload           10
        //  1698: aaload         
        //  1699: astore          29
        //  1701: goto            1745
        //  1704: astore          23
        //  1706: aload           23
        //  1708: astore          6
        //  1710: aload           15
        //  1712: astore          31
        //  1714: aload           17
        //  1716: astore          32
        //  1718: iconst_0       
        //  1719: istore          10
        //  1721: aconst_null    
        //  1722: astore          9
        //  1724: iconst_0       
        //  1725: istore          27
        //  1727: aconst_null    
        //  1728: astore          17
        //  1730: iconst_0       
        //  1731: istore          28
        //  1733: aconst_null    
        //  1734: astore          29
        //  1736: goto            2217
        //  1739: iconst_0       
        //  1740: istore          28
        //  1742: aconst_null    
        //  1743: astore          29
        //  1745: iconst_3       
        //  1746: istore          30
        //  1748: iload           14
        //  1750: iload           30
        //  1752: if_icmple       1810
        //  1755: aload           6
        //  1757: iload           30
        //  1759: aaload         
        //  1760: astore          31
        //  1762: goto            1816
        //  1765: astore          23
        //  1767: aload           23
        //  1769: astore          6
        //  1771: aload           15
        //  1773: astore          31
        //  1775: aload           17
        //  1777: astore          32
        //  1779: aload           29
        //  1781: astore          34
        //  1783: iconst_0       
        //  1784: istore          10
        //  1786: aconst_null    
        //  1787: astore          9
        //  1789: iconst_0       
        //  1790: istore          27
        //  1792: aconst_null    
        //  1793: astore          17
        //  1795: iconst_0       
        //  1796: istore          28
        //  1798: aconst_null    
        //  1799: astore          29
        //  1801: iconst_0       
        //  1802: istore          40
        //  1804: aconst_null    
        //  1805: astore          33
        //  1807: goto            2229
        //  1810: iconst_0       
        //  1811: istore          30
        //  1813: aconst_null    
        //  1814: astore          31
        //  1816: iconst_4       
        //  1817: istore          41
        //  1819: iload           14
        //  1821: iload           41
        //  1823: if_icmple       1885
        //  1826: aload           6
        //  1828: iload           41
        //  1830: aaload         
        //  1831: astore          32
        //  1833: goto            1891
        //  1836: astore          23
        //  1838: aload           23
        //  1840: astore          6
        //  1842: aload           17
        //  1844: astore          32
        //  1846: aload           29
        //  1848: astore          34
        //  1850: aload           31
        //  1852: astore          37
        //  1854: iconst_0       
        //  1855: istore          10
        //  1857: aconst_null    
        //  1858: astore          9
        //  1860: iconst_0       
        //  1861: istore          27
        //  1863: aconst_null    
        //  1864: astore          17
        //  1866: iconst_0       
        //  1867: istore          28
        //  1869: aconst_null    
        //  1870: astore          29
        //  1872: iconst_0       
        //  1873: istore          40
        //  1875: aconst_null    
        //  1876: astore          33
        //  1878: aload           15
        //  1880: astore          31
        //  1882: goto            2235
        //  1885: iconst_0       
        //  1886: istore          41
        //  1888: aconst_null    
        //  1889: astore          32
        //  1891: iconst_5       
        //  1892: istore          40
        //  1894: iload           14
        //  1896: iload           40
        //  1898: if_icmple       1958
        //  1901: aload           6
        //  1903: iload           40
        //  1905: aaload         
        //  1906: astore          33
        //  1908: goto            1964
        //  1911: astore          23
        //  1913: aload           23
        //  1915: astore          6
        //  1917: aload           29
        //  1919: astore          34
        //  1921: aload           31
        //  1923: astore          37
        //  1925: aload           32
        //  1927: astore          9
        //  1929: iconst_0       
        //  1930: istore          28
        //  1932: aconst_null    
        //  1933: astore          29
        //  1935: iconst_0       
        //  1936: istore          40
        //  1938: aconst_null    
        //  1939: astore          33
        //  1941: aload           15
        //  1943: astore          31
        //  1945: aload           17
        //  1947: astore          32
        //  1949: iconst_0       
        //  1950: istore          27
        //  1952: aconst_null    
        //  1953: astore          17
        //  1955: goto            2235
        //  1958: iconst_0       
        //  1959: istore          40
        //  1961: aconst_null    
        //  1962: astore          33
        //  1964: bipush          6
        //  1966: istore          42
        //  1968: iload           14
        //  1970: iload           42
        //  1972: if_icmple       2012
        //  1975: aload           6
        //  1977: iload           42
        //  1979: aaload         
        //  1980: astore          34
        //  1982: goto            2018
        //  1985: astore          23
        //  1987: aload           23
        //  1989: astore          6
        //  1991: aload           29
        //  1993: astore          34
        //  1995: aload           31
        //  1997: astore          37
        //  1999: aload           32
        //  2001: astore          9
        //  2003: iconst_0       
        //  2004: istore          28
        //  2006: aconst_null    
        //  2007: astore          29
        //  2009: goto            1941
        //  2012: iconst_0       
        //  2013: istore          42
        //  2015: aconst_null    
        //  2016: astore          34
        //  2018: bipush          7
        //  2020: istore          43
        //  2022: iload           14
        //  2024: iload           43
        //  2026: if_icmple       2078
        //  2029: aload           6
        //  2031: iload           43
        //  2033: aaload         
        //  2034: astore          37
        //  2036: goto            2084
        //  2039: astore          23
        //  2041: aload           23
        //  2043: astore          6
        //  2045: aload           31
        //  2047: astore          37
        //  2049: aload           32
        //  2051: astore          9
        //  2053: aload           15
        //  2055: astore          31
        //  2057: aload           17
        //  2059: astore          32
        //  2061: aload           34
        //  2063: astore          17
        //  2065: aload           29
        //  2067: astore          34
        //  2069: iconst_0       
        //  2070: istore          28
        //  2072: aconst_null    
        //  2073: astore          29
        //  2075: goto            2235
        //  2078: iconst_0       
        //  2079: istore          43
        //  2081: aconst_null    
        //  2082: astore          37
        //  2084: bipush          8
        //  2086: istore          10
        //  2088: iload           14
        //  2090: iload           10
        //  2092: if_icmple       2138
        //  2095: aload           6
        //  2097: iload           10
        //  2099: aaload         
        //  2100: astore          6
        //  2102: goto            2147
        //  2105: astore          23
        //  2107: aload           23
        //  2109: astore          6
        //  2111: aload           32
        //  2113: astore          9
        //  2115: aload           17
        //  2117: astore          32
        //  2119: aload           34
        //  2121: astore          17
        //  2123: aload           29
        //  2125: astore          34
        //  2127: aload           37
        //  2129: astore          29
        //  2131: aload           31
        //  2133: astore          37
        //  2135: goto            1878
        //  2138: iconst_0       
        //  2139: istore          4
        //  2141: fconst_0       
        //  2142: fstore          5
        //  2144: aconst_null    
        //  2145: astore          6
        //  2147: aload           32
        //  2149: astore          9
        //  2151: aload           17
        //  2153: astore          32
        //  2155: aload           34
        //  2157: astore          17
        //  2159: aload           29
        //  2161: astore          34
        //  2163: aload           37
        //  2165: astore          29
        //  2167: aload           31
        //  2169: astore          37
        //  2171: aload           15
        //  2173: astore          31
        //  2175: iconst_1       
        //  2176: istore          16
        //  2178: goto            2255
        //  2181: astore          23
        //  2183: aload           23
        //  2185: astore          6
        //  2187: iconst_0       
        //  2188: istore          10
        //  2190: aconst_null    
        //  2191: astore          9
        //  2193: iconst_0       
        //  2194: istore          27
        //  2196: aconst_null    
        //  2197: astore          17
        //  2199: iconst_0       
        //  2200: istore          28
        //  2202: aconst_null    
        //  2203: astore          29
        //  2205: iconst_0       
        //  2206: istore          30
        //  2208: aconst_null    
        //  2209: astore          31
        //  2211: iconst_0       
        //  2212: istore          41
        //  2214: aconst_null    
        //  2215: astore          32
        //  2217: iconst_0       
        //  2218: istore          40
        //  2220: aconst_null    
        //  2221: astore          33
        //  2223: iconst_0       
        //  2224: istore          42
        //  2226: aconst_null    
        //  2227: astore          34
        //  2229: iconst_0       
        //  2230: istore          43
        //  2232: aconst_null    
        //  2233: astore          37
        //  2235: aload           6
        //  2237: invokevirtual   java/lang/Exception.printStackTrace:()V
        //  2240: iconst_0       
        //  2241: istore          4
        //  2243: fconst_0       
        //  2244: fstore          5
        //  2246: aconst_null    
        //  2247: astore          6
        //  2249: iconst_0       
        //  2250: istore          16
        //  2252: aconst_null    
        //  2253: astore          15
        //  2255: iload           16
        //  2257: ifeq            2392
        //  2260: new             Lcom/baidu/location/Address$Builder;
        //  2263: astore          13
        //  2265: aload           13
        //  2267: invokespecial   com/baidu/location/Address$Builder.<init>:()V
        //  2270: aload           13
        //  2272: aload           17
        //  2274: invokevirtual   com/baidu/location/Address$Builder.country:(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
        //  2277: astore          13
        //  2279: aload           13
        //  2281: aload           29
        //  2283: invokevirtual   com/baidu/location/Address$Builder.countryCode:(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
        //  2286: astore          13
        //  2288: aload           13
        //  2290: aload           31
        //  2292: invokevirtual   com/baidu/location/Address$Builder.province:(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
        //  2295: astore          13
        //  2297: aload           13
        //  2299: aload           32
        //  2301: invokevirtual   com/baidu/location/Address$Builder.city:(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
        //  2304: astore          13
        //  2306: aload           13
        //  2308: aload           33
        //  2310: invokevirtual   com/baidu/location/Address$Builder.cityCode:(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
        //  2313: astore          13
        //  2315: aload           13
        //  2317: aload           34
        //  2319: invokevirtual   com/baidu/location/Address$Builder.district:(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
        //  2322: astore          13
        //  2324: aload           13
        //  2326: aload           37
        //  2328: invokevirtual   com/baidu/location/Address$Builder.street:(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
        //  2331: astore          13
        //  2333: aload           13
        //  2335: aload           9
        //  2337: invokevirtual   com/baidu/location/Address$Builder.streetNumber:(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
        //  2340: astore          9
        //  2342: aload           9
        //  2344: aload           6
        //  2346: invokevirtual   com/baidu/location/Address$Builder.adcode:(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
        //  2349: astore          6
        //  2351: aload           6
        //  2353: invokevirtual   com/baidu/location/Address$Builder.build:()Lcom/baidu/location/Address;
        //  2356: astore          6
        //  2358: aload_2        
        //  2359: aload           6
        //  2361: putfield        com/baidu/location/BDLocation.u:Lcom/baidu/location/Address;
        //  2364: aload_2        
        //  2365: iload           12
        //  2367: putfield        com/baidu/location/BDLocation.o:Z
        //  2370: goto            2392
        //  2373: aload_2        
        //  2374: iconst_0       
        //  2375: putfield        com/baidu/location/BDLocation.o:Z
        //  2378: iconst_0       
        //  2379: istore          4
        //  2381: fconst_0       
        //  2382: fstore          5
        //  2384: aconst_null    
        //  2385: astore          6
        //  2387: aload_2        
        //  2388: aconst_null    
        //  2389: invokevirtual   com/baidu/location/BDLocation.setAddrStr:(Ljava/lang/String;)V
        //  2392: ldc_w           "floor"
        //  2395: astore          6
        //  2397: aload_3        
        //  2398: aload           6
        //  2400: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  2403: istore          4
        //  2405: iload           4
        //  2407: ifeq            2461
        //  2410: ldc_w           "floor"
        //  2413: astore          6
        //  2415: aload_3        
        //  2416: aload           6
        //  2418: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  2421: astore          6
        //  2423: aload_2        
        //  2424: aload           6
        //  2426: putfield        com/baidu/location/BDLocation.v:Ljava/lang/String;
        //  2429: aload_2        
        //  2430: getfield        com/baidu/location/BDLocation.v:Ljava/lang/String;
        //  2433: astore          6
        //  2435: aload           6
        //  2437: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //  2440: istore          4
        //  2442: iload           4
        //  2444: ifeq            2461
        //  2447: iconst_0       
        //  2448: istore          4
        //  2450: fconst_0       
        //  2451: fstore          5
        //  2453: aconst_null    
        //  2454: astore          6
        //  2456: aload_2        
        //  2457: aconst_null    
        //  2458: putfield        com/baidu/location/BDLocation.v:Ljava/lang/String;
        //  2461: ldc_w           "indoor"
        //  2464: astore          6
        //  2466: aload_3        
        //  2467: aload           6
        //  2469: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  2472: istore          4
        //  2474: iload           4
        //  2476: ifeq            2524
        //  2479: ldc_w           "indoor"
        //  2482: astore          6
        //  2484: aload_3        
        //  2485: aload           6
        //  2487: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  2490: astore          6
        //  2492: aload           6
        //  2494: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //  2497: istore          10
        //  2499: iload           10
        //  2501: ifne            2524
        //  2504: aload           6
        //  2506: invokestatic    java/lang/Integer.valueOf:(Ljava/lang/String;)Ljava/lang/Integer;
        //  2509: astore          6
        //  2511: aload           6
        //  2513: invokevirtual   java/lang/Integer.intValue:()I
        //  2516: istore          4
        //  2518: aload_2        
        //  2519: iload           4
        //  2521: invokevirtual   com/baidu/location/BDLocation.setUserIndoorState:(I)V
        //  2524: ldc_w           "loctp"
        //  2527: astore          6
        //  2529: aload_3        
        //  2530: aload           6
        //  2532: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  2535: istore          4
        //  2537: iload           4
        //  2539: ifeq            2593
        //  2542: ldc_w           "loctp"
        //  2545: astore          6
        //  2547: aload_3        
        //  2548: aload           6
        //  2550: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  2553: astore          6
        //  2555: aload_2        
        //  2556: aload           6
        //  2558: putfield        com/baidu/location/BDLocation.B:Ljava/lang/String;
        //  2561: aload_2        
        //  2562: getfield        com/baidu/location/BDLocation.B:Ljava/lang/String;
        //  2565: astore          6
        //  2567: aload           6
        //  2569: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //  2572: istore          4
        //  2574: iload           4
        //  2576: ifeq            2593
        //  2579: iconst_0       
        //  2580: istore          4
        //  2582: fconst_0       
        //  2583: fstore          5
        //  2585: aconst_null    
        //  2586: astore          6
        //  2588: aload_2        
        //  2589: aconst_null    
        //  2590: putfield        com/baidu/location/BDLocation.B:Ljava/lang/String;
        //  2593: ldc_w           "bldgid"
        //  2596: astore          6
        //  2598: aload_3        
        //  2599: aload           6
        //  2601: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  2604: istore          4
        //  2606: iload           4
        //  2608: ifeq            2662
        //  2611: ldc_w           "bldgid"
        //  2614: astore          6
        //  2616: aload_3        
        //  2617: aload           6
        //  2619: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  2622: astore          6
        //  2624: aload_2        
        //  2625: aload           6
        //  2627: putfield        com/baidu/location/BDLocation.w:Ljava/lang/String;
        //  2630: aload_2        
        //  2631: getfield        com/baidu/location/BDLocation.w:Ljava/lang/String;
        //  2634: astore          6
        //  2636: aload           6
        //  2638: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //  2641: istore          4
        //  2643: iload           4
        //  2645: ifeq            2662
        //  2648: iconst_0       
        //  2649: istore          4
        //  2651: fconst_0       
        //  2652: fstore          5
        //  2654: aconst_null    
        //  2655: astore          6
        //  2657: aload_2        
        //  2658: aconst_null    
        //  2659: putfield        com/baidu/location/BDLocation.w:Ljava/lang/String;
        //  2662: ldc_w           "bldg"
        //  2665: astore          6
        //  2667: aload_3        
        //  2668: aload           6
        //  2670: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  2673: istore          4
        //  2675: iload           4
        //  2677: ifeq            2731
        //  2680: ldc_w           "bldg"
        //  2683: astore          6
        //  2685: aload_3        
        //  2686: aload           6
        //  2688: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  2691: astore          6
        //  2693: aload_2        
        //  2694: aload           6
        //  2696: putfield        com/baidu/location/BDLocation.x:Ljava/lang/String;
        //  2699: aload_2        
        //  2700: getfield        com/baidu/location/BDLocation.x:Ljava/lang/String;
        //  2703: astore          6
        //  2705: aload           6
        //  2707: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //  2710: istore          4
        //  2712: iload           4
        //  2714: ifeq            2731
        //  2717: iconst_0       
        //  2718: istore          4
        //  2720: fconst_0       
        //  2721: fstore          5
        //  2723: aconst_null    
        //  2724: astore          6
        //  2726: aload_2        
        //  2727: aconst_null    
        //  2728: putfield        com/baidu/location/BDLocation.x:Ljava/lang/String;
        //  2731: ldc_w           "ibav"
        //  2734: astore          6
        //  2736: aload_3        
        //  2737: aload           6
        //  2739: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  2742: istore          4
        //  2744: iload           4
        //  2746: ifeq            2824
        //  2749: ldc_w           "ibav"
        //  2752: astore          6
        //  2754: aload_3        
        //  2755: aload           6
        //  2757: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  2760: astore          6
        //  2762: aload           6
        //  2764: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //  2767: istore          10
        //  2769: iload           10
        //  2771: ifeq            2782
        //  2774: aload_2        
        //  2775: iconst_0       
        //  2776: putfield        com/baidu/location/BDLocation.z:I
        //  2779: goto            2824
        //  2782: ldc_w           "0"
        //  2785: astore          9
        //  2787: aload           6
        //  2789: aload           9
        //  2791: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  2794: istore          10
        //  2796: iload           10
        //  2798: ifeq            2804
        //  2801: goto            2774
        //  2804: aload           6
        //  2806: invokestatic    java/lang/Integer.valueOf:(Ljava/lang/String;)Ljava/lang/Integer;
        //  2809: astore          6
        //  2811: aload           6
        //  2813: invokevirtual   java/lang/Integer.intValue:()I
        //  2816: istore          4
        //  2818: aload_2        
        //  2819: iload           4
        //  2821: putfield        com/baidu/location/BDLocation.z:I
        //  2824: ldc_w           "indoorflags"
        //  2827: astore          6
        //  2829: aload_3        
        //  2830: aload           6
        //  2832: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  2835: istore          4
        //  2837: iload           4
        //  2839: ifeq            3258
        //  2842: ldc_w           "indoorflags"
        //  2845: astore          6
        //  2847: aload_3        
        //  2848: aload           6
        //  2850: invokevirtual   org/json/JSONObject.getJSONObject:(Ljava/lang/String;)Lorg/json/JSONObject;
        //  2853: astore          6
        //  2855: ldc_w           "area"
        //  2858: astore          9
        //  2860: aload           6
        //  2862: aload           9
        //  2864: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  2867: istore          10
        //  2869: iload           10
        //  2871: ifeq            2936
        //  2874: ldc_w           "area"
        //  2877: astore          9
        //  2879: aload           6
        //  2881: aload           9
        //  2883: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  2886: astore          9
        //  2888: aload           9
        //  2890: invokestatic    java/lang/Integer.valueOf:(Ljava/lang/String;)Ljava/lang/Integer;
        //  2893: astore          9
        //  2895: aload           9
        //  2897: invokevirtual   java/lang/Integer.intValue:()I
        //  2900: istore          10
        //  2902: iload           10
        //  2904: ifne            2923
        //  2907: iconst_2       
        //  2908: istore          14
        //  2910: ldc             2.8E-45
        //  2912: fstore          26
        //  2914: aload_2        
        //  2915: iload           14
        //  2917: invokevirtual   com/baidu/location/BDLocation.setIndoorLocationSurpport:(I)V
        //  2920: goto            2936
        //  2923: iload           10
        //  2925: iload           12
        //  2927: if_icmpne       2936
        //  2930: aload_2        
        //  2931: iload           12
        //  2933: invokevirtual   com/baidu/location/BDLocation.setIndoorLocationSurpport:(I)V
        //  2936: ldc_w           "support"
        //  2939: astore          9
        //  2941: aload           6
        //  2943: aload           9
        //  2945: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  2948: istore          10
        //  2950: iload           10
        //  2952: ifeq            2989
        //  2955: ldc_w           "support"
        //  2958: astore          9
        //  2960: aload           6
        //  2962: aload           9
        //  2964: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  2967: astore          9
        //  2969: aload           9
        //  2971: invokestatic    java/lang/Integer.valueOf:(Ljava/lang/String;)Ljava/lang/Integer;
        //  2974: astore          9
        //  2976: aload           9
        //  2978: invokevirtual   java/lang/Integer.intValue:()I
        //  2981: istore          10
        //  2983: aload_2        
        //  2984: iload           10
        //  2986: invokevirtual   com/baidu/location/BDLocation.setIndoorLocationSource:(I)V
        //  2989: ldc_w           "inbldg"
        //  2992: astore          9
        //  2994: aload           6
        //  2996: aload           9
        //  2998: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  3001: istore          10
        //  3003: iload           10
        //  3005: ifeq            3028
        //  3008: ldc_w           "inbldg"
        //  3011: astore          9
        //  3013: aload           6
        //  3015: aload           9
        //  3017: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  3020: astore          9
        //  3022: aload_2        
        //  3023: aload           9
        //  3025: putfield        com/baidu/location/BDLocation.I:Ljava/lang/String;
        //  3028: ldc_w           "inbldgid"
        //  3031: astore          9
        //  3033: aload           6
        //  3035: aload           9
        //  3037: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  3040: istore          10
        //  3042: iload           10
        //  3044: ifeq            3067
        //  3047: ldc_w           "inbldgid"
        //  3050: astore          9
        //  3052: aload           6
        //  3054: aload           9
        //  3056: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  3059: astore          9
        //  3061: aload_2        
        //  3062: aload           9
        //  3064: putfield        com/baidu/location/BDLocation.J:Ljava/lang/String;
        //  3067: ldc_w           "polygon"
        //  3070: astore          9
        //  3072: aload           6
        //  3074: aload           9
        //  3076: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  3079: istore          10
        //  3081: iload           10
        //  3083: ifeq            3106
        //  3086: ldc_w           "polygon"
        //  3089: astore          9
        //  3091: aload           6
        //  3093: aload           9
        //  3095: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  3098: astore          9
        //  3100: aload_2        
        //  3101: aload           9
        //  3103: invokevirtual   com/baidu/location/BDLocation.setIndoorSurpportPolygon:(Ljava/lang/String;)V
        //  3106: ldc_w           "ret_fields"
        //  3109: astore          9
        //  3111: aload           6
        //  3113: aload           9
        //  3115: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  3118: istore          10
        //  3120: iload           10
        //  3122: ifeq            3258
        //  3125: ldc_w           "ret_fields"
        //  3128: astore          9
        //  3130: aload           6
        //  3132: aload           9
        //  3134: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  3137: astore          6
        //  3139: ldc_w           "\\|"
        //  3142: astore          9
        //  3144: aload           6
        //  3146: aload           9
        //  3148: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  3151: astore          6
        //  3153: aload           6
        //  3155: arraylength    
        //  3156: istore          10
        //  3158: iconst_0       
        //  3159: istore          14
        //  3161: fconst_0       
        //  3162: fstore          26
        //  3164: aconst_null    
        //  3165: astore          13
        //  3167: iload           14
        //  3169: iload           10
        //  3171: if_icmpge       3258
        //  3174: aload           6
        //  3176: iload           14
        //  3178: aaload         
        //  3179: astore          15
        //  3181: ldc_w           "="
        //  3184: astore          17
        //  3186: aload           15
        //  3188: aload           17
        //  3190: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  3193: astore          15
        //  3195: aload           15
        //  3197: iconst_0       
        //  3198: aaload         
        //  3199: astore          17
        //  3201: aload           15
        //  3203: iload           12
        //  3205: aaload         
        //  3206: astore          15
        //  3208: aload_2        
        //  3209: getfield        com/baidu/location/BDLocation.O:Ljava/util/HashMap;
        //  3212: astore          29
        //  3214: aload           29
        //  3216: aload           17
        //  3218: aload           15
        //  3220: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  3223: pop            
        //  3224: iload           14
        //  3226: iconst_1       
        //  3227: iadd           
        //  3228: istore          14
        //  3230: goto            3167
        //  3233: astore          23
        //  3235: aload           23
        //  3237: astore          6
        //  3239: aload           23
        //  3241: invokevirtual   java/lang/Exception.printStackTrace:()V
        //  3244: goto            3258
        //  3247: astore          23
        //  3249: aload           23
        //  3251: astore          6
        //  3253: aload           23
        //  3255: invokevirtual   java/lang/Exception.printStackTrace:()V
        //  3258: ldc_w           "gpscs"
        //  3261: astore          6
        //  3263: aload_3        
        //  3264: aload           6
        //  3266: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  3269: istore          4
        //  3271: iload           4
        //  3273: ifeq            3298
        //  3276: ldc_w           "gpscs"
        //  3279: astore          6
        //  3281: aload_3        
        //  3282: aload           6
        //  3284: invokevirtual   org/json/JSONObject.getInt:(Ljava/lang/String;)I
        //  3287: istore          4
        //  3289: aload_2        
        //  3290: iload           4
        //  3292: invokevirtual   com/baidu/location/BDLocation.setGpsCheckStatus:(I)V
        //  3295: goto            3303
        //  3298: aload_2        
        //  3299: iconst_0       
        //  3300: invokevirtual   com/baidu/location/BDLocation.setGpsCheckStatus:(I)V
        //  3303: ldc_w           "in_cn"
        //  3306: astore          6
        //  3308: aload_3        
        //  3309: aload           6
        //  3311: invokevirtual   org/json/JSONObject.has:(Ljava/lang/String;)Z
        //  3314: istore          4
        //  3316: iload           4
        //  3318: ifeq            3348
        //  3321: ldc_w           "in_cn"
        //  3324: astore          6
        //  3326: aload_3        
        //  3327: aload           6
        //  3329: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  3332: astore_3       
        //  3333: aload_3        
        //  3334: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //  3337: istore          18
        //  3339: aload_2        
        //  3340: iload           18
        //  3342: invokevirtual   com/baidu/location/BDLocation.setLocationWhere:(I)V
        //  3345: goto            3359
        //  3348: aload_2        
        //  3349: iload           12
        //  3351: invokevirtual   com/baidu/location/BDLocation.setLocationWhere:(I)V
        //  3354: goto            3359
        //  3357: astore          23
        //  3359: aload_2        
        //  3360: getfield        com/baidu/location/BDLocation.A:I
        //  3363: istore          18
        //  3365: iload           18
        //  3367: ifne            3377
        //  3370: ldc_w           "wgs84"
        //  3373: astore_3       
        //  3374: goto            677
        //  3377: ldc_w           "gcj02"
        //  3380: astore_3       
        //  3381: goto            677
        //  3384: bipush          66
        //  3386: istore          18
        //  3388: iload           16
        //  3390: iload           18
        //  3392: if_icmpeq       3433
        //  3395: bipush          68
        //  3397: istore          18
        //  3399: iload           16
        //  3401: iload           18
        //  3403: if_icmpne       3409
        //  3406: goto            3433
        //  3409: sipush          167
        //  3412: istore          18
        //  3414: iload           16
        //  3416: iload           18
        //  3418: if_icmpne       3606
        //  3421: iconst_2       
        //  3422: istore          18
        //  3424: aload_0        
        //  3425: iload           18
        //  3427: invokevirtual   com/baidu/location/BDLocation.setLocationWhere:(I)V
        //  3430: goto            3606
        //  3433: ldc_w           "content"
        //  3436: astore_3       
        //  3437: aload           13
        //  3439: aload_3        
        //  3440: invokevirtual   org/json/JSONObject.getJSONObject:(Ljava/lang/String;)Lorg/json/JSONObject;
        //  3443: astore_3       
        //  3444: ldc_w           "point"
        //  3447: astore          6
        //  3449: aload_3        
        //  3450: aload           6
        //  3452: invokevirtual   org/json/JSONObject.getJSONObject:(Ljava/lang/String;)Lorg/json/JSONObject;
        //  3455: astore          6
        //  3457: ldc_w           "y"
        //  3460: astore          9
        //  3462: aload           6
        //  3464: aload           9
        //  3466: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  3469: astore          9
        //  3471: aload           9
        //  3473: invokestatic    java/lang/Double.parseDouble:(Ljava/lang/String;)D
        //  3476: dstore          7
        //  3478: aload_2        
        //  3479: dload           7
        //  3481: invokevirtual   com/baidu/location/BDLocation.setLatitude:(D)V
        //  3484: ldc_w           "x"
        //  3487: astore          9
        //  3489: aload           6
        //  3491: aload           9
        //  3493: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  3496: astore          6
        //  3498: aload           6
        //  3500: invokestatic    java/lang/Double.parseDouble:(Ljava/lang/String;)D
        //  3503: dstore          21
        //  3505: aload_2        
        //  3506: dload           21
        //  3508: invokevirtual   com/baidu/location/BDLocation.setLongitude:(D)V
        //  3511: ldc_w           "radius"
        //  3514: astore          6
        //  3516: aload_3        
        //  3517: aload           6
        //  3519: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  3522: astore          6
        //  3524: aload           6
        //  3526: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //  3529: fstore          5
        //  3531: aload_2        
        //  3532: fload           5
        //  3534: invokevirtual   com/baidu/location/BDLocation.setRadius:(F)V
        //  3537: ldc_w           "isCellChanged"
        //  3540: astore          6
        //  3542: aload_3        
        //  3543: aload           6
        //  3545: invokevirtual   org/json/JSONObject.getString:(Ljava/lang/String;)Ljava/lang/String;
        //  3548: astore_3       
        //  3549: aload_3        
        //  3550: invokestatic    java/lang/Boolean.parseBoolean:(Ljava/lang/String;)Z
        //  3553: istore          18
        //  3555: iload           18
        //  3557: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //  3560: astore_3       
        //  3561: aload_2        
        //  3562: aload_3        
        //  3563: invokespecial   com/baidu/location/BDLocation.a:(Ljava/lang/Boolean;)V
        //  3566: ldc_w           "gcj02"
        //  3569: astore_3       
        //  3570: goto            677
        //  3573: astore          23
        //  3575: aload           23
        //  3577: astore_3       
        //  3578: aload           23
        //  3580: invokevirtual   java/lang/Error.printStackTrace:()V
        //  3583: goto            3596
        //  3586: astore          23
        //  3588: aload           23
        //  3590: astore_3       
        //  3591: aload           23
        //  3593: invokevirtual   java/lang/Exception.printStackTrace:()V
        //  3596: aload_2        
        //  3597: iconst_0       
        //  3598: putfield        com/baidu/location/BDLocation.a:I
        //  3601: aload_2        
        //  3602: iconst_0       
        //  3603: putfield        com/baidu/location/BDLocation.o:Z
        //  3606: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  306    309    3586   3596   Ljava/lang/Exception;
        //  306    309    3573   3586   Ljava/lang/Error;
        //  313    317    3586   3596   Ljava/lang/Exception;
        //  313    317    3573   3586   Ljava/lang/Error;
        //  323    327    3586   3596   Ljava/lang/Exception;
        //  323    327    3573   3586   Ljava/lang/Error;
        //  334    339    3586   3596   Ljava/lang/Exception;
        //  334    339    3573   3586   Ljava/lang/Error;
        //  341    346    3586   3596   Ljava/lang/Exception;
        //  341    346    3573   3586   Ljava/lang/Error;
        //  349    354    3586   3596   Ljava/lang/Exception;
        //  349    354    3573   3586   Ljava/lang/Error;
        //  360    365    3586   3596   Ljava/lang/Exception;
        //  360    365    3573   3586   Ljava/lang/Error;
        //  367    371    3586   3596   Ljava/lang/Exception;
        //  367    371    3573   3586   Ljava/lang/Error;
        //  388    392    3586   3596   Ljava/lang/Exception;
        //  388    392    3573   3586   Ljava/lang/Error;
        //  399    404    3586   3596   Ljava/lang/Exception;
        //  399    404    3573   3586   Ljava/lang/Error;
        //  413    418    3586   3596   Ljava/lang/Exception;
        //  413    418    3573   3586   Ljava/lang/Error;
        //  420    425    3586   3596   Ljava/lang/Exception;
        //  420    425    3573   3586   Ljava/lang/Error;
        //  428    433    3586   3596   Ljava/lang/Exception;
        //  428    433    3573   3586   Ljava/lang/Error;
        //  440    445    3586   3596   Ljava/lang/Exception;
        //  440    445    3573   3586   Ljava/lang/Error;
        //  447    452    3586   3596   Ljava/lang/Exception;
        //  447    452    3573   3586   Ljava/lang/Error;
        //  455    460    3586   3596   Ljava/lang/Exception;
        //  455    460    3573   3586   Ljava/lang/Error;
        //  466    471    3586   3596   Ljava/lang/Exception;
        //  466    471    3573   3586   Ljava/lang/Error;
        //  473    478    3586   3596   Ljava/lang/Exception;
        //  473    478    3573   3586   Ljava/lang/Error;
        //  481    486    3586   3596   Ljava/lang/Exception;
        //  481    486    3573   3586   Ljava/lang/Error;
        //  492    497    3586   3596   Ljava/lang/Exception;
        //  492    497    3573   3586   Ljava/lang/Error;
        //  499    504    3586   3596   Ljava/lang/Exception;
        //  499    504    3573   3586   Ljava/lang/Error;
        //  507    512    3586   3596   Ljava/lang/Exception;
        //  507    512    3573   3586   Ljava/lang/Error;
        //  518    523    3586   3596   Ljava/lang/Exception;
        //  518    523    3573   3586   Ljava/lang/Error;
        //  525    530    3586   3596   Ljava/lang/Exception;
        //  525    530    3573   3586   Ljava/lang/Error;
        //  533    538    3586   3596   Ljava/lang/Exception;
        //  533    538    3573   3586   Ljava/lang/Error;
        //  544    549    3586   3596   Ljava/lang/Exception;
        //  544    549    3573   3586   Ljava/lang/Error;
        //  551    556    3586   3596   Ljava/lang/Exception;
        //  551    556    3573   3586   Ljava/lang/Error;
        //  559    564    3586   3596   Ljava/lang/Exception;
        //  559    564    3573   3586   Ljava/lang/Error;
        //  570    575    3586   3596   Ljava/lang/Exception;
        //  570    575    3573   3586   Ljava/lang/Error;
        //  588    593    604    606    Ljava/lang/Exception;
        //  588    593    3573   3586   Ljava/lang/Error;
        //  596    601    604    606    Ljava/lang/Exception;
        //  596    601    3573   3586   Ljava/lang/Error;
        //  612    617    660    662    Ljava/lang/Exception;
        //  612    617    3573   3586   Ljava/lang/Error;
        //  630    635    660    662    Ljava/lang/Exception;
        //  630    635    3573   3586   Ljava/lang/Error;
        //  636    640    660    662    Ljava/lang/Exception;
        //  636    640    3573   3586   Ljava/lang/Error;
        //  643    648    660    662    Ljava/lang/Exception;
        //  643    648    3573   3586   Ljava/lang/Error;
        //  652    657    660    662    Ljava/lang/Exception;
        //  652    657    3573   3586   Ljava/lang/Error;
        //  662    666    3586   3596   Ljava/lang/Exception;
        //  662    666    3573   3586   Ljava/lang/Error;
        //  678    682    3586   3596   Ljava/lang/Exception;
        //  678    682    3573   3586   Ljava/lang/Error;
        //  710    714    3586   3596   Ljava/lang/Exception;
        //  710    714    3573   3586   Ljava/lang/Error;
        //  721    726    3586   3596   Ljava/lang/Exception;
        //  721    726    3573   3586   Ljava/lang/Error;
        //  735    740    3586   3596   Ljava/lang/Exception;
        //  735    740    3573   3586   Ljava/lang/Error;
        //  742    747    3586   3596   Ljava/lang/Exception;
        //  742    747    3573   3586   Ljava/lang/Error;
        //  750    755    3586   3596   Ljava/lang/Exception;
        //  750    755    3573   3586   Ljava/lang/Error;
        //  762    767    3586   3596   Ljava/lang/Exception;
        //  762    767    3573   3586   Ljava/lang/Error;
        //  769    774    3586   3596   Ljava/lang/Exception;
        //  769    774    3573   3586   Ljava/lang/Error;
        //  777    782    3586   3596   Ljava/lang/Exception;
        //  777    782    3573   3586   Ljava/lang/Error;
        //  788    793    3586   3596   Ljava/lang/Exception;
        //  788    793    3573   3586   Ljava/lang/Error;
        //  795    800    3586   3596   Ljava/lang/Exception;
        //  795    800    3573   3586   Ljava/lang/Error;
        //  803    808    3586   3596   Ljava/lang/Exception;
        //  803    808    3573   3586   Ljava/lang/Error;
        //  814    819    3586   3596   Ljava/lang/Exception;
        //  814    819    3573   3586   Ljava/lang/Error;
        //  832    837    3586   3596   Ljava/lang/Exception;
        //  832    837    3573   3586   Ljava/lang/Error;
        //  846    851    3586   3596   Ljava/lang/Exception;
        //  846    851    3573   3586   Ljava/lang/Error;
        //  865    870    3586   3596   Ljava/lang/Exception;
        //  865    870    3573   3586   Ljava/lang/Error;
        //  872    877    3586   3596   Ljava/lang/Exception;
        //  872    877    3573   3586   Ljava/lang/Error;
        //  885    890    3586   3596   Ljava/lang/Exception;
        //  885    890    3573   3586   Ljava/lang/Error;
        //  907    912    3586   3596   Ljava/lang/Exception;
        //  907    912    3573   3586   Ljava/lang/Error;
        //  926    931    3586   3596   Ljava/lang/Exception;
        //  926    931    3573   3586   Ljava/lang/Error;
        //  940    945    3586   3596   Ljava/lang/Exception;
        //  940    945    3573   3586   Ljava/lang/Error;
        //  947    950    3586   3596   Ljava/lang/Exception;
        //  947    950    3573   3586   Ljava/lang/Error;
        //  952    957    3586   3596   Ljava/lang/Exception;
        //  952    957    3573   3586   Ljava/lang/Error;
        //  963    968    3586   3596   Ljava/lang/Exception;
        //  963    968    3573   3586   Ljava/lang/Error;
        //  979    984    3586   3596   Ljava/lang/Exception;
        //  979    984    3573   3586   Ljava/lang/Error;
        //  993    998    3586   3596   Ljava/lang/Exception;
        //  993    998    3573   3586   Ljava/lang/Error;
        //  1007   1012   3586   3596   Ljava/lang/Exception;
        //  1007   1012   3573   3586   Ljava/lang/Error;
        //  1021   1026   3586   3596   Ljava/lang/Exception;
        //  1021   1026   3573   3586   Ljava/lang/Error;
        //  1028   1031   3586   3596   Ljava/lang/Exception;
        //  1028   1031   3573   3586   Ljava/lang/Error;
        //  1039   1044   3586   3596   Ljava/lang/Exception;
        //  1039   1044   3573   3586   Ljava/lang/Error;
        //  1046   1054   3586   3596   Ljava/lang/Exception;
        //  1046   1054   3573   3586   Ljava/lang/Error;
        //  1064   1069   3586   3596   Ljava/lang/Exception;
        //  1064   1069   3573   3586   Ljava/lang/Error;
        //  1076   1081   3586   3596   Ljava/lang/Exception;
        //  1076   1081   3573   3586   Ljava/lang/Error;
        //  1095   1100   3586   3596   Ljava/lang/Exception;
        //  1095   1100   3573   3586   Ljava/lang/Error;
        //  1102   1107   3586   3596   Ljava/lang/Exception;
        //  1102   1107   3573   3586   Ljava/lang/Error;
        //  1115   1120   3586   3596   Ljava/lang/Exception;
        //  1115   1120   3573   3586   Ljava/lang/Error;
        //  1127   1132   3586   3596   Ljava/lang/Exception;
        //  1127   1132   3573   3586   Ljava/lang/Error;
        //  1146   1151   3586   3596   Ljava/lang/Exception;
        //  1146   1151   3573   3586   Ljava/lang/Error;
        //  1153   1158   3586   3596   Ljava/lang/Exception;
        //  1153   1158   3573   3586   Ljava/lang/Error;
        //  1166   1171   3586   3596   Ljava/lang/Exception;
        //  1166   1171   3573   3586   Ljava/lang/Error;
        //  1177   1182   3586   3596   Ljava/lang/Exception;
        //  1177   1182   3573   3586   Ljava/lang/Error;
        //  1195   1200   1208   1225   Ljava/lang/Exception;
        //  1195   1200   3573   3586   Ljava/lang/Error;
        //  1273   1278   3586   3596   Ljava/lang/Exception;
        //  1273   1278   3573   3586   Ljava/lang/Error;
        //  1292   1297   3586   3596   Ljava/lang/Exception;
        //  1292   1297   3573   3586   Ljava/lang/Error;
        //  1306   1311   3586   3596   Ljava/lang/Exception;
        //  1306   1311   3573   3586   Ljava/lang/Error;
        //  1325   1330   3586   3596   Ljava/lang/Exception;
        //  1325   1330   3573   3586   Ljava/lang/Error;
        //  1339   1344   3586   3596   Ljava/lang/Exception;
        //  1339   1344   3573   3586   Ljava/lang/Error;
        //  1358   1363   3586   3596   Ljava/lang/Exception;
        //  1358   1363   3573   3586   Ljava/lang/Error;
        //  1372   1377   3586   3596   Ljava/lang/Exception;
        //  1372   1377   3573   3586   Ljava/lang/Error;
        //  1391   1396   3586   3596   Ljava/lang/Exception;
        //  1391   1396   3573   3586   Ljava/lang/Error;
        //  1405   1410   3586   3596   Ljava/lang/Exception;
        //  1405   1410   3573   3586   Ljava/lang/Error;
        //  1424   1429   3586   3596   Ljava/lang/Exception;
        //  1424   1429   3573   3586   Ljava/lang/Error;
        //  1438   1443   3586   3596   Ljava/lang/Exception;
        //  1438   1443   3573   3586   Ljava/lang/Error;
        //  1457   1462   3586   3596   Ljava/lang/Exception;
        //  1457   1462   3573   3586   Ljava/lang/Error;
        //  1471   1476   3586   3596   Ljava/lang/Exception;
        //  1471   1476   3573   3586   Ljava/lang/Error;
        //  1490   1495   3586   3596   Ljava/lang/Exception;
        //  1490   1495   3573   3586   Ljava/lang/Error;
        //  1504   1509   3586   3596   Ljava/lang/Exception;
        //  1504   1509   3573   3586   Ljava/lang/Error;
        //  1523   1528   3586   3596   Ljava/lang/Exception;
        //  1523   1528   3573   3586   Ljava/lang/Error;
        //  1537   1542   3586   3596   Ljava/lang/Exception;
        //  1537   1542   3573   3586   Ljava/lang/Error;
        //  1556   1561   3586   3596   Ljava/lang/Exception;
        //  1556   1561   3573   3586   Ljava/lang/Error;
        //  1587   1592   2181   2211   Ljava/lang/Exception;
        //  1587   1592   3573   3586   Ljava/lang/Error;
        //  1601   1606   2181   2211   Ljava/lang/Exception;
        //  1601   1606   3573   3586   Ljava/lang/Error;
        //  1608   1611   2181   2211   Ljava/lang/Exception;
        //  1608   1611   3573   3586   Ljava/lang/Error;
        //  1620   1622   2181   2211   Ljava/lang/Exception;
        //  1620   1622   3573   3586   Ljava/lang/Error;
        //  1642   1645   1650   1681   Ljava/lang/Exception;
        //  1642   1645   3573   3586   Ljava/lang/Error;
        //  1696   1699   1704   1739   Ljava/lang/Exception;
        //  1696   1699   3573   3586   Ljava/lang/Error;
        //  1757   1760   1765   1810   Ljava/lang/Exception;
        //  1757   1760   3573   3586   Ljava/lang/Error;
        //  1828   1831   1836   1878   Ljava/lang/Exception;
        //  1828   1831   3573   3586   Ljava/lang/Error;
        //  1903   1906   1911   1941   Ljava/lang/Exception;
        //  1903   1906   3573   3586   Ljava/lang/Error;
        //  1977   1980   1985   2012   Ljava/lang/Exception;
        //  1977   1980   3573   3586   Ljava/lang/Error;
        //  2031   2034   2039   2078   Ljava/lang/Exception;
        //  2031   2034   3573   3586   Ljava/lang/Error;
        //  2097   2100   2105   2138   Ljava/lang/Exception;
        //  2097   2100   3573   3586   Ljava/lang/Error;
        //  2235   2240   3586   3596   Ljava/lang/Exception;
        //  2235   2240   3573   3586   Ljava/lang/Error;
        //  2260   2263   3586   3596   Ljava/lang/Exception;
        //  2260   2263   3573   3586   Ljava/lang/Error;
        //  2265   2270   3586   3596   Ljava/lang/Exception;
        //  2265   2270   3573   3586   Ljava/lang/Error;
        //  2272   2277   3586   3596   Ljava/lang/Exception;
        //  2272   2277   3573   3586   Ljava/lang/Error;
        //  2281   2286   3586   3596   Ljava/lang/Exception;
        //  2281   2286   3573   3586   Ljava/lang/Error;
        //  2290   2295   3586   3596   Ljava/lang/Exception;
        //  2290   2295   3573   3586   Ljava/lang/Error;
        //  2299   2304   3586   3596   Ljava/lang/Exception;
        //  2299   2304   3573   3586   Ljava/lang/Error;
        //  2308   2313   3586   3596   Ljava/lang/Exception;
        //  2308   2313   3573   3586   Ljava/lang/Error;
        //  2317   2322   3586   3596   Ljava/lang/Exception;
        //  2317   2322   3573   3586   Ljava/lang/Error;
        //  2326   2331   3586   3596   Ljava/lang/Exception;
        //  2326   2331   3573   3586   Ljava/lang/Error;
        //  2335   2340   3586   3596   Ljava/lang/Exception;
        //  2335   2340   3573   3586   Ljava/lang/Error;
        //  2344   2349   3586   3596   Ljava/lang/Exception;
        //  2344   2349   3573   3586   Ljava/lang/Error;
        //  2351   2356   3586   3596   Ljava/lang/Exception;
        //  2351   2356   3573   3586   Ljava/lang/Error;
        //  2359   2364   3586   3596   Ljava/lang/Exception;
        //  2359   2364   3573   3586   Ljava/lang/Error;
        //  2365   2370   3586   3596   Ljava/lang/Exception;
        //  2365   2370   3573   3586   Ljava/lang/Error;
        //  2374   2378   3586   3596   Ljava/lang/Exception;
        //  2374   2378   3573   3586   Ljava/lang/Error;
        //  2388   2392   3586   3596   Ljava/lang/Exception;
        //  2388   2392   3573   3586   Ljava/lang/Error;
        //  2398   2403   3586   3596   Ljava/lang/Exception;
        //  2398   2403   3573   3586   Ljava/lang/Error;
        //  2416   2421   3586   3596   Ljava/lang/Exception;
        //  2416   2421   3573   3586   Ljava/lang/Error;
        //  2424   2429   3586   3596   Ljava/lang/Exception;
        //  2424   2429   3573   3586   Ljava/lang/Error;
        //  2429   2433   3586   3596   Ljava/lang/Exception;
        //  2429   2433   3573   3586   Ljava/lang/Error;
        //  2435   2440   3586   3596   Ljava/lang/Exception;
        //  2435   2440   3573   3586   Ljava/lang/Error;
        //  2457   2461   3586   3596   Ljava/lang/Exception;
        //  2457   2461   3573   3586   Ljava/lang/Error;
        //  2467   2472   3586   3596   Ljava/lang/Exception;
        //  2467   2472   3573   3586   Ljava/lang/Error;
        //  2485   2490   3586   3596   Ljava/lang/Exception;
        //  2485   2490   3573   3586   Ljava/lang/Error;
        //  2492   2497   3586   3596   Ljava/lang/Exception;
        //  2492   2497   3573   3586   Ljava/lang/Error;
        //  2504   2509   3586   3596   Ljava/lang/Exception;
        //  2504   2509   3573   3586   Ljava/lang/Error;
        //  2511   2516   3586   3596   Ljava/lang/Exception;
        //  2511   2516   3573   3586   Ljava/lang/Error;
        //  2519   2524   3586   3596   Ljava/lang/Exception;
        //  2519   2524   3573   3586   Ljava/lang/Error;
        //  2530   2535   3586   3596   Ljava/lang/Exception;
        //  2530   2535   3573   3586   Ljava/lang/Error;
        //  2548   2553   3586   3596   Ljava/lang/Exception;
        //  2548   2553   3573   3586   Ljava/lang/Error;
        //  2556   2561   3586   3596   Ljava/lang/Exception;
        //  2556   2561   3573   3586   Ljava/lang/Error;
        //  2561   2565   3586   3596   Ljava/lang/Exception;
        //  2561   2565   3573   3586   Ljava/lang/Error;
        //  2567   2572   3586   3596   Ljava/lang/Exception;
        //  2567   2572   3573   3586   Ljava/lang/Error;
        //  2589   2593   3586   3596   Ljava/lang/Exception;
        //  2589   2593   3573   3586   Ljava/lang/Error;
        //  2599   2604   3586   3596   Ljava/lang/Exception;
        //  2599   2604   3573   3586   Ljava/lang/Error;
        //  2617   2622   3586   3596   Ljava/lang/Exception;
        //  2617   2622   3573   3586   Ljava/lang/Error;
        //  2625   2630   3586   3596   Ljava/lang/Exception;
        //  2625   2630   3573   3586   Ljava/lang/Error;
        //  2630   2634   3586   3596   Ljava/lang/Exception;
        //  2630   2634   3573   3586   Ljava/lang/Error;
        //  2636   2641   3586   3596   Ljava/lang/Exception;
        //  2636   2641   3573   3586   Ljava/lang/Error;
        //  2658   2662   3586   3596   Ljava/lang/Exception;
        //  2658   2662   3573   3586   Ljava/lang/Error;
        //  2668   2673   3586   3596   Ljava/lang/Exception;
        //  2668   2673   3573   3586   Ljava/lang/Error;
        //  2686   2691   3586   3596   Ljava/lang/Exception;
        //  2686   2691   3573   3586   Ljava/lang/Error;
        //  2694   2699   3586   3596   Ljava/lang/Exception;
        //  2694   2699   3573   3586   Ljava/lang/Error;
        //  2699   2703   3586   3596   Ljava/lang/Exception;
        //  2699   2703   3573   3586   Ljava/lang/Error;
        //  2705   2710   3586   3596   Ljava/lang/Exception;
        //  2705   2710   3573   3586   Ljava/lang/Error;
        //  2727   2731   3586   3596   Ljava/lang/Exception;
        //  2727   2731   3573   3586   Ljava/lang/Error;
        //  2737   2742   3586   3596   Ljava/lang/Exception;
        //  2737   2742   3573   3586   Ljava/lang/Error;
        //  2755   2760   3586   3596   Ljava/lang/Exception;
        //  2755   2760   3573   3586   Ljava/lang/Error;
        //  2762   2767   3586   3596   Ljava/lang/Exception;
        //  2762   2767   3573   3586   Ljava/lang/Error;
        //  2775   2779   3586   3596   Ljava/lang/Exception;
        //  2775   2779   3573   3586   Ljava/lang/Error;
        //  2789   2794   3586   3596   Ljava/lang/Exception;
        //  2789   2794   3573   3586   Ljava/lang/Error;
        //  2804   2809   3586   3596   Ljava/lang/Exception;
        //  2804   2809   3573   3586   Ljava/lang/Error;
        //  2811   2816   3586   3596   Ljava/lang/Exception;
        //  2811   2816   3573   3586   Ljava/lang/Error;
        //  2819   2824   3586   3596   Ljava/lang/Exception;
        //  2819   2824   3573   3586   Ljava/lang/Error;
        //  2830   2835   3586   3596   Ljava/lang/Exception;
        //  2830   2835   3573   3586   Ljava/lang/Error;
        //  2848   2853   3247   3258   Ljava/lang/Exception;
        //  2848   2853   3573   3586   Ljava/lang/Error;
        //  2862   2867   3247   3258   Ljava/lang/Exception;
        //  2862   2867   3573   3586   Ljava/lang/Error;
        //  2881   2886   3247   3258   Ljava/lang/Exception;
        //  2881   2886   3573   3586   Ljava/lang/Error;
        //  2888   2893   3247   3258   Ljava/lang/Exception;
        //  2888   2893   3573   3586   Ljava/lang/Error;
        //  2895   2900   3247   3258   Ljava/lang/Exception;
        //  2895   2900   3573   3586   Ljava/lang/Error;
        //  2915   2920   3247   3258   Ljava/lang/Exception;
        //  2915   2920   3573   3586   Ljava/lang/Error;
        //  2931   2936   3247   3258   Ljava/lang/Exception;
        //  2931   2936   3573   3586   Ljava/lang/Error;
        //  2943   2948   3247   3258   Ljava/lang/Exception;
        //  2943   2948   3573   3586   Ljava/lang/Error;
        //  2962   2967   3247   3258   Ljava/lang/Exception;
        //  2962   2967   3573   3586   Ljava/lang/Error;
        //  2969   2974   3247   3258   Ljava/lang/Exception;
        //  2969   2974   3573   3586   Ljava/lang/Error;
        //  2976   2981   3247   3258   Ljava/lang/Exception;
        //  2976   2981   3573   3586   Ljava/lang/Error;
        //  2984   2989   3247   3258   Ljava/lang/Exception;
        //  2984   2989   3573   3586   Ljava/lang/Error;
        //  2996   3001   3247   3258   Ljava/lang/Exception;
        //  2996   3001   3573   3586   Ljava/lang/Error;
        //  3015   3020   3247   3258   Ljava/lang/Exception;
        //  3015   3020   3573   3586   Ljava/lang/Error;
        //  3023   3028   3247   3258   Ljava/lang/Exception;
        //  3023   3028   3573   3586   Ljava/lang/Error;
        //  3035   3040   3247   3258   Ljava/lang/Exception;
        //  3035   3040   3573   3586   Ljava/lang/Error;
        //  3054   3059   3247   3258   Ljava/lang/Exception;
        //  3054   3059   3573   3586   Ljava/lang/Error;
        //  3062   3067   3247   3258   Ljava/lang/Exception;
        //  3062   3067   3573   3586   Ljava/lang/Error;
        //  3074   3079   3247   3258   Ljava/lang/Exception;
        //  3074   3079   3573   3586   Ljava/lang/Error;
        //  3093   3098   3247   3258   Ljava/lang/Exception;
        //  3093   3098   3573   3586   Ljava/lang/Error;
        //  3101   3106   3247   3258   Ljava/lang/Exception;
        //  3101   3106   3573   3586   Ljava/lang/Error;
        //  3113   3118   3247   3258   Ljava/lang/Exception;
        //  3113   3118   3573   3586   Ljava/lang/Error;
        //  3132   3137   3233   3247   Ljava/lang/Exception;
        //  3132   3137   3573   3586   Ljava/lang/Error;
        //  3146   3151   3233   3247   Ljava/lang/Exception;
        //  3146   3151   3573   3586   Ljava/lang/Error;
        //  3153   3156   3233   3247   Ljava/lang/Exception;
        //  3153   3156   3573   3586   Ljava/lang/Error;
        //  3176   3179   3233   3247   Ljava/lang/Exception;
        //  3176   3179   3573   3586   Ljava/lang/Error;
        //  3188   3193   3233   3247   Ljava/lang/Exception;
        //  3188   3193   3573   3586   Ljava/lang/Error;
        //  3197   3199   3233   3247   Ljava/lang/Exception;
        //  3197   3199   3573   3586   Ljava/lang/Error;
        //  3203   3206   3233   3247   Ljava/lang/Exception;
        //  3203   3206   3573   3586   Ljava/lang/Error;
        //  3208   3212   3233   3247   Ljava/lang/Exception;
        //  3208   3212   3573   3586   Ljava/lang/Error;
        //  3218   3224   3233   3247   Ljava/lang/Exception;
        //  3218   3224   3573   3586   Ljava/lang/Error;
        //  3239   3244   3247   3258   Ljava/lang/Exception;
        //  3239   3244   3573   3586   Ljava/lang/Error;
        //  3253   3258   3586   3596   Ljava/lang/Exception;
        //  3253   3258   3573   3586   Ljava/lang/Error;
        //  3264   3269   3586   3596   Ljava/lang/Exception;
        //  3264   3269   3573   3586   Ljava/lang/Error;
        //  3282   3287   3586   3596   Ljava/lang/Exception;
        //  3282   3287   3573   3586   Ljava/lang/Error;
        //  3290   3295   3586   3596   Ljava/lang/Exception;
        //  3290   3295   3573   3586   Ljava/lang/Error;
        //  3299   3303   3586   3596   Ljava/lang/Exception;
        //  3299   3303   3573   3586   Ljava/lang/Error;
        //  3309   3314   3357   3359   Ljava/lang/Exception;
        //  3309   3314   3573   3586   Ljava/lang/Error;
        //  3327   3332   3357   3359   Ljava/lang/Exception;
        //  3327   3332   3573   3586   Ljava/lang/Error;
        //  3333   3337   3357   3359   Ljava/lang/Exception;
        //  3333   3337   3573   3586   Ljava/lang/Error;
        //  3340   3345   3357   3359   Ljava/lang/Exception;
        //  3340   3345   3573   3586   Ljava/lang/Error;
        //  3349   3354   3357   3359   Ljava/lang/Exception;
        //  3349   3354   3573   3586   Ljava/lang/Error;
        //  3359   3363   3586   3596   Ljava/lang/Exception;
        //  3359   3363   3573   3586   Ljava/lang/Error;
        //  3425   3430   3586   3596   Ljava/lang/Exception;
        //  3425   3430   3573   3586   Ljava/lang/Error;
        //  3439   3443   3586   3596   Ljava/lang/Exception;
        //  3439   3443   3573   3586   Ljava/lang/Error;
        //  3450   3455   3586   3596   Ljava/lang/Exception;
        //  3450   3455   3573   3586   Ljava/lang/Error;
        //  3464   3469   3586   3596   Ljava/lang/Exception;
        //  3464   3469   3573   3586   Ljava/lang/Error;
        //  3471   3476   3586   3596   Ljava/lang/Exception;
        //  3471   3476   3573   3586   Ljava/lang/Error;
        //  3479   3484   3586   3596   Ljava/lang/Exception;
        //  3479   3484   3573   3586   Ljava/lang/Error;
        //  3491   3496   3586   3596   Ljava/lang/Exception;
        //  3491   3496   3573   3586   Ljava/lang/Error;
        //  3498   3503   3586   3596   Ljava/lang/Exception;
        //  3498   3503   3573   3586   Ljava/lang/Error;
        //  3506   3511   3586   3596   Ljava/lang/Exception;
        //  3506   3511   3573   3586   Ljava/lang/Error;
        //  3517   3522   3586   3596   Ljava/lang/Exception;
        //  3517   3522   3573   3586   Ljava/lang/Error;
        //  3524   3529   3586   3596   Ljava/lang/Exception;
        //  3524   3529   3573   3586   Ljava/lang/Error;
        //  3532   3537   3586   3596   Ljava/lang/Exception;
        //  3532   3537   3573   3586   Ljava/lang/Error;
        //  3543   3548   3586   3596   Ljava/lang/Exception;
        //  3543   3548   3573   3586   Ljava/lang/Error;
        //  3549   3553   3586   3596   Ljava/lang/Exception;
        //  3549   3553   3573   3586   Ljava/lang/Error;
        //  3555   3560   3586   3596   Ljava/lang/Exception;
        //  3555   3560   3573   3586   Ljava/lang/Error;
        //  3562   3566   3586   3596   Ljava/lang/Exception;
        //  3562   3566   3573   3586   Ljava/lang/Error;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0651:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:692)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:529)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:317)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:238)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:138)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void a(final Boolean b) {
        this.t = b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String getAdCode() {
        return this.u.adcode;
    }
    
    public String getAddrStr() {
        return this.u.address;
    }
    
    public Address getAddress() {
        return this.u;
    }
    
    public double getAltitude() {
        return this.f;
    }
    
    public String getBuildingID() {
        return this.w;
    }
    
    public String getBuildingName() {
        return this.x;
    }
    
    public String getCity() {
        return this.u.city;
    }
    
    public String getCityCode() {
        return this.u.cityCode;
    }
    
    public String getCoorType() {
        return this.n;
    }
    
    public String getCountry() {
        return this.u.country;
    }
    
    public String getCountryCode() {
        return this.u.countryCode;
    }
    
    public float getDerect() {
        return this.m;
    }
    
    public float getDirection() {
        return this.m;
    }
    
    public String getDistrict() {
        return this.u.district;
    }
    
    public String getFloor() {
        return this.v;
    }
    
    public int getGpsAccuracyStatus() {
        return this.P;
    }
    
    public int getGpsCheckStatus() {
        return this.Q;
    }
    
    public int getIndoorLocationSource() {
        return this.H;
    }
    
    public int getIndoorLocationSurpport() {
        return this.F;
    }
    
    public String getIndoorLocationSurpportBuidlingID() {
        return this.J;
    }
    
    public String getIndoorLocationSurpportBuidlingName() {
        return this.I;
    }
    
    public int getIndoorNetworkState() {
        return this.G;
    }
    
    public String getIndoorSurpportPolygon() {
        return this.K;
    }
    
    public double getLatitude() {
        return this.c;
    }
    
    public int getLocType() {
        return this.a;
    }
    
    public String getLocTypeDescription() {
        return this.M;
    }
    
    public String getLocationDescribe() {
        return this.q;
    }
    
    public String getLocationID() {
        return this.N;
    }
    
    public int getLocationWhere() {
        return this.A;
    }
    
    public double getLongitude() {
        return this.d;
    }
    
    public String getNetworkLocationType() {
        return this.B;
    }
    
    public int getOperators() {
        return this.C;
    }
    
    public List getPoiList() {
        return this.L;
    }
    
    public String getProvince() {
        return this.u.province;
    }
    
    public float getRadius() {
        return this.j;
    }
    
    public String getRetFields(final String s) {
        return this.O.get(s);
    }
    
    public int getSatelliteNumber() {
        this.k = true;
        return this.l;
    }
    
    public String getSemaAptag() {
        return this.q;
    }
    
    public float getSpeed() {
        return this.h;
    }
    
    public String getStreet() {
        return this.u.street;
    }
    
    public String getStreetNumber() {
        return this.u.streetNumber;
    }
    
    public String getTime() {
        return this.b;
    }
    
    public int getUserIndoorState() {
        return this.E;
    }
    
    public boolean hasAddr() {
        return this.o;
    }
    
    public boolean hasAltitude() {
        return this.e;
    }
    
    public boolean hasRadius() {
        return this.i;
    }
    
    public boolean hasSateNumber() {
        return this.k;
    }
    
    public boolean hasSpeed() {
        return this.g;
    }
    
    public boolean isCellChangeFlag() {
        return this.t;
    }
    
    public boolean isIndoorLocMode() {
        return this.y;
    }
    
    public int isParkAvailable() {
        return this.z;
    }
    
    public void setAddr(final Address u) {
        if (u != null) {
            this.u = u;
            this.o = true;
        }
    }
    
    public void setAddrStr(final String p) {
        this.p = p;
        this.o = (p != null);
    }
    
    public void setAltitude(final double f) {
        this.f = f;
        this.e = true;
    }
    
    public void setBuildingID(final String w) {
        this.w = w;
    }
    
    public void setBuildingName(final String x) {
        this.x = x;
    }
    
    public void setCoorType(final String n) {
        this.n = n;
    }
    
    public void setDirection(final float m) {
        this.m = m;
    }
    
    public void setFloor(final String v) {
        this.v = v;
    }
    
    public void setGpsAccuracyStatus(final int p) {
        this.P = p;
    }
    
    public void setGpsCheckStatus(final int q) {
        this.Q = q;
    }
    
    public void setIndoorLocMode(final boolean y) {
        this.y = y;
    }
    
    public void setIndoorLocationSource(final int h) {
        this.H = h;
    }
    
    public void setIndoorLocationSurpport(final int f) {
        this.F = f;
    }
    
    public void setIndoorNetworkState(final int g) {
        this.G = g;
    }
    
    public void setIndoorSurpportPolygon(final String k) {
        this.K = k;
    }
    
    public void setLatitude(final double c) {
        this.c = c;
    }
    
    public void setLocType(int a) {
        String locTypeDescription = null;
        switch (this.a = a) {
            default: {
                locTypeDescription = "UnKnown!";
                break;
            }
            case 505: {
                locTypeDescription = "NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !";
                break;
            }
            case 167: {
                locTypeDescription = "NetWork location failed because baidu location service can not caculate the location!";
                break;
            }
            case 162: {
                locTypeDescription = "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !";
                break;
            }
            case 161: {
                locTypeDescription = "NetWork location successful!";
                break;
            }
            case 66: {
                locTypeDescription = "Offline location successful!";
                break;
            }
            case 63:
            case 67: {
                locTypeDescription = "Offline location failed, please check the net (wifi/cell)!";
                break;
            }
            case 62: {
                locTypeDescription = "Location failed beacuse we can not get any loc information!";
                break;
            }
            case 61: {
                this.setLocTypeDescription("GPS location successful!");
                a = 0;
                this.setUserIndoorState(0);
                return;
            }
        }
        this.setLocTypeDescription(locTypeDescription);
    }
    
    public void setLocTypeDescription(final String m) {
        this.M = m;
    }
    
    public void setLocationDescribe(final String q) {
        this.q = q;
    }
    
    public void setLocationID(final String n) {
        this.N = n;
    }
    
    public void setLocationWhere(final int a) {
        this.A = a;
    }
    
    public void setLongitude(final double d) {
        this.d = d;
    }
    
    public void setNetworkLocationType(final String b) {
        this.B = b;
    }
    
    public void setOperators(final int c) {
        this.C = c;
    }
    
    public void setParkAvailable(final int z) {
        this.z = z;
    }
    
    public void setPoiList(final List l) {
        this.L = l;
    }
    
    public void setRadius(final float j) {
        this.j = j;
        this.i = true;
    }
    
    public void setSatelliteNumber(final int l) {
        this.l = l;
    }
    
    public void setSpeed(final float h) {
        this.h = h;
        this.g = true;
    }
    
    public void setTime(String a) {
        this.b = a;
        a = com.baidu.location.d.j.a(a);
        this.setLocationID(a);
    }
    
    public void setUserIndoorState(final int e) {
        this.E = e;
    }
    
    public void writeToParcel(final Parcel parcel, int n) {
        n = this.a;
        parcel.writeInt(n);
        parcel.writeString(this.b);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeDouble(this.f);
        parcel.writeFloat(this.h);
        parcel.writeFloat(this.j);
        n = this.l;
        parcel.writeInt(n);
        parcel.writeFloat(this.m);
        parcel.writeString(this.v);
        n = this.z;
        parcel.writeInt(n);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.B);
        parcel.writeString(this.u.province);
        parcel.writeString(this.u.city);
        parcel.writeString(this.u.district);
        parcel.writeString(this.u.street);
        parcel.writeString(this.u.streetNumber);
        parcel.writeString(this.u.cityCode);
        parcel.writeString(this.u.address);
        parcel.writeString(this.u.country);
        parcel.writeString(this.u.countryCode);
        parcel.writeString(this.u.adcode);
        n = this.C;
        parcel.writeInt(n);
        parcel.writeString(this.D);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        n = this.A;
        parcel.writeInt(n);
        parcel.writeString(this.M);
        n = this.E;
        parcel.writeInt(n);
        n = this.F;
        parcel.writeInt(n);
        n = this.G;
        parcel.writeInt(n);
        n = this.H;
        parcel.writeInt(n);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        n = this.P;
        parcel.writeInt(n);
        parcel.writeString(this.N);
        n = this.Q;
        parcel.writeInt(n);
        parcel.writeBooleanArray(new boolean[] { this.e, this.g, this.i, this.k, this.o, this.t, this.y });
        parcel.writeList(this.L);
    }
}
