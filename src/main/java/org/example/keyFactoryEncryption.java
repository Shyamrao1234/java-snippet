package org.example;

/**
 * Created by $CapName on Feb 01, 2025.
 */

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;

/**
 * A key factory is a mechanism in cryptographic systems that allows you to:
 * <p>
 * 1-Convert an opaque key (a key object that hides its internal structure) into
 * a key specification (a transparent representation of the key material).
 * <p>
 * 2-Convert a key specification back into an opaque key.
 * <p>
 * Note This is useful because:
 * <p>
 * 1-opaque keys are typically used in cryptographic operations (e.g., encryption, decryption, signing)
 * where the internal structure of the key is not exposed.
 * <p>
 * 2-Key specifications are used when you need to inspect, manipulate,
 * or serialize the key material (e.g., for storage or transmission).
 */


public class keyFactoryEncryption {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair    pair       = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        RSAPrivateCrtKeySpec keySpec = keyFactory.getKeySpec(privateKey, RSAPrivateCrtKeySpec.class);

        System.out.println(keySpec.getModulus());
        System.out.println(keySpec.getCrtCoefficient());
        System.out.println(keySpec.getPrimeExponentP());
        System.out.println(keySpec.getPrimeP());
        System.out.println(keySpec.getPrimeQ());
        System.out.println(keySpec.getPrivateExponent());



    }
}
