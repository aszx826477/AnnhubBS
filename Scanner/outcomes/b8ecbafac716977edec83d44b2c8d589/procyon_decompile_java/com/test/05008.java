//源于程序没有对getAction()等获取到的数据进行空指针判断，从而导致了空指针异常导致应用崩溃
Intent i = new Intent();
try {
if (i.getAction().equals("TestForNullPointerException")) {

    Log.d("TAG", "Test for Android Refuse Service Bug");

}
} catch Exception {
}

Intent abc = new Intent();
Intent kkk = new Intent();
if (abc.getAction().equals("TestForNullPointerException")) {
    Log.d("TAG", "Test for Android Refuse Service Bug");
} 

//源于程序没有对getSerializableExtra()等获取到的数据进行类型判断而进行强制类型转换，从而导致类型转换异常导致拒绝服务漏洞
Intent a = getIntent();
try {
	String test = (String) a.getSerializableExtra("serializable_key");
} catch Exception {
    //针对异常进行操作
}

//源于程序没有对getIntegerArrayListExtra()等获取到的数据数组元素大小判断，导致数组访问越界而造成拒绝服务漏洞
Intent intent = getIntent();

ArrayList<Integer> intArray = intent.getIntegerArrayListExtra("user_id");
if (intArray != null) {
    for (int i = 0; i < 10; i++) {
        intArray.get(i);
    }
}


//源于程序没有找到从getSerializableExtra()获取到的序列化对象的类定义，因此导致发生类未定义的异常导致拒绝服务漏洞
a.getSerializableExtra("key");
