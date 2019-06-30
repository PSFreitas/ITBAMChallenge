package com.itbamchallenge.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


class Product(
    @SerializedName(value = "name")
    val name: String = "",

    @SerializedName(value = "style")
    val style: String = "",

    @SerializedName(value = "code_color")
    val codeColor: String = "",

    @SerializedName(value = "color_slug")
    val colorSlug: String = "",

    @SerializedName(value = "color")
    val color: String = "",

    @SerializedName(value = "on_sale")
    val onSale: Boolean = false,

    @SerializedName(value = "regular_price")
    val regularPrice: String = "",

    @SerializedName(value = "actual_price")
    val actualPrice: String = "",

    @SerializedName(value = "discount_percentage")
    val discountPercentage: String = "",

    @SerializedName(value = "installments")
    val installments: String = "",

    @SerializedName(value = "image")
    val image: String = "",

    @SerializedName(value = "sizes")
    val sizes: List<Size> = ArrayList()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createTypedArrayList(Size)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(style)
        parcel.writeString(codeColor)
        parcel.writeString(colorSlug)
        parcel.writeString(color)
        parcel.writeByte(if (onSale) 1 else 0)
        parcel.writeString(regularPrice)
        parcel.writeString(actualPrice)
        parcel.writeString(discountPercentage)
        parcel.writeString(installments)
        parcel.writeString(image)
        parcel.writeTypedList(sizes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }


}