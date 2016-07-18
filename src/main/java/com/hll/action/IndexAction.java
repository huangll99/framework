package com.hll.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hll on 2016/7/18.
 */
@Controller
public class IndexAction {

  @RequestMapping("/")
  public String index(){
    return "index";
  }
}
