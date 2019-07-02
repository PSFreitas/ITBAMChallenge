package com.itbamchallenge.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


/**
 * Classe de Tamanho que segura os dados recebidos da API
 * @constructor Cria um tamanho com os dados passados
 *
 * @property available Se o tamanho está disponível
 * @property size Tipo de tamanho do produto
 * @property sku Código do tamanho do produto
 */
data class Size(
    @SerializedName(value = "available")
    var available: Boolean = false,

    @SerializedName(value = "size")
    var size: String = "",

    @SerializedName(value = "sku")
    var sku: String = ""
) : Parcelable {


    constructor(parcel: Parcel) : this() {
        available = parcel.readByte() != 0.toByte()

        size = parcel.readString().toString()

        sku = parcel.readString().toString()
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