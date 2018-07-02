package com.fmi.uni.Connections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class Connector {

	private static final String basePlayerURL = "https://api.opendota.com/api/players/";

	private static String getJSONDataFromAPI(String urlToDownloadFrom) {

		String line = null;

		try {
			URL url = new URL(urlToDownloadFrom);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

			line = br.readLine();

		} catch (MalformedURLException ex) {
			System.err.println("Problem with handling URL");
		} catch (IOException e) {
			System.err.println("Problem with opening or reading from stream");
		}

		return line;

	}

	public static String getWinrate(long profile_id) {

		return getJSONDataFromAPI(basePlayerURL + profile_id + "/wl");

	}

	public static String getWinrate(long profile_id, int numberOfMatches) {

		return getJSONDataFromAPI(basePlayerURL + profile_id + "/wl" + "?limit=" + numberOfMatches);

	}

	public static String getTotals(long profile_id) {

		return getJSONDataFromAPI(basePlayerURL + profile_id + "/totals");

	}

}
