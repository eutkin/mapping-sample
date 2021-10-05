package com.github.eutkin

sealed class Attribute<T>(val name: String, val converter: (Any) -> T)

class StringAttribute(name: String) : Attribute<String>(name, Any::toString)
class LongAttribute(name: String) : Attribute<Long>(name, { it as Long })