package com.hxx.movies.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 影片表
 * 
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */
@Data
@TableName("hxx_movies")
public class HxxMoviesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long id;
	/**
	 * 演员ID
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long actorId;
	/**
	 * 影视类别ID
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long subjectId;
	/**
	 * 影视类别父级ID
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long subjectParentId;
	/**
	 * 影视标题
	 */
	private String movieTitle;
	/**
	 * 销售价格
	 */
	private BigDecimal salePrice;
	/**
	 * 总段数
	 */
	private Integer totalChapters;
	/**
	 * 影视封面图片路径
	 */
	private String coverImageUrl;
	/**
	 * 销售量
	 */
	private Integer sales;
	/**
	 * 浏览量
	 */
	private Integer views;
	/**
	 * 影视状态
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;
	/**
	 * 修改时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;
	/**
	 * 逻辑删除标志
	 */
	@TableLogic
	@TableField(fill = FieldFill.INSERT)
	private Integer del;
	/**
	 * 版本号
	 */
	@Version
	@TableField(fill = FieldFill.INSERT)
	private Integer version;
	/**
	 * 备注
	 */
	private String bak;

}
