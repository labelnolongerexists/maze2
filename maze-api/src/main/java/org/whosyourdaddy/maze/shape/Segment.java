package org.whosyourdaddy.maze.shape;

import com.google.common.base.MoreObjects;

/**
 * 线段
 */
public class Segment {

  public final Point from;
  public final Point to;

  public Segment(Point from, Point to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("from", from).add("to", to).toString();
  }
}
