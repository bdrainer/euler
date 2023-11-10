package com.bwg.euler.prob9

import com.bwg.euler.util.EulerMath
import groovy.time.TimeCategory
import groovy.util.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * Problem 9 - Special Pythagorean Triplet
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 *
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.  Find the product abc.
 *
 * Answer: 31875000
 */
@Log
@RestController
class SpecialPythagoreanTriplet {

    @Autowired
    EulerMath eulerMath

    @GetMapping("/specialpytriplet")
    def get() {
        def start = new Date()
        def product = eulerMath.getSpecialPyTripletProduct()
        log.info "Problem 9 execution time: ${TimeCategory.minus(new Date(), start)}"
        Mono.just product
    }

}

