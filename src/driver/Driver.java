package driver;

import blockchain.block.Block;
import implementation.linkedlist.LinkedListBlockChain;
import implementation.splaytree.SplayTreeBlockChain;

import java.security.NoSuchAlgorithmException;

import static driver.util.BlockIdsSearchHelper.*;

/**
 * {@code Driver} class performs time analysis of linked list and splay tree implementations.
 *
 * @author Dhrumil Amish Shah
 * @version 1.0.0
 */
public class Driver {

  /**
   * Block chain with 100 blocks.
   *
   * @throws NoSuchAlgorithmException when hashing algorithm is not available in environment.
   */
  private static void blockChain100() throws NoSuchAlgorithmException {
    final LinkedListBlockChain ll = new LinkedListBlockChain();
    final SplayTreeBlockChain st = new SplayTreeBlockChain();
    for (int i = 0; i < 100; ++i) {
      Block llBlock;
      Block stBlock;
      switch (i) {
        case 34 -> {
          llBlock = new Block(BLOCK_IDS.get(0), null, null);
          stBlock = new Block(BLOCK_IDS.get(0), null, null);
        }
        case 98 -> {
          llBlock = new Block(BLOCK_IDS.get(1), null, null);
          stBlock = new Block(BLOCK_IDS.get(1), null, null);
        }
        case 86 -> {
          llBlock = new Block(BLOCK_IDS.get(2), null, null);
          stBlock = new Block(BLOCK_IDS.get(2), null, null);
        }
        case 82 -> {
          llBlock = new Block(BLOCK_IDS.get(3), null, null);
          stBlock = new Block(BLOCK_IDS.get(3), null, null);
        }
        case 71 -> {
          llBlock = new Block(BLOCK_IDS.get(4), null, null);
          stBlock = new Block(BLOCK_IDS.get(4), null, null);
        }
        default -> {
          final long blockID = System.nanoTime();
          llBlock = new Block(blockID, null, null);
          stBlock = new Block(blockID, null, null);
        }
      }
      ll.insert(llBlock);
      st.insert(stBlock);
    }

    final StringBuilder sb = new StringBuilder();
    sb.append("Block chain with 100 blocks").append("\n");
    sb.append(String.format("%-40s%-35s%-35s", "Block ID", "Linked List Search Time(ns)", "Splay Tree Search Time (ns)")).append("\n");
    for (final Long blockId : BLOCK_IDS_SEARCH_SEQUENCE) {
      // Linked List
      final long startTimeLL = System.nanoTime();
      ll.search(blockId);
      final long endTimeLL = System.nanoTime();
      final String searchTimeLL = (endTimeLL - startTimeLL) + " ns";

      // Splay Tree
      final long startTimeST = System.nanoTime();
      st.search(blockId);
      final long endTimeST = System.nanoTime();
      final String searchTimeST = (endTimeST - startTimeST) + " ns";
      sb.append(String.format("%-40s%-35s%-35s", blockId, searchTimeLL, searchTimeST)).append("\n");
    }
    sb.append("\n");
    System.out.println(sb.toString());
  }

  /**
   * Block chain with 1000 blocks.
   *
   * @throws NoSuchAlgorithmException when hashing algorithm is not available in environment.
   */
  private static void blockChain1000() throws NoSuchAlgorithmException {
    final LinkedListBlockChain ll = new LinkedListBlockChain();
    final SplayTreeBlockChain st = new SplayTreeBlockChain();
    for (int i = 0; i < 1000; ++i) {
      Block llBlock;
      Block stBlock;
      switch (i) {
        case 342 -> {
          llBlock = new Block(BLOCK_IDS.get(0), null, null);
          stBlock = new Block(BLOCK_IDS.get(0), null, null);
        }
        case 989 -> {
          llBlock = new Block(BLOCK_IDS.get(1), null, null);
          stBlock = new Block(BLOCK_IDS.get(1), null, null);
        }
        case 863 -> {
          llBlock = new Block(BLOCK_IDS.get(2), null, null);
          stBlock = new Block(BLOCK_IDS.get(2), null, null);
        }
        case 719 -> {
          llBlock = new Block(BLOCK_IDS.get(3), null, null);
          stBlock = new Block(BLOCK_IDS.get(3), null, null);
        }
        case 71 -> {
          llBlock = new Block(BLOCK_IDS.get(4), null, null);
          stBlock = new Block(BLOCK_IDS.get(4), null, null);
        }
        default -> {
          final long blockID = System.nanoTime();
          llBlock = new Block(blockID, null, null);
          stBlock = new Block(blockID, null, null);
        }
      }
      ll.insert(llBlock);
      st.insert(stBlock);
    }

    final StringBuilder sb = new StringBuilder();
    sb.append("Block chain with 1000 blocks").append("\n");
    sb.append(String.format("%-40s%-35s%-35s", "Block ID", "Linked List Search Time(ns)", "Splay Tree Search Time (ns)")).append("\n");
    for (final Long blockId : BLOCK_IDS_SEARCH_SEQUENCE) {
      // Linked List
      final long startTimeLL = System.nanoTime();
      ll.search(blockId);
      final long endTimeLL = System.nanoTime();
      final String searchTimeLL = (endTimeLL - startTimeLL) + " ns";

      // Splay Tree
      final long startTimeST = System.nanoTime();
      st.search(blockId);
      final long endTimeST = System.nanoTime();
      final String searchTimeST = (endTimeST - startTimeST) + " ns";
      sb.append(String.format("%-40s%-35s%-35s", blockId, searchTimeLL, searchTimeST)).append("\n");
    }
    sb.append("\n");
    System.out.println(sb.toString());
  }

