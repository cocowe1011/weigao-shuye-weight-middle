package com.middle.wcs.record.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * (ScanWeightRecord)实体类
 *
 * @author makejava
 * @since 2025-09-16 15:51:26
 */
@Data
@TableName("scan_weight_record")
public class ScanWeightRecord {
/**
    * 主键
    */
@TableId
    private Long recordId;

/**
    * 产品名称
    */
private String productName;

/**
    * 产品货号
    */
private String productCode;

/**
    * 目标重量
    */
private String productWeight;

/**
    * 实际重量
    */
private String actualWeight;

/**
    * 是否合格，0否，1是
    */
private String isQualified;

/**
    * 误差上限
    */
private String errorUpper;

/**
    * 误差下限
    */
private String errorLower;

/**
 * 扫码位置
 */
private String location;

/**
    * 作废标识，0未作废，1作废
    */
private String invalidFlag;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

/**
    * udi码
    */
private String udi;

    /**
     * 起始页数
     */
    @TableField(exist = false)
    @NotNull(message = "起始页数不能为空")
    private Integer pageNum;

    /**
     * 每页大小
     */
    @TableField(exist = false)
    @NotNull(message = "每页大小不能为空")
    private Integer pageSize;
}
