package com.bwg.euler.prob5

import com.bwg.euler.util.EulerMath
import groovy.time.TimeCategory
import groovy.util.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * Problem 5 - Smallest Multiple
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * Answer: 232792560
 */
@Log
@RestController
class SmallestMultiple {

    private static final int MAX_VALUE = 20

    @Autowired
    EulerMath eulerMath

    @GetMapping("/smallestmultiple")
    def calculate() {
        def start = new Date()
        log.info"Problem 5: Finding the smallest positive number that is evenly divisible by all of the numbers from 1 to 20"
        def rangeList = (1..MAX_VALUE).collect { it }
        def lcm = eulerMath.lcm(rangeList as List<BigInteger>)
        log.info "Problem 5 execution time: ${TimeCategory.minus(new Date(), start)}"
        Mono.just lcm
    }
}
