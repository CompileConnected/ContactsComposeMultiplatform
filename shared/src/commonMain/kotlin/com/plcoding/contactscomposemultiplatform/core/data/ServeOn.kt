package com.plcoding.contactscomposemultiplatform.core.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServeOn (

    @SerialName("id"                   ) var id                   : String?              = null,
    @SerialName("createdBy"            ) var createdBy            : String?              = null,
    @SerialName("createdDate"          ) var createdDate          : Long?                = null,
    @SerialName("modifiedBy"           ) var modifiedBy           : String?              = null,
    @SerialName("modifiedDate"         ) var modifiedDate         : String?              = null,
    @SerialName("ownerCompanyId"       ) var ownerCompanyId       : String?              = null,
    @SerialName("systemGenerated"      ) var systemGenerated      : String?              = null,
    @SerialName("servedId"             ) var servedId             : String?              = null,
    @SerialName("serveOnTime"          ) var serveOnTime          : Long?                = null,
    @SerialName("serveOffTime"         ) var serveOffTime         : String?              = null,
    @SerialName("serveOnTimeLong"      ) var serveOnTimeLong      : Long?                = null,
    @SerialName("serveOffTimeLong"     ) var serveOffTimeLong     : Long?                = null,
    @SerialName("serveOnTimeString"    ) var serveOnTimeString    : String?              = null,
    @SerialName("serveOffTimeString"   ) var serveOffTimeString   : String?              = null,
    @SerialName("inRadius"             ) var inRadius             : String?              = null,
    @SerialName("npk"                  ) var npk                  : String?              = null,
    @SerialName("userId"               ) var userId               : String?              = null,
    @SerialName("name"                 ) var name                 : String?              = null,
    @SerialName("thirdPartyEmployeeId" ) var thirdPartyEmployeeId : String?              = null,
    @SerialName("shiftId"              ) var shiftId              : String?              = null,
    @SerialName("companyId"            ) var companyId            : String?              = null,
    @SerialName("siteId"               ) var siteId               : String?              = null,
    @SerialName("startTime"            ) var startTime            : String?              = null,
    @SerialName("endTime"              ) var endTime              : String?              = null,
    @SerialName("startBreakTime"       ) var startBreakTime       : String?              = null,
    @SerialName("endBreakTime"         ) var endBreakTime         : String?              = null,
    @SerialName("qrCodeId"             ) var qrCodeId             : String?              = null,
    @SerialName("companyName"          ) var companyName          : String?              = null,
    @SerialName("siteName"             ) var siteName             : String?              = null,
    @SerialName("locationName"         ) var locationName         : String?              = null,
    @SerialName("type"                 ) var type                 : String?              = null,
    @SerialName("keterangan"           ) var keterangan           : String?              = null,
    @SerialName("totalHours"           ) var totalHours           : Double?                = null,
    @SerialName("serveOnLocation"      ) var serveOnLocation      : String?              = null,
    @SerialName("serveOnLatitude"      ) var serveOnLatitude      : Double?                = null,
    @SerialName("serveOnLongitude"     ) var serveOnLongitude     : Double?                = null,
    @SerialName("serveOffLocation"     ) var serveOffLocation     : String?              = null,
    @SerialName("serveOffLatitude"     ) var serveOffLatitude     : Double?                = null,
    @SerialName("serveOffLongitude"    ) var serveOffLongitude    : Double?                = null,
    @SerialName("description"          ) var description          : String?              = null,
    @SerialName("image"                ) var image                : String?              = null,
    @SerialName("path"                 ) var path                 : String?              = null,
    @SerialName("timezone"             ) var timezone             : String?              = null,
    @SerialName("addhocid"             ) var addhocid             : String?              = null,
    @SerialName("status"               ) var status               : String?              = null,
    @SerialName("directHead"           ) var directHead           : String?              = null,
    @SerialName("directHeadName"       ) var directHeadName       : String?              = null,
    @SerialName("approvalRemark"       ) var approvalRemark       : String?              = null,
    @SerialName("approvalDate"         ) var approvalDate         : String?              = null,
    @SerialName("session"              ) var session              : String?              = null,
    @SerialName("mandays"              ) var mandays              : String?              = null,
    @SerialName("codecase"             ) var codecase             : String?              = null,
    @SerialName("timeSheets"           ) var timeSheets           : TimeSheets?          = TimeSheets(),
    @SerialName("corrections"          ) var corrections          : Corrections?         = Corrections(),
    @SerialName("histories"            ) var histories            : List<History>        = listOf(),
    @SerialName("row"                  ) var row                  : Long?                = null,
    @SerialName("page"                 ) var page                 : Long?                = null,
    @SerialName("sortColumn"           ) var sortColumn           : String?              = null,
    @SerialName("sortType"             ) var sortType             : String?              = null,
    @SerialName("nearestDistance"      ) var nearestDistance      : Double?                = null,
    @SerialName("nearestLocation"      ) var nearestLocation      : Double?              = null,
    @SerialName("selected"             ) var selected             : Boolean?             = null

) {
    @Serializable
    data class TimeSheets (

        @SerialName("id"                        ) var id                      : String? = null,
        @SerialName("createdBy"                 ) var createdBy               : String? = null,
        @SerialName("createdDate"               ) var createdDate             : String? = null,
        @SerialName("modifiedBy"                ) var modifiedBy              : String? = null,
        @SerialName("modifiedDate"              ) var modifiedDate            : String? = null,
        @SerialName("ownerCompanyId"            ) var ownerCompanyId          : String? = null,
        @SerialName("systemGenerated"           ) var systemGenerated         : String? = null,
        @SerialName("serveId"                   ) var serveId                 : String? = null,
        @SerialName("npk"                       ) var npk                     : String? = null,
        @SerialName("userid"                    ) var userid                  : String? = null,
        @SerialName("serve_group_id"            ) var serveGroupId            : String? = null,
        @SerialName("serve_group_name"          ) var serveGroupName          : String? = null,
        @SerialName("assignment_id"             ) var assignmentId            : String? = null,
        @SerialName("assignmentName"            ) var assignmentName          : String? = null,
        @SerialName("activity_id"               ) var activityId              : String? = null,
        @SerialName("activity_name"             ) var activityName            : String? = null,
        @SerialName("start_time"                ) var startTime               : Long?    = null,
        @SerialName("end_time"                  ) var endTime                 : Long?    = null,
        @SerialName("result_id"                 ) var resultId                : String? = null,
        @SerialName("result_name"               ) var resultName              : String? = null,
        @SerialName("description"               ) var description             : String? = null,
        @SerialName("achievement"               ) var achievement             : String? = null,
        @SerialName("type_id"                   ) var typeId                  : String? = null,
        @SerialName("type_name"                 ) var typeName                : String? = null,
        @SerialName("selling_step_id"           ) var sellingStepId           : String? = null,
        @SerialName("selling_step_name"         ) var sellingStepName         : String? = null,
        @SerialName("next_activity_date"        ) var nextActivityDate        : String? = null,
        @SerialName("next_activity_description" ) var nextActivityDescription : String? = null

    )

    @Serializable
    data class History (

        @SerialName("id"              ) var id              : String? = null,
        @SerialName("createdBy"       ) var createdBy       : String? = null,
        @SerialName("createdDate"     ) var createdDate     : Long?   = null,
        @SerialName("modifiedBy"      ) var modifiedBy      : String? = null,
        @SerialName("modifiedDate"    ) var modifiedDate    : String? = null,
        @SerialName("ownerCompanyId"  ) var ownerCompanyId  : String? = null,
        @SerialName("systemGenerated" ) var systemGenerated : String? = null,
        @SerialName("histori_id"      ) var historyId       : String? = null,
        @SerialName("activityName"    ) var activityName    : String? = null,
        @SerialName("activity_code"   ) var activityCode    : String? = null,
        @SerialName("npk"             ) var npk             : String? = null,
        @SerialName("name"            ) var name            : String? = null

    )

    @Serializable
    data class Corrections (

        @SerialName("serveId"    ) var serveId    : String? = null,
        @SerialName("reason_id"  ) var reasonId   : String? = null,
        @SerialName("reasonName" ) var reasonName : String? = null,
        @SerialName("remark"     ) var remark     : String? = null

    )

}




