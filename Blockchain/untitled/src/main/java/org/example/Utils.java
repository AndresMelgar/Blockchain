package org.example;

import java.security.MessageDigest;

public class Utils {
    public static String calculateHash(Block block) {
        String input = block.getPreviousHash() + block.getData() + block.getTimestamp();
        return encodeToSHA256(input);
    }

    private static String encodeToSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(input.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : bytes) {
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
