package org.whosyourdaddy.maze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.whosyourdaddy.maze.m.Maze;
import org.whosyourdaddy.maze.service.MazeService;

/**
 * User: Z J Wu Date: 2020/2/23 Time: 13:54 Package: org.whosyourdaddy.maze.controller
 */
@Controller
public class MazeController {

  @Autowired
  private MazeService mazeService;

  @RequestMapping("/maze")
  String createNewMaze(Model model) {
    Maze maze = mazeService.createMaze(10, 20);
    StringBuilder sb = new StringBuilder();
    for (byte b : maze.dump()) {
      sb.append(b);
    }
    model.addAttribute("mazeData", sb.toString());
    return "maze";
  }

}
