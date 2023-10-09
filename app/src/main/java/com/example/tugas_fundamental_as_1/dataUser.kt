package com.example.tugas_fundamental_as_1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize //inisialisasi data class milik parcelize (pilih rekomendasi yg ada android.parcelizenya
data class DataUser(
    val username:String,
    val password:String
):Parcelable