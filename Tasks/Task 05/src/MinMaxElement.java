public class MinMaxElement {
    public static void main(String[] args) {
        //инициализация массива
        int arr[] = {10, 13, 1, 34, 55, 10, 8, 9, 44, 100};
        // инициализация минимального и максимального значения
        int minValue = arr[0];
        int maxValue = arr[0];
        // поиск минимального и максимального
        for (int i = 1; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minValue = arr[i];
            }
            ;
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        // вывод найденных значений
        System.out.println("Минимальное значение: " + minValue);
        System.out.println("Максимальное значение: " + maxValue);
    }
}
