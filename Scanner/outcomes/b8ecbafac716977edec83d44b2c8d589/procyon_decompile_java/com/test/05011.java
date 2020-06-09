public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent(); // 检测点1
        String className = intent.getStringExtra("className");
        String methodName = intent.getStringExtra("methodName");

        try {
            Class<?> clz = null;
            clz = Class.forName(className); // 检测点2
            Date object = (Date) clz.newInstance();
            Method method = clz.getMethod(methodName);
            Toast.makeText(getApplicationContext(), method.invoke(object, null) + "======", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
