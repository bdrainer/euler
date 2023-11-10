package com.bwg.euler.util

import com.bwg.euler.exception.BadRequestException

class Validator {
    static Optional<Throwable> checkExceedsMaxValue(BigInteger value, BigInteger maxValue) {
        value > maxValue
                ? Optional.of(new BadRequestException("Value cannot exceed $maxValue"))
                : Optional.empty() as Optional<Throwable>
    }
}
