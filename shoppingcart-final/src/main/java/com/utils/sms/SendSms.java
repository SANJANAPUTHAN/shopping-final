package com.utils.sms;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//import java.net.URLEncoder;
import java.util.ArrayList;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSms {

	public static void SendMessage(ArrayList<ArrayList<String>> msg) throws Exception{
				String ACCOUNT_SID = "ACe66b5a504184209f2201c403f44eedf0";
				String AUTH_TOKEN = "52bfa2f2efbdd2409184a01e0c7503a4";
				Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
				Message message = Message.creator(new PhoneNumber("+91 6381424145"), new PhoneNumber("+12013080799"),msg.toString()).create();
				System.out.println(message.getSid());
	}
}