package org.whosyourdaddy.maze.m;

/**
 * User: Z J Wu Date: 2020/2/23 Time: 14:08 Package: org.whosyourdaddy.maze.service
 */
public interface Maze {

  byte[] dump();

  void generate() throws Exception;
}
