package br.wtf.souza.utils;

import br.wtf.souza.stocks.Quote;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FinancialUtils {
    private static final String SAB = ".SA";
    private static final String URL = "https://www.alphavantage.co/query?";
    private static final String QUOTE_FUNCTION = "GLOBAL_QUOTE";

    public static float getQuotPrice(Quote quote) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(URL + "function=" + QUOTE_FUNCTION + "&symbol=" + quote.getSymbol() + SAB + "&apikey=" + "DT4G6I3HCT0NYWC6"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject quoteJSON = new JSONObject(response.body());
        String price = quoteJSON.getJSONObject("Global Quote").getString("05. price");

        return Float.parseFloat(price);
    }
}
