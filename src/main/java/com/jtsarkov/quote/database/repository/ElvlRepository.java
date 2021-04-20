package com.jtsarkov.quote.database.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jtsarkov.quote.database.entity.Elvl;

public interface ElvlRepository extends CrudRepository<Elvl, String> {
  Optional<Elvl> getByIsin(String isin);
}
