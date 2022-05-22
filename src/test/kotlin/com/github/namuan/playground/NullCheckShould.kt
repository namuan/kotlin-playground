package com.github.namuan.playground

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class NullCheckShould {

    @Test
    fun checkForNulls() {
        val nullString: String? = null

        assertThat(nullCheck(nullString), equalTo(true))
    }

    fun nullCheck(str: String?) = str.isNullOrBlank()
}
