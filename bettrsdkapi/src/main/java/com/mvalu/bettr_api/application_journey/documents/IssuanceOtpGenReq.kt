package com.mvalu.bettr_api.application_journey.documents

import com.squareup.moshi.Json

class IssuanceOtpGenReq {
    @field:Json(name = "mobileNumber")
    var mobileNumber: String? = null
}