package com.bwg.euler.prob6

import com.bwg.euler.util.EulerMath
import groovy.time.TimeCategory
import groovy.util.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * Problem 6
 *
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 *
 * Hence the difference between the sum of the squares of the
 * first ten natural numbers and the square of the
 * sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the
 * first one hundred natural numbers and the square of the sum.
 *
 * Answer: 25164150
 */
@Log
@RestController
class SumSquareDiff {

    @Autowired
    EulerMath eulerMath

    @GetMapping("sumsquarediff")
    Mono<BigInteger> sumSquareDifference() {
        def start = new Date()
        log.info"Problem 6: Finding the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum"
        def diff = eulerMath.sumSquareDiff(100)
        log.info "Problem 6 execution time: ${TimeCategory.minus(new Date(), start)}"
        Mono.just diff
    }
}
