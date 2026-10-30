package com.hxx.movies.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

//查询vo
@Schema(description = "查询vo")
@Data
public class ActorQuery {
    @Schema(hidden = true,description = "演员名称")
    private String name;

    @Schema(hidden = true,description = "上映时间")
    private String begin;

    @Schema(hidden = true,description = "上映时间：2021-02-25 10:15:25")
    private String end;

    @Schema(hidden = true,description = "演员的头衔：1一级演员  2级演员")
    private String title;
}
