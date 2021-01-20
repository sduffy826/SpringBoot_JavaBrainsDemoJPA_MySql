package com.corti.springboot_jpa_mysql.stockAfd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockAttributesForDayService {
  private static boolean debugIt = false;
  
  @Autowired
  private StockAttributesForDayRepository stockAfdRepository;
  
  // Get all the data on file
  public List<StockAttributesForDay> getAllStockAttributesForDay() {
    // System.out.println("In getAllTopics()");
    List<StockAttributesForDay> stockAfd = new ArrayList<>();
    stockAfdRepository.findAll()
      .forEach(stockAfd::add);  // Method reference
    return stockAfd;
  }
  
  // Get all the data for a particular symbol
  public List<StockAttributesForDay> getAllStockAttributesForDayAndTicker(String tickerSymbol) {
    // System.out.println("In getAllTopics()");
    List<StockAttributesForDay> stockAfd = new ArrayList<>();
    stockAfdRepository.findByTickerSymbol(tickerSymbol)
      .forEach(stockAfd::add);  // Method reference
    return stockAfd;
  }
  
  
  public StockAttributesForDay getStockAttributesForDay(String tickerSymbol, LocalDate stockDate) {
   // List<StockAttributesForDay> stockAfd = new ArrayList<>();
   // stockAfd.
    if (debugIt) {
      System.out.println(String.format("In getStockAttributesForDay %s %s",tickerSymbol, stockDate.toString()));
      List<StockAttributesForDay> stockAfd = new ArrayList<>();
      stockAfdRepository.findByTickerSymbolAndStockDate(tickerSymbol, stockDate)
        .forEach(stockAfd::add);
      if (stockAfd.size() == 1)
        System.out.println(stockAfd.get(0).toString());
      System.out.println(String.format("Size of array is:%d",stockAfd.size()));
    }
   
    return (StockAttributesForDay) stockAfdRepository.findByTickerSymbolAndStockDate(tickerSymbol, stockDate)
                                      .stream()
                                      .findFirst().orElse(null);
  }
  
  // Insert record
  public void addStockAttributesForDay(StockAttributesForDay stockAfd) {
    stockAfdRepository.save(stockAfd);
  }

  // Update record
  public void updateStockAttributesForDay(StockAttributesForDay stockAfd) {
    stockAfdRepository.save(stockAfd);
  }
  
  // Delete record by ticker, date
  public void deleteStockAttributesForDay(String tickerSymbol, LocalDate stockDate) {   
    stockAfdRepository.deleteByTickerSymbolAndStockDate(tickerSymbol, stockDate);
  }
  
  
}
