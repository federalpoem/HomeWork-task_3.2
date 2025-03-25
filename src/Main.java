public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new Employee("Иванов Кирилл Иванович", "Программист", "ivan24990@gmail.com", "+7(999)-123-45-67", 96000, 35),
                new Employee("Сидоров Павел Алексеевич", "Тестировщик", "petr92163872@mail.ru", "+7(975)-755-57-15", 74000, 50),
                new Employee("Петрова Анна Сергеевна", "Менеджер", "anna1980@gmail.com", "+7(943)-987-65-43", 67000, 45),
                new Employee("Кузнецова Людмила Владимировна", "Дизайнер", "maria2344@gmail.com", "+7(931)-111-92-33", 71000, 30),
                new Employee("Смирнов Дмитрий Николаевич", "HR", "d1mas@mail.ru", "+7(972)-444-59-15", 66000, 42)
        };

        System.out.println("\nСотрудники старше 40 лет:");
        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfo();
            }
        }
    }
}

class Employee {
    private final String fullName;
    private final String position;
    private final String email;
    private final String phone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;

        // Проверки с установкой значений по умолчанию при невалидных данных
        this.salary = salary > 0 ? salary : 30000; // если зарплата <= 0, ставим 30000
        this.age = age >= 18 ? age : 18;          // если возраст < 18, ставим 18
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.printf("║ %-34s ║\n", "ФИО: " + fullName);
        System.out.println("╠════════════════════════════════════╣");
        System.out.printf("║ %-34s ║\n", "Должность: " + position);
        System.out.printf("║ %-34s ║\n", "Email: " + email);
        System.out.printf("║ %-34s ║\n", "Телефон: " + phone);
        System.out.printf("║ %-34s ║\n", "Зарплата: " + salary + " руб.");
        System.out.printf("║ %-34s ║\n", "Возраст: " + age + " лет");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println();
    }

    // Дополнительные методы для изменения зарплаты и возраста
    public void setSalary(int newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
        } else {
            System.out.println("Ошибка: зарплата должна быть положительной");
        }
    }

    public void setAge(int newAge) {
        if (newAge >= 18) {
            this.age = newAge;
        } else {
            System.out.println("Ошибка: возраст должен быть 18+");
        }
    }
}