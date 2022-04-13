package driver.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@code BlockIdsSearchHelper} class helps with generating unique block ids and creating a sequence of searches.
 * <p>
 * Block ids: 2 4 0 1 3
 * Block ids search sequence: 0 1 2 3 0 2 0 3 3 4 2 0 1 1 2 0 1
 * 100 Blocks:   34    98    86    82    71
 * 1000 Blocks:  342   989   863   821   719
 * 10000 Blocks: 3426  9899  8638  8211  7190
 * 100000 Blocks 34266 98999 86387 82115 71908
 *
 * @author Dhrumil Amish Shah
 * @version 1.0.0
 */
public final class BlockIdsSearchHelper {

  /**
   * Constructs this {@code BlockIdsSearchHelper}
   */
  private BlockIdsSearchHelper() {
    // Required private constructor
  }

  public static final List<Long> BLOCK_IDS = new ArrayList<>(Arrays.asList(
      System.nanoTime(),
      System.nanoTime(),
      System.nanoTime(),
      System.nanoTime(),
      System.nanoTime()
  ));

  public static final List<Long> BLOCK_IDS_SEARCH_SEQUENCE = new ArrayList<>(Arrays.asList(
      BLOCK_IDS.get(1),
      BLOCK_IDS.get(2),
      BLOCK_IDS.get(1),
      BLOCK_IDS.get(1),
      BLOCK_IDS.get(2),
      BLOCK_IDS.get(1)
  ));

  public static final List<Integer> IDS_LOCATION_IN_100_BLOCKS = new ArrayList<>(Arrays.asList(
      34,
      98,
      86,
      82,
      71
  ));

  public static final List<Integer> IDS_LOCATION_IN_1000_BLOCKS = new ArrayList<>(Arrays.asList(
      342,
      989,
      863,
      821,
      719
  ));

  public static final List<Integer> IDS_LOCATION_IN_10000_BLOCKS = new ArrayList<>(Arrays.asList(
      3426,
      9899,
      8638,
      8211,
      7190
  ));

  public static final List<Integer> IDS_LOCATION_IN_100000_BLOCKS = new ArrayList<>(Arrays.asList(
      34266,
      98999,
      86387,
      82115,
      71908
  ));
}