package com.djs.springboot;

import com.djs.springboot.entity.AES;
import com.djs.springboot.entity.RSA;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

/**
 * 对称秘钥与非对称密钥结合
 * @author bohua
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestR {

    private TestR(){
        //模仿加密
        try {
            InputStream in=new FileInputStream("C:\\Users\\dell\\Desktop\\key.txt");
            OutputStream out=new FileOutputStream("C:\\Users\\dell\\Desktop\\sock.txt");
            AES aes=new AES();
            RSA rsa=new RSA();
            aes.generateKey();//获得key
            Key key=aes.getKey();
            System.out.println(key+"  kkkkk");
            //获取非对称秘钥
            KeyPair keyPair=rsa.generateKeyPair();
            rsa.setPrivateKey(keyPair.getPrivate());
            byte[] b=rsa.wrapKey(key);
            aes.encrypt(in, out);//加密过程
            Decrypt(b,keyPair);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ShortBufferException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     模仿解密过程
     * @param b
     * @param keyPair
     */
    private void Decrypt(byte[] b, KeyPair keyPair) {
        InputStream in2;
        try {
            in2 = new FileInputStream("C:\\Users\\dell\\Desktop\\key1.txt");
            OutputStream out2=new FileOutputStream("C:\\Users\\dell\\Desktop\\sock2.txt");
            AES aes2=new AES();
            RSA rsa2=new RSA();
            rsa2.setPublicKey(keyPair.getPublic());
            Key key2=rsa2.unwrapKey(b);
            aes2.setKey(key2);
            aes2.decrypt(in2,out2);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ShortBufferException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new TestR();
    }
}

