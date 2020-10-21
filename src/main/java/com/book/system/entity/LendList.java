package com.book.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
public class LendList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "lend_id", type = IdType.AUTO)
    private Long lendId;

    private Long bookId;

    private Long readerId;

    private LocalDate lendDate;

    private LocalDate backDate;


}