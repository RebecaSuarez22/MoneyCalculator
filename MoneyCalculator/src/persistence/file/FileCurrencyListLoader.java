/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence.file;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Currency;
import persistence.CurrencyListLoader;
/**
 *
 * @author Rebe
 */
public class FileCurrencyListLoader implements CurrencyListLoader {
    private final String fileName;

    public FileCurrencyListLoader(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public List<Currency> currencies() {
        List<Currency> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                list.add(currencyOf(line));
            }
        } catch (IOException exe) {
            System.out.println("IOException");
        }
        return list;
    }
    
    private Currency currencyOf(String line) {
        String[] columns = line.split(",");
        Currency currency = new Currency(columns[0], columns[1], columns[2]);
        return currency;
    }
    
}