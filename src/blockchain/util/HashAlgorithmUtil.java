package blockchain.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * {@code HashAlgorithmUtil} class provides utility to generate hash from the content provided.
 *
 * @author Dhrumil Amish Shah
 * @version 1.0.0
 */
public final class HashAlgorithmUtil {

  /**
   * Private constructor to prevent the instantiation of {@code HashAlgorithmUtil} class.
   */
  private HashAlgorithmUtil() {
    // Required empty constructor.
  }

  /**
   * Gets the SHA-256 of {@code content} provided.
   *
   * @param content content to be hashed using SHA-256 algorithm.
   *
   * @return SHA-256 hash of the {@code content} provided.
   *
   * @throws NoSuchAlgorithmException if hashing algorithm (i.e., SHA-256) is not available in this environment.
   */
  public static String getSHA256Hash(final String content) throws NoSuchAlgorithmException {
    if (content == null) {
      return null;
    }
    final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    return String.format("%064x", new BigInteger(1, messageDigest.digest(content.getBytes(StandardCharsets.UTF_8))));
  }
}