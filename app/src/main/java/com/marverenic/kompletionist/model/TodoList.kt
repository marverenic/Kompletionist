package com.marverenic.kompletionist.model

import android.os.Parcel
import android.os.Parcelable
import com.marverenic.kompletionist.util.readList

data class TodoList(var name: String, var tasks: List<Task>): Parcelable {

    companion object CREATOR : Parcelable.Creator<TodoList> {
        override fun newArray(size: Int): Array<TodoList?> = arrayOfNulls(size)
        override fun createFromParcel(source: Parcel): TodoList = TodoList(source)
    }

    private constructor(parcel: Parcel) : this(parcel.readString(), parcel.readList(Task::class.java))

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.apply {
            writeString(name)
            writeList(tasks)
        }
    }

    override fun describeContents() = 0

}