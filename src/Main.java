import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Инициализация переменных всех типов
        byte byteVar = 120;
        short shortVar = -25000;
        int intVar = 2_000_000_000;
        long longVar = 9_000_000_000_000L;
        float floatVar = 3.1415f;
        double doubleVar = 2.71828;
        char charVar = 'Ї';
        boolean boolVar = true;
        String stringVar = "Привет";

        // Вызов остальных задач
        task_2();
        task_3();
        task_4();
        task_5();
    }

    // 2. Приветствие пользователя
    private static void task_2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите ваше имя: ");
        String name = scanner.nextLine();
        System.out.println("Привет, " + name + "!");
    }

    // 3. Проверка числа на отрицательность
    private static void task_3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите число для проверки: ");
        int number = scanner.nextInt();
        System.out.println("Результат: " + (number < 0));
    }

    // 4. Определение знака числа
    private static void task_4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите число для проверки знака: ");
        int number = scanner.nextInt();

        if (number > 0) {
            System.out.println("Результат: положительное");
        } else if (number < 0) {
            System.out.println("Результат: отрицательное");
        } else {
            System.out.println("Результат: ноль");
        }
    }

    // 5. Числа кратные 3
    private static void task_5() {
        System.out.println("\nЧисла от 1000 до 0, кратные 3:");
        for (int i = 1000; i >= 0; i--) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");
    }
}