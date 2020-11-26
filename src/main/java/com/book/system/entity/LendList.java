package com.book.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

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
public class LendList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "lend_id", type = IdType.AUTO)
    private Long lendId;

    private Long bookId;

    private Long readerId;

    private String lendDate;

    private String backDate;

    private Integer state;
    
    @TableField(exist = false)
    private BookInfo bookInfo;

    @TableField(exist = false)
    private ReaderInfo readerInfo;

}
