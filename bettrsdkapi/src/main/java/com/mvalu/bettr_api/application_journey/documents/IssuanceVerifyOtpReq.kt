package com.mvalu.bettr_api.application_journey.documents

import com.squareup.moshi.Json

class IssuanceVerifyOtpReq {
    @field:Json(name = "id")
    var id: String? = null

    @field:Json(name = "otp")
    var otp: String? = null
}