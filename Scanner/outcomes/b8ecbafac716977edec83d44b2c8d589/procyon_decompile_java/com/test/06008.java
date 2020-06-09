WebView mWebView;
WebView yelbeeView;


mWebView.getSettings().setJavaScriptEnabled(true);
mWebView.addJavascriptInterface(new JsBridge(mContext), JS_OBJECT);
mWebView.loadUrl("http://www.baidu.com");
mWebView.setWebViewClient(new WebViewClient() {
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler,
        SslError error) {
        // 06008
        }
            handler.proceed(); //忽略SSL证书的错误
        }
}

// 06009
mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
mWebView.removeJavascriptInterface("accessibilityTraversal");
//mWebView.removeJavascriptInterface("accessibility");
