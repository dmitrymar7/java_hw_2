import ex7.Celsius;
import ex7.TemperatureUnit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ex1();
        //ex2();
        //ex3();
        //ex4();
        //ex5();
        //ex6();
        //ex7();
    }

    /**
     * Процедура: Дана последовательность N целых чисел. Найти количество положительных чисел,
     * после которых следует отрицательное число
     */
    public static void ex1(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество членов последовательности: ");
        int n = scanner.nextInt();
        int current;
        int prev = 0, count = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Введите число: ");
            if (i == 0){
                prev = scanner.nextInt();
                continue;
            }
            current = scanner.nextInt();
            if (prev > 0 && current < 0){
                count++;
            }
            prev = current;

        }

        scanner.close();
        System.out.println(count);

    }

    /**
     * Процедура: Дана последовательность целых чисел, оканчивающаяся нулем. Найти сумму положительных чисел,
     * после которых следует отрицательное число
     */
    public static void ex2(){

        Scanner scanner = new Scanner(System.in);

        int current, prev;
        int count = 0;
        System.out.println("Введите число: ");
        prev = scanner.nextInt();
        if (prev == 0){
            System.out.println(count);
            return;
        }
        while (true){
            System.out.println("Введите число: ");
            current = scanner.nextInt();
            if (current == 0){
                break;
            }
            if (prev > 0 && current < 0){
                count++;
            }
            prev = current;
        }

        scanner.close();
        System.out.println(count);
    }

    /**
     * Процедура: Дана последовательность N целых чисел. Найти сумму простых чисел.
     */
    public static void ex3(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество членов последовательности: ");
        int n = scanner.nextInt();
        int current;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Введите число: ");
            current = scanner.nextInt();
            if (isSimple(current)){
                sum += current;
            }
        }

        scanner.close();
        System.out.println(sum);
    }

    /**
     * Функция проверки числа на простоту
     * @param - число для проверки
     * @return простое число или нет
     */
    public static boolean isSimple(int num){
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0){
                return false;
            }        }
        return true;
    }

    /**
     * Процедура: Дана последовательность из N целых чисел. Верно ли, что последовательность является возрастающей.
     */
    public static void ex4(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество членов последовательности: ");
        int n = scanner.nextInt();
        int current;
        int prev = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            System.out.println("Введите число: ");
            if (i == 0) {
                prev = scanner.nextInt();
                continue;
            }
            current = scanner.nextInt();
            if (current < prev) {
                flag = false;
            }

        }

        scanner.close();
        if (flag) {
            System.out.println("Последовательность возрастает");
        } else {
            System.out.println("Последовательность не возрастает");
        }

    }

    /**
     * Процедура: Дан массив целых чисел. Найти сумму элементов, у которых последняя и предпоследняя цифры равны.
     */
    static void ex5(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов в массиве: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int current : array){
            if (current < 10){
                continue;
            }
            int penultDigit = current / 10 % 10;
            int lastDigit = current % 10;
            if (penultDigit == lastDigit){
                sum += current;
            }        }

        scanner.close();
        System.out.println("Массив: " + Arrays.toString(array));
        System.out.println("Сумма равна: " + sum);

    }

    /**
     * Процедура: Дан массив целых чисел. Заменить отрицательные элементы на сумму индексов двузначных элементов массива.
     */
    static void ex6(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов в массиве: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            if (array[i] > 9 && array[i] < 100){
                sum += i;
            }
        }

        System.out.println("Исходный массив: " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0){
                array[i] = sum;
            }
        }

        scanner.close();
        System.out.println("Массив после преобразований: " + Arrays.toString(array));

    }

    /**
     * Процедура: апишите интерфейс Converter для конвертации из градусов по Цельсию в
     * Кельвины, Фаренгейты. У классов наследников необходимо переопределить метод интерфейса,
     * для валидного перевода величин. Метод для конвертации назовите "convertValue".
     */
    public static void ex7(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите температуру в градусах по Цельсию");
        double tempCelsius = scanner.nextDouble();
        Celsius celsius = new Celsius(tempCelsius);

        System.out.println("Выберите в какую систему хотите перевести\n 1. В градусы по Кельвину \n 2. В градусы по Фаренгейту");
        int unitNum = scanner.nextInt();
        scanner.close();

        if (unitNum == 1){
            double res = celsius.convertValue(TemperatureUnit.KELVIN);
            System.out.println("Температура по Кельвину: " + res);
            return;
        }else if (unitNum == 2){
            double res = celsius.convertValue(TemperatureUnit.FAHRENHEIT);
            System.out.println("Температура по Фаренгейту: " + res);
            return;
        }
    }

}
