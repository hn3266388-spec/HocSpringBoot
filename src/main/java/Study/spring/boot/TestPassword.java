package Study.spring.boot;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassword {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String hash = encoder.encode("password");

        System.out.println(hash);

        System.out.println(
                encoder.matches("password", hash)
        );
    }
}