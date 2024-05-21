package com.SneakerSite.SneakerSite.Utils;

import java.util.Random;

public class RandomStringGenerated {

    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String randomString(int size) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(size);

        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            char randomChar = ALLOWED_CHARACTERS.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

}
