package com.marverenic.kompletionist.model

import android.os.Parcel
import android.os.Parcelable
import com.marverenic.kompletionist.util.readBoolean
import com.marverenic.kompletionist.util.writeBoolean

data class SubTask(var completed: Boolean, var name: String) : Parcelable {

    companion object CREATOR : Parcelable.Creator<SubTask> {
        override fun newArray(size: Int): Array<SubTask?> = arrayOfNulls(size)
        override fun createFromParcel(source: Parcel): SubTask = SubTask(source)
    }

    private constructor(parcel: Parcel) : this(parcel.readBoolean(), parcel.readString())

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.apply {
            writeBoolean(completed)
            writeString(name)
        }
    }

    override fun describeContents() = 0

}
