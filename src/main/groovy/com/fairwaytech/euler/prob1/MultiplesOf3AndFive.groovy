package com.fairwaytech.euler.prob1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Problem 1 - Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
@RestController
class MultiplesOf3AndFive {

    @GetMapping("/multiplesof3and5/{maxValue}")
    int calculate(@PathVariable int maxValue) {
        int val = 0
        (1..<maxValue).each {
            val += (it % 3 == 0 || it % 5 == 0) ? it : 0
        }
        return val
    }
}
