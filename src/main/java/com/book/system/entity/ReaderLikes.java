package com.book.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lan
 * @since 2020-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReaderLikes implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "likes_id", type = IdType.AUTO)
    private Integer likesId;

    private Integer commentId;

    private Integer readerId;


}
