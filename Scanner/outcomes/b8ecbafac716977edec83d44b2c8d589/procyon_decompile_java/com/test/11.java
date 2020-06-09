import android.provider.Settings.Secure;

// 11001
String text = "YellowBee";
String data = encryptSha256Server(text);
info = decryptSha256Client(data);

// 11002 - 在test文件夹有个EncryptData.java的测试文件

// 11003
Runtime rr = Runtime.getRuntime();
          Process p = rr.exec("ls -al");

// 11004
System.loadLibrary("libtest.so");

// 11005
DexClassLoader cl = new DexClassLoader(
    optimizedDexOutputPath.getAbsolutePath(),              //参数1
    Environment.getExternalStorageDirectory().toString(),  //参数2
    null,                                                  //参数3
    getClassLoader());                                     //参数4

// 11006
           Runtime rr_2 = Runtime.getRuntime();
  Process p = rr_2.exec("su");

// 11007
TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
String final DEVICE_ID = tm.getDeviceId();

// 11008
String androidId = Secure.getString(getContentResolver(), Secure.ANDROID_ID);

// 11009
SmsManager smsm = SmsManager.getDefault();
smsm.sendTextMessage("123123", null, "hello", null, null);
smsm.sendDataMessage("13123", "123", (short) 90, null, null, null);
smsm.sendMultimediaMessage(this, null, null, null, null);

// 11010
File file = new File("tmp.doc");
File file22 = new File("qwe.doc");
boolean deleted = file.delete();

// 11011
PackageManager pkgManager = context.getPackageManager();
byte[] signature = pkgManager.getPackageInfo(
    context.getPackageName(),
    PackageManager.GET_SIGNATURES).signatures[0].toByteArray();
