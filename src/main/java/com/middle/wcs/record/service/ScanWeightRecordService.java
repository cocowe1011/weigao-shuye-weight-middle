package com.middle.wcs.record.service;
import com.github.pagehelper.PageInfo;
import com.middle.wcs.record.entity.po.ScanWeightRecord;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;
/**
 * (ScanWeightRecord)表服务接口
 *
 * @author makejava
 * @since 2025-09-16 15:51:26
 */
@Validated
public interface ScanWeightRecordService {
    /**
     * 新增数据
     *
     * @param entity 实例对象
     * @return 成功为1，失败为0
     */
    int save(@NotNull ScanWeightRecord entity);

    /**
     * 修改数据
     *
     * @param entity 实例对象
     * @return 成功为1，失败为0
     */
    int update(@NotNull ScanWeightRecord entity);

    PageInfo<ScanWeightRecord> selectListByPage(ScanWeightRecord dto);
}
