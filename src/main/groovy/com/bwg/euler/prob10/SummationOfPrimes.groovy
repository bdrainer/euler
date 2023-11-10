package com.bwg.euler.prob10

import com.bwg.euler.util.EulerMath
import groovy.time.TimeCategory
import groovy.util.logging.Log
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
 * Answer: 142913828922
 */
@Log
@RestController
class SummationOfPrimes {

    @Autowired
    EulerMath eulerMath

    @GetMapping("/summationofprimes")
    def get() {
        def start = new Date()

        def max = 2000000

        def result = eulerMath.getPrimes(max)

        def total = BigInteger.ZERO
        result.each {
            total += it
        }

        log.info "Problem 10 execution time: ${TimeCategory.minus(new Date(), start)}"

        Mono.just total
    }

}

