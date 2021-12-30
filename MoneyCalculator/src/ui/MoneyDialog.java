/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import model.Money;
import model.Currency;

/**
 *
 * @author Rebe
 */


public interface MoneyDialog {
    public Money get();
    public Currency getCurrencyFrom();
    public Currency getCurrencyTo();
}