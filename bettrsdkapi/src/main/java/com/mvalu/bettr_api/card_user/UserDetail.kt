package com.mvalu.bettr_api.card_user

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

class UserDetail() : Parcelable {

    @field:Json(name = "id")
    var id: String? = null

    @field:Json(name = "mobileNumber")
    var mobileNumber: String? = null

    @field:Json(name = "mobileNumberCountryCodePrefix")
    var mobileNumberCountryCodePrefix: String? = null

    @field:Json(name = "isFirstTimeCustomer")
    var isFirstTime: Boolean? = false

    @field:Json(name = "firstName")
    var firstName: String? = null

    @field:Json(name = "middleName")
    var middleName: String? = null

    @field:Json(name = "lastName")
    var lastName: String? = null

    @field:Json(name = "status")
    var status: String? = null

    @field:Json(name = "city")
    var city: String? = null

    @field:Json(name = "state")
    var state: String? = null

    @field:Json(name = "pincode")
    var pincode: String? = null

    @field:Json(name = "addressLine1")
    var addressLine1: String? = null

    @field:Json(name = "addressLine2")
    var addressLine2: String? = null

    @field:Json(name = "locality")
    var locality: String? = null

    @field:Json(name = "gender")
    var gender: String? = null

    @field:Json(name = "dateOfBirth")
    var dateOfBirth: String? = null

    @Transient
    var dateOfBirthInput: String? = null

    @field:Json(name = "email")
    var email: String? = null

    @field:Json(name = "isEmailVerified")
    var isEmailVerified: Boolean? = null

    @JvmSuppressWildcards
    @field:Json(name = "location")
    var location: Location? = null

    @field:Json(name = "aadharCard")
    var aadharCard: String? = null

    @field:Json(name = "aadharCardBack")
    var aadharCardBack: String? = null

    @field:Json(name = "photo")
    var photo: String? = null

    @field:Json(name = "cancelledCheque")
    var cancelledCheque: String? = null

    @field:Json(name = "accountHolderName")
    var accountHolderName: String? = null

    var accountHolderNameEditable: String? = null

    @field:Json(name = "panVerified")
    var isPanVerified: Boolean? = false

    @field:Json(name = "aadharVerified")
    var isAadharVerified: Boolean? = false

    @field:Json(name = "isBankAccountVerified")
    var isBankAccountVerified: Boolean? = false


    //customer detail merge
    @field:Json(name = "residenceType")
    var residenceType: String? = null

    @field:Json(name = "residenceSince")
    var residenceSince: String? = null

    @field:Json(name = "professionType")
    var professionType: String? = null

    @field:Json(name = "profession")
    var profession: String? = null

    @field:Json(name = "isExistingLoan")
    var isExistingLoan: Boolean? = null

    @field:Json(name = "isCreditCard")
    var isCreditCard: Boolean? = null

    @field:Json(name = "totalEMIPaid")
    var totalEMIPaid: String? = null

    @field:Json(name = "panNumber")
    var panNumber: String? = null


    @field:Json(name = "panNumberAsText")
    var panNumberAsText: String? = null

    @Transient
    var panNumberEditable: String? = null

    @field:Json(name = "aadharNumber")
    var aadharNumber: String? = null

    @Transient
    var aadharNumberEditable: String? = null

    @field:Json(name = "pan")
    var panImage: String? = null

    @field:Json(name = "takeHomeSalary")
    var takeHomeSalary: Int? = null

    @field:Json(name = "familyMonthlyIncome")
    var familyMonthlyIncome: Int? = null

    @field:Json(name = "modeOfSalary")
    var modeOfSalary: String? = null

    @field:Json(name = "employerName")
    var employerName: String? = null

    @field:Json(name = "designation")
    var designation: String? = null

    @field:Json(name = "timeSpentInCurrentJob")
    var timeSpentInCurrentJob: String? = null

    @field:Json(name = "workExperience")
    var workExperience: String? = null

    @field:Json(name = "fatherName")
    var fatherName: String? = null

