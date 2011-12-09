package cao_project.android.smsprinter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
/************************************************
*SMSPrinter class definition
************************************************/

public class SMSPrinter extends android.content.BroadcastReceiver{

	@Override
	public void onReceive( Context context, Intent intent ){
		//TODO auto generated method
		Object []objs = (Object[]) intent.getExtras().get("pdus");
		SmsMessage sms = SmsMessage.createFromPdu( (byte[]) objs[0] );
		if(sms != null){
		System.out.println("From: " + sms.getDisplayOriginatingAddress());
		System.out.println("Contents: " + sms.getDisplayMessageBody());
		} else {
		System.out.println("receive a text message");
		}
	}
}
