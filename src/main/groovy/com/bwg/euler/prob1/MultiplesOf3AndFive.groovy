package com.bwg.euler.prob1


import groovy.time.TimeCategory
import groovy.util.logging.Log
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * Problem 1 - Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * Answer: 233168
 */
@Log
@RestController
class MultiplesOf3AndFive {

    final static MAX_VALUE = 1000 as BigInteger

    @GetMapping("/multiplesof3and5")
    def calculate() {
        def start = new Date()
        log.info"Problem 1: Finding the sum of all the multiples of 3 or 5 below $MAX_VALUE"
        int val = 0
        (1..<MAX_VALUE).each {val += (it % 3 == 0 || it % 5 == 0) ? it : 0 }
        log.info "Problem 1 execution time: ${TimeCategory.minus(new Date(), start)}"
        Mono.just val
    }
}
