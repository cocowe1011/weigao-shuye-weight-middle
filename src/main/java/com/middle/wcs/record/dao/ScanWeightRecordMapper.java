package com.middle.wcs.record.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.middle.wcs.record.entity.po.ScanWeightRecord;
/**
 * (ScanWeightRecord)表数据库访问层
 *
 * @author makejava
 * @since 2025-09-16 15:51:26
 */
@Mapper
public interface ScanWeightRecordMapper extends BaseMapper<ScanWeightRecord> {
}
