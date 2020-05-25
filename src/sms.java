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
public class sms {
     String mob,name,venue,venue_address,date,time,total_payement,paid;
  int event_id;
  public sms(String mobile,String name1,int event_id1,String venue1,String venue_address1,String date1,String time1,String total_payment1,String paid1)
  {
        mob=mobile;
       name=name1;
       event_id=event_id1;
       venue=venue1;
       venue_address=venue_address1;
       date=date1;
       time=time1;
       total_payement=total_payment1;
       paid=paid1;
  }
    public String sendsms()
    {
       
       
        try {
			// Construct data
			String apiKey = "apikey=" + "SPnqpVxsMe0-X8LQnybWOpK3SZZ7Kigfmz8aP4Kh25";
			String message = "&message=" + "THANK U FOR REGISTERING YOUR EVENT IN EVENTSMATE \n"
                                + "YOUR EVENT REF ID : "+event_id+"\n"
                                + "VENUE: "+venue+"\n"
                                + "VENUE ADDRESS : "+venue_address+"\n"
                                + "DATE : "+date+"\n"
                                + "TIME : "+time+"\n"
                                + "TOTAL_PAYMENT : "+total_payement+"\n"
                                +"FOR MORE DETAILS CALL ON 9689655094"
                                ;
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
