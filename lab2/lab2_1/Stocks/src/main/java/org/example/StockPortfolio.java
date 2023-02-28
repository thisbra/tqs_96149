package org.example;

import java.util.ArrayList;
import java.util.List;

public class StockPortfolio {
    private List<Stock> stocks;
    private IStockmarketService stockmarket;

    public StockPortfolio(IStockmarketService stockmarket) {
        this.stockmarket = stockmarket;
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double getTotalValue() {
        double value = 0;

        for (Stock s: stocks) {
            value = value + s.getQuantity() * stockmarket.lookUpPrice(s.getLabel());
        }

        return value;
    }

}
