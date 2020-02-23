package org.whosyourdaddy.maze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * User: Z J Wu Date: 2020/2/23 Time: 13:54 Package: org.whosyourdaddy.maze
 */
@SpringBootApplication(scanBasePackages = "org.whosyourdaddy.maze")
public class MazeServer {

  public static void main(String[] args) {
    SpringApplication.run(MazeServer.class);
  }

}
