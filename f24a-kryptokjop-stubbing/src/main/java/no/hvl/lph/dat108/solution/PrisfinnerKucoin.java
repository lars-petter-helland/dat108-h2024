package no.hvl.lph.dat108.solution;

import java.io.IOException;

import com.kucoin.sdk.KucoinClientBuilder;
import com.kucoin.sdk.KucoinRestClient;

public class PrisfinnerKucoin implements Prisfinner {

	@Override
	public double finnPris(String kryptoCode, String fiatCode) throws IOException {
		
		KucoinRestClient kucoinRestklient = new KucoinClientBuilder()
				.withBaseUrl("https://openapi-v2.kucoin.com").buildRestClient();

		return kucoinRestklient.currencyAPI()
				.getFiatPrice(fiatCode, kryptoCode)
				.get(kryptoCode).doubleValue();
	}
}
