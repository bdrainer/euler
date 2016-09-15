package com.fairwaytech.euler

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


/**
 * Problem #6
 *
 * The sum of the squares of the first ten natural numbers is,
 *
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 * Answer: 25164150
 */
@RestController
class SumSquareDiffApi {

    @GetMapping("sumsquarediff")
    def sumSquareDifference() {
        return calculate()
    }

    def calculate() {
        def sum      = BigInteger.ZERO
        def sumSqr   = BigInteger.ZERO
        def sumOfSqr = BigInteger.ZERO

        (1..100).each() {
            sum = sum.add(BigInteger.valueOf(it))
            sumOfSqr = sumOfSqr.add(BigInteger.valueOf(it * it))
        }

        sumSqr = sum.multiply(sum)

        def answer = sumSqr.subtract(sumOfSqr).toString()

        println "$sumSqr - $sumOfSqr = $answer"

        return answer
    }
}
