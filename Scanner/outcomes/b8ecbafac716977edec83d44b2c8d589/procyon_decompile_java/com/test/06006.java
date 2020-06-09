TrustManager tm = new X509TrustManager() {
    public void checkClientTrusted(X509Certificate[) chain, String authType)
        throws CertificateException {
            //do nothing, 接受任意客户端证书
    }

    public void checkServerTrusted(X509Certificate[) chain, String authType)
        throws CertificateException {
            //do nothing, 接受任意服务端证书
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    public X509Certificate[] getAcceptedIssuers() {
		return new X509Certificate[0];
    }
}