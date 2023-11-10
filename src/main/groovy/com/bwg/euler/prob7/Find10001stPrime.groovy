package com.bwg.euler.prob7

import com.bwg.euler.util.EulerMath
import groovy.time.TimeCategory
import groovy.util.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * Problem 7 - 10001st Prime
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see the 6th prime is 13.
 *
 * What is the 10001st prime number?
 *
 * Answer: 104743
 */
@Log
@RestController
class Find10001stPrime {

    static final BigInteger N_TH = 10001

    @Autowired
    EulerMath eulerMath

    @GetMapping("/nthprime")
    def getNthPrime() {
        def start = new Date()
        log.info"Problem 7: Finding the 10001st prime number"
        def prime = eulerMath.calculatePrime(N_TH)
        log.info "Problem 7 execution time: ${TimeCategory.minus(new Date(), start)}"
        Mono.just prime
    }

}

