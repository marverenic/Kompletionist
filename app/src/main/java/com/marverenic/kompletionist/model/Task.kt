package com.marverenic.kompletionist.model

import android.os.Parcel
import android.os.Parcelable
import com.marverenic.kompletionist.util.readBoolean
import com.marverenic.kompletionist.util.readList
import com.marverenic.kompletionist.util.writeBoolean

data class Task(val complete: Boolean = false,
                val name: String,
                val dueDate: Long,
                val subTasks: List<SubTask> = emptyList()) : Parcelable {

    companion object CREATOR : Parcelable.Creator<Task> {
        override fun newArray(size: Int): Array<Task?> = arrayOfNulls(size)
        override fun createFromParcel(source: Parcel): Task = Task(source)
    }

    private constructor(parcel: Parcel) : this(parcel.readBoolean(), parcel.readString(),
            parcel.readLong(), parcel.readList(SubTask::class.java))

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.apply {
            writeBoolean(complete)
            writeString(name)
            writeLong(dueDate)
            writeList(subTasks)
        }
    }

    override fun describeContents() = 0

}