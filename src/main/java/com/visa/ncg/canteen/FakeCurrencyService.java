package com.visa.ncg.canteen;

import com.visa.ncg.canteen.domain.CurrencyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("fake")
public class FakeCurrencyService implements CurrencyService {
  @Override
  public int convertToGbp(int amount) {
    return 99999;
  }
}
