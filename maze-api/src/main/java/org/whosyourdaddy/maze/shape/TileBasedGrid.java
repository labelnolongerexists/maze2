package org.whosyourdaddy.maze.shape;

import static org.whosyourdaddy.maze.Constants.ACCESSIBLE;
import static org.whosyourdaddy.maze.Constants.BLOCK;
import static org.whosyourdaddy.maze.Constants.B_ROOM;
import static org.whosyourdaddy.maze.Constants.G_WALL;
import static org.whosyourdaddy.maze.Constants.H_BLOCK;
import static org.whosyourdaddy.maze.Constants.H_WALL;
import static org.whosyourdaddy.maze.Constants.ROAD;
import static org.whosyourdaddy.maze.Constants.ROOM;
import static org.whosyourdaddy.maze.Constants.V_BLOCK;
import static org.whosyourdaddy.maze.Constants.V_WALL;
import static org.whosyourdaddy.maze.shape.Point.bottom;
import static org.whosyourdaddy.maze.shape.Point.bottomLeft;
import static org.whosyourdaddy.maze.shape.Point.bottomRight;
import static org.whosyourdaddy.maze.shape.Point.left;
import static org.whosyourdaddy.maze.shape.Point.right;
import static org.whosyourdaddy.maze.shape.Point.top;
import static org.whosyourdaddy.maze.shape.Point.topLeft;
import static org.whosyourdaddy.maze.shape.Point.topRight;

/**
 * User: Z J Wu Date: 2019-02-25 Time: 10:23 Package: com.qyer.dora.maze.generator
 */
public class TileBasedGrid {

  public static final Point DEFAULT_ENTRANCE = new Point(1, 0);

  public final int rows;
  public final int columns;

  public final byte[][] store;

  public TileBasedGrid(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.store = new byte[rows][columns];
  }

  public TileBasedGrid(int rowsColumns) {
    this(rowsColumns, rowsColumns);
  }

  public boolean isBorder(int r, int c) {
    return r <= firstRow() || r >= lastRow() || c <= firstColumn() || c >= lastColumn();
  }

  public boolean isBorder(Point p) {
    final int r = p.row, c = p.column;
    return r <= firstRow() || r >= lastRow() || c <= firstColumn() || c >= lastColumn();
  }

  public void border(byte border) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (i == 0 || i == rows - 1) {
          store[i][j] = border;
        } else if (j == 0 || j == columns - 1) {
          store[i][j] = border;
        }
      }
    }
  }

  public void fill(byte type, int rowFrom, int rowTo, int columnFrom, int columnTo) {
    for (int i = rowFrom; i < rowTo; i++) {
      for (int j = columnFrom; j < columnTo; j++) {
        store[i][j] = type;
      }
    }
  }

  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }

  public byte[][] getStore() {
    return store;
  }

  public int firstRow() {
    return 0;
  }

  public int firstColumn() {
    return 0;
  }

  public int lastRow() {
    return rows - 1;
  }

  public int lastColumn() {
    return columns - 1;
  }

  public boolean isBlocked(Point point) {
    return isBlocked(point.row, point.column);
  }

  public boolean isBlocked(int r, int c) {
    return isBlocked(getContent(r, c));
  }

  public boolean isBlocked(byte b) {
    return b != ACCESSIBLE;
  }

  public boolean isAccessible(Point point) {
    return isAccessible(point.row, point.column);
  }

  public boolean isAccessible(int r, int c) {
    return isAccessible(getContent(r, c));
  }

  public boolean isAccessible(byte b) {
    return b == ACCESSIBLE;
  }

  public boolean isRoom(Point point) {
    return isRoom(point.row, point.column);
  }

  public boolean isRoom(int r, int c) {
    return isRoom(getContent(r, c));
  }

  public boolean isRoom(byte b) {
    return b == B_ROOM;
  }

  public byte getContent(Point point) {
    return getContent(point.row, point.column);
  }

  public byte getContent(int r, int c) {
    return store[r][c];
  }

  public void defaultEntrance() {
    store[DEFAULT_ENTRANCE.row][DEFAULT_ENTRANCE.column] = ACCESSIBLE;
  }

  public void defaultExit() {
    store[rows - 2][columns - 1] = ACCESSIBLE;
  }

  public void setEntrance(Point entrance) {
    store[entrance.row][entrance.column] = ACCESSIBLE;
  }

  public void setExit(Point exit) {
    store[exit.row][exit.column] = ACCESSIBLE;
  }

  public void updateVal(Point p, byte v) {
    store[p.row][p.column] = v;
  }

  public void updateVal(int r, int c, byte v) {
    store[r][c] = v;
  }

  public void updateRowSegment(int r, int cFrom, int cTo, byte v) {
    for (int i = cFrom; i < cTo; i++) {
      updateVal(r, i, v);
    }
  }

  public void updateColSegment(int c, int rFrom, int rTo, byte v) {
    for (int i = rFrom; i < rTo; i++) {
      updateVal(i, c, v);
    }
  }

  public void updateSurrounded(int r, int c, byte b) {
    updateVal(top(r, c), b);
    updateVal(topRight(r, c), b);
    updateVal(right(r, c), b);
    updateVal(bottomRight(r, c), b);
    updateVal(bottom(r, c), b);
    updateVal(bottomLeft(r, c), b);
    updateVal(left(r, c), b);
    updateVal(topLeft(r, c), b);
  }

  public int surroundedAccessibleCnt(int r, int c) {
    return 8 - surroundedBlockCnt(r, c);
  }

  public int surroundedBlockCnt(int r, int c) {
    int cnt = 0;
    if (isBlocked(top(r, c))) {
      ++cnt;
    }
    if (isBlocked(topRight(r, c))) {
      ++cnt;
    }
    if (isBlocked(right(r, c))) {
      ++cnt;
    }
    if (isBlocked(bottomRight(r, c))) {
      ++cnt;
    }
    if (isBlocked(bottom(r, c))) {
      ++cnt;
    }
    if (isBlocked(bottomLeft(r, c))) {
      ++cnt;
    }
    if (isBlocked(left(r, c))) {
      ++cnt;
    }
    if (isBlocked(topLeft(r, c))) {
      ++cnt;
    }
    return cnt;
  }

  public String toPlainStr() {
    StringBuilder sb = new StringBuilder();
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        if (isAccessible(r, c)) {
          sb.append('0');
        } else if (isRoom(r, c)) {
          sb.append('r');
        } else {
          sb.append('1');
        }
      }
    }
    return sb.toString();
  }

  public static final void dump(TileBasedGrid grid) {
    for (int i = 0; i < grid.getRows(); i++) {
      for (int j = 0; j < grid.getColumns(); j++) {
        switch (grid.getContent(i, j)) {
          case ACCESSIBLE:
            System.out.print(ROAD);
            break;
          case BLOCK:
            System.out.print(G_WALL);
            break;
          case H_BLOCK:
            System.out.print(H_WALL);
            break;
          case V_BLOCK:
            System.out.print(V_WALL);
            break;
          case B_ROOM:
            System.out.print(ROOM);
            break;
        }
      }
      System.out.println();
    }
  }
}
