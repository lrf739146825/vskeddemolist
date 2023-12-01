package com.vsked.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class CryptoToolTest{

    private static final Logger log = LoggerFactory.getLogger(CryptoToolTest.class);

    @Test
    public void base64Test(){
        //base64加密测试
        String encodeBeforeString="abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
        encodeBeforeString="abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
        log.debug("encodeBeforePassword value|{}|",encodeBeforeString);
        String encodeAfterString=CryptoTool.base64Encode(encodeBeforeString.getBytes());
        log.debug("encodeAfterPassword value|{}|",encodeAfterString);

        //base64解密测试
        byte[] decodeAfterByte=CryptoTool.base64Decode(encodeAfterString);
        String decodeAfterString=new String(decodeAfterByte);
        log.debug("decodeAfterString value|{}|",decodeAfterString);
    }

    @Test
    public void md5Encode(){
        //md5加密测试
        String encodeBeforePassword="abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
        encodeBeforePassword="abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
        log.debug("encodeBeforePassword value|{}|",encodeBeforePassword);
        String encodeAfterPassword=CryptoTool.md5Encode(encodeBeforePassword);
        log.debug("encodeAfterPassword value|{}|",encodeAfterPassword);
    }

    @Test
    public void aesCBCPKCS5Encode(){
        try {
            //AES/CBC/PKCS5Padding加密测试
            String encodeBeforePassword = "abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
            encodeBeforePassword = "abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
            log.debug("encodeBeforePassword value|{}|", encodeBeforePassword);
            String encodeAfterPassword = CryptoTool.aesCBCPKCS5Encode(encodeBeforePassword);
            log.debug("encodeAfterPassword value|{}|", encodeAfterPassword);

            //AES/CBC/PKCS5Padding解密测试
            String decodeResult=CryptoTool.aesCBCPKCS5Decode(encodeAfterPassword);
            log.debug("decodeResult value|{}|", decodeResult);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void aesGCMNoPaddingEncode(){
        try{
            String key="vskyuelaiyuehaoa";
            //AES/GCM/NoPadding加密测试
            String encodeBeforePassword = "abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
            encodeBeforePassword = "abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
            log.debug("encodeBeforePassword value|{}|", encodeBeforePassword);
            String encodeAfterPassword = CryptoTool.aesGCMNoPaddingEncode(encodeBeforePassword,key);
            log.debug("encodeAfterPassword value|{}|", encodeAfterPassword);

            //AES/GCM/NoPadding解密测试
            String decodeResult=CryptoTool.aesGCMNoPaddingDecode(encodeAfterPassword,key);
            log.debug("decodeResult value|{}|", decodeResult);

        }catch (Exception e){
            log.error("aes code error",e);
        }
    }

}
