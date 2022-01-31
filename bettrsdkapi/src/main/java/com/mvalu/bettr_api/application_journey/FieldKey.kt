package com.mvalu.bettr_api.application_journey

enum class FieldKey(val value: String) {
    /*** Personal details section */
    GENDER("gender"),
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    PAN_NUMBER("panNumber"),
    DOB("dateOfBirth"),
    MARITAL_STATUS("maritalStatus"),
    HUSBAND_NAME("husbandName"),
    FATHER_NAME("fatherName"),

    /*** Residential details section */
    ADDRESS_LINE_1("addressLine1"),
    ADDRESS_LINE_2("addressLine2"),
    LOCALITY("locality"),
    LANDMARK("landMark"),
    PINCODE("pincode"),
    CITY("city"),
    RESIDENCE_TYPE("residenceType"),
    LOCATION("location"),
    BUREAU_VERIFIED("bureauVerified"),

    /*** Income details section */
    ARE_YOU_EMPLOYED_IN_A_COMPANY("areYouEmployedInCompany"),
    DESIGNATION("designation"),
    ROLE_IN_YOUR_COMPANY("roleInCompany"),
    COMPANY_TYPE("companyType"),
    COMPANY_NAME("employerName"),
    BUSINESS_OF_COMPANY("companyAreaOfBusiness"),
    MONTHLY_INCOME("takeHomeSalary"),
    NO_OF_EMPLOYEE_IN_COMPANY("noOfEmployeeInCompany"),
    DO_YOU_OWN_BUSINESS("isOwnABusiness"),
    YOU_ARE("ownBusiness"),
    SHOP_NAME("shopName"),
    TYPE_OF_BUSINESS("typeOfBusiness"),
    NO_OF_EMPLOYEES_IN_BUSINESS("noOfEmployeeInBusiness"),
    ARE_YOU_EMPLOYED("areYouEmployed"),
    OFFICE_EMAIL("officeEmail"),
    EMPLOYMENT_TYPE("employmentType"),
    DO_YOU_FILE_ITR("havingITR"),
    FAMILY_MONTHLY_INCOME("familyMonthlyIncome"),
    OFFICE_ADDRESS("officeAddress1"),

    /*** Income documents section */
    SALARY_SLIP("salarySlip"),
    BANK_STATEMENT("bankStatement"),
    COMPANY_ID_CARD("companyIdCard"),
    COMPANY_BUSINESS_CARD("companyBusinessCard"),
    GST_INVOICE("gstInvoice"),
    GST_ISSUE_CERTIFICATE("gstIssueCertificate"),
    SHOP_PHOTO_INSIDE("shopPhotoInside"),
    SHOP_PHOTO_OUTSIDE("shopPhotoOutside"),
    ESTABLISHMENT_REGISTRATION("establishmentRegistration"),

    /*** kyc documents section */
    PAN("pan"),
    AADHAR_CARD("aadharCard"),
    AADHAR_CARD_BACK("aadharCardBack"),
    ADDRESS_PROOF("addressProof"),
    SELFIE("photo"),

    /*** kyc documents section */
    BANK_NAME("bankName"),
    ACCOUNT_NUMBER("bankAccountNumber"),
    IFSC("bankIfsc")
}