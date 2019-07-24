package todo;

import com.github.mekuanent.encryption.config.EnableEncryptionConfig;
import com.github.mekuanent.encryption.handler.EncryptionHandler;
import com.github.mekuanent.encryption.handler.PBEHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by Mekuanent Kassaye on 2019-06-21.
 */

@SpringBootApplication
@EnableJpaAuditing
@Import(EnableEncryptionConfig.class)
public class Application {

    public static void main(String[] args) {

        EncryptionHandler.set(new PBEHandler("boooooooooom!!!!",
                "some really huge salt", "akjhsdjalshdkasjhdkjashdksad", 100, 256));

        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }
}