package com.mvalu.bettr_api.network

import com.mvalu.bettr_api.BankAccountIFSCResponseModel
import com.mvalu.bettr_api.account_statements.AccountStatementDetailSummaryApiResponse
import com.mvalu.bettr_api.account_statements.AccountStatementsApiResponse
import com.mvalu.bettr_api.account_statements.transactions.AccountStatementTransactionInfoApiResponse
import com.mvalu.bettr_api.account_statements.transactions.AccountStatementTransactionsApiResponse
import com.mvalu.bettr_api.application_journey.IFSCCityAndBranchApiResponse
import com.mvalu.bettr_api.application_journey.LeadDetail
import com.mvalu.bettr_api.application_journey.LeadDetailApiResponse
import com.mvalu.bettr_api.application_journey.bureau.*
import com.mvalu.bettr_api.application_journey.checklist.CheckListApiResponse
import com.mvalu.bettr_api.application_journey.checklist.CheckListRequest
import com.mvalu.bettr_api.application_journey.content.ApplicationJourneyContentApiResponse
import com.mvalu.bettr_api.application_journey.content.ApplicationJourneyContentRequest
import com.mvalu.bettr_api.application_journey.documents.*
import com.mvalu.bettr_api.application_journey.income.*
import com.mvalu.bettr_api.application_journey.pan.ValidatePANNumberApiResponse
import com.mvalu.bettr_api.application_journey.pan.ValidatePANNumberRequest
import com.mvalu.bettr_api.application_journey.pincode.ValidatePincodeApiResponse
import com.mvalu.bettr_api.application_journey.pincode.ValidatePincodeRequest
import com.mvalu.bettr_api.downloads.DocumentDownloadApiResponse
import com.mvalu.bettr_api.emi.ConvertToEmiApiRequest
import com.mvalu.bettr_api.emi.ConvertToEmiApiResponse
import com.mvalu.bettr_api.home_module.AccountInfoApiResponse
import com.mvalu.bettr_api.home_module.HomeModuleApiResponse
import com.mvalu.bettr_api.home_module.statement.HomeModuleStatementApiResponse
import com.mvalu.bettr_api.login.GenerateTokenRequest
import com.mvalu.bettr_api.login.GenerateTokenResponse
import com.mvalu.bettr_api.payment.GenerateOrderApiRequest
import com.mvalu.bettr_api.payment.GenerateOrderApiResponse
import com.mvalu.bettr_api.payment.PaymentStatusApiResponse
import com.mvalu.bettr_api.payment.PaymentStatusRequest
import com.mvalu.bettr_api.payment.detail.PaymentDetailApiResponse
import com.mvalu.bettr_api.payment.summary.PaymentSummaryApiResponse
import com.mvalu.bettr_api.rewards.RewardPointsApiResponse
import com.mvalu.bettr_api.rewards.RewardPointsRedeemRequest
import com.mvalu.bettr_api.rewards.RewardPointsSummaryApiResponse
import com.mvalu.bettr_api.rewards.cashback.RewardCashbackApiResponse
import com.mvalu.bettr_api.rewards.cashback.RewardCashbackInfoApiResponse
import com.mvalu.bettr_api.search.SearchFieldDataApiResponse
import com.mvalu.bettr_api.settings.*
import com.mvalu.bettr_api.settings.otp.OtpApiResponse
import com.mvalu.bettr_api.settings.otp.OtpReSendRequest
import com.mvalu.bettr_api.settings.otp.OtpSendRequest
import com.mvalu.bettr_api.settings.otp.OtpVerifyRequest
import com.mvalu.bettr_api.settings.plastic_card.CardActivationRequest
import com.mvalu.bettr_api.settings.plastic_card.CardNumberVerifyRequest
import com.mvalu.bettr_api.transactions.AccountTransactionsApiResponse
import com.mvalu.bettr_api.transactions.CardTransactionsApiResponse
import com.mvalu.bettr_api.transactions.TransactionAnalysisApiResponse
import com.mvalu.bettr_api.transactions.TransactionInfoApiResponse
import com.mvalu.bettr_api.transactions.payments.CardPaymentsApiResponse
import com.mvalu.bettr_api.transactions.payments.PaymentInfoApiResponse
import com.mvalu.bettr_api.upi.*
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*


interface ServiceApi {
    @POST("v1/{organizationId}/auth/generateToken")
    fun generateToken(
        @Path("organizationId") organizationId: String,
        @Body generateTokenRequest: GenerateTokenRequest
    ): Observable<Response<GenerateTokenResponse>>

