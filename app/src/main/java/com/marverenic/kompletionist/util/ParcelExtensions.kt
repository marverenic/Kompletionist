package com.marverenic.kompletionist.util

import android.os.Parcel

inline fun <reified T: Any> Parcel.readList() =
        mutableListOf<T>().apply { readList(this, T::class.java.classLoader) }

fun Parcel.writeBoolean(boolean: Boolean) {
    writeByte(if (boolean) 1 else 0)
}

fun Parcel.readBoolean() = readByte() != 0.toByte()