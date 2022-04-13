package implementation.linkedlist;

import blockchain.block.Block;

/**
 * {@code LinkedListBlockChain} class is the linked list implementation of the the blocks in the blockchain.
 *
 * @author Dhrumil Amish Shah
 * @version 1.0.0
 */
public final class LinkedListBlockChain {
  private Block rootBlock;

  /**
   * Constructs this {@code LinkedListBlockChain}.
   */
  public LinkedListBlockChain() {
    this.rootBlock = null;
  }

  /**
   * Inserts the block.
   *
   * @param block block to be inserted.
   */
  public void insert(final Block block) {
    if (rootBlock == null) {
      rootBlock = block;
      return;
    }
    Block tempBlock = rootBlock;
    while (tempBlock.getRightBlock() != null) {
      tempBlock = tempBlock.getRightBlock();
    }
    tempBlock.setRightBlock(block);
  }

  /**
   * Searches the block.
   *
   * @param blockId block id to be searched.
   *
   * @return block found.
   */
  public Block search(final long blockId) {
    Block tempBlock = rootBlock;
    while (tempBlock != null) {
      if (tempBlock.getBlockId() == blockId) {
        return tempBlock;
      }
      tempBlock = tempBlock.getRightBlock();
    }
    return null;
  }
}