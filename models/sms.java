/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author YURI
 */
 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
public class sms {
	public String sendSms() {
		try {
			// Construct data
			String apiKey = "apikey=" + "1s4SMLrJvY8-xMiHNL5FU2jDykNa6DN2AOK9M59KiK";
			String message = "&message=" + "Une commande a ete effectue ";
			String sender = "&sender=" + "Veolo.Tn";
			String numbers = "&numbers=" + "96017549";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
                        System.out.println("sending...");
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			                        System.out.println("sending...");

			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}