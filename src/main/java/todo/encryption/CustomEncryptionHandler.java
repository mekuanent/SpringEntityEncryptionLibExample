package todo.encryption;

import com.github.mekuanent.encryption.handler.IEncryptionHandler;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

/**
 * Created by Mekuanent Kassaye on 2019-06-26.
 *
 */
@Component
public class CustomEncryptionHandler implements IEncryptionHandler {

    private static SecretKey KEY = null;

    @Override
    public String encrypt(String raw) {

        String strData=null;

        try {

            KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");
            if(KEY == null)
                KEY = keygenerator.generateKey();

            Cipher cipher=Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, KEY);
            byte[] encrypted=cipher.doFinal(raw.getBytes());
            strData= new String(Base64.getEncoder().encode(encrypted));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strData;
    }

    @Override
    public String decrypt(String cipherText) {
        String strData=null;

        try {
            if(KEY != null){
                Cipher cipher=Cipher.getInstance("Blowfish");
                cipher.init(Cipher.DECRYPT_MODE, KEY);
                byte[] decrypted=cipher.doFinal(Base64.getDecoder().decode(cipherText));
                strData = new String(decrypted);
            }else{
                return "expired key";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strData;
    }
}
