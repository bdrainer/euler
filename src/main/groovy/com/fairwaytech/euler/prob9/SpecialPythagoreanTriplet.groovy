package com.fairwaytech.euler.prob9

import com.fairwaytech.euler.util.EulerMath
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
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
 */
@RestController
class SpecialPythagoreanTriplet {

    @Autowired
    EulerMath eulerMath

    @GetMapping("/specialpytriplet")
    def get() {
        def start = System.currentTimeMillis()
        def product = eulerMath.getSpecialPyTripletProduct()
        println "Elapsed Time: ${(System.currentTimeMillis() - start) / 1000.0} seconds"
        return product
    }

}

