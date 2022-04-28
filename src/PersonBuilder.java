import java.util.OptionalInt;

public class PersonBuilder implements IPersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String adress;

    public PersonBuilder setName(String name) {
        if (name == null) {
            throw new IllegalStateException("Имя должно быть заполнено.");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalStateException("Фамилия должна быть заполнена.");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("возраст не может быть меньше 0");
        }
        if (age > 120) {
            throw new IllegalArgumentException("Людей старше 120 лет пока не обнаружено");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.adress = address;
        return this;
    }

    public boolean hasAge() {
        if (OptionalInt.of(this.age) == null) {
            return false;
        }
        return true;
    }

    public boolean hasAdress() {
        // if(this.adress.isEmpty()||this.name.trim().isEmpty()){
        if (this.adress == null) {
            return false;
        }
        return true;
    }

    @Override
    public Person build() {
        if (this.name == null || name.trim().isEmpty() || this.surname == null || surname.trim().isEmpty()) {
            throw new IllegalStateException("Имя и фамилия должны быть заполнены.");
        }
        Person person = new Person(this);
        return person;
    }
}
