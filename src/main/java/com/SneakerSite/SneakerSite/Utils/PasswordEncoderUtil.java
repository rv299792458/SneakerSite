package com.SneakerSite.SneakerSite.Utils;

import org.mindrot.jbcrypt.BCrypt;
import java.security.SecureRandom;
import java.util.Objects;

public class PasswordEncoderUtil {

    private final int STRENGTH = 10; // Work factor (strength) of the bcrypt algorithm
    private final SecureRandom secureRandom = new SecureRandom();

    private String encSalt;

    public void setEncSalt(String encSalt) {
        this.encSalt = encSalt;
    }

    public String getEncSalt() {
        return encSalt;
    }

    public  String encodePassword(String password) {
        if(Objects.isNull(encSalt) || encSalt.isBlank() || encSalt.isEmpty() )
        {
            encSalt = BCrypt.gensalt(STRENGTH, secureRandom);
        }
        return BCrypt.hashpw(password, encSalt);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword, encodedPassword);
    }

}
