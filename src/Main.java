import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    /** Task 1
     * Реализуйте метод, который получает в качестве параметра год, а затем проверяет, является ли он високосным, и выводит результат в консоль.
     * Теперь проверку нужно обернуть в метод и использовать год, который приходит в виде параметра.
     * Результат программы выведите в консоль. Если год високосный, то должно быть выведено “номер года — високосный год”.
     * Если год не високосный, то, соответственно: “номер года — не високосный год”.
     */
    private static void task1() {
        System.out.println("Task 1");
        int year = 2022;
        String yearStatus = checkYear(year);
        printStatus(year, yearStatus);
        System.out.println();
    }

    private static void printStatus(int year, String yearStatus) {
        System.out.println(year + " - " + yearStatus);
    }

    private static String checkYear(int year) {
        boolean divisionBy4 = year % 4 == 0;
        boolean divisionBy100 = year % 100 == 0;
        boolean divisionBy400 = year % 400 == 0;

        if (!divisionBy100 && divisionBy4 || divisionBy400) {
            return "високосный год";
        }
        return "не високосный год";
    }

    /** Task 2
     * Вспомним задание 2 по условным операторам, где нам необходимо было предложить пользователю облегченную версию приложения.
     * Напишите метод, куда подаются два параметра: тип операционной системы (ОС) ( 0 — iOS или 1 — Android) и год выпуска устройства.
     * Если устройство старше текущего года, предложите ему установить lite-версию (облегченную версию).
     * Текущий год можно получить таким способом:
     *      int currentYear = LocalDate.now().getYear();
     * Или самим задать значение вручную, введя в переменную числовое значение.
     * В результате программа должна выводить в консоль в зависимости от исходных данных, какую версию приложения (обычную или lite)
     * и для какой ОС (Android или iOS) нужно установить пользователю.
     */
    private static void task2() {
        System.out.println("Task 2");
        int osType = 1; // 0 - iOS, 1 - Android
        int yearOfManufacture = 2015;
        String osName = getOsName(osType);
        String message = getMessage(osName, yearOfManufacture);
        System.out.println(message);
        System.out.println();
    }

    private static String getOsName(int osType) {
        if (osType == 0) {
            return "iOS";
        } else if (osType == 1) {
            return "Android";
        }
        return "error";
    }

    private static String getMessage(String osName, int yearOfManufacture) {
        if (osName.equals("error")) {
            return "Ваше устройство не поддерживается";
        }
        int currentYear = LocalDate.now().getYear();
        if (yearOfManufacture >= currentYear) {
            return "Установите версию приложения для " + osName + " по ссылке";
        }
        return "Установите облегченную версию приложения для " + osName + " по ссылке";
    }

    /** Task 3
     * Возвращаемся к любимой многими задаче на расчет дней доставки банковской карты от банка.
     * Наша задача — доработать код, а именно написать метод, который на вход принимает дистанцию и возвращает итоговое
     *      количество дней доставки.
     */
    private static void task3() {
        System.out.println("Task 3");
        int deliveryDistance = 90;
        int requiredNumberOfDays = getRequiredNumberOfDays(deliveryDistance);
        System.out.println("Потребуется дней: " + requiredNumberOfDays);
        System.out.println();
    }

    private static int getRequiredNumberOfDays(int deliveryDistance) {
        int deliveryDays = 0;
        int minDistance = 20;
        int stepDistance = 40;
        if (deliveryDistance < 0 || deliveryDistance > 20000) {
            throw new RuntimeException("Неправильно указано расстояние");
        }
        deliveryDays = (int) Math.ceil((deliveryDistance + minDistance - 1) / stepDistance) + 1;
        return deliveryDays;
    }

}