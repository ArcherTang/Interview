package com.web.util;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
public class ApiUtils {
	private static final String COINDESK_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

	public static <T> T callApi(String url, Class<T> clazz) {
		Request request = new Request.Builder().url(HttpUrl.get(url)).build();

		OkHttpClient client = new OkHttpClient();
		String responseBody = null;
		int responseCode = -1;
		T result = null;

		try (Response response = client.newCall(request).execute()) {
			responseCode = response.code();
			responseBody = response.body().string();

			result = new Gson().fromJson(responseBody, clazz);

			log.info("result: {}", result);
		} catch (Exception cause) {
			log.error("api response code: " + responseCode + ", api response body: "
					+ responseBody + ", cause: " + cause.getMessage(), cause);
		}

		return result;
	}
}