  /**
   * Block chain with 10000 blocks.
   *
   * @throws NoSuchAlgorithmException when hashing algorithm is not available in environment.
   */
  private static void blockChain10000() throws NoSuchAlgorithmException {
    final LinkedListBlockChain ll = new LinkedListBlockChain();
    final SplayTreeBlockChain st = new SplayTreeBlockChain();
    for (int i = 0; i < 10000; ++i) {
      Block llBlock;
      Block stBlock;
      switch (i) {
        case 3426 -> {
          llBlock = new Block(BLOCK_IDS.get(0), null, null);
          stBlock = new Block(BLOCK_IDS.get(0), null, null);
        }
        case 9899 -> {
          llBlock = new Block(BLOCK_IDS.get(1), null, null);
          stBlock = new Block(BLOCK_IDS.get(1), null, null);
        }
        case 8638 -> {
          llBlock = new Block(BLOCK_IDS.get(2), null, null);
          stBlock = new Block(BLOCK_IDS.get(2), null, null);
        }
        case 8211 -> {
          llBlock = new Block(BLOCK_IDS.get(3), null, null);
          stBlock = new Block(BLOCK_IDS.get(3), null, null);
        }
        case 7190 -> {
          llBlock = new Block(BLOCK_IDS.get(4), null, null);
          stBlock = new Block(BLOCK_IDS.get(4), null, null);
        }
        default -> {
          final long blockID = System.nanoTime();
          llBlock = new Block(blockID, null, null);
          stBlock = new Block(blockID, null, null);
        }
      }
      ll.insert(llBlock);
      st.insert(stBlock);
    }

    final StringBuilder sb = new StringBuilder();
    sb.append("Block chain with 10000 blocks").append("\n");
    sb.append(String.format("%-40s%-35s%-35s", "Block ID", "Linked List Search Time(ns)", "Splay Tree Search Time (ns)")).append("\n");
    for (final Long blockId : BLOCK_IDS_SEARCH_SEQUENCE) {
      // Linked List
      final long startTimeLL = System.nanoTime();
      ll.search(blockId);
      final long endTimeLL = System.nanoTime();
      final String searchTimeLL = (endTimeLL - startTimeLL) + " ns";

      // Splay Tree
      final long startTimeST = System.nanoTime();
      st.search(blockId);
      final long endTimeST = System.nanoTime();
      final String searchTimeST = (endTimeST - startTimeST) + " ns";
      sb.append(String.format("%-40s%-35s%-35s", blockId, searchTimeLL, searchTimeST)).append("\n");
    }
    sb.append("\n");
    System.out.println(sb.toString());
  }

  /**
   * Block chain with 100000 blocks.
   *
   * @throws NoSuchAlgorithmException when hashing algorithm is not available in environment.
   */
  private static void blockChain100000() throws NoSuchAlgorithmException {
    final LinkedListBlockChain ll = new LinkedListBlockChain();
    final SplayTreeBlockChain st = new SplayTreeBlockChain();
    for (int i = 0; i < 100000; ++i) {
      Block llBlock;
      Block stBlock;
      switch (i) {
        case 34266 -> {
          llBlock = new Block(BLOCK_IDS.get(0), null, null);
          stBlock = new Block(BLOCK_IDS.get(0), null, null);
        }
        case 98998 -> {
          llBlock = new Block(BLOCK_IDS.get(1), null, null);
          stBlock = new Block(BLOCK_IDS.get(1), null, null);
        }
        case 86387 -> {
          llBlock = new Block(BLOCK_IDS.get(2), null, null);
          stBlock = new Block(BLOCK_IDS.get(2), null, null);
        }
        case 82115 -> {
          llBlock = new Block(BLOCK_IDS.get(3), null, null);
          stBlock = new Block(BLOCK_IDS.get(3), null, null);
        }
        case 71908 -> {
          llBlock = new Block(BLOCK_IDS.get(4), null, null);
          stBlock = new Block(BLOCK_IDS.get(4), null, null);
        }
        default -> {
          final long blockID = System.nanoTime();
          llBlock = new Block(blockID, null, null);
          stBlock = new Block(blockID, null, null);
        }
      }
      ll.insert(llBlock);
      st.insert(stBlock);
    }

    final StringBuilder sb = new StringBuilder();
    sb.append("Block chain with 100000 blocks").append("\n");
    sb.append(String.format("%-40s%-35s%-35s", "Block ID", "Linked List Search Time(ns)", "Splay Tree Search Time (ns)")).append("\n");
    for (final Long blockId : BLOCK_IDS_SEARCH_SEQUENCE) {
      // Linked List
      final long startTimeLL = System.nanoTime();
      ll.search(blockId);
      final long endTimeLL = System.nanoTime();
      final String searchTimeLL = (endTimeLL - startTimeLL) + " ns";

      // Splay Tree
      final long startTimeST = System.nanoTime();
      st.search(blockId);
      final long endTimeST = System.nanoTime();
      final String searchTimeST = (endTimeST - startTimeST) + " ns";
      sb.append(String.format("%-40s%-35s%-35s", blockId, searchTimeLL, searchTimeST)).append("\n");
    }
    sb.append("\n");
    System.out.println(sb.toString());
  }

  public static void main(String[] args) throws NoSuchAlgorithmException {
    blockChain100();
    blockChain1000();
    blockChain10000();
    blockChain100000();
  }
}