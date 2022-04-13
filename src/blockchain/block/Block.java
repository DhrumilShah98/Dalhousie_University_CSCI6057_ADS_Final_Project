package blockchain.block;

import blockchain.merkletree.MerkleNode;
import blockchain.merkletree.MerkleTree;
import blockchain.transaction.Transaction;
import blockchain.util.HashAlgorithmUtil;

import java.util.List;
import java.util.Objects;
import java.security.NoSuchAlgorithmException;

/**
 * {@code Block} class stores the block of blockchain.
 *
 * @author Dhrumil Amish Shah
 * @version 1.0.0
 */
public final class Block implements Comparable<Block> {
  // Unique block id.
  private final long blockId;

  // Unique block hash.
  private final String blockHash;

  // Previous block hash.
  private final String preBlockHash;

  // Timestamp of block creation.
  private final long timeStamp;

  // Left block link
  private Block leftBlock;

  // Right block link
  private Block rightBlock;

  // Parent block link
  private Block parentBlock;

  // Merkle root.
  private final MerkleNode merkleRoot;

  // List of transactions.
  private final List<Transaction> transactions;

  /**
   * Constructs this {@code Block}.
   *
   * @param preBlockHash previous block hash.
   * @param transactions list of transactions.
   *
   * @throws NoSuchAlgorithmException if hashing algorithm is not available.
   */
  public Block(final String preBlockHash,
               final List<Transaction> transactions) throws NoSuchAlgorithmException {
    this.blockId = System.nanoTime();
    this.blockHash = HashAlgorithmUtil.getSHA256Hash(String.valueOf(this.blockId));
    this.preBlockHash = preBlockHash;
    this.timeStamp = System.nanoTime();
    this.leftBlock = null;
    this.rightBlock = null;
    this.parentBlock = null;
    this.merkleRoot = new MerkleTree().createMerkleTree(transactions);
    this.transactions = transactions;
  }

  /**
   * Constructs this {@code Block}.
   *
   * @param blockId      unique block id.
   * @param preBlockHash previous block hash.
   * @param transactions list of transactions.
   *
   * @throws NoSuchAlgorithmException if hashing algorithm is not available.
   */
  public Block(final long blockId,
               final String preBlockHash,
               final List<Transaction> transactions) throws NoSuchAlgorithmException {
    this.blockId = blockId;
    this.blockHash = HashAlgorithmUtil.getSHA256Hash(String.valueOf(this.blockId));
    this.preBlockHash = preBlockHash;
    this.timeStamp = System.nanoTime();
    this.leftBlock = null;
    this.rightBlock = null;
    this.parentBlock = null;
    this.merkleRoot = new MerkleTree().createMerkleTree(transactions);
    this.transactions = transactions;
  }

  /**
   * Gets the unique id of the block.
   *
   * @return unique id of the block.
   */
  public long getBlockId() {
    return blockId;
  }

  /**
   * Gets the unique hash of the block.
   *
   * @return unique hash of the block.
   */
  public String getBlockHash() {
    return blockHash;
  }

  /**
   * Gets the previous block hash.
   *
   * @return previous block hash.
   */
  public String getPreBlockHash() {
    return preBlockHash;
  }

  /**
   * Gets the timestamp of block creation.
   *
   * @return timestamp of block creation.
   */
  public long getTimeStamp() {
    return timeStamp;
  }

  /**
   * Gets the left block link.
   *
   * @return left block link.
   */
  public Block getLeftBlock() {
    return leftBlock;
  }

  /**
   * Sets the left block link.
   *
   * @param leftBlock left block link.
   */
  public void setLeftBlock(final Block leftBlock) {
    this.leftBlock = leftBlock;
  }

  /**
   * Gets the right block link.
   *
   * @return right block link.
   */
  public Block getRightBlock() {
    return rightBlock;
  }

  /**
   * Sets the right block link.
   *
   * @param rightBlock left block link.
   */
  public void setRightBlock(final Block rightBlock) {
    this.rightBlock = rightBlock;
  }

  /**
   * Gets the parent block link.
   *
   * @return parent block link.
   */
  public Block getParentBlock() {
    return parentBlock;
  }

  /**
   * Sets the parent block link.
   *
   * @param parentBlock parent block link.
   */
  public void setParentBlock(Block parentBlock) {
    this.parentBlock = parentBlock;
  }

  /**
   * Gets the list of transactions.
   *
   * @return list of transactions.
   */
  public List<Transaction> getTransactions() {
    return transactions;
  }

  /**
   * Gets the merkle root.
   *
   * @return merkle root.
   */
  public MerkleNode getMerkleRoot() {
    return merkleRoot;
  }

  @Override
  public int compareTo(Block b) {
    return (int) (this.getBlockId() - b.getBlockId());
  }

  /**
   * Compares two blocks to check whether they are same or not.
   *
   * @param b other block
   *
   * @return true if both blocks are same otherwise  false.
   */
  @Override
  public boolean equals(Object b) {
    if (this == b)
      return true;
    if (b == null || getClass() != b.getClass())
      return false;
    Block block = (Block) b;
    return (blockId == block.blockId);
  }

  /**
   * Gets the hash code.
   *
   * @return hash code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(blockId);
  }
}