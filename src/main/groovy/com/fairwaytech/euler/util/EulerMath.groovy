package com.fairwaytech.euler.util

import org.springframework.stereotype.Component

import static java.lang.String.valueOf

@Component
class EulerMath {

    def getSpecialPyTripletProduct() {
        boolean found = false
        def (max, fx, fy, fz) = [500, 0, 0, 0]

        def s = System.currentTimeMillis()
        for (int x = 1; x < max; ++x) {
            if (found) break
            for (int y = x + 1; y < max; ++y) {
                if (found) break
                for (int z = y + 1; z < max; ++z) {
                    if (found) break
                    if (isPyTripletMatch(x,y,z)) {
                        fx = x; fy = y; fz = z
                        found = true
                    }
                }
            }
        }
        def product = fx * fy * fz

        if (found) println "FOUND! -> [$fx,$fy,$fz] : $product"

        return product
    }

    private boolean isPyTripletMatch(def x, def y, def z) {
        return (z**2) == (x**2) + (y**2) && x+y+z == 1000
    }

    def getLargestProduct() {
        def numberString = '7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450'
        def loopLimit = numberString.size() - 12

        def listOfNumbers = []

        // create digits of length 13 from the number string
        0.step loopLimit, 1, {
            def val = numberString.substring(it, it + 13)
            // exclude any value with 0
            if (!val.contains('0')) {
                listOfNumbers << val
            }
        }

        // find the max
        listOfNumbers.collect { number ->
            number.collect { digitChar ->
                BigInteger.valueOf(digitChar.toLong())
            }.inject(BigInteger.valueOf(1L)) {
                result, digit -> result * digit
            }
        }.max()

    }

    /**
     * In mathematics, the greatest common divisor (gcd) of two or more integers, when at least one of them is not
     * zero, is the largest positive integer that divides the numbers without a remainder. For example, the GCD
     * of 8 and 12 is 4.
     */
    BigInteger gcd(BigInteger a, BigInteger b) {
        if (b == 0) return a
        gcd(b, a % b)
    }

    /**
     * A common multiple is a number that is a multiple of two or more numbers. The common multiples of
     * 3 and 4 are 0, 12, 24, .... The least common multiple (LCM) of two numbers is the smallest
     * number (not zero) that is a multiple of both.
     */
    BigInteger lcm(BigInteger a, BigInteger b) {
        a * b / gcd(a, b)
    }

    BigInteger lcm(List<BigInteger> input) {
        BigInteger result = input[0]
        for (BigInteger i = 1; i < input.size(); i++) {
            result = lcm(result, input[i])
        }
        return result
    }

    def sumSquareDiff(int maxValue) {
        def sum = BigInteger.ZERO, sumOfSqr = BigInteger.ZERO

        (1..maxValue).each() {
            sum = sum.add(BigInteger.valueOf(it))
            sumOfSqr = sumOfSqr.add(BigInteger.valueOf(it * it))
        }

        def sumSqr = sum.multiply(sum)
        sumSqr.subtract(sumOfSqr)
    }

    BigInteger calculatePrime(BigInteger n) {
        BigInteger numberOfPrimes = 0, prime = 1
        while (numberOfPrimes < n) {
            ++prime
            if (isPrime(prime)) {
                ++numberOfPrimes
            }
        }
        return prime
    }

    boolean isPrime(BigInteger n) {
        if (n < 2) {
            return false
        } else if (n == 2) {
            return true
        }

        for (int i = 2; i < Math.pow(n, 0.5) + 1; i++) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }

    BigInteger largestPrimeFactor(BigInteger number) {
        BigInteger i
        BigInteger copyOfInput = number
        for (i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                copyOfInput /= i
                --i
            }
        }
        return i;
    }

    def largestPalindromeProduct() {
        def result
        (999..100).each { x ->
            (x..100).each { y ->
                def check = x * y
                if (isPalindrome(check)) {
                    if (check > result) {
                        println "$x times $y = $check"
                        result = check
                    }
                }
            }
        }
        result
    }

    boolean isPalindrome(def value) {
        def valueString = valueOf(value)
        def reverse = valueString.reverse()
        valueString.equals(reverse)
    }
}
