package org.whosyourdaddy.maze;

import org.apache.commons.collections4.CollectionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * User: Z J Wu Date: 2019-02-22 Time: 10:58 Package: com.qyer.dora.maze
 */
public class Utils {

  public static boolean between(int t, int x, int y) {
    return (t >= x) && (t <= y);
  }

  public static final int closedRandom(int fromClosed, int toClosed) {
    if (fromClosed > toClosed) {
      return fromClosed;
    }
    return Constants.RANDOM.nextInt(toClosed + 1 - fromClosed) + fromClosed;
  }

  public static final <T> T selectOne(List<T> list) {
    if (CollectionUtils.isEmpty(list)) {
      return null;
    }
    int idx = Constants.RANDOM.nextInt(list.size());
    return list.get(idx);
  }

  public static final void printFileContentInClassPath(String filePath) {
    try (BufferedReader br = new BufferedReader(
      new InputStreamReader(Utils.class.getClassLoader().getResourceAsStream(filePath)))) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static boolean generateBooleanProbability(int percentOfTrue) {
    if (percentOfTrue <= 0) {
      return false;
    }
    if (percentOfTrue >= 100) {
      return true;
    }
    return Constants.RANDOM.nextInt(100) < percentOfTrue;
  }



}
