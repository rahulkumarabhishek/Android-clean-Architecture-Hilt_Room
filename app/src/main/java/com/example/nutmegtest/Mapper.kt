package com.example.nutmegtest

interface Mapper<T, E> {

    fun toEntity(e: E): T

    fun toData(t: T): E

}