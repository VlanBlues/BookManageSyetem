package com.book.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class BookCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "collection_id", type = IdType.AUTO)
    private Integer collectionId;

    private Integer bookId;

    private Integer readerId;
    
}
