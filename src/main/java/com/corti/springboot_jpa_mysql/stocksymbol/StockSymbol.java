package com.corti.springboot_jpa_mysql.stocksymbol;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockSymbol {

  @Id
  String tickerSymbol;
  
  String companyName;
  
  public String getTickerSymbol() {
    return tickerSymbol;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setSymbol(String tickerSymbol) {
    this.tickerSymbol = tickerSymbol;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String toString() {
    return this.getTickerSymbol() + " " + this.getCompanyName();
  }

  // We shift open in case user wants to insert something between date and open (i.e. dividend)
  public String toCsvAll() {
    return this.getTickerSymbol() + ",," + this.getCompanyName();
  }
}
