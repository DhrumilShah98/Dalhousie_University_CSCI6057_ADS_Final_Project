package blockchain.transaction;

import blockchain.merkletree.MerkleNode;
import blockchain.util.HashAlgorithmUtil;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * {@code Transaction} class is a model class that holds a transaction.
 *
 * @author Dhrumil Amish Shah
 * @version 1.0.0
 */
public final class Transaction {

  // Unique transaction id.
  private final String transactionID;

  // Timestamp of transaction creation.
  private final long timeStamp;

  // Transaction content.
  private final String transactionContent;

  // Transaction hash.
  private final String transactionHash;

  // Pointer to the merkle node.
  private MerkleNode merkleNode;

  /**
   * Constructs this {@code Transaction}.
   *
   * @param transactionContent Transaction content.
   */
  public Transaction(final String transactionContent) throws NoSuchAlgorithmException {
    this.transactionID = UUID.randomUUID().toString();
    this.timeStamp = System.nanoTime();
    this.transactionContent = transactionContent;
    this.transactionHash = HashAlgorithmUtil.getSHA256Hash(this.transactionContent);
    this.merkleNode = null;
  }

  /**
   * Gets this blockchain.transaction id.
   *
   * @return blockchain.transaction id.
   */
  public String getTransactionID() {
    return transactionID;
  }

  /**
   * Gets this blockchain.transaction timestamp of creation.
   *
   * @return timestamp of blockchain.transaction creation.
   */
  public long getTimeStamp() {
    return timeStamp;
  }

  /**
   * Gets this blockchain.transaction content.
   *
   * @return blockchain.transaction content.
   */
  public String getTransactionContent() {
    return transactionContent;
  }

  /**
   * Gets this blockchain.transaction hash.
   *
   * @return blockchain.transaction hash.
   */
  public String getTransactionHash() {
    return transactionHash;
  }

  /**
   * Gets the pointer to the merkle node.
   *
   * @return pointer to the merkle node.
   */
  public MerkleNode getMerkleNode() {
    return merkleNode;
  }

  /**
   * Sets the pointer to the merkle node.
   *
   * @param merkleNode pointer to the merkle node.
   */
  public void setMerkleNode(final MerkleNode merkleNode) {
    this.merkleNode = merkleNode;
  }
}