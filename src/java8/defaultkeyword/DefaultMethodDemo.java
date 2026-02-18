package java8.defaultkeyword;

interface Payment {
	// abstract method
	void pay(int amount);

	// default method
	default void receipt() {
		System.out.println("Default: Payment completed. Receipt generated.");
	}
}

class UpiPayment implements Payment {
	@Override
	public void pay(int amount) {
		System.out.println("Paid using UPI: " + amount);
	}

	// overriding default method
	@Override
	public void receipt() {
		System.out.println("UPI: Custom receipt generated.");
	}
}

class CardPayment implements Payment {
	@Override
	public void pay(int amount) {
		System.out.println("Paid using Card: " + amount);
	}
	// NOT overriding default -> default method will run
}

//MULTIPLE INTERFACE DEFAULT METHOD CONFLICT
interface EmailNotification {
	default void notifyUser() {
		System.out.println("Email notification sent");
	}
}

interface SMSNotification {
	default void notifyUser() {
		System.out.println("SMS notification sent");
	}
}

//must resolve conflict
class OrderService implements EmailNotification, SMSNotification {
	@Override
	public void notifyUser() {
		// choosing one OR combining both
		EmailNotification.super.notifyUser();
		SMSNotification.super.notifyUser();
		System.out.println("Order notification handled");
	}
}

public class DefaultMethodDemo {
	public static void main(String[] args) {
		System.out.println("---- Default Method Used ----");
		Payment card = new CardPayment();
		card.pay(500);
		card.receipt(); // default runs

		System.out.println("\n---- Default Overridden ----");
		Payment upi = new UpiPayment();
		upi.pay(300);
		upi.receipt(); // overridden runs

		System.out.println("\n---- Multiple Interface Conflict ----");
		OrderService order = new OrderService();
		order.notifyUser();
	}
}
