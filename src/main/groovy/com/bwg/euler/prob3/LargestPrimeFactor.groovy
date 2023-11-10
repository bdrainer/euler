package com.bwg.euler.prob3

import com.bwg.euler.util.EulerMath
import groovy.time.TimeCategory
import groovy.util.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * Problem 3 - Largest Prime Factor
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 *
 * Answer: 6857
 */
@Log
@RestController
class LargestPrimeFactor {

    @Autowired
    EulerMath eulerMath

    @GetMapping("/largestprimefactor/{value}")
    def getNthPrime(@PathVariable BigInteger value) {
        def start = new Date()
        def factor = eulerMath.largestPrimeFactor(value)
        log.info "Problem 3 execution time: ${TimeCategory.minus(new Date(), start)}"
        Mono.just factor

    }
}
