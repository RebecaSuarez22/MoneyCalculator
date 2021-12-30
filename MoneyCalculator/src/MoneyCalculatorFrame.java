/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Currency;
import model.Money;
import model.ExchangeRate;
import persistence.ExchangeRateLoader;
import ui.MoneyDialog;
import ui.MoneyDisplay;
import ui.swing.SwingMoneyDialog;
import ui.swing.SwingMoneyDisplay;

/**
 *
 * @author Rebe
 */


public class MoneyCalculatorFrame extends JFrame {
    private final List<Currency> currencies;
    private final ExchangeRateLoader exchangeRateLoader;
    
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;

    public MoneyCalculatorFrame(List<Currency> currencies, ExchangeRateLoader exchangeRateLoader) {
        this.currencies = currencies;
        this.exchangeRateLoader = exchangeRateLoader;
        this.setTitle("Money Calculator");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.add(moneyDialog(), BorderLayout.NORTH);
        this.add(toolbar(), BorderLayout.CENTER);
        this.add(moneyDisplay(), BorderLayout.SOUTH); 
        
        this.setVisible(true);
    }

    private Component moneyDialog() {
        SwingMoneyDialog swingMoneyDialog = new SwingMoneyDialog(currencies);
        this.moneyDialog = swingMoneyDialog;
        return swingMoneyDialog;
    }

    private Component toolbar() {
        JPanel toolBarPanel = new JPanel();
        toolBarPanel.add(calculateButton());
        return toolBarPanel;
    }

    private Component moneyDisplay() {
        SwingMoneyDisplay swingMoneyDisplay = new SwingMoneyDisplay();
        this.moneyDisplay = swingMoneyDisplay;
        return swingMoneyDisplay;
    }
    
    private JButton calculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(calculate());
        return button;
    }
    
    private ActionListener calculate() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Money baseMoney = moneyDialog.get();
                ExchangeRate exchangeRate = exchangeRateLoader.load(moneyDialog.getCurrencyFrom(), moneyDialog.getCurrencyTo());
                if (exchangeRate != null) {
                    Money resultMoney = new Money(moneyDialog.getCurrencyTo(), baseMoney.getAmount() * exchangeRate.getAmount());
                    moneyDisplay.display(resultMoney);
                }
            }
        };
    }
    
    
}
