package com.book.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lan
 * @since 2020-11-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 消息内容
     */
    private String title;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 发布时间
     */
    private String publishedDate;

    /**
     * 状态0为未发布，1为已发布，-1为回收站
     */
    private Integer state;


}
