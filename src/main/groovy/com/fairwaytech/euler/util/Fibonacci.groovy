package com.fairwaytech.euler.util

import org.springframework.stereotype.Component

@Component
class Fibonacci {

    BigInteger calculate(int term) {
        calculate(term as BigInteger)
    }

    /**
     * Uses Groovy's built in "memoize" to increase performance, but the method suffers
     * from stackoverflow when the term is somewhere over 600.
     *
     * @param term
     * @return
     */
    BigInteger calculate(BigInteger term) {
        def mem
        def fib = { n -> n < 2 ? n : mem(n - 1) + mem(n - 2) }
        mem = fib.memoize()
        fib(term) as BigInteger
    }

    BigInteger evenSum(int limit) {
        evenSum(limit as BigInteger)
    }
    /**
     * Calculates the sum of the even Fibonacci values up to but excluding the limit argument.
     *
     * @param limit
     * @return
     */
    BigInteger evenSum(BigInteger limit) {
        def fibber = new Fibber()
        BigInteger sum = BigInteger.ZERO

        // while limit > fibber.fib
        while (limit <=> fibber.fib == BigInteger.ONE) {
            if (fibber.fib % 2 == 0) {
                sum += fibber.fib
            }
            fibber.next()
        }
        sum
    }

    static class Fibber {
        BigInteger old = 0, fib = 1, term = 1

        def next() {
            // multiple assignments
            (old, fib) = [fib, fib + old]
            ++term
        }
    }
}
