package com.bwg.euler.prob4

import com.bwg.euler.util.EulerMath
import groovy.time.TimeCategory
import groovy.util.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * Problem 4 - Largest Palindrome Product
 *
 * A palindromic number reads the same both ways. The largest palindrome
 * made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * Answer: 906609
 */
@Log
@RestController
class LargestPalindromeProduct {

    @Autowired
    EulerMath eulerMath

    @GetMapping("/largestpalindromeproduct")
    def getLargestPalindromProduct() {
        def start = new Date()
        log.info"Problem 4: Finding the largest palindrome made from the product of two 3-digit numbers"
        def product = eulerMath.largestPalindromeProduct()
        log.info "Problem 4 execution time: ${TimeCategory.minus(new Date(), start)}"
        Mono.just product
    }
}
