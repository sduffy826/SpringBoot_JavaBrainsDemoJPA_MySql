package com.corti.springboot_jpa_mysql.stockAfd;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "StockAttributesForDay") // I know the same but want to show how to override mysql table name
@IdClass(StockAttributesForDateId.class)
public class StockAttributesForDay implements Serializable {

  @Id
  private String tickerSymbol;
  
  @Id
  private LocalDate stockDate;
  
  private float open, high, low, close, adjClose;
  private long volume;

  public StockAttributesForDay() { }
  
  public StockAttributesForDay(String _ticker, LocalDate _sDate, float _open, float _high,
      float _low, float _close, float _adjClose, long _volume) {
    super();
    this.setTickerSymbol(_ticker);
    this.setStockDate(_sDate);
    this.setOpen(_open);
    this.setHigh(_high);
    this.setLow(_low);
    this.setClose(_close);
    this.setAdjClose(_adjClose);
    this.setVolume(_volume);
  }

  public StockAttributesForDay(String _ticker, String _sdate, float _open, float _high,
      float _low, float _close, float _adjClose, long _volume) {
    super();
    this.setTickerSymbol(_ticker);
    this.setStockDate(_sdate);
    this.setOpen(_open);
    this.setHigh(_high);
    this.setLow(_low);
    this.setClose(_close);
    this.setAdjClose(_adjClose);
    this.setVolume(_volume);
  }

  public StockAttributesForDay(String _ticker, String _sdate, String _open, String _high,
      String _low, String _close, String _adjClose, String _volume) {
    super();
    
    float _o, _h, _l, _c, _a;
    long _v;
    
    _o = Float.parseFloat(_open);
    _h = Float.parseFloat(_high);
    _l = Float.parseFloat(_low);
    _c = Float.parseFloat(_close);
    _a = Float.parseFloat(_adjClose);
    _v = Long.parseLong(_volume);

    this.setTickerSymbol(_ticker);
    this.setStockDate(_sdate);
    this.setOpen(_o);
    this.setHigh(_h);
    this.setLow(_l);
    this.setClose(_c);
    this.setAdjClose(_a);
    this.setVolume(_v);
  }
  
  public String getTickerSymbol() {
    return tickerSymbol;
  }
  public LocalDate getStockDate() {
    return stockDate;
  }
  public float getOpen() {
    return open;
  }
  public float getHigh() {
    return high;
  }
  public float getLow() {
    return low;
  }
  public float getClose() {
    return close;
  }
  public float getAdjClose() {
    return adjClose;
  }
  public long getVolume() {
    return volume;
  }
  
  protected void setTickerSymbol(String _ticker) {
    this.tickerSymbol = _ticker;
  }
  
  // Setter taking a date
  protected void setStockDate(LocalDate _sDate) {
    this.stockDate = _sDate;
  }
  
  // Setter with a string representation of the date (ISO fmt)
  protected void setStockDate(String _sDate) {
    this.stockDate = LocalDate.parse(_sDate, DateTimeFormatter.ISO_LOCAL_DATE);
  }
  
  protected void setStockDate(int _year, int _month, int _day) {
    this.stockDate = LocalDate.of(_year, _month, _day);
  }

  protected void setOpen(float _open) {
    this.open = _open;
  }
  protected void setHigh(float _high) {
    this.high = _high;
  }
  protected void setLow(float _low) {
    this.low = _low;
  }
  
  protected void setClose(float _close) {
    this.close = _close;
  }
  protected void setAdjClose(float _adjClose) {
    this.adjClose = _adjClose;
  }
  protected void setVolume(long _volume) {
    this.volume = _volume;
  }

  public String toString() {
    return this.getTickerSymbol() + " " +
           this.getStockDate().format(DateTimeFormatter.ISO_LOCAL_DATE) + " " +
           "Open: " + Float.toString(this.getOpen()) +
           "High: " + Float.toString(this.getHigh()) +
           "Low: " + Float.toString(this.getLow()) +
           "Close: " + Float.toString(this.getClose()) +
           "AdjClose: " + Float.toString(this.getAdjClose());
  }

  // We shift open in case user wants to insert something between date and open (i.e. dividend)
  public String toCsvAll() {
    return this.getTickerSymbol() + ",," + 
           this.getStockDate().format(DateTimeFormatter.ISO_LOCAL_DATE) + ",,,," +
           Float.toString(this.getOpen()) + ",," +
           Float.toString(this.getHigh()) + ",," +
           Float.toString(this.getLow()) + ",," +
           Float.toString(this.getClose()) + ",," +
           Float.toString(this.getAdjClose()) + ",," +
           Long.toString(this.getVolume());
  }
}
