/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;
import model.Currency;
import model.ExchangeRate;

/**
 *
 * @author Rebe
 */


public interface ExchangeRateLoader {
    public ExchangeRate load(Currency from, Currency to);
}
