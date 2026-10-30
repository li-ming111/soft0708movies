package com.hxx.movies.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

//影片发布信息
@Schema(description = "影片发布信息")
@Data
public class CoursePublishVo {
    @Schema(hidden = true,description = "影片的id")
    private String id;

    @Schema(hidden = true,description = "影片名称")
    private String title;

    @Schema(hidden = true,description = "影片海报的url路径")
    private String cover;

    @Schema(hidden = true,description = "影片的总段数")
    private Integer videoNum;

    @Schema(hidden = true,description = "演员的一级头衔")
    private String subjectLevelOne;

    @Schema(hidden = true,description = "演员的二级头衔")
    private String subjectLevelTwo;

    @Schema(hidden = true,description = "演员的名称")
    private String actorName;

    @Schema(hidden = true,description = "影片价格")
    private String price;
}