    @field:Json(name = "husbandName")
    var husbandName: String? = null

    @field:Json(name = "motherName")
    var motherName: String? = null

    @field:Json(name = "maritalStatus")
    var maritalStatus: String? = null

    @field:Json(name = "officeEmail")
    var officeEmail: String? = null

    @field:Json(name = "isOfficeEmailVerified")
    var isOfficeEmailVerified: Boolean? = null

    @field:Json(name = "isOfficeEmailSkipped")
    var isOfficeEmailSkipped: Boolean? = null

    @field:Json(name = "officeAddress1")
    var officeAddress1: String? = null

    @field:Json(name = "officeAddress2")
    var officeAddress2: String? = null

    @field:Json(name = "officeAddressLocality")
    var officeAddressLocality: String? = null

    @field:Json(name = "officeAddressLandMark")
    var officeAddressLandMark: String? = null

    @field:Json(name = "officeAddressCity")
    var officeAddressCity: String? = null

    @field:Json(name = "officeAddressState")
    var officeAddressState: String? = null

    @field:Json(name = "officeAddressPincode")
    var officeAddressPinCode: String? = null

    @field:Json(name = "landMark")
    var landMark: String? = null

    @field:Json(name = "permanentAddress1")
    var permanentAddress1: String? = null

    @field:Json(name = "permanentAddress2")
    var permanentAddress2: String? = null

    @field:Json(name = "permanentAddressLocality")
    var permanentAddressLocality: String? = null

    @field:Json(name = "permanentAddressLandMark")
    var permanentAddressLandMark: String? = null

    @field:Json(name = "permanentAddressCity")
    var permanentAddressCity: String? = null

    @field:Json(name = "permanentAddressState")
    var permanentAddressState: String? = null

    @field:Json(name = "permanentAddressPincode")
    var permanentAddressPinCode: String? = null

    @field:Json(name = "isPermanentAddressSame")
    var isPermanentAddressSame: Boolean? = null

    @field:Json(name = "highestLevelOfEducation")
    var education: String? = null

    @field:Json(name = "lastEducationalInstitute")
    var lastEducationalInstitute: String? = null

    @field:Json(name = "bankStatement")
    var bankStatement: List<String>? = mutableListOf()

    @field:Json(name = "salarySlip")
    var salarySlip: List<String>? = mutableListOf()

    @field:Json(name = "idProofType")
    var idProofType: String? = null

    @field:Json(name = "idProof")
    var idProof: List<String>? = mutableListOf()

    @field:Json(name = "addressProofType")
    var addressProofType: String? = null

    @field:Json(name = "addressProof")
    var addressProof: List<String>? = mutableListOf()

    @field:Json(name = "emailAuthorizationToken")
    var emailAuthToken: String? = null

    @field:Json(name = "isEmailTokenValid")
    var isEmailTokenValid: Boolean? = null

    @field:Json(name = "panValidateId")
    var panValidateId: String? = null

    @field:Json(name = "aadharValidateId")
    var aadharValidateId: String? = null

    @field:Json(name = "photoValidateId")
    var photoValidateId: String? = null

    @field:Json(name = "aadharFaceCheckId")
    var aadharFaceCheckId: String? = null

    @field:Json(name = "panFaceCheckId")
    var panFaceCheckId: String? = null

    @field:Json(name = "whatsupConsent")
    var whatsAppConsent: Boolean? = false

    @field:Json(name = "preApproval")
    var preApproval: Boolean? = false

//    @field:Json(name = "preApprovalDetail")
//    var preApprovalDetail: PreApprovalDetail? = null

    @field:Json(name = "mapPinnedLatitude")
    var mapPinnedLatitude: Double? = null

    @field:Json(name = "mapPinnedLongitude")
    var mapPinnedLongitude: Double? = null

    @field:Json(name = "mapPinnedAddress")
    var mapPinnedAddress: String? = null

    @field:Json(name = "areYouEmployedInCompany")
    var employedInCompany: String? = null

    @field:Json(name = "employment")
    var employment: String? = null //WORKING_PROFESSIONAL

