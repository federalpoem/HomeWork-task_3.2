public class Main {
    public static void main(String[] args) {
        // Создаем объекты классов Cat и Dog
        Cat catMurzik = new Cat("Мурзик");
        Dog dogBobik = new Dog("Бобик");
        Cat catBarsik = new Cat("Барсик"); // Добавим еще одного кота для демонстрации счетчика

        // Демонстрация работы методов run и swim для кота
        catMurzik.run(150);
        catMurzik.run(250);
        catMurzik.swim(5);

        // Демонстрация работы методов run и swim для собаки
        dogBobik.run(300);
        dogBobik.run(600);
        dogBobik.swim(5);
        dogBobik.swim(15);

        // Вывод статистики созданных животных
        System.out.println("\nСтатистика:");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
    }
}

// Базовый класс Animal для всех животных
abstract class Animal {
    private static int animalCount = 0; // Счетчик созданных животных

    protected final String name;
    protected final int runLimit;
    protected final int swimLimit;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalCount++;
    }

    // Метод для бега
    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. (лимит " + runLimit + " м.)");
        }
    }

    // Метод для плавания
    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " не умеет плавать.");
        } else if (distance <= swimLimit) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. (лимит " + swimLimit + " м.)");
        }
    }

    // Геттер для счетчика животных
    public static int getAnimalCount() {
        return animalCount;
    }
}

// Класс Cat наследуется от Animal
class Cat extends Animal {
    private static int catCount = 0; // Счетчик созданных котов

    public Cat(String name) {
        super(name, 200, 0);
        catCount++;
    }

    // Геттер для счетчика котов
    public static int getCatCount() {
        return catCount;
    }
}

// Класс Dog наследуется от Animal
class Dog extends Animal {
    private static int dogCount = 0; // Счетчик созданных собак

    public Dog(String name) {
        super(name, 500, 10);
        dogCount++;
    }

    // Геттер для счетчика собак
    public static int getDogCount() {
        return dogCount;
    }
}