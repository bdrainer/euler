package com.fairwaytech.euler.util

import org.junit.Test

import static org.assertj.core.api.Assertions.assertThat

class FibonacciTest {

    def fib = new Fibonacci()

    @Test
    void itShouldCalculateEvenSumCorrectly() {
        assertValue(fib.evenSum(0), 0)
        assertValue(fib.evenSum(1), 0)
        assertValue(fib.evenSum(2), 0)
        assertValue(fib.evenSum(3), 2)
        assertValue(fib.evenSum(5), 2)
        assertValue(fib.evenSum(8), 2)
        assertValue(fib.evenSum(9), 10)
        assertValue(fib.evenSum(13), 10)
        assertValue(fib.evenSum(21), 10)
        assertValue(fib.evenSum(34), 10)
        assertValue(fib.evenSum(55), 44)
        assertValue(fib.evenSum(89), 44)
        assertValue(fib.evenSum(144), 44)
        assertValue(fib.evenSum(233), 188)
        assertValue(fib.evenSum(4000000), 4613732)
    }

    @Test
    void fibberShouldCalculateCorrectly() {
        def fibber = new Fibonacci.Fibber()
        assertValue(fibber.fib, 1)
        fibber.next()
        assertValue(fibber.fib, 1)
        fibber.next()
        assertValue(fibber.fib, 2)
        fibber.next()
        assertValue(fibber.fib, 3)
        fibber.next()
        assertValue(fibber.fib, 5)
        fibber.next()
        assertValue(fibber.fib, 8)
        fibber.next()
        assertValue(fibber.fib, 13)
    }

    @Test
    void itShouldCalculateCorrectly() {
        assertValue(fib.calculate(1), 1)
        assertValue(fib.calculate(2), 1)
        assertValue(fib.calculate(3), 2)
        assertValue(fib.calculate(4), 3)
        assertValue(fib.calculate(5), 5)
        assertValue(fib.calculate(6), 8)
        assertValue(fib.calculate(7), 13)
        assertValue(fib.calculate(8), 21)
        assertValue(fib.calculate(9), 34)
        assertValue(fib.calculate(10), 55)
        assertValue(fib.calculate(11), 89)
        assertValue(fib.calculate(12), 144)
        assertValue(fib.calculate(13), 233)
        assertValue(fib.calculate(100), "354224848179261915075")
        // over 600 stackoverflow starts
        assertValue(fib.calculate(500), "139423224561697880139724382870407283950070256587697307264108962948325571622863290691557658876222521294125")
    }

    void assertValue(BigInteger actual, def expected) {
        assertThat(actual).isEqualByComparingTo(new BigInteger(expected))
    }

}
