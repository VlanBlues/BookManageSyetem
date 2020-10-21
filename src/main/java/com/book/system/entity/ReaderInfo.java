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
public class ReaderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "reader_id", type = IdType.AUTO)
    private Integer readerId;

    private String name;

    private String username;

    private String password;

    private String sex;

    private LocalDate birth;

    private String address;

    private String phone;


}
