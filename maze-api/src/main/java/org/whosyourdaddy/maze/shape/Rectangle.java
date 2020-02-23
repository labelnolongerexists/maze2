package org.whosyourdaddy.maze.shape;

import static org.whosyourdaddy.maze.Utils.between;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import org.whosyourdaddy.maze.Utils;

import java.util.List;

/**
 * User: Z J Wu Date: 2019-03-01 Time: 11:35 Package: com.qyer.dora.shape
 */
public class Rectangle {

  private Point point;
  private int pointRow;
  private int pointCol;

  private int rows;
  private int columns;

  private int width;
  private int height;

  public Rectangle(Point leftTopPoint, int width, int height) {
    this(leftTopPoint.row, leftTopPoint.column, height, width);
  }

  public Rectangle(int leftTopRow, int leftTopCol, int rows, int columns) {
    this.point = Point.of(leftTopRow, leftTopCol);
    this.pointRow = leftTopRow;
    this.pointCol = leftTopCol;
    this.width = columns;
    this.height = rows;
    this.columns = columns;
    this.rows = rows;
  }

  public Point getLeftTop() {
    return this.point;
  }

  public Point getRightTop() {
    return Point.right(pointRow, pointCol, width);
  }

  public Point getLeftBottom() {
    return Point.bottom(pointRow, pointCol, height);
  }

  public Point getRightBottom() {
    return Point.of(pointRow + rows, pointCol + columns);
  }

  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Point getPoint() {
    return point;
  }

  public int getPointRow() {
    return pointRow;
  }

  public int getPointCol() {
    return pointCol;
  }

  public boolean in(Point p) {
    return Utils.between(p.row, pointRow, pointRow + rows) && between(p.column, pointCol,
                                                                      pointCol + columns);
  }

  public boolean onBorder(Point p) {
    return false;
  }

  public List<Segment> border() {
    List<Segment> list = Lists.newArrayListWithCapacity(4);
    list.add(new Segment(getLeftTop(), getRightTop()));
    list.add(new Segment(getRightTop(), getRightBottom()));
    list.add(new Segment(getLeftTop(), getLeftBottom()));
    list.add(new Segment(getLeftBottom(), getRightBottom()));
    return list;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("point", point).add("pointRow", pointRow)
                      .add("pointCol", pointCol).add("rows", rows).add("columns", columns)
                      .add("width", width).add("height", height).toString();
  }
}
