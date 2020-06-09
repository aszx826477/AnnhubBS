// 12001
public class WelcomeActivity extends PreferenceActivity {
    @Override
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }

}



// 12003
SecureRandom secureRandom = new SecureRandom();
byte[] b = new byte[] { (byte) 1 };
secureRandom.setSeed(b);
// 对于Android 4.2版本Test1和Test2会返回相同的值
Log.v("wgc","-------------------------------");
Log.v("wgc","Test1:" + secureRandom.nextInt());

SecureRandom secureRandom2 = new SecureRandom(new byte[] { (byte) 1 });
Log.v("wgc","Test2:" + secureRandom2.nextInt());

SecureRandom secureRandom3 = new SecureRandom();
secureRandom3.setSeed(10L);
Log.v("wgc","Test3:" + secureRandom3.nextInt());

SecureRandom secureRandom4 = new SecureRandom();
secureRandom4.nextBytes(b);
secureRandom4.setSeed(10L);
Log.v("wgc","Test4:" + secureRandom4.nextInt());

SecureRandom secureRandom5 = new SecureRandom();
Log.v("wgc","Test5:" + secureRandom5.nextInt());