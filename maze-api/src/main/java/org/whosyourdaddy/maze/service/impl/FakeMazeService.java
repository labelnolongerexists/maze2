package org.whosyourdaddy.maze.service.impl;

import org.springframework.stereotype.Service;
import org.whosyourdaddy.maze.m.FakeMaze;
import org.whosyourdaddy.maze.m.Maze;
import org.whosyourdaddy.maze.service.MazeService;

/**
 * User: Z J Wu Date: 2020/2/23 Time: 14:13 Package: org.whosyourdaddy.maze.service
 */
@Service
public class FakeMazeService implements MazeService {

  public Maze createMaze(int length, int height) {
    return new FakeMaze(length, height);
  }
}
