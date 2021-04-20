package com.jtsarkov.quote.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUOTE")
public class Quote {

  @Id
  @Column(name = "ID", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "ISIN")
  private String isin;
  @Column(name = "BID")
  private Double bid;
  @Column(name = "ASK")
  private Double ask;

  public Quote() {
  }

  public Quote(String isin, Double bid, Double ask) {
    this.isin = isin;
    this.bid = bid;
    this.ask = ask;
  }

  public Long getId() {
    return id;
  }

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
