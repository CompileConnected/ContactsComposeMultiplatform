package com.plcoding.contactscomposemultiplatform.core.network.serveon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServeOnRequest(
    @SerialName("servedId"                  ) var servedId                : String? = null,
    @SerialName("name"                      ) var name                    : String? = null,
    @SerialName("npk"                       ) var npk                     : String? = null,
    @SerialName("userId"                    ) var userId                  : String? = null,
    @SerialName("serveOnTime"               ) var serveOnTime             : String? = null,
    @SerialName("serveOffTime"              ) var serveOffTime            : String? = null,
    @SerialName("serveOnTimeLong"           ) var serveOnTimeLong         : String? = null,
    @SerialName("serveOffTimeLong"          ) var serveOffTimeLong        : String? = null,
    @SerialName("serveOnTimeString"         ) var serveOnTimeString       : String? = null,
    @SerialName("serveOffTimeString"        ) var serveOffTimeString      : String? = null,
    @SerialName("serveGroupId"              ) var serveGroupId            : String? = null,
    @SerialName("serveGroupName"            ) var serveGroupName          : String? = null,
    @SerialName("assignmentId"              ) var assignmentId            : String? = null,
    @SerialName("assignmentName"            ) var assignmentName          : String? = null,
    @SerialName("assignmentNumber"          ) var assignmentNumber        : String? = null,
    @SerialName("activityId"                ) var activityId              : String? = null,
    @SerialName("activityName"              ) var activityName            : String? = null,
    @SerialName("resultId"                  ) var resultId                : String? = null,
    @SerialName("resultName"                ) var resultName              : String? = null,
    @SerialName("directHead"                ) var directHead              : String? = null,
    @SerialName("directHeadName"            ) var directHeadName          : String? = null,
    @SerialName("description"               ) var description             : String? = null,
    @SerialName("achievement"               ) var achievement             : String? = null,
    @SerialName("typeId"                    ) var typeId                  : String? = null,
    @SerialName("categoryId"                ) var categoryId              : String? = null,
    @SerialName("categoryName"              ) var categoryName            : String? = null,
    @SerialName("next_activity_description" ) var nextActivityDescription : String? = null,
    @SerialName("nextActivityDate"          ) var nextActivityDate        : String? = null,
    @SerialName("shiftId"                   ) var shiftId                 : String? = null,
    @SerialName("shiftname"                 ) var shiftname               : String? = null,
    @SerialName("startTime"                 ) var startTime               : String? = null,
    @SerialName("endTime"                   ) var endTime                 : String? = null,
    @SerialName("startBreakTime"            ) var startBreakTime          : String? = null,
    @SerialName("endBreakTime"              ) var endBreakTime            : String? = null,
    @SerialName("keterangan"                ) var keterangan              : String? = null
)