package com.fairwaytech.euler.prob10

import com.fairwaytech.euler.util.EulerMath
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * Problem 10 - Summation of Primes
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 */
@RestController
class SummationOfPrimes {

    @Autowired
    EulerMath eulerMath

    @GetMapping("/summationofprimes")
    def get() {
        def start = System.currentTimeMillis()

        def max = 2000000

        def result = eulerMath.getPrimes(max)

        def total = BigInteger.valueOf(0L)
        result.each {
            total += it
        }

        println "Elapsed Time: ${(System.currentTimeMillis() - start) / 1000.0} seconds"

        Mono.just total
    }

}

