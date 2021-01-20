package com.corti.springboot_jpa_mysql.stockAfd;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StockAttributesForDayRepository extends CrudRepository<StockAttributesForDay, LocalDate> {
  
  // You provide a hint to spring on how to implement this... you name it a particular, so say you want
  // a method to 'get' 'Courses' 'By' 'Name'; it starts with 'findBy' 'property' name so you'd do 'findByName(String name)
  // for us we want courses for a particular topic so then  
  public List<StockAttributesForDay> findByTickerSymbol(String tickerSymbol);  
  
  // To find by composite key use 'And' between the properties (can use Or also)
  public List<StockAttributesForDay> findByTickerSymbolAndStockDate(String tickerSymbol, LocalDate stockDate);
  
  public void deleteByTickerSymbolAndStockDate(String tickerSymbol, LocalDate stockDate);
}
