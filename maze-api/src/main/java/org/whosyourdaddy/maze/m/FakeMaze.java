package org.whosyourdaddy.maze.m;

import java.util.Random;

/**
 * User: Z J Wu Date: 2020/2/23 Time: 14:12 Package: org.whosyourdaddy.maze
 */
public class FakeMaze extends AbstractMaze{

  private static final Random RANDOM = new Random();

  public FakeMaze(int rowsColumns) {
    super(rowsColumns);
  }

  public FakeMaze(int rows, int columns) {
    super(rows, columns);
  }

  @Override
  public void generate() throws Exception {

  }
}
