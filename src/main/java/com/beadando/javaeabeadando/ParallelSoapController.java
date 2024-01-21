package com.beadando.javaeabeadando;

import com.oanda.v20.Context;
import com.oanda.v20.ContextBuilder;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.pricing.ClientPrice;
import com.oanda.v20.pricing.PricingGetRequest;
import com.oanda.v20.pricing.PricingGetResponse;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ParallelSoapController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private TextArea welcomeText;
    @FXML
    protected void onHelloButtonClick() {
        try {
            Context ctx = new ContextBuilder(Config.URL).setToken(Config.TOKEN).setApplication("PricePolling").build();
            AccountID accountId = Config.ACCOUNTID;
            List<String> instruments = new ArrayList<>( Arrays.asList("EUR_USD", "USD_JPY", "GBP_USD", "USD_CHF"));
            PricingGetRequest request = new PricingGetRequest(accountId, instruments);
            PricingGetResponse resp = ctx.pricing.get(request);
            for (ClientPrice price : resp.getPrices())
                welcomeText.setText(welcomeText.getText() + "\n" +price.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
