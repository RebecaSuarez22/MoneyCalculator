/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.swing;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Money;
import ui.MoneyDisplay;


/**
 *
 * @author Rebe
 */

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {
    private Money money;
    
    @Override
    public void display(Money money) {
        this.money = money;
        this.removeAll();
        this.add(amount());
        this.add(currency());
        this.updateUI();
    }

    private Component amount() {
        return new JLabel(String.valueOf(money.getAmount()));
    }

    private Component currency() {
        return new JLabel(String.valueOf(money.getCurrency().getCode()));
    }
    
}
