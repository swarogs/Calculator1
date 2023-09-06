import java.io.IOException;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите арифметичский пример 2+2 или II+II");
        String input = in.next();
        String znak = input.replaceAll("[^-+/*]", "");
        String chislo1;
        String chislo2;
        int result;
        int[] chisla ;
        try {
            proverkaOperatii(input);

        String[] directoryfinal = input.split("[-+/*]");

        chislo1 = directoryfinal[0];
        chislo2 = directoryfinal[1];
            chisla = proverkaRaznihchisel(chislo1, chislo2);

        if(chisla[2]==2){
            chisla[0] = romanToNumber(chislo1);
            chisla[1] = romanToNumber(chislo2);
            result=calculated(chisla[0], chisla[1], znak);
                proverkaOshibkaSystemChisel(result);
            String resultRoman = convertNumToRoman(result);
            System.out.println(resultRoman);
        }else {
            result = calculated(chisla[0], chisla[1], znak);
            System.out.println(result);

        }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
        private static String convertNumToRoman (int numArabian) {
            String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                    "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                    "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                    "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
            };
            return roman[numArabian];
    }


    private static int romanToNumber (String roman) throws IOException {
        switch (roman){
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default: throw new IOException("Ошибка. Неизвестная система исчесления");
        }
    }
    private static int calculated (int num1, int num2, String op) {
        int result = 0;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }
    public static int[] proverkaRaznihchisel(String chislo1, String chislo2) throws IOException {
        int[] chisla = new int[3];
        try {
            chisla[0] = Integer.parseInt(chislo1);
        } catch (NumberFormatException e) {
            chisla[2] += 1;
        }
        try {
            chisla[1] = Integer.parseInt(chislo2);
        } catch (NumberFormatException e) {
            chisla[2] += 1;
        }
        if(chisla[2]==1){
            throw new IOException("Ошибка. Используются одновременно разные системы счисления");
        }
        if((chisla[0]>10)||(chisla[1]>10)){
            throw new IOException("Ошибка. Одно или несколько чисел больше 10");
        }
        return chisla;
    }
    public static void proverkaOshibkaSystemChisel(int result) throws IOException {
        if (result<1){
            throw new IOException("Ошибка. в римской системе нет отрицательных чисел и нуля");
        }
    }
    public static void proverkaOperatii(String input) throws IOException{
        String znak = input.replaceAll("[^-+/*]", "");
        if (znak.isEmpty()){
            throw new IOException("Ошибка.строка не является математической операцией");
        }
        if (znak.length() != 1 ) {
            throw new IOException("Ошибка. Формат математической операции не удовлетворяет заданию - два " +
                    "операнда и один оператор (+, -, /, *)");
        }

    }
    }