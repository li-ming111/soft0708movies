package com.hxx.movies.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 影视片段表
 * 
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */
@Data
@TableName("hxx_chapter")
public class HxxChapterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long movieId;
	/**
	 * 片段名称
	 */
	private String chapterName;
	/**
	 * 排序
	 */
	private Integer sort;
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

	@TableField(exist = false)
	private List<HxxVideoEntity> children;
}
