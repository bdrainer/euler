package com.fairwaytech.euler.prob6

import com.fairwaytech.euler.util.EulerMath
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
/**
 * Problem 6
 *
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the
 * sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 * Answer: 25164150
 */
@RestController
class SumSquareDiff {

    @Autowired
    EulerMath eulerMath

    @GetMapping("sumsquarediff")
    def sumSquareDifference() {
        return eulerMath.sumSquareDiff(100)
    }
}
