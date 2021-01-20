package com.corti.springboot_jpa_mysql.stockAfd;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.corti.springboot_jpa_mysql.stocksymbol.StockSymbol;


@RestController
public class StockAttributesForDayController {

  private static boolean debugIt = false;
  
  @Autowired
  private StockAttributesForDayService stockAttributesForDayService;

  @RequestMapping("/stocks")
  public List<StockAttributesForDay> getAllStockAttributesForDay() {
    return stockAttributesForDayService.getAllStockAttributesForDay();
  }
  
  @RequestMapping("/stocks/{ticker}")
  public List<StockAttributesForDay> getAllStockAttributesForDayAndTicker(@PathVariable("ticker") String ticker) {
    return stockAttributesForDayService.getAllStockAttributesForDayAndTicker(ticker);
  }
  
  @RequestMapping("/stocks/{ticker}/{thedate}")  // Get by ticker and date
  public StockAttributesForDay getStockAttributesForDay(@PathVariable("ticker") String ticker, @PathVariable("thedate") String isoDate) {
    if (debugIt) System.out.println(String.format("theDate is:%s:",isoDate));
    LocalDate theDate = LocalDate.parse(isoDate);
    if (debugIt) System.out.println("theDate is " + theDate.toString());
    return stockAttributesForDayService.getStockAttributesForDay(ticker, theDate);
  }
  
  
  @RequestMapping(method=RequestMethod.POST, value="/stocks")  // POST request to insert a new record
  public void addStockAttributesForDay(@RequestBody StockAttributesForDay stockAfb) {  
    // Get the post body, convert it and call service method to add it
    stockAttributesForDayService.addStockAttributesForDay(stockAfb);
  }
  
  @RequestMapping(method=RequestMethod.PUT, value="/stocks")  // POST request to insert a new record
  public void updateStockAttributesForDay(@RequestBody StockAttributesForDay stockAfb) {  
    // Get the post body, convert it and call service method to add it
    stockAttributesForDayService.updateStockAttributesForDay(stockAfb);
  }
  
  @RequestMapping(method=RequestMethod.DELETE, value="/stocks/{ticker}/{thedate}")  // Delete record by ticker and date
  public void deleteStockAttributesForDay(@PathVariable("ticker") String ticker, @PathVariable("thedate") String isoDate) {  
    LocalDate theDate = LocalDate.parse(isoDate);
    stockAttributesForDayService.deleteStockAttributesForDay(ticker, theDate);
  }
  
}
