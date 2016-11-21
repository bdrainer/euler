package com.fairwaytech.euler.util

import org.springframework.stereotype.Component


@Component
class EulerMath {

    BigInteger gcd(BigInteger a, BigInteger b) {
        if (b == 0) return a
        return gcd(b, a % b)
    }

    BigInteger lcm(BigInteger a, BigInteger b) {
        return a * b / gcd(a, b)
    }

    BigInteger lcm(List<BigInteger> input) {
        BigInteger result = input[0]
        for (BigInteger i = 1; i < input.size(); i++) {
            result = lcm(result, input[i])
        }
        return result
    }

    def sumSquareDiff(int maxValue) {
        def sum = BigInteger.ZERO, sumOfSqr = BigInteger.ZERO

        (1..maxValue).each() {
            sum = sum.add(BigInteger.valueOf(it))
            sumOfSqr = sumOfSqr.add(BigInteger.valueOf(it * it))
        }

        def sumSqr = sum.multiply(sum)
        return sumSqr.subtract(sumOfSqr)
    }

    BigInteger calculatePrime(BigInteger n) {
        BigInteger numberOfPrimes = 0, prime = 1
        while (numberOfPrimes < n) {
            ++prime
            if (isPrime(prime)) {
                ++numberOfPrimes
            }
        }
        return prime
    }

    boolean isPrime(BigInteger n) {
        if (n < 2) {
            return false
        } else if (n == 2) {
            return true
        }

        for (int i = 2; i < Math.pow(n, 0.5) + 1; i++) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }

}
