package com.mvalu.bettr_api.settings.otp

import com.mvalu.bettr_api.BettrApiSdk
import com.mvalu.bettr_api.base.ApiSdkBase
import com.mvalu.bettr_api.internal.ErrorMessage
import com.mvalu.bettr_api.network.ApiResponseCallback
import com.mvalu.bettr_api.network.ApiTag
import com.mvalu.bettr_api.utils.BettrApiSdkLogger
import com.mvalu.bettr_api.utils.NOT_SPECIFIED_ERROR_CODE
import com.mvalu.bettr_api.utils.NO_NETWORK_ERROR_CODE

object OTP : ApiSdkBase() {

    private const val TAG = "OTP"
    private var otpResponseCallback: ApiResponseCallback<OtpResult>? = null

    init {
        BettrApiSdk.getAppComponent().inject(this)
    }

    fun sendOtp(
        otpResponseCallback: ApiResponseCallback<OtpResult>,
        accountId: String
    ) {
        if (!BettrApiSdk.isSdkInitialized()) {
            throw IllegalArgumentException(ErrorMessage.SDK_NOT_INITIALIZED_ERROR.value)
        }
        this.otpResponseCallback = otpResponseCallback
        callApi(
            serviceApi.sendOtp(
                BettrApiSdk.getOrganizationId(),
                accountId,
                OtpSendRequest(BettrApiSdk.getUserId())
            ),
            ApiTag.SEND_OTP_API
        )
    }

    fun resendOtp(
        otpResponseCallback: ApiResponseCallback<OtpResult>,
        accountId: String,
        otpRequestId: String
    ) {
        if (!BettrApiSdk.isSdkInitialized()) {
            throw IllegalArgumentException(ErrorMessage.SDK_NOT_INITIALIZED_ERROR.value)
        }
        this.otpResponseCallback = otpResponseCallback
        callApi(
            serviceApi.resendOtp(
                BettrApiSdk.getOrganizationId(),
                accountId,
                OtpReSendRequest(otpRequestId)
            ),
            ApiTag.RESEND_OTP_API
        )
    }

    fun verifyOtp(
        otpResponseCallback: ApiResponseCallback<OtpResult>,
        accountId: String,
        otpRequestId: String,
        otp: Int
    ) {
        if (!BettrApiSdk.isSdkInitialized()) {
            throw IllegalArgumentException(ErrorMessage.SDK_NOT_INITIALIZED_ERROR.value)
        }
        this.otpResponseCallback = otpResponseCallback
        callApi(
            serviceApi.verifyOtp(
                BettrApiSdk.getOrganizationId(),
                accountId,
                OtpVerifyRequest(otpRequestId, otp)
            ),
            ApiTag.VERIFY_OTP_API
        )
    }

    override fun onApiSuccess(apiTag: ApiTag, response: Any) {
        when (apiTag) {
            ApiTag.SEND_OTP_API -> {
                BettrApiSdkLogger.printInfo(TAG, "Sent OTP")
                val otpApiResponse = response as OtpApiResponse
                otpResponseCallback?.onSuccess(otpApiResponse.results!!)
            }
            ApiTag.RESEND_OTP_API -> {
                BettrApiSdkLogger.printInfo(TAG, "Resent OTP")
                val otpApiResponse = response as OtpApiResponse
                otpResponseCallback?.onSuccess(otpApiResponse.results!!)
            }
            ApiTag.VERIFY_OTP_API -> {
                BettrApiSdkLogger.printInfo(TAG, "Verified OTP")
                val otpApiResponse = response as OtpApiResponse
                otpResponseCallback?.onSuccess(otpApiResponse.results!!)
            }
        }
    }

    override fun onApiError(errorCode: Int, apiTag: ApiTag, errorMessage: String) {
        BettrApiSdkLogger.printInfo(TAG, apiTag.name + " " + errorMessage)
        when (apiTag) {
            ApiTag.SEND_OTP_API, ApiTag.RESEND_OTP_API, ApiTag.VERIFY_OTP_API -> {
                otpResponseCallback?.onError(errorCode, errorMessage)
            }
        }
    }

    override fun onTimeout(apiTag: ApiTag) {
        BettrApiSdkLogger.printInfo(TAG, apiTag.name + " " + ErrorMessage.API_TIMEOUT_ERROR.value)
        when (apiTag) {
            ApiTag.SEND_OTP_API, ApiTag.RESEND_OTP_API, ApiTag.VERIFY_OTP_API -> {
                otpResponseCallback?.onError(
                    NOT_SPECIFIED_ERROR_CODE,
                    ErrorMessage.API_TIMEOUT_ERROR.value
                )
            }
        }
    }

    override fun onNetworkError(apiTag: ApiTag) {
        BettrApiSdkLogger.printInfo(TAG, apiTag.name + " " + ErrorMessage.NETWORK_ERROR.value)
        when (apiTag) {
            ApiTag.SEND_OTP_API, ApiTag.RESEND_OTP_API, ApiTag.VERIFY_OTP_API -> {
                otpResponseCallback?.onError(
                    NO_NETWORK_ERROR_CODE,
                    ErrorMessage.NETWORK_ERROR.value
                )
            }
        }
    }

    override fun onAuthError(apiTag: ApiTag) {
        BettrApiSdkLogger.printInfo(TAG, apiTag.name + " " + ErrorMessage.AUTH_ERROR.value)
        when (apiTag) {
            ApiTag.SEND_OTP_API, ApiTag.RESEND_OTP_API, ApiTag.VERIFY_OTP_API -> {
                otpResponseCallback?.onError(
                    NOT_SPECIFIED_ERROR_CODE,
                    ErrorMessage.AUTH_ERROR.value
                )
            }
        }
    }
}