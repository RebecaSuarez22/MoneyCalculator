/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import persistence.CurrencyListLoader;
import persistence.ExchangeRateLoader;
import persistence.file.FileCurrencyListLoader;
import persistence.rest.RestExchangeRateLoader;

/**
 *
 * @author Rebe
 */



public class MoneyCalculator {

    public static void main(String[] args) {
        CurrencyListLoader currencyListLoader = new FileCurrencyListLoader("currencies.txt");
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        
        MoneyCalculatorFrame moneyCalculatorFrame = new MoneyCalculatorFrame(currencyListLoader.currencies(), exchangeRateLoader);
    }
    
}
