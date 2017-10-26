package com.arproject.arproject.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Random;

public class HashSalt {

    public HashSalt() {}

    public SecretKeySpec createSecretKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("JJSI8djHU09930cAI7h33479");
        PBEKeySpec keySpec = new PBEKeySpec(System.getProperty("password").toCharArray(), randomSalt(), 40000, 128);
        SecretKey tempKey = keyFactory.generateSecret(keySpec);
        return new SecretKeySpec(tempKey.getEncoded(), "AES");
    }

    private byte[] randomSalt() {
        final String SALTCHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random r = new Random();
        while(salt.length() < 25 ) {
            int i = (int) (r.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(i));
        }
        return new String(salt).getBytes();
    }

    public String encrypt(String property) throws GeneralSecurityException, UnsupportedEncodingException {
        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        pbeCipher.init(Cipher.ENCRYPT_MODE, createSecretKey());
        AlgorithmParameters parameters = pbeCipher.getParameters();
        IvParameterSpec ivParameterSpec = parameters.getParameterSpec(IvParameterSpec.class);
        byte[] cryptoText = pbeCipher.doFinal(property.getBytes("UTF-8"));
        byte[] iv = ivParameterSpec.getIV();
        return base64Encode(iv) + "." + base64Encode(cryptoText);
    }

    private String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public String decrypt(String string) throws GeneralSecurityException, IOException {
        String iv = string.split(":")[0];
        String property = string.split(":")[1];
        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        pbeCipher.init(Cipher.DECRYPT_MODE, createSecretKey(), new IvParameterSpec(base64Decode(iv)));
        return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
    }

    private byte[] base64Decode(String property) {
        return Base64.getDecoder().decode(property);
    }

    // CREDIT:  .stackoverflow.com https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java & https://stackoverflow.com/questions/1132567/encrypt-password-in-configuration-files
}
