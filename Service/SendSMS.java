/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author youssef
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
public class SendSMS {
    public static final String ACCOUNT_SID = "AC7ac3baefefdb85df574451cd24990b84";
    public static final String AUTH_TOKEN = "1e9e15126fdbf71789a08c9b717126e7";

    public static void sendSMSreservation() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message.creator(new com.twilio.type.PhoneNumber("+21692452730"),//to
                new com.twilio.type.PhoneNumber("+12194912836"),//from 
                "une reclamation a été faite").create();
    }
}
