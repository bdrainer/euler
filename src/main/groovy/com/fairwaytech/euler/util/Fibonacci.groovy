package com.fairwaytech.euler.util

import org.springframework.stereotype.Component

@Component
class Fibonacci {

    BigInteger calculate(int term) {
        def mem
        def fib = { n -> n < 2 ? n : mem(n - 1) + mem(n - 2) }
        mem = fib.memoize()
        return fib(term)
    }

    BigInteger evenSum(BigInteger limit) {
        def fibber = new Fibber()
        def sum = new BigInteger(0)

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
            (old, fib) = [fib, fib+old]
            ++term
        }
    }
}
