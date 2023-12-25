package sky.demo.oautn2auth.util;

/**
 * @author 提笔难书
 * @create -05-17  15:24
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * AES加密解密工具类
 *
 * @author 提笔难书
 * @since 2021/5/12 14:32 ，1.0
 **/
@Slf4j
public class AESUtil {

    private static final String AES_KEY = "915eae87951a448c86c47796e44c1fcf";
    /**
     * AES解密
     *
     * @param encryptStr 密文
     * @return 明文
     */
    public static String aesDecrypt(String encryptStr) {
        String decryptKey = AES_KEY;
        if (StringUtils.isEmpty(encryptStr) || StringUtils.isEmpty(decryptKey)) {
            return null;
        }
        byte[] encryptByte = Base64.getDecoder().decode(encryptStr);
        byte[] decryptBytes = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
            decryptBytes = cipher.doFinal(encryptByte);
        } catch (Exception e) {
            log.error("AES解密发生错误,密文:{},AES秘钥:{}", encryptStr, decryptKey, e);
        }
        return new String(decryptBytes);
    }

    /**
     * AES加密
     *
     * @param content    明文
     * @return 密文
     */
    public static String aesEncrypt(String content) {
        String encryptKey = AES_KEY;
        if (StringUtils.isEmpty(content) || StringUtils.isEmpty(encryptKey)) {
            return null;
        }
        byte[] encryptStr = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
            encryptStr = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error("AES加密发生错误,明文:{},AES秘钥:{}", content, encryptStr, e);
        }
        return Base64.getEncoder().encodeToString(encryptStr);
    }

    public static void main(String[] args) {
        String content = "123456";
        String encryptStr = aesEncrypt(content);
        String decryptStr = aesDecrypt(encryptStr);
        System.out.println(content);
        System.out.println(encryptStr);
        System.out.println(decryptStr);
    }

}
