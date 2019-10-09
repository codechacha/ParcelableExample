package com.codechacha.sample

import android.os.Parcel
import android.os.Parcelable

class MyData() : Parcelable {
    var name : String? = null
    var version : Int = 0
    var lastModified : Int = 0

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        version = parcel.readInt()
        lastModified = parcel.readInt()
    }

    constructor(name: String?, version: Int, lastModified: Int) : this() {
        this.name = name
        this.version = version
        this.lastModified = lastModified
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(version)
        parcel.writeInt(lastModified)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyData> {
        override fun createFromParcel(parcel: Parcel): MyData {
            return MyData(parcel)
        }

        override fun newArray(size: Int): Array<MyData?> {
            return arrayOfNulls(size)
        }
    }

}