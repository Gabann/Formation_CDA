package exercices.design_pattern.adapter.sms_notification;

public class Main
{
	public static void main(String[] args)
	{
		SmsService smsService = new SmsToEmailAdapter();

		smsService.sendSms("060606", "wesh");
	}
}
