/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence.rest;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import model.Currency;
import model.ExchangeRate;
import persistence.ExchangeRateLoader;

/**
 *
 * @author Rebe
 */
public class RestExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            return new ExchangeRate(from, to, read(from.getCode(), to.getCode()));
        } catch (MalformedURLException exception) {
            System.out.println("ERROR RestExchangeRateLoader::load (Mal formed URL)" + exception.getMessage());
            return null;
        } catch (IOException exception) {
            System.out.println("ERROR RestExchangeRateLoader::load (IO)" + exception.getMessage());
            return null;
        }
    }
    
    private double read(String from, String to) throws MalformedURLException, IOException {
        if (from.equals(to)) {
            return 1d;
        }
        String line = read(new URL("https://api.exchangeratesapi.io/latest?base="+from));
        return Double.parseDouble(line.substring(line.indexOf(to) + 5, line.indexOf(",", line.indexOf(to))));
    }

    private String read(URL url) throws IOException {
        InputStream is = url.openStream();
        String result = "";
        byte[] buffer = new byte[1024];
        int length = 0;
        while (length != -1) {
            result += new String(buffer, 0, length);
            length = is.read(buffer);
        }
        return result;
    }
    
}
