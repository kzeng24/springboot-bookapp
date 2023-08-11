package com.example.hw3part1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class RedirectController {
  @RequestMapping(method = RequestMethod.GET)
  public String redirect() {
    return "redirect:/books";
  }
}
