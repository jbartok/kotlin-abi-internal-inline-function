package com.gradle.abi

class InternalInlineFunction {

    fun foo() = bar()

    internal inline fun bar() {
        println("foo")
    }

}