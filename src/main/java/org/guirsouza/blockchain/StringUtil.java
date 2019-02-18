package org.guirsouza.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class StringUtil {

  public static String applySha256(String input) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      //Applies sha256 to our input,
      byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
      StringBuilder hexString = new StringBuilder();
      for (byte hash1 : hash) {
        String hex = Integer.toHexString(0xff & hash1);
        if (hex.length() == 1)
          hexString.append('0');
        hexString.append(hex);
      }
      return hexString.toString();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
