package com.jtsarkov.quote.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jtsarkov.quote.database.entity.Elvl;
import com.jtsarkov.quote.database.entity.Quote;
import com.jtsarkov.quote.database.repository.ElvlRepository;
import com.jtsarkov.quote.database.repository.QuoteRepository;
import com.jtsarkov.quote.service.QuoteService;

@Service
public class QuoteServiceImpl implements QuoteService {

  private final QuoteRepository quoteRepository;
  private final ElvlRepository elvlRepository;

  public QuoteServiceImpl(QuoteRepository quoteRepository,
      ElvlRepository elvlRepository) {
    this.quoteRepository = quoteRepository;
    this.elvlRepository = elvlRepository;
  }

  private Elvl updateElvl(Elvl elvl, String isin, Double bid, Double ask) {
    // в предположении, что п.4 правил расчёта применим только для п.3
    elvl.setNew(false);
    if (elvl.getElvl() < bid) {
      elvl.setElvl(bid);
    } else if (elvl.getElvl() > ask) {
      elvl.setElvl(ask);
    }
    return elvl;
  }

  @Override
  @Async
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void processQuote(String isin, Double bid, Double ask) {
    quoteRepository.save(new Quote(isin, bid, ask));
    //    Elvl elvl = elvlRepository.getByIsin(isin).orElse(getElvl(null, isin, bid, ask));
    Optional<Elvl> elvlOpt = elvlRepository.getByIsin(isin);
    Elvl elvl = elvlOpt.map(value -> updateElvl(value, isin, bid, ask))
        .orElseGet(() -> new Elvl(true, isin, Objects.isNull(bid) ? ask : bid));
    elvlRepository.save(elvl);
  }

  @Override
  @Transactional
  public Double getElvlByIsin(String isin) {
    Optional<Elvl> elvlOpt = elvlRepository.getByIsin(isin);
    return elvlOpt.isPresent() ? elvlOpt.get().getElvl() : null;
  }

  //  @Transactional(readOnly = true)
  //  public
}