    @field:Json(name = "companyType")
    var companyType: String? = null //PRIVATE

    @field:Json(name = "noOfEmployeeInCompany")
    var noOfEmployeeInCompany: String? = null //0_100

    @field:Json(name = "noOfEmployeeInBusiness")
    var noOfEmployeeInBusiness: String? = null //0_100

    @field:Json(name = "ownBusiness")
    var ownBusiness: String? = null //shop_owner

    @field:Json(name = "roleInCompany")
    var roleInCompany: String? = null //SALES

    @field:Json(name = "companyAreaOfBusiness")
    var companyAreaOfBusiness: String? = null //HOSPITALITY

    @field:Json(name = "typeOfBusiness")
    var typeOfBusiness: String? = null //typeOfBusiness

    @field:Json(name = "dateOfSalary")
    var dateOfSalary: String? = null //"31"

    @field:Json(name = "areYouEmployed")
    var areYouEmployed: String? = null

    @field:Json(name = "havingITR")
    var havingITR: String? = null

    @field:Json(name = "havingOfficeMail")
    var havingOfficeMail: Boolean? = null

    @field:Json(name = "isOwnABusiness")
    var isOwnABusiness: String? = null

    @field:Json(name = "shopName")
    var shopName: String? = null

    @field:Json(name = "gstInvoice")
    var gstInvoice: String? = null

    @field:Json(name = "gstIssueCertificate")
    var gstIssueCertificate: String? = null

    @field:Json(name = "shopPhotoInside")
    var shopPhotoInside: List<String>? = mutableListOf()

    @field:Json(name = "shopPhotoOutside")
    var shopPhotoOutside: List<String>? = mutableListOf()

    @field:Json(name = "establishmentRegistration")
    var establishmentRegistration: String? = null

    @field:Json(name = "companyIdCard")
    var companyIdCard: String? = null

    @field:Json(name = "companyBusinessCard")
    var companyBusinessCard: String? = null

    @field:Json(name = "nachRazorpayTokenId")
    var nachRazorpayTokenId: String? = null

    @field:Json(name = "isRazorpayFailed")
    var isRazorpayFailed: Boolean? = false

    @field:Json(name = "isEnachSkip")
    var isEnachSkip: Boolean? = false

    @field:Json(name = "isSalarySlipSkipped")
    var isSalarySlipSkipped: Boolean? = false

    @field:Json(name = "isBankStatementSkipped")
    var isBankStatementSkipped: Boolean? = false

    @field:Json(name = "isCompanyIdCardSkipped")
    var isCompanyIdCardSkipped: Boolean? = false

    @field:Json(name = "isCompanyBusinessCardSkipped")
    var isCompanyBusinessCardSkipped: Boolean? = false

    @field:Json(name = "isGstInvoiceSkipped")
    var isGstInvoiceSkipped: Boolean? = false

    @field:Json(name = "isGstIssueCertificateSkipped")
    var isGstIssueCertificateSkipped: Boolean? = false

    @field:Json(name = "isShopPhotoInsideSkipped")
    var isShopPhotoInsideSkipped: Boolean? = false

    @field:Json(name = "isShopPhotoOutsideSkipped")
    var isShopPhotoOutsideSkipped: Boolean? = false

    @field:Json(name = "isEstablishmentRegistrationSkipped")
    var isEstablishmentRegistrationSkipped: Boolean? = false


    /**
     * Other method
     */
    fun getAadharNumberDigits(): String? {
        return aadharNumberEditable?.replace("-", "")
    }


    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        mobileNumber = parcel.readString()
        mobileNumberCountryCodePrefix = parcel.readString()
        isFirstTime = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        firstName = parcel.readString()
        middleName = parcel.readString()
        lastName = parcel.readString()
        city = parcel.readString()
        state = parcel.readString()
        pincode = parcel.readString()
        addressLine1 = parcel.readString()
        addressLine2 = parcel.readString()
        locality = parcel.readString()
        gender = parcel.readString()
        dateOfBirth = parcel.readString()
        dateOfBirthInput = parcel.readString()
        email = parcel.readString()
        isEmailVerified = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        location = parcel.readParcelable(Location::class.java.classLoader)
        panNumber = parcel.readString()
        panNumberAsText = parcel.readString()
        panImage = parcel.readString()
        aadharNumber = parcel.readString()
        aadharCard = parcel.readString()
        photo = parcel.readString()
        aadharCardBack = parcel.readString()
        accountHolderName = parcel.readString()
        cancelledCheque = parcel.readString()
        status = parcel.readString()
        isAadharVerified = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isPanVerified = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isBankAccountVerified = parcel.readValue(Boolean::class.java.classLoader) as? Boolean

