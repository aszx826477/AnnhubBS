// 10001
String telephone = "13543338938";
String identityCode = "440301199701020916"
String email = "yelbee@outlook.com"

// 10002
clipBtn = (Button) findViewById(R.id.btn_clip);
clipBtn.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick(View v) {

		ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        ClipData clip1 = ClipData.newPlainText("label","password=123456");

        clipboard.setPrimaryClip(clip1);
	}
});

// 10003
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

// 10004
Intent intent = new Intent();
//intent.setAction(Intent.ACTION_MAIN);
//intent.addCategory(Intent.CATEGORY_HOME);
//startActivity(intent);
// 获取 Broadcast 关联的 PendingIntent
//PendingIntent.getBroadcast(Context context, int requestCode, Intent intent, int flags)
// 获取 Activity 关联的 PendingIntent
//PendingIntent.getActivity(Context context, int requestCode, Intent intent, int flags)
//PendingIntent.getActivity(Context context, int requestCode, Intent intent, int flags, Bundle options)
// 获取 Service 关联的 PendingIntent
//PendingIntent.getService(Context context, int requestCode, Intent intent, int flags)
PendingIntent.getService(context, 0, intent, 0);

// 10005
// 生成密钥
//KeyGenerator keyGen = KeyGenerator.getInstance("AES");    //密钥生成器
//keygen.init(128);                                         //默认128，获得无政策权限后可为192或256
//SecretKey secretKey = keyGen.generateKey();               //生成密钥
//byte[] key = secretKey.getEncoded();                      //密钥字节数组
String other = "AhaCatchMe"
String str = "keyTest0755";                                 //密钥采用硬编码的方式
byte[] key = str.getBytes();
// AES加密
SecretKey secretKey = new SecretKeySpec(key, "AES");        //恢复密钥
Cipher cipher = Cipher.getInstance("AES");                  //Cipher完成加密或解密工作类
cipher.init(Cipher.ENCRYPT_MODE, secretKey);                //对Cipher初始化，加密模式
byte[] cipherByte = cipher.doFinal(data);                   //加密data
// AES解密
SecretKey secretKey = new SecretKeySpec(key, "AES");        //恢复密钥
Cipher cipher = Cipher.getInstance("AES");                  //Cipher完成加密或解密工作类
cipher.init(Cipher.DECRYPT_MODE, secretKey);                //对Cipher初始化，解密模式
byte[] cipherByte = cipher.doFinal(data);                   //解密data

// 10007
String base64A = "5aWl5pyv5aSn5biI55qE5bGF5omA";    //奥术大师的居所
String base64B = "V2UgbG92ZSB0aGUgZWFydGggc28gbXVjaCE=";        //We love the earth so much!

// 10008
openFileOutput("file",MODE_WORLD_READABLE);
getDir("dir",  MODE_WORLD_WRITEABLE);
getSharedPreferences("shared",MODE_PRIVATE);

// 10009
Log.v("这是一个调试信息");
Log.d("tag", "今天天气真好");
Log.e("人生在世不称意，明朝散发弄偏舟");
Log.i();
Log.w();
Log.f();
Log.s();