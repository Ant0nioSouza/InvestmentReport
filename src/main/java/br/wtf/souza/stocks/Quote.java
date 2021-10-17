package br.wtf.souza.stocks;

import br.wtf.souza.utils.FinancialUtils;

public class Quote {
    private final String id;
    private final int amount;

    public Quote(String symbol, int amount) {
        this.id = symbol;
        this.amount = amount;
    }
    public String getSymbol() {
        return id;
    }
    public int getAmount() {
        return amount;
    }
    public float getPrice() {
        return FinancialUtils.getQuotPrice();
    }
}
