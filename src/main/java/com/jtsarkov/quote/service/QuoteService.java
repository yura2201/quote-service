package com.jtsarkov.quote.service;

import org.springframework.scheduling.annotation.Async;

public interface QuoteService {

  @Async
  void processQuote(String isin, Double bid, Double ask);

  Double getElvlByIsin(String isin);
}
