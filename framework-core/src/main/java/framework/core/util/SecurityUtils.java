package framework.core.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class SecurityUtils {

    private static final String ENC_KEY = "0123456789012345";

    public static final String AES256Encrypt(String plainText) throws UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        byte[] keyBytes = new byte[16];
        byte[] b = ENC_KEY.getBytes("UTF-8");
        int len = b.length;
        if (len > keyBytes.length) {
            len = keyBytes.length;
        }
        System.arraycopy(b, 0, keyBytes, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(ENC_KEY.getBytes()));

        byte[] encrypted = c.doFinal(plainText.getBytes("UTF-8"));
        String encryptedText = new String(Base64.encodeBase64(encrypted));

        return encryptedText;
    }

    public static final String AES256Decrypt(String encryptedText) throws UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        byte[] keyBytes = new byte[16];
        byte[] b = ENC_KEY.getBytes("UTF-8");
        int len = b.length;
        if (len > keyBytes.length) {
            len = keyBytes.length;
        }
        System.arraycopy(b, 0, keyBytes, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(ENC_KEY.getBytes()));

        byte[] decrypted = c.doFinal(encryptedText.getBytes("UTF-8"));
        String plainText = new String(Base64.encodeBase64(decrypted));

        return plainText;
    }
}
