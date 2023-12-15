package sky.demo.oautn2auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("sky.demo.oautn2auth.mapper")
public class Oautn2AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oautn2AuthApplication.class, args);
    }

}
