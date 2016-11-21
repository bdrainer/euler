package com.fairwaytech.euler.prob7

import com.fairwaytech.euler.util.EulerMath
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
/**
 * Problem 7 - 10001st Prime
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10001st prime number?
 */
@RestController
class Find10001stPrime {

    @Autowired
    EulerMath eulerMath

    @GetMapping("/nthprime/{nth}")
    def getNthPrime(@PathVariable BigInteger nth) {
        return eulerMath.calculatePrime(nth)
    }

}

