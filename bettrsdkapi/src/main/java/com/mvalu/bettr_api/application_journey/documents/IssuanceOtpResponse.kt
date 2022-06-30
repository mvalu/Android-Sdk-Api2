package com.mvalu.bettr_api.application_journey.documents

import com.mvalu.bettr_api.network.ApiBaseResponse
import com.squareup.moshi.Json

class IssuanceOtpResponse: ApiBaseResponse() {
    @field:Json(name = "results")
    var result: Result? = null

    class Result {
        @field:Json(name = "id")
        var id: String? = null
    }
}