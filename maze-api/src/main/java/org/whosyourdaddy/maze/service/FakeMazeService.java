package org.whosyourdaddy.maze.service;

import org.springframework.stereotype.Service;
import org.whosyourdaddy.maze.FakeMaze;
import org.whosyourdaddy.maze.Maze;

/**
 * User: Z J Wu Date: 2020/2/23 Time: 14:13 Package: org.whosyourdaddy.maze.service
 */
@Service
public class FakeMazeService implements MazeService {

  public Maze createMaze(int length, int height) {
    return new FakeMaze(length, height);
  }
}
