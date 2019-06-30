package com.itbamchallenge.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Size() : Parcelable {

    @SerializedName(value = "available")
    var available: Boolean = false

    @SerializedName(value = "size")
    var size: String = ""

    @SerializedName(value = "sku")
    var sky: String = ""

    constructor(parcel: Parcel) : this() {
        available = parcel.readByte() != 0.toByte()
        size = parcel.readString().toString()
        sky = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (available) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Size> {
        override fun createFromParcel(parcel: Parcel): Size {
            return Size(parcel)
        }

        override fun newArray(size: Int): Array<Size?> {
            return arrayOfNulls(size)
        }
    }

}