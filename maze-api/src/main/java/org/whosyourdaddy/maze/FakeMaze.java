package org.whosyourdaddy.maze;

import java.util.Random;

/**
 * User: Z J Wu Date: 2020/2/23 Time: 14:12 Package: org.whosyourdaddy.maze
 */
public class FakeMaze implements Maze {

  private static final Random RANDOM = new Random();

  public final int length;
  public final int height;

  public FakeMaze(int length, int height) {
    this.length = length;
    this.height = height;
  }

  public byte[] dump() {
    byte[] data = new byte[length * height];
    for (int i = 0; i < length * height; i++) {
      data[i] = (byte) (RANDOM.nextBoolean() ? 0 : 1);
    }
    return data;
  }
}
