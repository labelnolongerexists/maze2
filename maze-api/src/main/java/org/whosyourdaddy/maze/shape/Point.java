package org.whosyourdaddy.maze.shape;

import java.util.Objects;

/**
 * User: Z J Wu Date: 2019-02-22 Time: 10:29 Package: com.com.qyer.dora.shape
 */
public final class Point {

  public final int row;
  public final int column;

  public Point(int row, int column) {
    this.row = row;
    this.column = column;
  }

  public static final Point of(int r, int c) {
    return new Point(r, c);
  }

  public static Point top(int r, int c) {
    return top(r, c, 1);
  }

  public static Point top(int r, int c, int step) {
    return new Point(r - step, c);
  }

  public static Point topRight(int r, int c) {
    return topRight(r, c, 1);
  }

  public static Point topRight(int r, int c, int step) {
    return new Point(r - step, c + step);
  }

  public static Point right(int r, int c) {
    return right(r, c, 1);
  }

  public static Point right(int r, int c, int step) {
    return new Point(r, c + step);
  }

  public static Point bottomRight(int r, int c) {
    return bottomRight(r, c, 1);
  }

  public static Point bottomRight(int r, int c, int step) {
    return new Point(r + step, c + step);
  }

  public static Point bottom(int r, int c) {
    return bottom(r, c, 1);
  }

  public static Point bottom(int r, int c, int step) {
    return new Point(r + step, c);
  }

  public static Point bottomLeft(int r, int c) {
    return bottomLeft(r, c, 1);
  }

  public static Point bottomLeft(int r, int c, int step) {
    return new Point(r + step, c - step);
  }

  public static Point left(int r, int c) {
    return left(r, c, 1);
  }

  public static Point left(int r, int c, int step) {
    return new Point(r, c - step);
  }

  public static Point topLeft(int r, int c) {
    return topLeft(r, c, 1);
  }

  public static Point topLeft(int r, int c, int step) {
    return new Point(r - step, c - step);
  }

  @Override
  public String toString() {
    return "(" + row + "," + column + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Point))
      return false;
    Point Point = (Point) o;
    return row == Point.row && column == Point.column;
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, column);
  }

}
