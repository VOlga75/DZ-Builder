import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .setAge(6)
                .build();
        System.out.println("У " + mom + " есть сын, " + son);
        Person pap = new PersonBuilder()
                .setName("А")
                .setSurname("Вольф")
                //  .setAge(31)
                .setAddress("Сидней")
                .build();

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // не тот возраст
            new PersonBuilder().setAge(140).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        mom.happyBirthday(); // проверяем изменение возраста
        System.out.println("У " + mom.name + " прошло ДР: " + mom);
        mom.setAddress("Moscou"); // проверяем изменение адреса
        System.out.println("Изменили адрес: " + mom);
    }
}

