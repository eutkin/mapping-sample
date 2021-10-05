package com.github.eutkin

import io.micronaut.core.convert.ConversionContext
import io.micronaut.core.convert.TypeConverter
import jakarta.inject.Singleton
import java.util.*

@Singleton
class AttributeTypeConverter : TypeConverter<String, Attribute<*>> {

    override fun convert(value: String, clazz: Class<Attribute<*>>, ctx: ConversionContext): Optional<Attribute<*>> {
        val (name, type) = value.split("\\s*as\\s*".toRegex())
        return when (type) {
            "Long" -> Optional.of(LongAttribute(name))
            else -> Optional.of(StringAttribute(name))
        }
    }
}