package com.fairwaytech.euler.util

import org.junit.jupiter.api.Test

import static org.assertj.core.api.Assertions.assertThat

class EulerMathTest {

    def eulerMath = new EulerMath()

    @Test
    void itShouldGetPrimes() {
        def max = 2000000

        def start = System.currentTimeMillis()
        def result = eulerMath.getPrimes(max)
        def end = System.currentTimeMillis()

        println "Time: ${end - start} millis"

        def total = BigInteger.valueOf(0L)
        result.each {
            total += it
        }
        assert BigInteger.valueOf(142913828922L) == total
    }

    @Test
    void itShouldGetSpecialPyTriplet() {
        def start = System.currentTimeMillis()
        def product = eulerMath.getSpecialPyTripletProduct()
        println "Elapsed Time: ${System.currentTimeMillis() - start}"
        println product
    }

    @Test
    void itShouldGetLargestProduct() {
        def start = System.currentTimeMillis()
        println eulerMath.getLargestProduct()
        def end = System.currentTimeMillis()
        println "Time: ${end - start} millis"
    }

    @Test
    void itShouldFindLargestPalindromeProduct() {
        assertThat(eulerMath.largestPalindromeProduct()).isEqualTo(906609)
    }

    @Test
    void itShouldCheckIfNumberIsPalindrome() {
        assertThat(eulerMath.isPalindrome(1111)).isTrue()
        assertThat(eulerMath.isPalindrome(9009)).isTrue()
        assertThat(eulerMath.isPalindrome(9119)).isTrue()
        assertThat(eulerMath.isPalindrome(1234)).isFalse()

        assertThat(eulerMath.isPalindrome(9119L)).isTrue()
        assertThat(eulerMath.isPalindrome(1234L)).isFalse()

        assertThat(eulerMath.isPalindrome('9119')).isTrue()
        assertThat(eulerMath.isPalindrome('1234')).isFalse()

    }

    @Test
    void itShouldCalculateLargestPrimeNumber() {
        assertValue(eulerMath.largestPrimeFactor(2 as BigInteger), 2)
        assertValue(eulerMath.largestPrimeFactor(15 as BigInteger), 5)
        assertValue(eulerMath.largestPrimeFactor(1787866 as BigInteger), 893933)
        assertValue(eulerMath.largestPrimeFactor(600851475143 as BigInteger), 6857)
        assertThat(eulerMath.isPrime(6857)).isTrue()
    }

    @Test
    void itShouldCalculateGCD() {
        assertValue(eulerMath.gcd(8, 12), 4)
        assertValue(eulerMath.gcd(45, 54), 9)
        assertValue(eulerMath.gcd(270, 192), 6)
    }

    @Test
    void itShouldCalculateLCM() {
        assertValue(eulerMath.lcm(1, 2), 2)
        assertValue(eulerMath.lcm(2, 3), 6)
        assertValue(eulerMath.lcm(6, 4), 12)
        assertValue(eulerMath.lcm(12, 5), 60)
        assertValue(eulerMath.lcm(60, 6), 60)
        assertValue(eulerMath.lcm(60, 7), 420)
        assertValue(eulerMath.lcm(420, 8), 840)
        assertValue(eulerMath.lcm(840, 9), 2520)
        assertValue(eulerMath.lcm(2520, 10), 2520)
    }

    @Test
    void itShouldCalculateSmallestMultiple() {
        def list = (1..10).collect { it }
        assertValue(eulerMath.lcm(list), 2520)
        list = (1..20).collect { it }
        assertValue(eulerMath.lcm(list), "232792560")
    }

    @Test
    void itShouldSumSquareDiff() {
        assertValue(eulerMath.sumSquareDiff(10), 2640)
        assertValue(eulerMath.sumSquareDiff(100), "25164150")
    }

    @Test
    void itShouldCheckIsPrime() {
        assertThat(eulerMath.isPrime(0)).isFalse()
        assertThat(eulerMath.isPrime(1)).isFalse()
        assertThat(eulerMath.isPrime(2)).isTrue()
        assertThat(eulerMath.isPrime(3)).isTrue()
        assertThat(eulerMath.isPrime(4)).isFalse()
        assertThat(eulerMath.isPrime(5)).isTrue()
        assertThat(eulerMath.isPrime(6)).isFalse()
        assertThat(eulerMath.isPrime(7)).isTrue()
    }

    @Test
    void itShouldCalculatePrime() {
        assertValue(eulerMath.calculatePrime(6), 13)
        assertValue(eulerMath.calculatePrime(10001), 104743)
    }

    static void assertValue(BigInteger actual, def expected) {
        assertThat(actual).isEqualByComparingTo(expected as BigInteger)
    }
}
