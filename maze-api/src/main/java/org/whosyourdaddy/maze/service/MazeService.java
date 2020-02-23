package org.whosyourdaddy.maze.service;

import org.whosyourdaddy.maze.m.Maze;

/**
 * User: Z J Wu Date: 2020/2/23 Time: 14:08 Package: org.whosyourdaddy.maze.service
 */
public interface MazeService {

  Maze createMaze(int length, int height);
}
