package com.plcoding.contactscomposemultiplatform.core.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserProfile (

    @SerialName("id"                      ) val id                      : String? = null,
    @SerialName("createdBy"               ) val createdBy               : String? = null,
    @SerialName("createdDate"             ) val createdDate             : Long?    = null,
    @SerialName("modifiedBy"              ) val modifiedBy              : String? = null,
    @SerialName("modifiedDate"            ) val modifiedDate            : Long?    = null,
    @SerialName("ownerCompanyId"          ) val ownerCompanyId          : String? = null,
    @SerialName("systemGenerated"         ) val systemGenerated         : String? = null,
    @SerialName("name"                    ) val name                    : String? = null,
    @SerialName("imei"                    ) val imei                    : String? = null,
    @SerialName("mobilePhone"             ) val mobilePhone             : String? = null,
    @SerialName("homePhone"               ) val homePhone               : String? = null,
    @SerialName("email"                   ) val email                   : String? = null,
    @SerialName("officePhone"             ) val officePhone             : String? = null,
    @SerialName("officePhoneExt"          ) val officePhoneExt          : String? = null,
    @SerialName("apkCurrent"              ) val apkCurrent              : String? = null,
    @SerialName("apkTarget"               ) val apkTarget               : String? = null,
    @SerialName("profilePicture"          ) val profilePicture          : String? = null,
    @SerialName("departmentId"            ) val departmentId            : String? = null,
    @SerialName("jobId"                   ) val jobId                   : String? = null,
    @SerialName("locationAuthorizationId" ) val locationAuthorizationId : String? = null,
    @SerialName("remark"                  ) val remark                  : String? = null,
    @SerialName("organizationId"          ) val organizationId          : String? = null,
    @SerialName("jobName"                 ) val jobName                 : String? = null,
    @SerialName("departmentName"          ) val departmentName          : String? = null,
    @SerialName("companyId"               ) val companyId               : String? = null,
    @SerialName("companyName"             ) val companyName             : String? = null,
    @SerialName("siteId"                  ) val siteId                  : String? = null,
    @SerialName("siteName"                ) val siteName                : String? = null,
    @SerialName("address"                 ) val address                 : String? = null,
    @SerialName("birthday"                ) val birthday                : String? = null,
    @SerialName("customerId"              ) val customerId              : String? = null,
    @SerialName("customerName"            ) val customerName            : String? = null,
    @SerialName("supervisorId"            ) val supervisorId            : String? = null,
    @SerialName("supervisorName"          ) val supervisorName          : String? = null,
    @SerialName("worklocationId"          ) val worklocationId          : String? = null,
    @SerialName("worklocationAddress"     ) val worklocationAddress     : String? = null,
    @SerialName("korlap_admin"            ) val korlapAdmin             : String? = null,
    @SerialName("fax"                     ) val fax                     : String? = null,
    @SerialName("fromDate"                ) val fromDate                : String? = null,
    @SerialName("toDate"                  ) val toDate                  : String? = null,
    @SerialName("keterangan"              ) val description             : String? = null

)