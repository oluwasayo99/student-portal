package com.studentportal;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptTest {
    @Test
    public void generateHash() {
        System.out.println("GENERATED_HASH=" + new BCryptPasswordEncoder().encode("admin123"));
    }
}
