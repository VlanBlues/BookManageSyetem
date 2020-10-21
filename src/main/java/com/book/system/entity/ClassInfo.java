package com.book.system.entity;

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
public class ClassInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer classId;

    private String className;


}
