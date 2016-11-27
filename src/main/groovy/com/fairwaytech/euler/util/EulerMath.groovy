package com.fairwaytech.euler.util

import org.springframework.stereotype.Component

import static java.lang.String.valueOf
import static org.codehaus.groovy.runtime.StringGroovyMethods.reverse

@Component
class EulerMath {

    /**
     * In mathematics, the greatest common divisor (gcd) of two or more integers, when at least one of them is not
     * zero, is the largest positive integer that divides the numbers without a remainder. For example, the GCD
     * of 8 and 12 is 4.
     */
    BigInteger gcd(BigInteger a, BigInteger b) {
        if (b == 0) return a
        return gcd(b, a % b)
    }

    /**
     * A common multiple is a number that is a multiple of two or more numbers. The common multiples of
     * 3 and 4 are 0, 12, 24, .... The least common multiple (LCM) of two numbers is the smallest
     * number (not zero) that is a multiple of both.
     */
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

    BigInteger largestPrimeFactor(BigInteger number) {
        BigInteger i
        BigInteger copyOfInput = number
        for (i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                copyOfInput /= i
                --i
            }
        }
        return i;
    }

    def largestPalindromeProduct() {
        def result
        (999..100).each {
            def x = it
            (it..100).each { y ->
                def check = x * y
                if (isPalindrome(check)) {
                    if (check > result) {
                        println "$x times $y = $check"
                        result = check
                    }
                }
            }
        }
        return result
    }

    boolean isPalindrome(def value) {
        def valueString = valueOf(value)
        def reverse = reverse(valueString)
        return valueString.equals(reverse)
    }
}
