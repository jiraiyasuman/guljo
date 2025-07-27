package com.guljo.guljo.util;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrongPasswordGenerator {
	private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_+=<>?";

    private static final String ALL_CHARS = LOWERCASE + UPPERCASE + DIGITS + SPECIAL;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateStrongPassword() {
        int length = 12;

        List<Character> password = new ArrayList<>();

        // Ensure at least one character from each category
        password.add(getRandomChar(LOWERCASE));
        password.add(getRandomChar(UPPERCASE));
        password.add(getRandomChar(DIGITS));
        password.add(getRandomChar(SPECIAL));

        // Fill the remaining characters
        for (int i = 4; i < length; i++) {
            password.add(getRandomChar(ALL_CHARS));
        }

        // Shuffle to prevent fixed order
        Collections.shuffle(password, RANDOM);

        // Convert to String
        StringBuilder sb = new StringBuilder();
        for (char c : password) {
            sb.append(c);
        }

        return sb.toString();
    }

    private static char getRandomChar(String input) {
        return input.charAt(RANDOM.nextInt(input.length()));
    }
}
