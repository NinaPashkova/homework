package com.company.homework2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String commandLine = enterNumbers();
        maxMinLength(commandLine);
        sortedInAscendingOrder(commandLine);
        sortedInDescendingOrder(commandLine);
        numbersWhichLengthLongerMidlength(commandLine);
        numbersWithSameDigits(commandLine);
        onlyEvenDigits(commandLine);
        equalAmountOfEvenandOddDigits(commandLine);
        digitsSortedInAscendingOrder(commandLine);
        numberOnlyWithDifferentDigits(commandLine);
        enterMatrix();
        int[][] twoDimArray = buildMatrixWithRandomNumbers();
        sortedMatrix(twoDimArray);
        shiftMatrix(twoDimArray);
        amountOfIncreasingAndDecreasingElements(twoDimArray);
        sumOfElementsBetweenFirstAndSecondPositiveElement(twoDimArray);
        rotateMatrix(twoDimArray);
        buildNewMatrixMinusAverageOfRowElements(twoDimArray);
        matrixWithoutZeroRowsAndColumns(twoDimArray);
        moveZeroToEnd(twoDimArray);


    }

    public static String enterNumbers() {
        System.out.println("Enter numbers: ");
        Scanner sc = new Scanner(System.in);
        String commandLine = sc.nextLine();
        return commandLine;
    }

    // task 1 Найти самое короткое и самое длинное число. Вывести найденные числа и их длину

    public static void maxMinLength(String commandLine) {
        String[] numbersLine = commandLine.trim().split(" ");
        int maxNumber = numbersLine[0].length();
        int minNumber = numbersLine[0].length();
        String lNumber = numbersLine[0];
        String sNumber = numbersLine[0];
        for (int i = 0; i < numbersLine.length; i++) {
            if (numbersLine[i].length() >= maxNumber) {
                maxNumber = numbersLine[i].length();
                lNumber = numbersLine[i] + " ";
            } else if (numbersLine[i].length() <= minNumber) {
                minNumber = numbersLine[i].length();
                sNumber = numbersLine[i] + " ";
            }
        }
        System.out.println("The longest number: " + lNumber + " Length: " + maxNumber);
        System.out.println("The shortest number : " + sNumber + " Length: " + minNumber);
    }

    //task 2 Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины

    public static void sortedInAscendingOrder(String commandLine) {
        String[] numbersLine = commandLine.trim().split(" ");
        for (int i = numbersLine.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbersLine[j].length() > numbersLine[j + 1].length()) {
                    String tmp = numbersLine[j];
                    numbersLine[j] = numbersLine[j + 1];
                    numbersLine[j + 1] = tmp;
                }
            }
        }
        String numbers = "";
        for (int i = 0; i < numbersLine.length; i++) {
            numbers += numbersLine[i] + " ";
        }
        System.out.println("Numbers sorted by length in ascending order: " + numbers);
    }

    public static void sortedInDescendingOrder(String commandLine) {
        String[] numbersLine = commandLine.trim().split(" ");
        for (int i = 0; i < numbersLine.length - 1; i++) {
            for (int j = 0; j < numbersLine.length - i - 1; j++) {
                if (numbersLine[j].length() < numbersLine[j + 1].length()) {
                    String tmp = numbersLine[j];
                    numbersLine[j] = numbersLine[j + 1];
                    numbersLine[j + 1] = tmp;
                }
            }
        }
        String numbers = "";
        for (int i = 0; i < numbersLine.length; i++) {
            numbers += numbersLine[i] + " ";
        }
        System.out.println("Numbers sorted in length descending order: " + numbers);
    }

    // task 3 Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину

    public static void numbersWhichLengthLongerMidlength(String commandLine) {
        String[] numbersLine = commandLine.trim().split(" ");
        int sumLength = 0;
        String numWithShortLength = "";
        String numWithLongLength = "";
        String numLengthForLong = "";
        String numLengthForShort = "";
        for (int i = 0; i < numbersLine.length; i++) {
            sumLength += numbersLine[i].length();
        }
        double midLengthDouble = (double)sumLength / (double)numbersLine.length;
        long midLength = Math.round(midLengthDouble);
        for (int i = 0; i < numbersLine.length; i++) {
            if (numbersLine[i].length() > midLength) {
                numWithLongLength += numbersLine[i] + " ";
                numLengthForLong += numbersLine[i].length() + " ";
            } else if(numbersLine[i].length() < midLength){
                numWithShortLength += numbersLine[i] + " ";
                numLengthForShort += numbersLine[i].length() + " ";
            }
        }
        System.out.println("Numbers which length longer than midlength: " + numWithLongLength + " length: " + numLengthForLong  );
        System.out.println("Numbers which length shorter than midlength: " + numWithShortLength + " length: " + numLengthForShort );
    }

    // task 4 Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них

    public static void numbersWithSameDigits(String commandLine) {
        String[] numbersLine = commandLine.trim().split(" ");
        int[] numberMatches = new int[numbersLine.length];
        int maxSameNumbersIndex = 0;

        for (int i = 0; i < numbersLine.length; i++) {
            String currentNumber = numbersLine[i];
            int differentNumbers = currentNumber.length();
            String[] currentNumberArr = currentNumber.trim().split("");
            int[] checkedNumbers = new int[0];
            for (int j = 0; j < currentNumberArr.length; j++) {
                if(!isNumberAlreadyChecked(checkedNumbers, Integer.parseInt(currentNumberArr[j]))) {
                    for (int k = j + 1; k < currentNumberArr.length; k++) {
                        if (currentNumberArr[j].equals(currentNumberArr[k])) {
                            differentNumbers--;
                        }
                    }
                    int[] tempArray = new int[checkedNumbers.length+1];
                    System.arraycopy(checkedNumbers, 0, tempArray, 0, checkedNumbers.length);
                    tempArray[tempArray.length-1] = Integer.parseInt(currentNumberArr[j]);
                    checkedNumbers = tempArray;
                }
            }
            numberMatches[i] = differentNumbers;
        }

        int maxSameNumbers = 0;
        for (int i = 0; i < numberMatches.length; i++) {
            if (numbersLine[i].length()-numberMatches[i] > maxSameNumbers) {
                maxSameNumbersIndex = i;
                maxSameNumbers = numbersLine[i].length()-numberMatches[i];
            }
        }
        System.out.println("Number which contains minimumum different numbers: " + numbersLine[maxSameNumbersIndex]);
    }
    private static boolean isNumberAlreadyChecked(int[] checkedNumbers, int currentNumber) {
        for (int checkedNumber : checkedNumbers) {
            if (checkedNumber == currentNumber) {
                return true;
            }
        }
        return false;
    }

