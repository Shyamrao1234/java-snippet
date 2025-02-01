package org.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.sound.midi.Soundbank;
import javax.xml.bind.DatatypeConverter;
import javax.xml.crypto.Data;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 * Created by $CapName on Jan 28, 2025.
 */

/*
Java Cryptography Architecture
 */

public class JCA {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        String msg = "Shyam";

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(msg.getBytes());
        byte[] digest = md.digest();

        System.out.println(digest);


    }
}

/*
   RAC a type of asymmetric encryption with two different but linked keys
   Public key : we can share it with any one to encrypt the data
   Private key : we have to keep it to decrypt the data
 */

class RSAEncryptionTest {
    public static void main(String[] args) throws Exception {
        String msg = "Shyam";


        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(600);
        KeyPair    pair       = generator.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        PublicKey  publicKey  = pair.getPublic();

        System.out.println("privateKey---->" + privateKey);
        System.out.println("publicKey---->" + publicKey);
        System.out.println("endcoded privateKey---->" + Base64.getEncoder().encodeToString(privateKey.getEncoded()));
        System.out.println("endcoded publickey---->" + Base64.getEncoder().encodeToString(publicKey.getEncoded()));


        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] msgInByte         = msg.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMsgBytes = encryptCipher.doFinal(msgInByte);

        System.out.println("encrypted++++++++++++++++++++++"+Base64.getEncoder().encodeToString(encryptedMsgBytes));


        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] decryptedMsgBytes = decryptCipher.doFinal(encryptedMsgBytes);
        String decryptedMsg      = new String(decryptedMsgBytes, StandardCharsets.UTF_8);

        System.out.println(decryptedMsg);

    }
}


class AESEncryptionTest {
    public static void main(String[] args) {
        try {
            // Step 1: Generate AES Key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128); // AES 128-bit key
            SecretKey secretKey = keyGenerator.generateKey();

            // Step 2: Initialize Cipher for AES/ECB/PKCS5Padding
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            // Step 3: Encrypt Data
            String plaintext = "Hello, AES encryption!";
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(plaintext.getBytes());
            String encryptedText = Base64.getEncoder().encodeToString(encryptedData); // Base64 encoding for readability
            System.out.println("Encrypted Text: " + encryptedText);


            // Step 4: Decrypt Data
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            String decryptedText = new String(decryptedData);
            System.out.println("Decrypted Text: " + decryptedText);

            // Check if encryption and decryption match
            if (plaintext.equals(decryptedText)) {
                System.out.println("Encryption and Decryption successful. The original text and decrypted text match.");
            } else {
                System.out.println("Something went wrong. The decrypted text does not match the original.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//Note: Youtube session examples

class HashEncryption {

    private static void hashText(String s) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[]        inputInBytes  = s.getBytes();
        byte[]        digest        = messageDigest.digest(inputInBytes);
        System.out.println("Input:   " + s);
        System.out.println("Digest:   " + DatatypeConverter.printHexBinary(digest));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

//        HashEncryption hashEncryption=new HashEncryption();

        HashEncryption.hashText("my name is shyam");
        HashEncryption.hashText("my name is shyam");
        HashEncryption.hashText("my am rocky");
        HashEncryption.hashText("hello");


    }
}


class AESEncryption {

    public static void symmetricEncryption(String s) throws GeneralSecurityException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        //specify we want a key length of 192 bits, allowed for AES
        generator.init(192);
        Key key = generator.generateKey();
        System.out.println("Key====" + DatatypeConverter.printHexBinary(key.getEncoded()));

        byte[] input = s.getBytes();
        System.out.println("input===" + new String(input));


        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedOutPut = cipher.doFinal(input);
        System.out.println("cipher text====" + DatatypeConverter.printHexBinary(encryptedOutPut));


        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryption = cipher.doFinal(encryptedOutPut);
        System.out.println("decrypted==" + new String(decryption));
    }


    public static void main(String[] args) throws GeneralSecurityException {

        AESEncryption.symmetricEncryption("shyamraoshyamrao");


    }


}

class Base {
    public static void main(String[] args) {
        byte[] bytes  = "Rocky@123".getBytes();
        String encode = Base64.getEncoder().encodeToString(bytes);
        System.out.println(encode);

    }
}


class RSAEncryptionTest2 {


    public static PrivateKey getPrivateKeyFromBase64(String base64String) throws Exception {

        byte[] decode = Base64.getDecoder().decode(base64String);

        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(decode);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        return keyFactory.generatePrivate(pkcs8EncodedKeySpec);

    }

    public static byte[] convertToByteArray(String str) {
        return Base64.getDecoder().decode(str.getBytes());
    }


    public static void main(String[] args) throws Exception {
        String privateKeyInStr = "MIIBhQIBADANBgkqhkiG9w0BAQEFAASCAW8wggFrAgEAAkwAvwIo/8BC+XQl8DSICDKmOUUcetP+nXccILBwsUPb7Yf/XXeq0EVbcAwi50XfztU9g04rDe3KF6F1W1ak08BDRXAJmmufV9mmWFkbAgMBAAECS0KUQi5DmhTRw5ei9/fDj+VOjcrSsmG47vkGB4ICoVp+mSi" +
                "/Wa8Nm2YYUlxchTW1uUil0Ic7Dp5WxtQBt3IIHlND+dC0WhF/hhjcoQImDejbI1iDWuAi0Szt0ycT+J31occSWAmkBIPaQ9fi+bqrA4QOUc8CJg27bUlXFzvNTr7R+wVhKE/sgmdClRpFFDcasNnWTyfmUB5xRJL1AiYEgKGeuWIbon3is+Zv+TBPw+Hk8imP8d7zzzJxz4obSD9fLfnspQImCWu5KSR/gv5x9IWYIfOqtVI7kF3kbtZPbRJ5m6jkOypNcuUgN3UCJg20bpuZk7Kkzr2Ua5iuXE7mJSi99s5w5QpfGO+DJHCGUVJ8q0kZ";

        String publicKeyInStr = "MGcwDQYJKoZIhvcNAQEBBQADVgAwUwJMAL8CKP/AQvl0JfA0iAgypjlFHHrT/p13HCCwcLFD2+2H/113qtBFW3AMIudF387VPYNOKw3tyhehdVtWpNPAQ0VwCZprn1fZplhZGwIDAQAB";

        String decryptedMsgInstr = "oRaKxQicVuPiuOaVPz3WKNZA+iJqMu05oDoqZK2IeD3InunmDoUxrdW2a353gPYHNt0VUvISTvT/u4pcqEVbm764JwokxaWFcDUM";


        PrivateKey privateKey = getPrivateKeyFromBase64(privateKeyInStr);

        byte[] decryptedByteMsg = convertToByteArray(decryptedMsgInstr);

        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytes = cipher.doFinal(decryptedByteMsg);

        System.out.println(new String(bytes));


    }
}

