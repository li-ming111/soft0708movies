package com.hxx.common.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Schema
@Data
public class R {
    @Schema(description = "是否成功")
    private Boolean success;

    @Schema(hidden = true,description = "返回码")
    private Integer code;

    @Schema(hidden = true,description = "返回消息")
    private String message;

    @Schema(hidden = true,description = "返回数据")
    private Map<String,Object> data = new HashMap<>();

    private R(){}

    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public R success(boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(int code){
        this.setCode(code);
        return this;
    }

    public R data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}
