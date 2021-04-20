package com.jtsarkov.quote.database.repository;

import org.springframework.data.repository.CrudRepository;

import com.jtsarkov.quote.database.entity.Quote;

public interface QuoteRepository extends CrudRepository<Quote, Long> {
}
