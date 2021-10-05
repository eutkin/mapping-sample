package com.github.eutkin

import io.micronaut.runtime.Micronaut.build

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("com.github.eutkin")
        .start()
        .use { context ->
            context.getBean(Sample::class.java).sample(
                mapOf(
                    "consumer.id" to "test-consumer",
                    "amount" to 1000L
                )
            ).forEach{ println(it) }
        }
}

