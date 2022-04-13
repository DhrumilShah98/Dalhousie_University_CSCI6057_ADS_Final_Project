package implementation.splaytree;

import blockchain.block.Block;

/**
 * {@code SplayTreeBlockChain} class is the splay tree implementation of the the blocks in the blockchain.
 *
 * @author Dhrumil Amish Shah
 * @version 1.0.0
 */
public final class SplayTreeBlockChain {
  private Block rootBlock;

  /**
   * Constructs this {@code SplayTreeBlockChain}.
   */
  public SplayTreeBlockChain() {
    this.rootBlock = null;
  }

  /**
   * Performs left rotation for the current block.
   *
   * @param block current block.
   */
  private void leftRotate(final Block block) {
    final Block temp = block.getRightBlock();
    block.setRightBlock(temp.getLeftBlock());
    if (temp.getLeftBlock() != null) {
      temp.getLeftBlock().setParentBlock(block);
    }
    temp.setParentBlock(block.getParentBlock());
    if (block.getParentBlock() == null) {
      rootBlock = temp;
    } else if (block == block.getParentBlock().getLeftBlock()) {
      block.getParentBlock().setLeftBlock(temp);
    } else {
      block.getParentBlock().setRightBlock(temp);
    }
    temp.setLeftBlock(block);
    block.setParentBlock(temp);
  }

  /**
   * Performs right rotation for the current block.
   *
   * @param block current block.
   */
  private void rightRotate(final Block block) {
    final Block temp = block.getLeftBlock();
    block.setLeftBlock(temp.getRightBlock());
    if (temp.getRightBlock() != null) {
      temp.getRightBlock().setParentBlock(block);
    }
    temp.setParentBlock(block.getParentBlock());
    if (block.getParentBlock() == null) {
      rootBlock = temp;
    } else if (block == block.getParentBlock().getRightBlock()) {
      block.getParentBlock().setRightBlock(temp);
    } else {
      block.getParentBlock().setLeftBlock(temp);
    }
    temp.setRightBlock(block);
    block.setParentBlock(temp);
  }

  /**
   * Performs splaying of this tree.
   *
   * @param block current block.
   */
  private void splay(final Block block) {
    while (block.getParentBlock() != null) {
      if (block.getParentBlock().getParentBlock() == null) {
        if (block == block.getParentBlock().getLeftBlock()) {
          // zig rotation
          rightRotate(block.getParentBlock());
        } else {
          // zag rotation
          leftRotate(block.getParentBlock());
        }
      } else if (block == block.getParentBlock().getLeftBlock() && block.getParentBlock() == block.getParentBlock().getParentBlock().getLeftBlock()) {
        // zig-zig rotation
        rightRotate(block.getParentBlock().getParentBlock());
        rightRotate(block.getParentBlock());
      } else if (block == block.getParentBlock().getRightBlock() && block.getParentBlock() == block.getParentBlock().getParentBlock().getRightBlock()) {
        // zag-zag rotation
        leftRotate(block.getParentBlock().getParentBlock());
        leftRotate(block.getParentBlock());
      } else if (block == block.getParentBlock().getRightBlock() && block.getParentBlock() == block.getParentBlock().getParentBlock().getLeftBlock()) {
        // zig-zag rotation
        leftRotate(block.getParentBlock());
        rightRotate(block.getParentBlock());
      } else {
        // zag-zig rotation
        rightRotate(block.getParentBlock());
        leftRotate(block.getParentBlock());
      }
    }
  }

  /**
   * Inserts the block.
   *
   * @param block block to be inserted.
   */
  public void insert(final Block block) {
    Block temp = null;
    Block temp1 = rootBlock;

    while (temp1 != null) {
      temp = temp1;
      if (block.getBlockId() < temp1.getBlockId()) {
        temp1 = temp1.getLeftBlock();
      } else {
        temp1 = temp1.getRightBlock();
      }
    }

    block.setParentBlock(temp);
    if (temp == null) {
      rootBlock = block;
    } else if (block.getBlockId() < temp.getBlockId()) {
      temp.setLeftBlock(block);
    } else {
      temp.setRightBlock(block);
    }

    // splay node
    splay(block);
  }

  /**
   * Searches the block.
   *
   * @param block   current block.
   * @param blockId block id to be searched.
   *
   * @return block found.
   */
  private Block search(final Block block, final long blockId) {
    if (block == null) {
      return null;
    } else if (blockId < block.getBlockId())
      return this.search(block.getLeftBlock(), blockId);
    else if (blockId > block.getBlockId())
      return this.search(block.getRightBlock(), blockId);
    else {
      this.splay(block);
      return block;
    }
  }

  /**
   * Searches the block.
   *
   * @param blockId block id to be searched.
   *
   * @return block found.
   */
  public Block search(final long blockId) {
    return search(this.rootBlock, blockId);
  }
}