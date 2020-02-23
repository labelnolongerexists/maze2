package org.whosyourdaddy.maze.config;

import org.springframework.context.annotation.Configuration;
import org.whosyourdaddy.maze.service.FakeMazeService;
import org.whosyourdaddy.maze.service.MazeService;

/**
 * User: Z J Wu Date: 2020/2/23 Time: 14:13 Package: org.whosyourdaddy.maze.config
 */
@Configuration
public class MazeConfig {

  MazeService mazeService() {
    return new FakeMazeService();
  }
}
