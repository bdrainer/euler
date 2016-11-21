package com.fairwaytech.euler.util

import org.springframework.stereotype.Component

@Component
class Fibonacci {

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
        return fib(term)
    }

    /**
     * Calculates the sum of the even Fibonacci values up to but excluding the limit argument.
     *
     * @param limit
     * @return
     */
    BigInteger evenSum(BigInteger limit) {
        def fibber = new Fibber()
        def sum = new BigInteger(0)

        // while limit > fibber.fib
        while (limit.compareTo(fibber.fib) == 1) {
            if (fibber.fib % 2 == 0) {
                sum += fibber.fib
            }
            fibber.next()
        }

        return sum
    }

    static class Fibber {
        def BigInteger old = 0, fib = 1, term = 1

        def next() {
            // multiple assignments
            (old, fib) = [fib, fib + old]
            ++term
        }
    }
}
