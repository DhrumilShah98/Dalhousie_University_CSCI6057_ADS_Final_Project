package blockchain.merkletree;

import blockchain.transaction.Transaction;
import blockchain.util.HashAlgorithmUtil;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * {@code MerkleTree} class creates a merkle tree from a list of transactions.
 *
 * @author Dhrumil Amish Shah
 * @version 1.0.0
 */
public final class MerkleTree {

  private static final String EMPTY_STRING = "";

  /**
   * Creates/Generates a merkle tree for a list of transactions.
   *
   * @param transactions list of transactions.
   *
   * @return root node of the Merkle Tree.
   *
   * @throws NoSuchAlgorithmException if hashing algorithm is not available.
   */
  public MerkleNode createMerkleTree(final List<Transaction> transactions) throws NoSuchAlgorithmException {
    if (transactions == null) {
      return null;
    }
    final List<MerkleNode> merkleLeafNodes = new ArrayList<>();
    for (final Transaction t : transactions) {
      final MerkleNode m = new MerkleNode(null, null, HashAlgorithmUtil.getSHA256Hash(t.getTransactionContent()));
      merkleLeafNodes.add(m);
      t.setMerkleNode(m);
    }
    return buildTree(merkleLeafNodes);
  }

  /**
   * Builds a merkle tree from merkel leaf nodes.
   *
   * @param children merkel leaf nodes.
   *
   * @return merkle root node.
   *
   * @throws NoSuchAlgorithmException if hashing algorithm is not available.
   */
  private MerkleNode buildTree(List<MerkleNode> children) throws NoSuchAlgorithmException {
    ArrayList<MerkleNode> parents = new ArrayList<>();
    while (children.size() != 1) {
      int currentIndex = 0;
      int totalChildren = children.size();
      while (currentIndex < totalChildren) {
        final MerkleNode leftMerkleNode = children.get(currentIndex);
        MerkleNode rightMerkleNode;

        if ((currentIndex + 1) < totalChildren) {
          rightMerkleNode = children.get(currentIndex + 1);
        } else {
          rightMerkleNode = new MerkleNode(null, null, leftMerkleNode.getHash());
        }

        String parentHash = HashAlgorithmUtil.getSHA256Hash(leftMerkleNode.getHash() + rightMerkleNode.getHash());
        parents.add(new MerkleNode(leftMerkleNode, rightMerkleNode, parentHash));
        currentIndex += 2;
      }
      children = parents;
      parents = new ArrayList<>();
    }
    return children.get(0); // Root node of the merkle tree.
  }

  /**
   * Print the leaves of merkle tree.
   *
   * @param root merkle tree root node.
   *
   * @return leaves of merkle tree.
   */
  public String printMerkleTreeLeaves(final MerkleNode root) {
    if (root == null) {
      return EMPTY_STRING;
    }

    final Queue<MerkleNode> nodes = new LinkedList<>();
    nodes.add(root);

    final StringBuilder leaves = new StringBuilder();
    while (!nodes.isEmpty()) {
      final MerkleNode currentNode = nodes.poll();
      if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
        leaves.append(currentNode.getHash()).append("\n\n");
      }
      if (currentNode.getLeftNode() != null) {
        nodes.add(currentNode.getLeftNode());
      }
      if (currentNode.getRightNode() != null) {
        nodes.add(currentNode.getRightNode());
      }
    }

    return leaves.toString();
  }
}