package com.fairwaytech.euler.prob5

import com.fairwaytech.euler.util.EulerMath
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
/**
 * Problem 5 - Smallest Multiple
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
@RestController
class SmallestMultiple {

    @Autowired
    EulerMath eulerMath

    @GetMapping("/smallestmultiple/{maxValue}")
    int calculate(@PathVariable int maxValue) {
        def rangeList = (1..maxValue).collect { it }
        return eulerMath.lcm(rangeList)
    }
}
