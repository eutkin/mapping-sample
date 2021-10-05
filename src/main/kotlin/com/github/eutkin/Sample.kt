package com.github.eutkin

import io.micronaut.context.annotation.Property
import io.micronaut.core.convert.format.MapFormat
import io.micronaut.core.naming.conventions.StringConvention
import jakarta.inject.Singleton

@Singleton
class Sample(
    @Property(name = "mapping")
    @MapFormat(keyFormat = StringConvention.RAW, transformation = MapFormat.MapTransformation.FLAT)
    private val mapping: Map<String, Attribute<*>>
) {

    fun sample(map: Map<String, Any?>): Map<String, Any?> = map.mapNotNull { (key, value) ->
        val attribute = this.mapping[key] ?: return@mapNotNull null
        attribute.name to value?.let { attribute.converter(it) }
    }.toMap()
}