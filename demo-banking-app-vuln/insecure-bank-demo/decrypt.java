import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Decrypt {
    private static final String STATIC_KEY = "BankKey1";
    private static final String ALGORITHM = "DES/ECB/PKCS5Padding";

    public static String decrypt(String ciphertext) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(STATIC_KEY.getBytes("UTF-8"), "DES");
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
        } catch (Exception e) {
            
        }
    }
    public void main() {
        bytes[] ciphertext = "4GAsQwj5WBJVKf5ICGRIw8Gb7TK0d5JV";

    }
} 