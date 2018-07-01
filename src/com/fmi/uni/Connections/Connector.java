package com.fmi.uni.Connections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Connector {
	
	private static final String baseUrlPlayersTab = "https://api.opendota.com/api/players/";
	
	private static String getJSONDataFromAPI(String urlToDownloadFrom) {

		String line = null;

		try {
			URL url = new URL(urlToDownloadFrom);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

			line = br.readLine();

		} catch (MalformedURLException ex) {
			System.out.println("malformedURLException problem");
		} catch (IOException e) {
			System.out.println("IO problem");
		}

		return line;

	}

	public static String getWinrate(long profile_id) {

		return getJSONDataFromAPI(baseUrlPlayersTab + profile_id + "/wl");

	}

	public static String getWinrate(long profile_id, int numberOfMatches) {

		return getJSONDataFromAPI(
				baseUrlPlayersTab + profile_id + "/wl" + "?limit=" + numberOfMatches);

	}
	
	public static String getTotals(long profile_id) {
		
		return getJSONDataFromAPI(baseUrlPlayersTab + profile_id + "/totals");
		
	}

}
