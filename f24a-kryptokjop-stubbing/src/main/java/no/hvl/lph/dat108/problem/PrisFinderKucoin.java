package no.hvl.lph.dat108.problem;

import java.io.IOException;

import com.kucoin.sdk.KucoinClientBuilder;
import com.kucoin.sdk.KucoinRestClient;

public class PrisFinderKucoin {

	public static double finnPris(String fiatCode, String kryptoCode) throws IOException {
		
		KucoinRestClient kucoinRestklient = new KucoinClientBuilder()
				.withBaseUrl("https://openapi-v2.kucoin.com").buildRestClient();

		return kucoinRestklient.currencyAPI().getFiatPrice(fiatCode, kryptoCode)
				.get(kryptoCode).doubleValue()	;
	}
}
