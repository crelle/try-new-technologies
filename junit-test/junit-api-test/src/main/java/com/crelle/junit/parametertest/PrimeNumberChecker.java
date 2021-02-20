package com.crelle.junit.parametertest;

/**
 * @author:crelle
 * @className:PrimeNumberChecker
 * @version:1.0.0
 * @date:2021/2/20
 * @description:XX
 **/
public class PrimeNumberChecker {
    public Boolean validate(final Integer primeNumber) {
        for (int i = 2; i < (primeNumber / 2); i++) {
            if (primeNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
