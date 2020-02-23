package org.whosyourdaddy.maze.m;

import static org.whosyourdaddy.maze.Constants.ACCESSIBLE;
import static org.whosyourdaddy.maze.Constants.BLOCK;

import org.whosyourdaddy.maze.shape.TileBasedGrid;

/**
 * User: Z J Wu Date: 2020/2/23 Time: 22:03 Package: org.whosyourdaddy.maze.m
 */
public abstract class AbstractMaze implements Maze {

  public final TileBasedGrid grid;

  public AbstractMaze(int rowsColumns) {
    this(rowsColumns, rowsColumns);
  }

  public AbstractMaze(int rows, int columns) {
    this.grid = new TileBasedGrid(rows, columns);
    grid.border(BLOCK);
    grid.fill(ACCESSIBLE, 1, rows - 1, 1, columns - 1);
  }

  @Override
  public byte[] dump() {
    byte[] byteData = new byte[grid.rows * grid.columns];
    int pos = 0;
    for (byte[] row : grid.store) {
      final int len = row.length;
      System.arraycopy(row, 0, byteData, pos, row.length);
      pos += len;
    }
    return byteData;
  }
}
