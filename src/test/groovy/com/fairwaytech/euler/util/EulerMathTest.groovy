package com.fairwaytech.euler.util

import org.junit.Test

import static org.assertj.core.api.Assertions.assertThat


class EulerMathTest {

    def eulerMath = new EulerMath();

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

    void assertValue(BigInteger actual, def expected) {
        assertThat(actual).isEqualByComparingTo(new BigInteger(expected))
    }
}
