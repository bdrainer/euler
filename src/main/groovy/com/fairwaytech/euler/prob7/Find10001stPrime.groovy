package com.fairwaytech.euler.prob7

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Problem #7 - 10001st Prime
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10001st prime number?
 */
@RestController
class Find10001stPrime {

    @GetMapping("/nthprime/{nth}")
    def getNthPrime(@PathVariable long nth) {
        return calculate(nth)
    }

    /* returns the nth prime number */
    long calculate(long n) {
        int numberOfPrimes = 0
        long prime = 1
        while (numberOfPrimes < n) {
            prime++
            if (isPrime(prime)) {
                numberOfPrimes++
            }
        }
        return prime
    }

    /* returns true if parameter n is a prime number, false if composite or neither */
    boolean isPrime(long n) {
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