        panNumberEditable = parcel.readString()
        aadharNumberEditable = parcel.readString()
        accountHolderNameEditable = parcel.readString()
        residenceSince = parcel.readString()
        residenceType = parcel.readString()
        professionType = parcel.readString()
        profession = parcel.readString()
        isExistingLoan = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        takeHomeSalary = parcel.readValue(Boolean::class.java.classLoader) as? Int
        familyMonthlyIncome = parcel.readValue(Boolean::class.java.classLoader) as? Int
        modeOfSalary = parcel.readString()
        employerName = parcel.readString()
        designation = parcel.readString()
        timeSpentInCurrentJob = parcel.readString()
        workExperience = parcel.readString()
        fatherName = parcel.readString()
        husbandName = parcel.readString()
        motherName = parcel.readString()
        maritalStatus = parcel.readString()
        officeEmail = parcel.readString()
        isOfficeEmailVerified = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isOfficeEmailSkipped = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        officeAddress1 = parcel.readString()
        officeAddress2 = parcel.readString()
        officeAddressLocality = parcel.readString()
        officeAddressCity = parcel.readString()
        officeAddressLandMark = parcel.readString()
        officeAddressPinCode = parcel.readString()
        officeAddressState = parcel.readString()
        landMark = parcel.readString()
        permanentAddress1 = parcel.readString()
        permanentAddress2 = parcel.readString()
        permanentAddressLocality = parcel.readString()
        permanentAddressCity = parcel.readString()
        permanentAddressLandMark = parcel.readString()
        permanentAddressPinCode = parcel.readString()
        permanentAddressState = parcel.readString()
        isPermanentAddressSame = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        education = parcel.readString()
        lastEducationalInstitute = parcel.readString()
        bankStatement = parcel.readValue(List::class.java.classLoader) as? List<String>
        salarySlip = parcel.readValue(List::class.java.classLoader) as? List<String>
        idProof = parcel.readValue(List::class.java.classLoader) as? List<String>
        addressProofType = parcel.readString()
        addressProof = parcel.readValue(List::class.java.classLoader) as? List<String>
//        parcel.readStringList(bankStatement)
//        parcel.readStringList(salarySlip)
//        parcel.readStringList(idProof)
//        parcel.readStringList(addressProof)
        emailAuthToken = parcel.readString()
        isEmailTokenValid = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        panValidateId = parcel.readString()
        aadharValidateId = parcel.readString()
        photoValidateId = parcel.readString()
        aadharFaceCheckId = parcel.readString()
        panFaceCheckId = parcel.readString()
        whatsAppConsent = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        preApproval = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
//        preApprovalDetail = parcel.readParcelable(PreApprovalDetail::class.java.classLoader)
        mapPinnedAddress = parcel.readString()
        mapPinnedLatitude = parcel.readValue(Double::class.java.classLoader) as? Double
        mapPinnedLongitude = parcel.readValue(Double::class.java.classLoader) as? Double
        employedInCompany = parcel.readString()
        employment = parcel.readString()
        companyType = parcel.readString()
        noOfEmployeeInCompany = parcel.readString()
        noOfEmployeeInBusiness = parcel.readString()
        ownBusiness = parcel.readString()
        roleInCompany = parcel.readString()
        companyAreaOfBusiness = parcel.readString()
        typeOfBusiness = parcel.readString()
        dateOfSalary = parcel.readString()
        areYouEmployed = parcel.readString()
        havingITR = parcel.readString()
        havingOfficeMail = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isOwnABusiness = parcel.readString()
        shopName = parcel.readString()
        gstInvoice = parcel.readString()
        gstIssueCertificate = parcel.readString()
        shopPhotoInside = parcel.readValue(List::class.java.classLoader) as? List<String>
        shopPhotoOutside = parcel.readValue(List::class.java.classLoader) as? List<String>
//        parcel.readStringList(shopPhotoInside)
//        parcel.readStringList(shopPhotoOutside)
        establishmentRegistration = parcel.readString()
        companyIdCard = parcel.readString()
        companyBusinessCard = parcel.readString()
        nachRazorpayTokenId = parcel.readString()
        isRazorpayFailed = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isEnachSkip = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isSalarySlipSkipped = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isBankStatementSkipped = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isCompanyIdCardSkipped = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isCompanyBusinessCardSkipped = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isGstInvoiceSkipped = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isGstIssueCertificateSkipped = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isShopPhotoInsideSkipped = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isShopPhotoOutsideSkipped = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isEstablishmentRegistrationSkipped = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(mobileNumber)
        parcel.writeString(mobileNumberCountryCodePrefix)
        parcel.writeValue(isFirstTime)
        parcel.writeString(firstName)
        parcel.writeString(middleName)
        parcel.writeString(lastName)
        parcel.writeString(city)
        parcel.writeString(state)
        parcel.writeString(pincode)
        parcel.writeString(addressLine1)
        parcel.writeString(addressLine2)
        parcel.writeString(locality)
        parcel.writeString(gender)
        parcel.writeString(dateOfBirth)
        parcel.writeString(dateOfBirthInput)
        parcel.writeString(email)
        parcel.writeValue(isEmailVerified)
        parcel.writeParcelable(location, flags)
        parcel.writeString(panNumber)
        parcel.writeString(panNumberAsText)
        parcel.writeString(panImage)
        parcel.writeString(aadharNumber)
        parcel.writeString(aadharCard)
        parcel.writeString(photo)
        parcel.writeString(aadharCardBack)
        parcel.writeString(accountHolderName)
        parcel.writeString(cancelledCheque)
        parcel.writeString(status)
        parcel.writeValue(isAadharVerified)
        parcel.writeValue(isPanVerified)
        parcel.writeValue(isBankAccountVerified)

