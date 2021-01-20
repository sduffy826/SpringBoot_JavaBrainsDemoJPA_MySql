package com.corti.springboot_jpa_mysql.stockAfd;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class StockAttributesForDateId implements Serializable {

    private String tickerSymbol;
    private LocalDate stockDate;

    public StockAttributesForDateId() {  }

    public StockAttributesForDateId(String tickerSymbol, LocalDate stockDate) {
        this.tickerSymbol = tickerSymbol;
        this.stockDate    = stockDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) 
          return true;
        if (o == null || getClass() != o.getClass()) 
          return false;

        StockAttributesForDateId otherStockForDate = (StockAttributesForDateId) o;
        return tickerSymbol.equals(otherStockForDate.tickerSymbol) &&
               stockDate.equals(otherStockForDate.stockDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickerSymbol, stockDate);
    }
}