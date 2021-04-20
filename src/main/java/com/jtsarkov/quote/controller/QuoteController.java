package com.jtsarkov.quote.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jtsarkov.quote.model.QuoteInputModel;
import com.jtsarkov.quote.service.QuoteService;

@RestController
public class QuoteController {

  private final QuoteService quoteService;

  public QuoteController(QuoteService quoteService) {
    this.quoteService = quoteService;
  }

  @PostMapping(value = "/quotes/add")
  public void addQuote(@RequestBody QuoteInputModel data) {
    quoteService.processQuote(data.getIsin(), data.getBid(), data.getAsk());
  }

  @GetMapping(value = "/quotes/{isin}")
  public Double getQuote(@PathVariable("isin") String isin) {
    return quoteService.getElvlByIsin(isin);
  }
}
