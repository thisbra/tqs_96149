package tqs.labii;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class StockPortfolioTest {
    
    @Mock
    private IStockmarketService iStockMarket;
    @InjectMocks
    private StocksPortfolio portfolio;

    
    @Test
    void getTotalValue() {
        // Mock preparation
        when(iStockMarket.lookUpPrice("AAPL")).thenReturn(2.0);
        when(iStockMarket.lookUpPrice("MSFT")).thenReturn(3.0);
        portfolio.setMarketService(iStockMarket);


        // Test
        portfolio.addStock(new Stock("AAPL", 1));
        portfolio.addStock(new Stock("MSFT", 2));
        assertEquals(8.0, portfolio.getTotalValue());

        // Mock verification
        verify(iStockMarket, times(2)).lookUpPrice(anyString());
        verify(iStockMarket).lookUpPrice("AAPL");
        verify(iStockMarket).lookUpPrice("MSFT");

    }

}
