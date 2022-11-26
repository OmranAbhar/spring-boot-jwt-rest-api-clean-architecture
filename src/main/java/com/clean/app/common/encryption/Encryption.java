package com.clean.app.common.encryption;

import org.jasypt.util.text.AES256TextEncryptor;

 public class Encryption {
    public static  String EncryptPassword(String email,String password)
    {
        AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
        aesEncryptor.setPassword(email);
        String myEncryptedPassword = aesEncryptor.encrypt(password);
        System.out.println(myEncryptedPassword );
        return myEncryptedPassword;
    }

    public static  String DecryptPassword(String email,String passwordFromConfigFile)
    {
        AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
        aesEncryptor.setPassword(email);
        String decryptedPassword = aesEncryptor.decrypt(passwordFromConfigFile);

        System.out.println(decryptedPassword );
        return decryptedPassword;
    }
}
