package polymorphism;

class Animal {
    Animal getAnimal() {
        return new Animal();
    }
}

class Dog extends Animal {
    Dog getAnimal() {
        return new Dog();
    }
}


public class TestCovariant {

    public static void main(String[] args) {

        Animal a = new Dog();     // parent reference, child object
        Animal animal = a.getAnimal();

        System.out.println(animal.getClass().getSimpleName());

        Dog d = new Dog();        // child reference, child object
        Dog dog = d.getAnimal();

        System.out.println(dog.getClass().getSimpleName());
    }
}

