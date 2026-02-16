package clonemethod;

class Location {
	String city;
	int pin;

	Location(String city, int pin) {
		this.city = city;
		this.pin = pin;
	}

	// copy constructor (deep copy helper)
	Location(Location other) {
		this.city = other.city;
		this.pin = other.pin;
	}

	public String toString() {
		return city + " - " + pin;
	}
}

class User implements Cloneable {
	String name;
	Location location;

	User(String name, Location location) {
		this.name = name;
		this.location = location;

	}

	User(User user) {
		this.name = user.name;
		this.location = new Location(user.location);
	}//COPY CONSTRUCTOR

//    @Override
//    public User clone() throws CloneNotSupportedException {
//        return (User) super.clone(); // shallow copy
//		   return new User(this);   
//    }

	@Override
	public User clone() throws CloneNotSupportedException {
		// original.location == copy.location (TRUE)
		// ⚠️ Still shallow copy.
		User copy = (User) super.clone();

		// deep copy, original.location == copy.location (FALSE)
		// Now changing clone won’t affect original.
		copy.location = new Location(this.location);
		return copy;
	}

	public String toString() {
		return name + " lives at " + location;
	}
}

public class CloneMethod {
	public static void main(String[] args) throws Exception {
		Location addr = new Location("Hyderabad", 500001);
		User u1 = new User("Prasanna", addr);
		User u2 = u1.clone(); // shallow copy
		u2.location.city = "Delhi";
		System.out.println("Original: " + u1);
		System.out.println("Cloned  : " + u2);
	}
}
