package org.whosyourdaddy.maze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.whosyourdaddy.maze.Maze;
import org.whosyourdaddy.maze.service.MazeService;

/**
 * User: Z J Wu Date: 2020/2/23 Time: 13:54 Package: org.whosyourdaddy.maze.controller
 */
@RestController
public class MazeController {

  @Autowired
  private MazeService mazeService;

  @RequestMapping("/")
  String createNewMaze() {
    Maze maze = mazeService.createMaze(10, 20);
    StringBuilder sb = new StringBuilder();
    for (byte b : maze.dump()) {
      sb.append(b);
    }
    return sb.toString();
  }

}
