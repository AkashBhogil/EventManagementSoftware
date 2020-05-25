
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailSSL {
 String mob,name,venue,venue_address,date,time,total_payement,paid,mail;
  int event_id;
   public  SendEmailSSL(String mobile,String name1,int event_id1,String venue1,String venue_address1,String date1,String time1,String total_payment1,String paid1,String mail1)
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
       mail=mail1;
   }
    
    public void sendsms()
    {
        
        final String username = "akashbhogil91098@gmail.com";
        final String password = "ddvicixnvltjrbpz";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("EventsMate"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mail)
            );
            message.setSubject("Event Register Success");
            message.setText("THANK U FOR REGISTERING YOUR EVENT IN EVENTSMATE,"
                    + "\n\n YOUR EVENT REFERENCE NUMBER :" +event_id
                    +"\n\n NAME: "+name
                    +"\n\n MOBILE: "+mob
                    +"\n\n VENUE: "+venue
                    +"\n\n VENUE ADDRESS: "+venue_address
                    +"\n\n VENUE DATE: "+date
                    +"\n\n VENUE TIME:"+time
                    +"\n\n TOTAL PAYMENT: "+total_payement
                    +"\n\n PAID PAYMENT: "+paid
                    +"\n\n TERMS & CONDITIONS :");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}