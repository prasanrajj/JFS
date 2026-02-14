package Regex;

public class EnumPlayground {

	// 1) Simple enum
	enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

	// 2) Enum with data (real world style)
	enum StatusCode {
		SUCCESS(200), CREATED(201), NO_CONTENT(204), NOT_FOUND(404);

		private final int code;

		StatusCode(int code) { // constructor (runs once)
			this.code = code;
		}

		public int getCode() { // getter only (immutable)
			return code;
		}
	}

	public static void main(String[] args) {

		// -------- BASIC USAGE --------
		Day today = Day.MONDAY;
		System.out.println("Today: " + today);

		// -------- TYPE SAFETY --------
		// Day d = Day.HOLIDAY; // ❌ uncomment → compile error

		// -------- SWITCH CASE --------
		switch (today) {
		case MONDAY:
			System.out.println("Start working 😐");
			break;
		case FRIDAY:
			System.out.println("Weekend coming 😄");
			break;
		default:
			System.out.println("Normal day");
		}

		// -------- ENUM WITH DATA --------
		StatusCode status = StatusCode.SUCCESS;
		System.out.println("Status: " + status);
		System.out.println("Code: " + status.getCode());

		// -------- LOOP ALL VALUES --------
		System.out.println("\nAll status codes:");
		for (StatusCode s : StatusCode.values()) {
			System.out.println(s + " -> " + s.getCode());
		}

		// -------- STRING TO ENUM --------
		String input = "NOT_FOUND";
		StatusCode converted = StatusCode.valueOf(input);
		System.out.println("\nConverted from string: " + converted);
		if (converted instanceof StatusCode) {
			System.out.println("yes");
		}

		// -------- ORDINAL (position index) --------
		System.out.println("\nOrdinal of MONDAY: " + Day.MONDAY.ordinal());
		System.out.println("Ordinal of SUNDAY: " + Day.SUNDAY.ordinal());
	}
}
