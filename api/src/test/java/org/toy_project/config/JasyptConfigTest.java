package org.toy_project.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JasyptConfigTest {

    @Test
    void init() {
        // TODO Auto-generated method stub
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword("apiKey");

        String url = "jdbc:mysql://3.37.128.188:3306/chanee";
        String username = "root";
        String password = "chanee1234!#%Z";

        System.out.println("기존  URL :: " + url + " | 변경 URL :: " + pbeEnc.encrypt(url));
        System.out.println("기존  username :: " + username + " | 변경 username :: " + pbeEnc.encrypt(username));
        System.out.println("기존  password :: " + password + " | 변경 password :: " + pbeEnc.encrypt(password));
    }
}
