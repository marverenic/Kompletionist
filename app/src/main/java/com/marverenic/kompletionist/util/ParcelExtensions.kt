package com.marverenic.kompletionist.util

import android.os.Parcel

fun <T: Any> Parcel.readList(clazz: Class<T>) : List<T> {
    val list = mutableListOf<T>()
    readList(list, clazz.classLoader)

    return list
}

fun Parcel.writeBoolean(boolean: Boolean) {
    writeByte(if (boolean) 1 else 0)
}

fun Parcel.readBoolean() = readByte() != 0.toByte()