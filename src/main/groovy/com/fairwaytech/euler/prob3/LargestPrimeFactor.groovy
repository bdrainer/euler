package com.fairwaytech.euler.prob3

import com.fairwaytech.euler.util.EulerMath
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Problem 3 - Largest Prime Factor
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
@RestController
class LargestPrimeFactor {

    @Autowired
    EulerMath eulerMath

    @GetMapping("/largestprimefactor/{value}")
    def getNthPrime(@PathVariable BigInteger value) {
        return eulerMath.largestPrimeFactor(value)
    }
}
