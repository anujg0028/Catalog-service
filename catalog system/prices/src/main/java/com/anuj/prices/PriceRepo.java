package com.anuj.prices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PriceRepo extends JpaRepository<Prices, Integer>{

}
