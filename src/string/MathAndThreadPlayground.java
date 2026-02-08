package string;

import java.util.Random;
import java.security.SecureRandom;

public class MathAndThreadPlayground {
	static int sharedCounter = 0;

	public static void main(String[] args) throws Exception {

		double a = 3.4;
		double b = 3.9;

		System.out.println("floor(3.4) = " + Math.floor(a));
		System.out.println("ceil(3.4)  = " + Math.ceil(a));
		System.out.println("round(3.4) = " + Math.round(a));
		System.out.println();
		System.out.println("floor(3.9) = " + Math.floor(b));
		System.out.println("ceil(3.9)  = " + Math.ceil(b));
		System.out.println("round(3.9) = " + Math.round(b));

		System.out.println("PI = " + Math.PI);

		Random r = new Random();
		System.out.println("\nRandom number (0–9): " + r.nextInt(10));

		SecureRandom sr = new SecureRandom();
		System.out.println("Secure random (7–10): " + sr.nextInt(7,10));
	}
}
