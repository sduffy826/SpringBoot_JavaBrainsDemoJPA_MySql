package com.corti.springboot_jpa_mysql.stocksymbol;

import org.springframework.data.repository.CrudRepository;

public interface StockSymbolRepository extends CrudRepository<StockSymbol, String> {

}
