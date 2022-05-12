package com.circleci.heapdumpr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

class Dumpr extends Thread {
  public void run() {
      int i = 0;
      while (true) {
          System.out.println(this.getName() + ": New Thread is running..." + i++);
          try {
              byte[] mem = new byte[1000000000];
              Thread.sleep(10);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }
}

@Controller
public class HeapdumprController {

  @GetMapping("/heap-dump")
  @ResponseBody
  public String dumpHeap(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
    Dumpr dumpr = new Dumpr();
    dumpr.start();
    return "Enjoy your heap dump";
  }

}