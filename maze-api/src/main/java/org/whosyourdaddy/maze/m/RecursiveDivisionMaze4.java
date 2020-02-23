package org.whosyourdaddy.maze.m;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * User: Z J Wu Date: 2020/2/23 Time: 22:05 Package: org.whosyourdaddy.maze.m
 * <p>
 * 递归分割 - 直线分割线, 4房间
 */
public class RecursiveDivisionMaze4 extends AbstractMaze {

  private final int MIN = 2;

  private static final int WALL_LEFT = 0;
  private static final int WALL_TOP = 1;
  private static final int WALL_RIGHT = 2;
  private static final int WALL_BOTTOM = 3;
  private static List<Integer> WALLS = Lists
    .newArrayList(WALL_LEFT, WALL_TOP, WALL_RIGHT, WALL_BOTTOM);

  public RecursiveDivisionMaze4(int rowsColumns) {
    super(rowsColumns);
  }

  public RecursiveDivisionMaze4(int rows, int columns) {
    super(rows, columns);
  }

  @Override
  public void generate() throws Exception {

  }

  public static void main(String[] args) {
    Maze maze = new RecursiveDivisionMaze4(10);
    System.out.println(Arrays.toString(maze.dump()));
  }
}
