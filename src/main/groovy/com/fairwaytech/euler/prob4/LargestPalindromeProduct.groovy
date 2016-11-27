package com.fairwaytech.euler.prob4

import com.fairwaytech.euler.util.EulerMath
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Problem 4 - Largest Palindrome Product
 *
 * A palindromic number reads the same both ways. The largest palindrome
 * made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * Answer 906609
 */
@RestController
class LargestPalindromeProduct {

    @Autowired
    EulerMath eulerMath

    @GetMapping("/largestpalindromeproduct")
    def getLargestPalindromProduct() {
        return eulerMath.largestPalindromeProduct()
    }
}
