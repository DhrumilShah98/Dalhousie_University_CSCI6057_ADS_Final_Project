package blockchain.merkletree;

/**
 * {@code MerkleNode} class stores the hash and left and right pointers to
 * traverse left and right nodes of the Merkle tree.
 *
 * @author Dhrumil Amish Shah
 * @version 1.0.0
 */
public final class MerkleNode {

  // Pointer to the left node of a Merkle tree.
  private MerkleNode leftNode;

  // Pointer to the right node of a Merkle tree.
  private MerkleNode rightNode;

  // Hash value of the data or its children.
  private String hash;

  /**
   * Constructs this {@code MerkleNode}.
   *
   * @param leftNode  pointer to the left node of a merkle tree.
   * @param rightNode pointer to the right node of a merkle tree.
   * @param hash      hash value of the data or its children.
   */
  public MerkleNode(final MerkleNode leftNode,
                    final MerkleNode rightNode,
                    final String hash) {
    this.leftNode = leftNode;
    this.rightNode = rightNode;
    this.hash = hash;
  }

  /**
   * Gets the pointer to the left node of a merkle tree.
   *
   * @return pointer to the left node of a merkle tree.
   */
  public MerkleNode getLeftNode() {
    return leftNode;
  }

  /**
   * Sets the pointer to the left node of a merkle tree.
   *
   * @param leftNode pointer to the left node of a merkle tree.
   */
  public void setLeftNode(final MerkleNode leftNode) {
    this.leftNode = leftNode;
  }

  /**
   * Gets the pointer to the right node of a merkle tree.
   *
   * @return pointer to the right node of a merkle tree.
   */
  public MerkleNode getRightNode() {
    return rightNode;
  }

  /**
   * Sets the pointer to the right node of a merkle tree.
   *
   * @param rightNode pointer to the right node of a merkle tree.
   */
  public void setRightNode(final MerkleNode rightNode) {
    this.rightNode = rightNode;
  }

  /**
   * Gets the hash value of the data or its children.
   *
   * @return hash value of the data or its children.
   */
  public String getHash() {
    return hash;
  }

  /**
   * Sets the hash value of the data or its children.
   *
   * @param hash hash value of the data or its children.
   */
  public void setHash(final String hash) {
    this.hash = hash;
  }
}