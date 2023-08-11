package com.example.hw3part1.web;

import com.example.hw3part1.entities.Book;
import com.example.hw3part1.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {
  @Autowired
  private BookService bookService;

  @RequestMapping(method = RequestMethod.GET)
  public String list(Model model, Authentication authentication) {
    model.addAttribute("books", bookService.findAllBooks());
    getAuthentication(model, authentication);
    return "list";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String show(@PathVariable("id") int id, Model model, Authentication authentication) {
    model.addAttribute("book", bookService.findBookById(id));
    getAuthentication(model, authentication);
    return "show";
  }

  @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
  public String updateForm(@PathVariable("id") int id, Model model, Authentication authentication) {
    model.addAttribute("book", bookService.findBookById(id));
    getAuthentication(model, authentication);
    return "edit";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public String update(@Valid Book book, BindingResult bindingResult, Model model,
      HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("message", "Error: all fields are required");
      return "edit";
    } else {
      model.asMap().clear();
      bookService.saveBook(book);
      redirectAttributes.addFlashAttribute("message", "Successfully updated book");
      return "redirect:/books/" + book.getId();
    }
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public String newForm(Model model, Authentication authentication) {
    getAuthentication(model, authentication);
    return "new";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String create(@Valid Book book, BindingResult bindingResult, Model model,
      HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("message", "Error: all fields are required");
      return "new";
    } else {
      model.asMap().clear();
      bookService.saveBook(book);
      redirectAttributes.addFlashAttribute("message", "Successfully added book");
      return "redirect:/books/" + book.getId();
    }
  }

  private void getAuthentication(Model model, Authentication authentication) {
    if (authentication != null && authentication.isAuthenticated()) {
      model.addAttribute("userRole", authentication.getAuthorities().toString());
    }
  }
}
