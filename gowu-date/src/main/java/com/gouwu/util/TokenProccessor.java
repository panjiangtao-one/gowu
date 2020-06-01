package com.gouwu.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @program: share-manage-1.0.0
 * @description: token 工具类
 * @author: ly
 * @create: 2019/2/12
 **/
public class TokenProccessor {

    private static final TokenProccessor instance = new TokenProccessor();

    private TokenProccessor() {
    }

    public static TokenProccessor getInstance() {
        return instance;
    }

    /**
     * 生成Token
     * @return
     */
    public String getToken() {
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] =  md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
