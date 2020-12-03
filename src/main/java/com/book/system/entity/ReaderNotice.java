package com.book.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lan
 * @since 2020-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReaderNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer noticeId;

    private Integer readerId;

    private Integer readState;
    
    @TableField(exist = false)
    private Notice notice;


}
