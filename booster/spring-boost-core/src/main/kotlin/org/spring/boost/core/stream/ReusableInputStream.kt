package org.spring.boost.core.stream

import java.io.BufferedInputStream
import java.io.InputStream
import java.io.OutputStream

/**
 * @author daiyuang
 * @since 2024.1.4
 * This class implements the [InputStream] interface to provide a reusable stream.
 * If the stream from the constructor is not markable, it will be cached.
 */
class ReusableInputStream
    @JvmOverloads
    constructor(
        stream: InputStream = nullInputStream(),
    ) : InputStream() {
        /**
         * If the stream does not support mark operations, cache the stream
         */
        private val internalStream: InputStream by lazy { if (stream.markSupported()) stream else BufferedInputStream(stream) }

        override fun read(): Int = internalStream.read()

        override fun read(b: ByteArray): Int = internalStream.read(b)

        override fun read(
            b: ByteArray,
            off: Int,
            len: Int,
        ): Int = internalStream.read(b, off, len)

        override fun readAllBytes(): ByteArray = internalStream.readAllBytes()

        override fun readNBytes(len: Int): ByteArray = internalStream.readNBytes(len)

        override fun readNBytes(
            b: ByteArray?,
            off: Int,
            len: Int,
        ): Int = internalStream.readNBytes(b, off, len)

        override fun skip(n: Long): Long = internalStream.skip(n)

        override fun skipNBytes(n: Long) = internalStream.skipNBytes(n)

        override fun markSupported(): Boolean {
            return true
        }

        override fun available(): Int = internalStream.available()

        override fun transferTo(out: OutputStream?): Long = internalStream.transferTo(out)

        override fun reset() = internalStream.reset()

        override fun close() = internalStream.close()
    }
