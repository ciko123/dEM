package com.ciko.guo.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 创建时间: 2017/8/28 上午11:19
 * 类描述:
 *
 * @author 木棉
 */

public class MD5Util {

    private static final String[] HEX_DIGITS = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private MD5Util() {
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer buf = new StringBuffer();
        for (byte aB : b) {
            buf.append(byteToHexString(aB));
        }
        return buf.toString();
    }

    private static String byteToHexString(byte b) {
        return HEX_DIGITS[(b & 240) >> 4] + HEX_DIGITS[b & 15];
    }

    public static String encode(String origin) {
        if (origin == null) {
            throw new IllegalArgumentException("MULTI_000523");
        } else {
            String resultString = origin;
            try {
                MessageDigest e = MessageDigest.getInstance("MD5");
                try {
                    resultString = byteArrayToHexString(e.digest(resultString.getBytes("UTF-8")));
                } catch (UnsupportedEncodingException var4) {
                    var4.printStackTrace();
                }
                return resultString;
            } catch (NoSuchAlgorithmException var5) {
                return null;
            }
        }
    }

}

