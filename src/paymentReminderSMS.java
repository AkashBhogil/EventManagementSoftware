/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
/**
 *
 * @author Administrator
 */
public class paymentReminderSMS {

    public String sendsms(String mob,String name,String pending_pay)
    {
       
       
        try {
			// Construct data
			String apiKey = "apikey=" + "SPnqpVxsMe0-Mgd4CUZiIENJD3bZJaL5HZnxZ9Sbg6";
			String message = "&message=" +"Dear "+name+" your eventsmate payment remaining to pay rupees "+pending_pay+" please pay your payment thank u";
                             
                                
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + mob;
			
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
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
        
        
    }
    
    public static void main(String[] args)
    {
     
      
    }
    
}
