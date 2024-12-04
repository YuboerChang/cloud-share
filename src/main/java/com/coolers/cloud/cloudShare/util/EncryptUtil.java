package com.coolers.cloud.cloudShare.util;

import com.coolers.cloud.cloudShare.constant.EncryptConst;

import javax.crypto.KeyGenerator;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptUtil {
    public static final String BASE_SECRET_KEY = "this_is_a_base_secret_key";
    public static final String ENCRYPTION_TYPE_AES = "AES";
    public static final int KEY_LENGTH_32 = 32;

    /**
     * MD5加密算法，不可再次查看加密前文本，仅适用于加密和校验
     */
    public static String encryptByMD5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(EncryptConst.ENCRYPT_ALGORITHM_MD5);
        byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuffer stb = new StringBuffer();
        for (byte bt : digest) {
            stb.append(String.format(EncryptConst.ENCODE_FORMAT_HEXADECIMAL, bt));
        }
        return stb.toString();
    }

    /**
     * 随机获取一个字符串，调用随机工具失败就直接返回基础字符串，不做异常处理
     */
    public static String getRandomSecretKey() {
        String secretKey = "";
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ENCRYPTION_TYPE_AES);
            keyGenerator.init(KEY_LENGTH_32, new SecureRandom());
            secretKey = Base64.getEncoder().encodeToString(keyGenerator.generateKey().getEncoded());
        } catch (Exception e) {
            secretKey = BASE_SECRET_KEY;
        }
        return secretKey;
    }

}
