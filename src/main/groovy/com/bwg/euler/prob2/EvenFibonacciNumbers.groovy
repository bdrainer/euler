package com.bwg.euler.prob2

import com.bwg.euler.util.Fibonacci
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

/**
 * Problem 2 - Even Fibonacci Numbers
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values do not exceed four
 * million, find the sum of the even-valued terms.
 */
@RestController
class EvenFibonacciNumbers {

    @Autowired
    Fibonacci fib

    @GetMapping(value = "/evenfibnumbers/{limit}", produces = APPLICATION_JSON_VALUE)
    def calculate(@PathVariable BigInteger limit) {
        Mono.just fib.evenSum(limit)
    }

}
