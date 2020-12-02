package com.book.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.print.DocFlavor;

/**
 * <p>
 * 
 * </p>
 *
 * @author lan
 * @since 2020-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    
    private String username;
    
    private Integer readerId;

    private String ip;

    private String date;


}
