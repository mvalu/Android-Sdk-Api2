package com.mvalu.bettr_api.payment.summary

import com.squareup.moshi.Json

class PaymentDueInfo {
    @field:Json(name = "status")
    var status: String? = null

    @field:Json(name = "statusText")
    var statusText: String? = null

    @field:Json(name = "totalDue")
    var totalDue: Double? = null

    @field:Json(name = "minDue")
    var minDue: Double? = null

    @field:Json(name = "interestRateForRemainingAmount")
    var interestRateForRemainingAmount: Double? = null

    @field:Json(name = "title")
    var title: String? = null

    @field:Json(name = "paymentButton")
    var paymentButton: Boolean? = false
    
    @field:Json(name = "interestBenefit")
    var interestBenefit: String? = null
    
    @field:Json(name = "note_message")
    var note_message: String? = null
    
    @field:Json(name = "status_Color")
    var status_Color: String? = null
    
}
