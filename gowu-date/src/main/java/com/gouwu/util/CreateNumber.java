package com.gouwu.util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * @author LiuYue
 * @Title: CreateNumber
 * @ProjectName center-manage
 * @Description: 生成订单编号等
 * @date 2019/3/4 15:21
 */
public class CreateNumber {
    /**
     * 用于生成随机数
     */
    private final static String CODES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * 生成订单编号
     * 支付订单yyyyMMdd+math(6)+6位随机数+(0、1、2、3、4、5)
     * PAYBALANCE(0, "充余额"),
     * PAYORDER(1, "支付订单"),
     * PAYWEEKCARD(2, "购买周卡"),
     * RETURNBALANCE(3, "退余额"),
     * REFUNDORDER(4,"订单退款");
     * PAYARREARS(5,支付订单尾款)
     *
     * 使用订单yyyyMMdd(6)+7位随机数+1
     *
     * 资金预授权yyyyMMdd(6)+7位随机数+2
     * @param length
     * @return
     */
    public static String getOrderNumber(int length, String mathId) {
        StringBuffer result = new StringBuffer();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        result.append(sdf.format(date));
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result.append(random.nextInt(length));
        }
        result.append(mathId);
        return result.toString();
    }

    /**
     * 生成周卡编号
     *
     * @param length
     * @return
     */
    public static String getCardNumber(int length) {
        StringBuffer result = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result.append(random.nextInt(8));
        }
        result.append(1);
        return result.toString();
    }

    /**
     * 用于32位生成随机数
     *
     * @param length
     * @return
     */
    public static String getRandom(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(CODES.length());
            sb.append(CODES.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成n个不同的随机数，且随机数区间为[0,10)
     * @param n
     * @return
     */
    public static ArrayList getDiffNO(int n){
        //生成 [0-n) 个不重复的随机数
        //list 用来保存这些随机数
        ArrayList list = new ArrayList();
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            do {
                //如果产生的数相同继续循环
                num = rand.nextInt(n);
            } while (bool[num]);
            bool[num] = true;
            list.add(num);
        }
        return list;
    }


}
