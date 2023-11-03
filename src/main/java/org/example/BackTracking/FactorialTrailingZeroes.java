package org.example.BackTracking;

public class FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        Long resFactorial= 1L;
        resFactorial = getTheFactorial(resFactorial, n);
        String resStringFactorial= resFactorial + "";

        int res = 0;
        for (int i = resStringFactorial.length() - 1; i >= 0; i--) {
            if (resStringFactorial.charAt(i) != '0') {
                break;
            }
            res++;
        }
        return res;
    }

    public static Long getTheFactorial(Long resFactorial, int factorialIter) {
        if (factorialIter == 1) {
            return resFactorial;
        }
        resFactorial = resFactorial * factorialIter;
        factorialIter--;
        return getTheFactorial(resFactorial, factorialIter);
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(13));
    }

}