        parcel.writeString(panNumberEditable)
        parcel.writeString(aadharNumberEditable)
        parcel.writeString(accountHolderNameEditable)
        parcel.writeString(residenceSince)
        parcel.writeString(residenceType)
        parcel.writeString(professionType)
        parcel.writeString(profession)
        parcel.writeValue(isExistingLoan)
        parcel.writeValue(takeHomeSalary)
        parcel.writeValue(familyMonthlyIncome)
        parcel.writeString(modeOfSalary)
        parcel.writeString(employerName)
        parcel.writeString(designation)
        parcel.writeString(timeSpentInCurrentJob)
        parcel.writeString(workExperience)
        parcel.writeString(fatherName)
        parcel.writeString(husbandName)
        parcel.writeString(motherName)
        parcel.writeString(maritalStatus)
        parcel.writeString(officeEmail)
        parcel.writeValue(isOfficeEmailVerified)
        parcel.writeValue(isOfficeEmailSkipped)
        parcel.writeString(officeAddress1)
        parcel.writeString(officeAddress2)
        parcel.writeString(officeAddressLocality)
        parcel.writeString(officeAddressCity)
        parcel.writeString(officeAddressLandMark)
        parcel.writeString(officeAddressPinCode)
        parcel.writeString(officeAddressState)
        parcel.writeString(landMark)
        parcel.writeString(permanentAddress1)
        parcel.writeString(permanentAddress2)
        parcel.writeString(permanentAddressLocality)
        parcel.writeString(permanentAddressCity)
        parcel.writeString(permanentAddressLandMark)
        parcel.writeString(permanentAddressPinCode)
        parcel.writeString(permanentAddressState)
        parcel.writeValue(isPermanentAddressSame)
        parcel.writeString(education)
        parcel.writeString(lastEducationalInstitute)
        parcel.writeValue(bankStatement)
        parcel.writeValue(salarySlip)
        parcel.writeValue(idProof)
        parcel.writeString(addressProofType)
        parcel.writeValue(addressProof)
//        parcel.writeList(bankStatement)
//        parcel.writeList(salarySlip)
//        parcel.writeList(idProof)
//        parcel.writeList(addressProof)
        parcel.writeString(emailAuthToken)
        parcel.writeValue(isEmailTokenValid)
        parcel.writeString(panValidateId)
        parcel.writeString(aadharValidateId)
        parcel.writeString(photoValidateId)
        parcel.writeString(aadharFaceCheckId)
        parcel.writeString(panFaceCheckId)
        parcel.writeValue(whatsAppConsent)
        parcel.writeValue(preApproval)
//        parcel.writeParcelable(preApprovalDetail, flags)
        parcel.writeString(mapPinnedAddress)
        parcel.writeValue(mapPinnedLatitude)
        parcel.writeValue(mapPinnedLongitude)
        parcel.writeString(employedInCompany)
        parcel.writeString(employment)
        parcel.writeString(companyType)
        parcel.writeString(noOfEmployeeInCompany)
        parcel.writeString(noOfEmployeeInBusiness)
        parcel.writeString(ownBusiness)
        parcel.writeString(roleInCompany)
        parcel.writeString(companyAreaOfBusiness)
        parcel.writeString(typeOfBusiness)
        parcel.writeString(dateOfSalary)
        parcel.writeString(areYouEmployed)
        parcel.writeString(havingITR)
        parcel.writeValue(havingOfficeMail)
        parcel.writeString(isOwnABusiness)
        parcel.writeString(shopName)
        parcel.writeString(gstInvoice)
        parcel.writeString(gstIssueCertificate)
        parcel.writeValue(shopPhotoInside)
        parcel.writeValue(shopPhotoOutside)
//        parcel.writeList(shopPhotoInside)
//        parcel.writeList(shopPhotoOutside)
        parcel.writeString(establishmentRegistration)
        parcel.writeString(companyIdCard)
        parcel.writeString(companyBusinessCard)
        parcel.writeString(nachRazorpayTokenId)
        parcel.writeValue(isRazorpayFailed)
        parcel.writeValue(isEnachSkip)
        parcel.writeValue(isSalarySlipSkipped)
        parcel.writeValue(isBankStatementSkipped)
        parcel.writeValue(isCompanyIdCardSkipped)
        parcel.writeValue(isCompanyBusinessCardSkipped)
        parcel.writeValue(isGstInvoiceSkipped)
        parcel.writeValue(isGstIssueCertificateSkipped)
        parcel.writeValue(isShopPhotoInsideSkipped)
        parcel.writeValue(isShopPhotoOutsideSkipped)
        parcel.writeValue(isEstablishmentRegistrationSkipped)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserDetail> {
        override fun createFromParcel(parcel: Parcel): UserDetail {
            return UserDetail(parcel)
        }

        override fun newArray(size: Int): Array<UserDetail?> {
            return arrayOfNulls(size)
        }
    }

    class Location() : Parcelable {

        @field:Json(name = "latitude")
        var latitude: Double? = null

        @field:Json(name = "longitude")
        var longitude: Double? = null

        @field:Json(name = "address")
        var address: String? = null

        constructor(parcel: Parcel) : this() {
            latitude = parcel.readValue(Double::class.java.classLoader) as? Double
            longitude = parcel.readValue(Double::class.java.classLoader) as? Double
            address = parcel.readString()
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeValue(latitude)
            parcel.writeValue(longitude)
            parcel.writeString(address)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Location> {
            override fun createFromParcel(parcel: Parcel): Location {
                return Location(parcel)
            }

            override fun newArray(size: Int): Array<Location?> {
                return arrayOfNulls(size)
            }
        }

    }
}