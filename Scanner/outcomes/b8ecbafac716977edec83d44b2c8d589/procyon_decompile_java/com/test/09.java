// 09001
SecretKeySpec key = new SecretKeySpec(rawKeyData, "DES");
Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
cipher.init(Cipher.DECRYPT_MODE, key);

// 09002
public static KeyPair getRSAKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512);
        KeyPair key = keyGen.generateKeyPair();
        return key;
      }

// 09003
SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
cipher.init(Cipher.ENCRYPT_MODE, key);

// 09004
byte[] iv = { 0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00 };
IvParameterSpec ips = new IvParameterSpec(iv)

// 09005
Cipher rsa = null;
try {
    rsa = javax.crypto.Cipher.getInstance("RSA/NONE/NoPadding");
}   catch (java.security.NoSuchAlgorithmException e) {}
    catch (javax.crypto.NoSuchPaddingException e) {}
SecretKeySpec key = new SecretKeySpec(rawKeyData, "RSA");
Cipher cipher = Cipher.getInstance("RSA/NONE/NoPadding");
cipher.init(Cipher.DECRYPT_MODE, key);