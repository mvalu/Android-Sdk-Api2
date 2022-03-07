package com.mvalu.bettr_api.application_journey

import com.mvalu.bettr_api.network.ApiBaseResponse
import com.squareup.moshi.Json

class KycStatusApiResponse : ApiBaseResponse() {
    @field:Json(name = "status")
    var status: Boolean? = null

    @field:Json(name = "ckycStatus")
    var ckycStatus: String? = null
}