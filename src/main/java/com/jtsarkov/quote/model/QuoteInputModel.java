package com.jtsarkov.quote.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jtsarkov.quote.annotation.BidConstraint;

@BidConstraint
public class QuoteInputModel {

  @Size(min = 12, max = 12)
  @NotNull
  private String isin;
  private Double bid;
  @NotNull // исходя из п.4 правил расчёта. Хотя м.б. и нет - требуется уточнение
  private Double ask;

  public String getIsin() {
    return isin;
  }

  public void setIsin(String isin) {
    this.isin = isin;
  }

  public Double getBid() {
    return bid;
  }

  public void setBid(Double bid) {
    this.bid = bid;
  }

  public Double getAsk() {
    return ask;
  }

  public void setAsk(Double ask) {
    this.ask = ask;
  }
}
