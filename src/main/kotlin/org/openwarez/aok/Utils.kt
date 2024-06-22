package org.openwarez.aok

import java.math.BigInteger
import java.nio.file.Files
import java.nio.file.Paths
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String): List<String> {
    val classLoader = Thread.currentThread().contextClassLoader
    val resource = classLoader.getResource(name)
        ?: throw IllegalArgumentException("file not found! $name")
    val path = Paths.get(resource.toURI())
    return Files.readAllLines(path)
}

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
