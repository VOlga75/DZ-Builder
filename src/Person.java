
import java.util.OptionalInt;

import static jdk.internal.org.jline.utils.AttributedStringBuilder.append;

public class Person {
    final protected String name;// final, чтобы нельзя было менять имя у созданного объекта
    final protected String surname;
    protected int age;
    protected String adress;

    public Person(PersonBuilder personBuilder) {
        if (personBuilder == null) {
            throw new IllegalArgumentException("Не удалось создать объект");
        }
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        if (personBuilder.hasAge()) {
            this.age = personBuilder.age;
        }
        if (personBuilder.hasAdress()) {
            this.adress = personBuilder.adress;
        }

    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        if (this.age < 0){
            return OptionalInt.empty();
        }
        return OptionalInt.of(this.age);
    }

    public String getAddress() {
        return this.adress;
    }

    public void setAddress(String address) {
        this.adress = address;
    }

    public void happyBirthday() {
        //   if (this.hasAge) {
        this.age = this.age + 1;
        //  }
    }

  /*  public boolean doQualityCheck() {
        return (!surname.trim().isEmpty() && !name.trim().isEmpty());
    }*/

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.adress);
        return child;

    }

    @Override
    public String toString() {
        StringBuilder person = new StringBuilder();
        person.append(name).append(" ").append(surname).append(": age = ").append(age).append("; adress = ").append(adress);
        return person.toString();
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 75 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

}
