package ru.saubanova;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int threadsCount = scanner.nextInt();
        int numbersCount = scanner.nextInt();

        int array[]=new int[numbersCount];
        Random random = new Random();
        // TODO: генерируете массив чисел
        for (int i = 0; i < numbersCount; i++) {
            array[i]= random.nextInt(1000);
        }
        // TODO: выводите их сумму
        int sumResult=0;
        for (int i = 0; i <numbersCount ; i++) {
            sumResult+=array[i];
        }
        System.out.println("Сумма элементов массива: "+sumResult);
        // TODO: создаете массив потоков
        Counter counters[] = new Counter[threadsCount];
        int from =0;
        int countElements=numbersCount/threadsCount;
        for (int i = 0; i <threadsCount ; i++) {
            // TODO: каждому потоку назначете свой участок
            counters[i]=new Counter(from, Math.min(from + countElements,numbersCount-1), array);
            from+=countElements+1;
            // TODO: запускаете каждый поток
            counters[i].start();
        }
        for (int i = 0; i < threadsCount; i++) {
            counters[i].join();
        }

        sumResult=0;
        // TODO: здесь у каждого потока берете sumResult и складываете, смотрите результат.
        for (int i = 0; i < threadsCount; i++) {
            sumResult+=counters[i].getSumResult();
        }
        System.out.println("Сумма элементов массива в потоках: "+sumResult);
    }
}