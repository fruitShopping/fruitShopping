package com.fruit.util;

import java.security.MessageDigest;

/**
 * Created by zcf on 2015/11/19.
 * 采用MD5加密
 */
public class MD5Util {
    /**
     *  MD5加密 生成32位md5码
     * @param inStr 加密字符串
     * @return 返回32位md5码
     * @throws Exception 异常
     */
    public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 测试主函数
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        String str = new String("weijifen01");
        System.out.println("原始：" + str);
        System.out.println("MD5后：" + md5Encode(str));
    }
}
