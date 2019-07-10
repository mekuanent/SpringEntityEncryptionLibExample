package todo;

import com.mekuanent.encryption.annotation.Encrypted;
import com.mekuanent.encryption.handler.EncryptionHandler;
import com.mekuanent.encryption.handler.PBEHandler;
import todo.encryption.CustomEncryptionHandler;
import todo.model.Todo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Mekuanent Kassaye on 2019-06-25.
 */
public class Terminal {

    public static void main(String[] args) {


        CustomEncryptionHandler handler = new CustomEncryptionHandler();

        System.out.println(handler.encrypt("My Love"));
        System.out.println(handler.decrypt(handler.encrypt("My Love")));
    }

}