    //new endpoint as per Shubhankar and vinoth old : cc_home_module
    @GET("v1/{organizationId}/rm/cc_home_module_Statement_New")
    fun getCardHomeModule(@Path("organizationId") organizationId: String): Observable<Response<HomeModuleApiResponse>>

    @GET("v1/{organizationId}/rm/cc_statement_module")
    fun getCardHomeModuleStatement(@Path("organizationId") organizationId: String): Observable<Response<HomeModuleStatementApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/transaction")
    fun getAccountTransactions(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Query("startMonth") startMonth: String?,
        @Query("endMonth") endMonth: String?,
        @Query("amountStart") amountStart: String?,
        @Query("amountEnd") amountEnd: String?,
        @Query("merchantCategory") merchantCategory: String?,
        @Query("startDate") startDate: String?,
        @Query("endDate") endDate: String?,
        @Query("status") status: String?,
        @Query("search") search: String?,
        @Query("offset") offset: Int
    ): Observable<Response<AccountTransactionsApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/spendAnalysis")
    fun getTransactionsAnalysis(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): Observable<Response<TransactionAnalysisApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/payment")
    fun getCardPayments(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Query("source") source: String?,
        @Query("startMonth") startMonth: String?,
        @Query("endMonth") endMonth: String?,
        @Query("status") status: String?,
        @Query("offset") offset: Int
    ): Observable<Response<CardPaymentsApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/statementTransaction")
    fun getStatementTransactions(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Query("type") type: String?,
        @Query("startMonth") startMonth: String?,
        @Query("endMonth") endMonth: String?,
        @Query("status") status: String?,
        @Query("amountStart") amountStart: Int?,
        @Query("amountEnd") amountEnd: Int?,
        @Query("category") category: String?
    ): Observable<Response<CardTransactionsApiResponse>>
//Statement Api : added /new at last api shared by Vinoth 12/jan/22
    @GET("v1/{organizationId}/lms/cc/account/{accountId}/statement/new")
    fun getAccountStatements(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String
    ): Observable<Response<AccountStatementsApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/statement/{statementId}")
    fun getAccountStatementTransactions(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("statementId") statementId: String
    ): Observable<Response<AccountStatementTransactionsApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/statementTransaction/{statementTransactionId}")
    fun getAccountStatementTransactionInfo(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("statementTransactionId") statementTransactionId: String
    ): Observable<Response<AccountStatementTransactionInfoApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/statement/{statementId}/statementSummaryNew")
    fun getAccountStatementDetailSummary(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("statementId") statementId: String
    ): Observable<Response<AccountStatementDetailSummaryApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/payment/{paymentId}")
    fun getPaymentInfo(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("paymentId") paymentId: String
    ): Observable<Response<PaymentInfoApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/transaction/{transactionId}")
    fun getTransactionInfo(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("transactionId") transactionId: String
    ): Observable<Response<TransactionInfoApiResponse>>

    @PUT("v1/{organizationId}/leads/{leadId}/new")
    fun updateLead(
        @Path("organizationId") organizationId: String,
        @Path("leadId") leadId: String,
        @Body lead: LeadDetail?
    ): Observable<Response<LeadDetailApiResponse>>

    @PUT("v1/{organizationId}/leads/{leadId}/new")
    fun updateLeadNew(
        @Path("organizationId") organizationId: String,
        @Path("leadId") leadId: String,
        @Body lead: LeadDetail?
    ): Observable<Response<LeadDetailApiResponse>>

    @GET("v1/{organizationId}/leads/{leadId}")
    fun getLead(
        @Path("organizationId") organizationId: String,
        @Path("leadId") leadId: String
    ): Observable<Response<LeadDetailApiResponse>>

    @POST("v1/{organizationId}/users/panValidate")
    fun validatePANNumber(
        @Path("organizationId") organizationId: String,
        @Body validatePANRequestModel: ValidatePANNumberRequest
    ): Observable<Response<ValidatePANNumberApiResponse>>

    @GET("v1/{organizationId}/leads/pinCheck/{pincode}")
    fun validatePincode(
        @Path("organizationId") organizationId: String,
        @Path("pincode") pinCode: String
    ): Observable<Response<ValidatePincodeApiResponse>>

    @POST("v1/{organizationId}/leads/{leadId}/pincheckwithbureau")
    fun validatePincodeNew(
        @Path("organizationId") organizationId: String,
        @Path("leadId") leadId: String,
        @Body validatPincodeRequestModel:ValidatePincodeRequest
    ): Observable<Response<ValidatePincodeApiResponse>>


