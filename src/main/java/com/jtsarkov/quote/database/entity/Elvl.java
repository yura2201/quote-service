package com.jtsarkov.quote.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "ELVL")
public class Elvl implements Persistable<String> {

  @Transient
  private boolean isNew;

  @Id
  @Column(name = "ISIN", nullable = false, updatable = false)
  private String isin;

  @Column(name = "ELVL")
  private Double elvl;

  public Elvl() {
    this.isNew = true;
  }

  public Elvl(boolean isNew, String isin, Double elvl) {
    this.isNew = isNew;
    this.isin = isin;
    this.elvl = elvl;
  }

  public String getIsin() {
    return isin;
  }

  public Double getElvl() {
    return elvl;
  }

  public void setElvl(Double elvl) {
    this.elvl = elvl;
  }

  @Override
  public String getId() {
    return getIsin();
  }

  @Override
  public boolean isNew() {
    return isNew;
  }

  public void setNew(boolean aNew) {
    isNew = aNew;
  }
}