//task 5 Найти количество чисел, содержащих только четные цифры, а среди них количество чисел с равным числом четных и нечетных цифр

    public static void onlyEvenDigits(String commandLine) {
        String[] numbersLine = commandLine.trim().split(" ");
        int evenNumbers = 0;
        for (int i = 0; i < numbersLine.length; i++) {
            String currentNumber = numbersLine[i];
            String[] currentNumberSplited = currentNumber.trim().split("");
            int[] currentNumberArr = new int[currentNumber.length()];
            for (int j = 0; j < currentNumber.length(); j++) {
                currentNumberArr[j] = Integer.parseInt(currentNumberSplited[j]);
            }
            int evenDigits = 0;
            for (int k = 0; k < currentNumberArr.length; k++) {

                if (currentNumberArr[k] % 2 == 0) {
                    evenDigits++;
                } else {
                    break;
                }
                if (evenDigits == currentNumberArr.length) {
                    evenNumbers++;
                }
            }
        }
        System.out.println("Amount of numbers which contain only even digits: " + evenNumbers);
    }

    public static void equalAmountOfEvenandOddDigits(String commandLine) {
        String[] numbersLine = commandLine.trim().split(" ");
        int equalNum = 0;
        int[] numbers = new int[numbersLine.length];
        for (int i = 0; i < numbersLine.length; i++) {
            numbers[i] = Integer.parseInt(numbersLine[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                String currentNumber = "";
                currentNumber += numbers[i];
                String[] currentNumberSplited = currentNumber.trim().split("");
                int[] currentNumberArr = new int[currentNumber.length()];
                for (int j = 0; j < currentNumber.length(); j++) {
                    currentNumberArr[j] = Integer.parseInt(currentNumberSplited[j]);
                }
                int evenDigits = 0;
                int oddDigits = 0;
                for (int k = 0; k < currentNumberArr.length; k++) {

                    if (currentNumberArr[k] % 2 == 0) {
                        evenDigits++;
                    } else if (currentNumberArr[k] % 2 != 0){
                        oddDigits++;
                    }
                }
                if (evenDigits == currentNumberArr.length / 2 && oddDigits == currentNumberArr.length / 2 ) {
                    equalNum++;
                }
            }
        }
        System.out.println("Amount of even numbers with equal amount of even and odd digits: " + equalNum);
    }

    // task 6 Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них

    public static void digitsSortedInAscendingOrder(String commandLine) {
        String[] numbersLine = commandLine.trim().split(" ");
        for (int i = 0; i < numbersLine.length; i++) {
            String currentNumber = numbersLine[i];
            String[] currentNumberSplited = currentNumber.trim().split("");
            int[] currentNumberArr = new int[currentNumber.length()];
            for (int j = 0; j < currentNumber.length(); j++) {
                currentNumberArr[j] = Integer.parseInt(currentNumberSplited[j]);
            }
            int counter = 0;
            for (int k = 0; k < currentNumberArr.length - 1; k++) {
                if (currentNumberArr[k] < currentNumberArr[k + 1]) {
                    counter++;
                } else {
                    break;
                }
            }
            if (counter == currentNumberArr.length - 1) {
                System.out.println("First number sorted in ascending order: " + numbersLine[i]);
                break;
            }
        }
    }

    // task 7 Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них

    public static void numberOnlyWithDifferentDigits(String commandLine) {
        String[] numbersLine = commandLine.trim().split(" ");
        for (int i = 0; i < numbersLine.length; i++) {
            String currentNumber = numbersLine[i];
            String[] currentNumberSplited = currentNumber.trim().split("");
            int[] currentNumberArr = new int[currentNumber.length()];
            for (int j = 0; j < currentNumber.length(); j++) {
                currentNumberArr[j] = Integer.parseInt(currentNumberSplited[j]);
            }
            int counter = 0;
            for (int k = 0; k < currentNumberArr.length - 1; k++) {
                if (currentNumberArr[k] != currentNumberArr[k + 1]) {
                    counter++;
                } else {
                    break;
                }
            }
            if (counter == currentNumberArr.length - 1) {
                System.out.println("First number only with different digits: " + numbersLine[i]);
                break;
            }
        }
    }

    // task 8 Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз

    private static void arraysPrint(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void enterMatrix() {
        System.out.println("Enter k, for building matrix which filled digits 1 to k : ");
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int k = sc.nextInt();
        double mSize = Math.sqrt(k);
        if (mSize % (int) mSize > 0) {
            mSize++;
        }
        int[][] matrix = new int[(int) mSize][(int) mSize];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(k) + 1;
            }
        }
        System.out.println("Matrix M x N filled digits 1 to k: ");
        arraysPrint(matrix);
    }

    // task 9 Ввести с консоли n-размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел

    public static int[][] buildMatrixWithRandomNumbers() {
        System.out.println("Enter n, where n it's matrix dimension a [n][n]:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Random random = new Random();
        int[][] twoDimArray = new int[n][n];
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                twoDimArray[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }
        System.out.println("Matrix filled by random numbers from: -n to n");
        arraysPrint(twoDimArray);
        return twoDimArray;
    }

    // task 9.1 Упорядочить строки (столбцы) матрицы в порядке возрастания значений

    public static void sortedMatrix(int[][] twoDimArray) {
        for (int k = 0; k < twoDimArray.length; k++) {
            for (int i = 0; i < twoDimArray.length; i++) {
                for (int j = 0; j < twoDimArray[i].length - 1; j++) {
                    if (twoDimArray[i][j] > twoDimArray[i][j + 1]) {
                        int tmp = twoDimArray[i][j];
                        twoDimArray[i][j] = twoDimArray[i][j + 1];
                        twoDimArray[i][j + 1] = tmp;
                    }
                }
            }
        }
        System.out.println("Matrix with sorted rows:");
        arraysPrint(twoDimArray);
        for (int k = 0; k < twoDimArray.length; k++) {
            for (int i = 0; i < twoDimArray.length; i++) {
                for (int j = 0; j < twoDimArray[i].length - 1; j++) {
                    if (twoDimArray[j][i] > twoDimArray[j + 1][i]) {
                        int tmp = twoDimArray[j][i];
                        twoDimArray[j][i] = twoDimArray[j + 1][i];
                        twoDimArray[j + 1][i] = tmp;
                    }
                }
            }
        }
        System.out.println("Matrix with sorted columns:");
        arraysPrint(twoDimArray);
    }

    // task 9.2 Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз)

    public static void shiftMatrix(int[][] twoDimArray) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter k, where k is number of matrix shift");
        int k = sc.nextInt();
        // right shift
        for (int step = 0; step < k; step++) {
            for (int i = 0; i < twoDimArray.length; i++) {
                int temp = twoDimArray[i][twoDimArray.length - 1];
                for (int j = twoDimArray[i].length - 1; j > 0; j--) {
                    twoDimArray[i][j] = twoDimArray[i][j - 1];
                }
                twoDimArray[i][0] = temp;
            }
        }
        System.out.println("Matrix shifted to right:");
        arraysPrint(twoDimArray);
        // left  shift
        for (int step = 0; step < k; step++) {
            for (int i = 0; i < twoDimArray.length; i++) {
                int temp = twoDimArray[i][0];
                for (int j = 0; j < twoDimArray[i].length - 1; j++) {
                    twoDimArray[i][j] = twoDimArray[i][j + 1];
                }
                twoDimArray[i][twoDimArray[i].length - 1] = temp;
            }
        }
        System.out.println("Matrix shifted to left:");
        arraysPrint(twoDimArray);
        // up shift
        for (int step = 0; step < k; step++) {
            int[] temp = new int[twoDimArray.length];
            for (int i = 0; i < twoDimArray.length; i++) {
                for (int j = 0; j < twoDimArray[i].length; j++) {
                    if (i == 0) {
                        temp[j] = twoDimArray[i][j];
                    }
                    if (i != twoDimArray.length - 1) {
                        twoDimArray[i][j] = twoDimArray[i + 1][j];
                    } else {
                        twoDimArray[i][j] = temp[j];
                    }
                }
            }
        }
        System.out.println("Matrix shifted to up:");
        arraysPrint(twoDimArray);
        // down shift
        for (int step = 0; step < k; step++) {
            int[] temp = new int[twoDimArray.length];
            for (int i = twoDimArray.length - 1; i >= 0; i--) {
                for (int j = 0; j < twoDimArray[i].length; j++) {
                    if (i == twoDimArray.length - 1) {
                        temp[j] = twoDimArray[i][j];
                    }
                    if (i != 0) {
                        twoDimArray[i][j] = twoDimArray[i - 1][j];
                    } else {
                        twoDimArray[i][j] = temp[j];
                    }
                }
            }
        }
        System.out.println("Matrix shifted to down:");
        arraysPrint(twoDimArray);
    }

    // task 9.3 Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд

    public static void amountOfIncreasingAndDecreasingElements(int[][] twoDimArray) {
        int incEli = 0;
        for (int i = 0; i < twoDimArray.length; i++) {
            int incElj = 1;
            for (int j = 0; j < twoDimArray[i].length - 1; j++) {
                if (twoDimArray[i][j + 1] > twoDimArray[i][j]) {
                    incElj++;
                }
            }
            if (incElj > incEli) {
                incEli = incElj;
            }
        }
        System.out.println("Amount of increasing elements: " + incEli);
        int decEli = 0;
        for (int i = 0; i < twoDimArray.length; i++) {
            int decElj = 1;
            for (int j = 0; j < twoDimArray[i].length - 1; j++) {
                if (twoDimArray[i][j + 1] < twoDimArray[i][j]) {
                    decElj++;
                }
            }
            if (decElj > decEli) {
                decEli = decElj;
            }
        }
        System.out.println("Amount of decreasing elements: " + decEli);
    }

    // task 9.4 Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки

    public static void sumOfElementsBetweenFirstAndSecondPositiveElement(int[][] twoDimArray) {
        for (int i = 0; i < twoDimArray.length; i++) {
            boolean firstFound = false;
            int firstPos = 0;
            int secondPos = 0;
            int sum = 0;
            for (int j = 0; j < twoDimArray[i].length - 1; j++) {
                if (twoDimArray[i][j] > 0 && !firstFound) {
                    firstPos = j;
                    firstFound = true;
                } else if (twoDimArray[i][j] > 0 && firstFound) {
                    secondPos = j;
                    break;
                }
            }
            if (firstPos == secondPos) {
                System.out.println("This row isn't contain 2 positive elements");
                continue;
            }
            for (int j = firstPos + 1; j < secondPos; j++) {
                sum += twoDimArray[i][j];
            }
            System.out.println("Sum of elements between first positive and second positive elements: "
                    + sum + " in row " + i);
        }
    }

    // task 9.5 Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки

    public static void rotateMatrix(int[][] twoDimArray) {
        int n = twoDimArray.length;
        twoDimArray = rotateMatrix(n, twoDimArray);
        System.out.println("Matrix rotated on 90");
        arraysPrint(twoDimArray);

        twoDimArray = rotateMatrix(n, twoDimArray);
        System.out.println("Matrix rotated on 180");
        arraysPrint(twoDimArray);

        twoDimArray = rotateMatrix(n, twoDimArray);
        System.out.println("Matrix rotated on 270");
        arraysPrint(twoDimArray);
    }

    private static int[][] rotateMatrix(int n, int[][] twoDimArray) {
        int[][] newArr = new int[n][n];
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                newArr[i][j] = twoDimArray[j][twoDimArray[i].length - 1 - i];
            }
        }
        return newArr;
    }

    // task 9.6 Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое

    public static void buildNewMatrixMinusAverageOfRowElements(int[][] twoDimArray) {
        for (int i = 0; i < twoDimArray.length; i++) {
            int sum = 0;
            for (int j = 0; j < twoDimArray[i].length; j++) {
                sum += twoDimArray[i][j];
                if (j == twoDimArray[i].length-1) {
                    int midSum = sum / twoDimArray[i].length;
                    for (int k = 0; k < twoDimArray[i].length; k++){
                        twoDimArray[i][k] = twoDimArray[i][k] - midSum;
                    }
                }
            }
        }
        System.out.println("New matrix minus average value: ");
        arraysPrint(twoDimArray);
    }

    // task 9.7 Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями

    public static void matrixWithoutZeroRowsAndColumns(int[][] twoDimArray) {
        int n = twoDimArray[0].length;
        int m = twoDimArray.length;
        for (int j = 1; j < twoDimArray.length; j++) {
            int counter = 0;
            for (int i = 0; i < twoDimArray.length; i++) {
                if (twoDimArray[i][twoDimArray[i].length - j] == 0) {
                    counter++;
                } else if (twoDimArray[i][twoDimArray[i].length - j] != 0) {
                    break;
                }
                if (counter == twoDimArray.length - 1) {
                    n--;
                }
            }
        }
        if (n < twoDimArray[0].length){
            for (int i = 0; i < twoDimArray.length; i++) {
                for (int j = 0; j < twoDimArray[i].length - 1; j++) {
                    if (twoDimArray[i][j] == 0) {
                        int nextValidValue = 0;
                        for (int k = j + 1; k < twoDimArray[i].length; k++) {
                            if (twoDimArray[i][k] != 0) {
                                nextValidValue = twoDimArray[i][k];
                                twoDimArray[i][k] = 0;
                                break;
                            }
                        }
                        twoDimArray[i][j] = nextValidValue;
                    }
                }
            }
        }
        for (int i = twoDimArray.length - 1; i > 0; i--) {
            int counter = 0;
            for (int j = 0; j < twoDimArray[i].length; j++) {

                if (twoDimArray[i][j] == 0) {
                    counter++;
                } else if (twoDimArray[i][j] != 0) {
                    break;
                }
                if (counter == twoDimArray[i].length - 1) {
                    m--;
                }
            }
        }
        if (m < twoDimArray.length){
            for (int j = 0; j < twoDimArray[0].length; j++) {
                for (int i = 0; i < twoDimArray.length; i++) {
                    if (twoDimArray[i][j] == 0) {
                        int nextValidValue = 0;
                        for (int k = i + 1; k < twoDimArray.length; k++) {
                            if (twoDimArray[k][j] != 0) {
                                nextValidValue = twoDimArray[k][j];
                                twoDimArray[k][j] = 0;
                                break;
                            }
                        }
                        twoDimArray[i][j] = nextValidValue;
                    }
                }
            }
        }
        int[][] newArr = new int[m][n];
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[i].length; j++) {
                newArr[i][j] = twoDimArray[i][j];

            }
        }
        System.out.println("Matrix without zero rows and columns:");
        arraysPrint(newArr);
    }

    // task 9.8 Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю, располагались после всех остальных

    public static void moveZeroToEnd(int[][] twoDimArray) {
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length - 1; j++) {
                if (twoDimArray[i][j] == 0) {
                    int nextValidValue = 0;
                    for (int k = j + 1; k < twoDimArray[i].length; k++) {
                        if (twoDimArray[i][k] != 0) {
                            nextValidValue = twoDimArray[i][k];
                            twoDimArray[i][k] = 0;
                            break;
                        }
                    }
                    twoDimArray[i][j] = nextValidValue;
                }
            }
        }
        System.out.println("Matrix with zero shifted to ends of rows");
        arraysPrint(twoDimArray);
    }
}
