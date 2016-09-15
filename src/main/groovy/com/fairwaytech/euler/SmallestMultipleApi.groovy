package com.fairwaytech.euler

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
class SmallestMultipleApi {

    @GetMapping("/smallestmultiple/{maxValue}")
    int calculate(@PathVariable int maxValue) {
        def range = (1..maxValue)
        def rangeArray = new int[range.to];

        range.each() { rangeArray[it - 1] = it }

        return lcm(rangeArray)
    }

    int gcd(int a, int b) {
        println "gcd: a=$a, b=$b"
        if (b == 0) return a
        return gcd(b, a % b)
    }

    int lcm(int a, int b) {
        println "lcm: a-$a, b=$b"
        return a * (b / gcd(a, b))
    }

    int lcm(int[] input) {
        println "lcm: $input"
        int result = input[0]
        for (int i = 1; i < input.length; i++) {
            println "i=$i : result = $result : input[$i]= ${input[i]}"
            result = lcm(result, input[i])
        }
        return result
    }
}
