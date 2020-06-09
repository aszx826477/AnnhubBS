// convert intent scheme URL to intent object  
Intent intent = Intent.parseUri(uri); 

// forbid launching activities without BROWSABLE category  
intent.addCategory("android.intent.category.BROWSABLE");  

// forbid explicit call  
intent.setComponent(null); 

// forbid intent with selector intent  
intent.setSelector(null);  

// start the activity by the intent  
context.startActivityIfNeeded(intent, -1)


Intent intent_2 = Intent.parseUri(uri); 
