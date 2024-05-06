package exercices.design_pattern.adapter.sms_notification;

public class SmsToEmailAdapter extends SmsService
{
	EmailService emailService;

	public SmsToEmailAdapter()
	{
		this.emailService = new EmailService();
	}

	@Override
	void sendSms(String number, String message)
	{
		emailService.sendEmail(number, null, message);
	}
}
