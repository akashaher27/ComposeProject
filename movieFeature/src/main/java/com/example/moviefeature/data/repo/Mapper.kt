package com.example.moviefeature.data.repo

interface Mapper<I, O> {
    fun map(input: I): O
}