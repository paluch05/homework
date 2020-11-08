package pl.orzechsoft.paluch.tasks.Task13;

import java.util.Map;

public class Rates {
    private String base;
    private Map<String, Double> rates;
    private String date;

    private Rates() {
    }

    public Rates(String base, Map<String, Double> rates, String date) {
        this.base = base;
        this.rates = rates;
        this.date = date;
    }

    public String getBase() {
        return base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public String getDate() {
        return date;
    }
}