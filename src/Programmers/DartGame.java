package Programmers;

import java.util.Scanner;

public class DartGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dartResult = scan.next();

        System.out.println(solution(dartResult));
    }

    public static int solution(String dartResult) {
        int[] resultArr = new int[3];

        int index = 0;
        int arrIndex = 0;

        while (index < dartResult.length()) {
            char t = dartResult.charAt(index);
            if (t == 'S' || t == 'D' || t == 'T') {
                int tempIndex = index - 1;
                while (tempIndex > 0) {
                    if (!(dartResult.charAt(tempIndex) >= '0' && dartResult.charAt(tempIndex) <= '9')) {
                        tempIndex++;
                        break;
                    }
                    tempIndex--;
                }
                String tempStr = dartResult.substring(tempIndex, index);
                resultArr[arrIndex] = Integer.parseInt(tempStr);

                if (t == 'D') {
                    resultArr[arrIndex] = (int) (Math.pow(resultArr[arrIndex], 2));
                } else if (t == 'T') {
                    resultArr[arrIndex] = (int) (Math.pow(resultArr[arrIndex], 3));
                }

                if (index + 1 < dartResult.length()) {
                    char next = dartResult.charAt(index + 1);
                    if (next == '*') {

                        if (arrIndex == 0) {
                            resultArr[arrIndex] *= 2;
                        } else {
                            resultArr[arrIndex - 1] *= 2;
                            resultArr[arrIndex] *= 2;
                        }

                        index++;
                    }
                    if (next == '#') {
                        resultArr[arrIndex] *= -1;

                        index++;
                    }
                }

                index++;
                arrIndex++;
            } else {
                index++;
            }
        }


        int result = 0;
        for (int i = 0; i < resultArr.length; i++) {
            result += resultArr[i];
        }

        return result;
    }
}