    @POST("v1/{organizationId}/integration/bureau")
    fun checkBureauStatus(
        @Path("organizationId") organizationId: String,
        @Body bureauStatusRequest: BureauStatusRequest
    ): Observable<Response<BureauStatusApiResponse>>

    @POST("v1/{organizationId}/integration/bureau/generateQuestion")
    fun getBureauQuestion(
        @Path("organizationId") organizationId: String,
        @Body bureauQuestionRequest: BureauQuestionRequest
    ): Observable<Response<BureauQuestionApiResponse>>

    @POST("v1/{organizationId}/integration/bureau/verifyAnswer")
    fun bureauVerifyAnswer(
        @Path("organizationId") organizationId: String,
        @Body bureauAnswerRequest: BureauAnswerRequest
    ): Observable<Response<BureauStatusApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/idProof")
    fun uploadIdProof(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/addressProof")
    fun uploadAddressProof(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/bankStatement")
    fun uploadBankStatement(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/salarySlip")
    fun uploadSalarySlip(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/photo")
    fun uploadProfilePic(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/pan")
    fun uploadPanCard(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/aadharCard")
    fun uploadAadharFront(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/companyIdCard")
    fun uploadCompanyIDCard(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/companyBusinessCard")
    fun uploadCompanyBusinessCard(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/gstInvoice")
    fun uploadGSTInvoice(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/gstIssueCertificate")
    fun uploadGSTIssueCertificate(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/shopPhotoInside")
    fun uploadShopInside(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/shopPhotoOutside")
    fun uploadShopOutside(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/establishmentRegistration")
    fun uploadShopRegistration(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @Multipart
    @POST("v1/{organizationId}/upload/single/aadharCardBack")
    fun uploadAadharBack(
        @Path("organizationId") organizationId: String,
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<DocumentUploadApiResponse>>

    @POST("v1/{organizationId}/application/{applicationId}/leadDocumentVerify")
    fun verifyDocuments(
        @Path("organizationId") organizationId: String,
        @Path("applicationId") applicationId: String,
        @Body request: VerifyDocumentsRequest
    ): Observable<Response<VerifyDocumentsApiResponse>>

    /*----------------------new document verify api--------*/
    @POST("v1/{organizationId}/application/{applicationId}/leadDocumentVerifyNew")
    fun verifyDocumentsNew(
        @Path("organizationId") organizationId: String,
        @Path("applicationId") applicationId: String,
        @Body request: VerifyDocumentsRequest
    ): Observable<Response<VerifyDocumentsApiResponse>>


    @POST("v1/{organizationId}/application/{applicationId}/leadRecaptureSelfieVerify")
    fun verifySelfieRecaptureDocumentsNew(
        @Path("organizationId") organizationId: String,
        @Path("applicationId") applicationId: String,
        @Body request: VerifyDocumentsRequest
    ): Observable<Response<VerifyDocumentsApiResponse>>

    /*------------------------------*/


    @POST("v1/{organizationId}/leads/screenDetail")
    fun fetchCheckList(
        @Path("organizationId") organizationId: String,
        @Body request: CheckListRequest
    ): Observable<Response<CheckListApiResponse>>

    @POST("v1/{organizationId}/constants/cc-dropdown")
    fun fetchApplicationJourneyContent(
        @Path("organizationId") organizationId: String,
        @Body request: ApplicationJourneyContentRequest
    ): Observable<Response<ApplicationJourneyContentApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/statement/{statementId}?isDownload=true")
    fun getStatementDownloadLink(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("statementId") statementId: String
    ): Observable<Response<DocumentDownloadApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/reward_point")
    fun getRewardPoints(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Query("startMonth") startMonth: String?,
        @Query("endMonth") endMonth: String?,
        @Query("pointStart") pointStart: String?,
        @Query("pointEnd") pointEnd: String?,
        @Query("startDate") startDate: String?,
        @Query("endDate") endDate: String?,
        @Query("search") search: String?,
        @Query("offset") offset: Int
    ): Observable<Response<RewardPointsApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/reward_cashback")
    fun getRewardCashbacks(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Query("startMonth") startMonth: String?,
        @Query("endMonth") endMonth: String?,
        @Query("amountStart") pointStart: String?,
        @Query("amountEnd") pointEnd: String?,
        @Query("startDate") startDate: String?,
        @Query("endDate") endDate: String?,
        @Query("search") search: String?,
        @Query("offset") offset: Int
    ): Observable<Response<RewardCashbackApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/reward_point/rewardPointSummary")
    fun getRewardPointsSummary(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String
    ): Observable<Response<RewardPointsSummaryApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/reward_cashback/{rewardCashbackId}")
    fun getRewardCashbackInfo(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("rewardCashbackId") rewardCashbackId: String
    ): Observable<Response<RewardCashbackInfoApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/reward_point/rewardPointRedeemed")
    fun redeemRewardPoints(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Body rewardPointsRedeemRequest: RewardPointsRedeemRequest
    ): Observable<Response<SettingsGenericApiResponse>>

//new endpoint added as per Shubhankar and Vinoth old ->quickPaymentSummary
    @GET("v1/{organizationId}/lms/cc/account/{accountId}/payment/quickPaymentSummaryNew")
    fun getPaymentSummary(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String
    ): Observable<Response<PaymentSummaryApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/card/{cardId}/newstatement")
    fun getSettingsInfo(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("cardId") cardId: String
    ): Observable<Response<SettingsInfoApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/payment/generateOrderId")
    fun generateOrderId(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Body generateOrderRequest: GenerateOrderApiRequest
    ): Observable<Response<GenerateOrderApiResponse>>

    @POST("v1/{organizationId}/integration/razorpay/paymentStatus")
    fun checkPaymentStatus(
        @Path("organizationId") organizationId: String,
        @Body checkPaymentStatusRequest: PaymentStatusRequest
    ): Observable<Response<PaymentStatusApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/card/{cardId}/imagev2")
    fun getCardImage(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("cardId") cardId: String
    ): Observable<Response<CardImageApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/card/{cardId}/pinInitialized")
    fun initializeCardPin(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("cardId") cardId: String
    ): Observable<Response<PinInitApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/card/{cardId}/pinSet")
    fun setCardPin(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("cardId") cardId: String,
        @Body pinSetReq: PinSetRequest
    ): Observable<Response<SettingsGenericApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/card/otpRequest")
    fun sendOtp(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Body otpSendRequest: OtpSendRequest
    ): Observable<Response<OtpApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/card/otpResend")
    fun resendOtp(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Body otpReSendRequest: OtpReSendRequest
    ): Observable<Response<OtpApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/card/otpVerification")
    fun verifyOtp(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Body otpVerifyRequest: OtpVerifyRequest
    ): Observable<Response<OtpApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/payment/paymentWithCardDetail/{paymentId}/")
    fun getPaymentDetails(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("paymentId") paymentId: String
    ): Observable<Response<PaymentDetailApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/card/{cardId}/block")
    fun blockCard(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("cardId") cardId: String
    ): Observable<Response<BlockCardApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/card/activateDigitalCard")
    fun activateDigitalCard(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Body cardActivationRequest: CardActivationRequest
    ): Observable<Response<SettingsGenericApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/card/activatePlasticCard")
    fun activatePlasticCard(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Body cardActivationRequest: CardActivationRequest
    ): Observable<Response<SettingsGenericApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/card/{cardId}/verifyCardNumber")
    fun verifyCardNumber(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("cardId") cardId: String,
        @Body cardNumberVerifyRequest: CardNumberVerifyRequest
    ): Observable<Response<SettingsGenericApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/card/{cardId}/actionSwitch")
    fun cardOnOff(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("cardId") cardId: String,
        @Body cardOnOffRequest: CardOnOffRequest
    ): Observable<Response<BlockCardApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}")
    fun getAccountInfo(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String
    ): Observable<Response<AccountInfoApiResponse>>

    @GET("v1/{organizationId}/config/search/{configKey}")
    fun getSearchFieldDataResponse(
        @Path("organizationId") organizationId: String,
        @Path("configKey") configKey: String,
        @QueryMap options: Map<String, String>
    ): Observable<Response<SearchFieldDataApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/transaction/upi/verifyMerchant")
    fun verifyMerchant(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Body verifyMerchantRequest: VerifyMerchantRequest
    ): Observable<Response<VerifyMerchantApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/transaction/upi/generateToken")
    fun upiGenerateToken(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Body upiGenerateTokenRequest: UPIGenerateTokenRequest
    ): Observable<Response<UPIGenerateTokenApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/transaction/upi/setup")
    fun upiSetUp(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Body upiSetUpRequest: UPISetUpRequest
    ): Observable<Response<UPISetUpApiResponse>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/transaction/upi/payment")
    fun makeUPIPayment(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Body upiPaymentRequest: UPIPaymentRequest
    ): Observable<Response<UPIPaymentApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/transaction/upi/recentMerchant")
    fun getRecentMerchants(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String
    ): Observable<Response<RecentMerchantsApiResponse>>

    @GET("v1/{organizationId}/config/search/ifsc-ifsc.config")
    fun getBranchDetailsFromIFSC(
        @Path("organizationId") organizationId: String,
        @Query("q") ifscCode: String
    ): Observable<Response<IFSCCityAndBranchApiResponse>>

    @GET("v1/{organizationId}/config/search/ifsc.config")
    fun getIFSCFromBankDetails(
        @Path("organizationId") organizationId: String,
        @Query("q") q: String
    ): Observable<Response<BankAccountIFSCResponseModel>>

    @POST("v1/{organizationId}/lms/cc/account/{accountId}/transaction/{transactionId}/convertToEmi")
    fun convertToEmi(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("transactionId") transactionId: String,
        @Body convertToEmiApiRequest: ConvertToEmiApiRequest
    ): Observable<Response<ConvertToEmiApiResponse>>

    @GET("v1/{organizationId}/lms/cc/account/{accountId}/transaction/{transactionId}/emiPrincipal")
    fun getTransactionEmiInfo(
        @Path("organizationId") organizationId: String,
        @Path("accountId") accountId: String,
        @Path("transactionId") transactionId: String
    ): Observable<Response<ConvertToEmiApiResponse>>

    @POST("v1/{organizationId}/mail/initMailVerification")
    fun emailSendOtp(
        @Path("organizationId") organizationId: String,
        @Body emailSendOtpRequest: EmailSendOtpRequest
    ): Observable<Response<EmailSendOtpApiResponse>>

    @POST("v1/{organizationId}/mail/resendOTP")
    fun emailResendOtp(
        @Path("organizationId") organizationId: String,
        @Body emailResendOtpRequest: EmailResendOtpRequest
    ): Observable<Response<EmailSendOtpApiResponse>>

    @POST("v1/{organizationId}/mail/verifyOTP")
    fun emailVerifyOtp(
        @Path("organizationId") organizationId: String,
        @Body emailVerifyOtpRequest: EmailVerifyOtpRequest
    ): Observable<Response<EmailVerifyOtpApiResponse>>

    @Multipart
    @POST("upload/single/aadhaarxml")
    fun uploadFileAadharXml(
        @Part("fileData") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Observable<Response<FileUploadResponse>>

    @POST("lms/cc/account/{accountId}/submitKyc")
    fun submitAadharKyc(
        @Path("accountId") accountId: String,
        @Body aadharKycRequest: AadharKycRequest
    ): Observable<Response<AadharKycResponse>>

    @POST("v1/{organizationId}/okyc/okycSubmit")
    fun submitAadharKycNew(
        @Path("organizationId") organizationId: String,
        @Body aadharKycRequest: AadharKycRequest
    ): Observable<Response<AadharKycResponse>>

    @POST("v1/{organizationId}/okyc/getAddress")
    fun getAdharAddrss(
        @Path("organizationId") organizationId: String,
        @Body request: LeadRequest
    ): Observable<Response<AadharKycResponse>>

    @GET("v1/{organizationId}/leads/{leadId}/getBureauAddress")
    fun getBureauAddrss(
        @Path("organizationId") organizationId: String,
        @Path("leadId") leadId: String
    ): Observable<Response<BureauAddressResponse>>

    @POST("v1/{organizationId}/leads/{leadId}/setAddress")
    fun selectAdharAddress(
        @Path("organizationId") organizationId: String,
        @Path("leadId") leadId: String,
        @Body request: ConfirmAdharAddrsRequest
    ): Observable<Response<LeadDetailApiResponse>>

    @POST("rdm/sms")
    fun sendSMSData(@Body request: SMSDataRequest): Observable<Response<ApiBaseResponse>>

    @POST("v1/{organizationId}/leads/{leadId}/addressSubmit")
    fun addressSubmit(
        @Path("organizationId") organizationId: String,
        @Path("leadId") leadId: String,
        @Body request: AddressSubmitRequest
    ): Observable<Response<LeadDetailApiResponse>>

    @POST("v1/{organizationId}/leads/{leadId}/companySubmit")
    fun companySubmit(
        @Path("organizationId") organizationId: String,
        @Path("leadId") leadId: String,
        @Body request: CompanyNameSubmitRequest
    ): Observable<Response<LeadDetailApiResponse>>

}