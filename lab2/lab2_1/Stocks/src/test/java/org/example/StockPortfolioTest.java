package org.example;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.example.IStockmarketService;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StockPortfolioTest {

    @Mock
    IStockmarketService market;

    @InjectMocks
    StockPortfolio portfolio;



    @Test
    void getTotalValueAnnot() {
//        1. Prepare a mock to substitute the remote service (@Mock annotation)

//        2. Create an instance of the subject under test (SuT) and use the mock to set
//        the (remote) service instance.
//        3. Load the mock with the proper expectations (when...thenReturn)
        when(market.lookUpPrice("EBAY")).thenReturn(1.5);
        when(market.lookUpPrice("MSFT")).thenReturn(4.75);

        portfolio.addStock(new Stock("EBAY", 1));
        portfolio.addStock(new Stock("MSFT", 2));

        double res = portfolio.getTotalValue();
        assertEquals(res, 11);
        verify(market, times(2)).lookUpPrice(anyString());
//        4. Execute the test (use the service in the SuT)
//        5. Verify the result (assert) and the use of the mock (verify)
    }
}
