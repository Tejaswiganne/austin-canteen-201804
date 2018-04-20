package com.visa.ncg.canteen.currencyconversion;

import com.visa.ncg.canteen.domain.CurrencyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Profile("prod")
public class JittertedCurrencyService implements CurrencyService {

  public static final String CURRENCY_CONVERSION_URL
      = "http://jitterted-currency-conversion.herokuapp.com/convert?from={from}&to={to}&amount={amount}";

  @Override
  public int convertToGbp(int amount) {

    RestTemplate restTemplate = new RestTemplate();

    Map<String, String> params = new HashMap<>();
    params.put("from", "USD");
    params.put("to", "GBP");
    params.put("amount", Integer.toString(amount));

    ConvertedCurrency convertedCurrency = restTemplate
        .getForObject(CURRENCY_CONVERSION_URL, ConvertedCurrency.class, params);

    return convertedCurrency.getConverted();
  }
}
