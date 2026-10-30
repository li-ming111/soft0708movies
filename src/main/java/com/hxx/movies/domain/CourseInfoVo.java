package com.hxx.movies.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;

@Schema(description = "描述影片信息")
@Data
public class CourseInfoVo {
    @Schema(hidden = true,description = "影片的id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @Schema(hidden = true,description = "影片主演的id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long actorId;

    @Schema(hidden = true,description = "影片的父id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectId;

    @Schema(hidden = true,description = "影片一级分类的id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectParentId;

    @Schema(hidden = true,description = "影片标题")
    private String movieTitle;

    @Schema(hidden = true,description = "影片的销售价格，0元表示免费")
    private BigDecimal salePrice;

    @Schema(hidden = true,description = "影片的总段数")
    private Integer totalChapters;

    @Schema(hidden = true,description = "影片海报的url路径")
    private String coverImageUrl;

    @Schema(hidden = true,description = "影片简介")
    private String description;
}
