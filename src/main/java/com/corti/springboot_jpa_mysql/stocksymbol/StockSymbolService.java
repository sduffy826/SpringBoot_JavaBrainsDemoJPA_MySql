package com.corti.springboot_jpa_mysql.stocksymbol;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockSymbolService {
  
  @Autowired
  private StockSymbolRepository stockSymbolRepository;
   
  public List<StockSymbol> getAllStockSymbols() {
    System.out.println("In getAllStockSymbols()");
    List<StockSymbol> stockSymbols = new ArrayList<>();
    stockSymbolRepository.findAll()
      .forEach(stockSymbols::add);  // add element to the array
    return stockSymbols;
  }
  
  public StockSymbol getStockSymbol(String tickerSymbol) {
   return stockSymbolRepository.findById(tickerSymbol).orElse(null);
    // old way when were using the array: return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
  }
  
  public void addStockSymbol(StockSymbol stockSymbol) {
    stockSymbolRepository.save(stockSymbol);
  }

  public void updateStockSymbol(StockSymbol stockSymbol) {
    System.out.println(String.format("updateStockSymbols: %s",stockSymbol.toString()));
    stockSymbolRepository.save(stockSymbol);
  }
  
  public void deleteStockSymbol(String tickerSymbol) {
    stockSymbolRepository.deleteById(tickerSymbol);
  }
  
  
}
