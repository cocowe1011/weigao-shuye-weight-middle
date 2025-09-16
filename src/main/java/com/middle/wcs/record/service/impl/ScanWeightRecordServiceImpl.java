package com.middle.wcs.record.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.middle.wcs.record.entity.po.ScanWeightRecord;
import com.middle.wcs.record.dao.ScanWeightRecordMapper;
import com.middle.wcs.record.service.ScanWeightRecordService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import static com.github.pagehelper.page.PageMethod.startPage;

/**
 * (ScanWeightRecord)表服务实现类
 *
 * @author makejava
 * @since 2025-09-16 15:51:26
 */
@Service("scanWeightRecordService")
public class ScanWeightRecordServiceImpl implements ScanWeightRecordService {

    @Resource
    private ScanWeightRecordMapper scanWeightRecordMapper;


    /**
     * 新增数据
     *
     * @param entity 实例对象
     * @return 成功为1，失败为0
     */
    @Override
    public int save(ScanWeightRecord entity) {
        return this.scanWeightRecordMapper.insert(entity);
    }

    /**
     * 修改数据
     *
     * @param entity 实例对象
     * @return 实例对象
     */
    @Override
    public int update(ScanWeightRecord entity) {
        return this.scanWeightRecordMapper.updateById(entity);
    }

    @Override
    public PageInfo<ScanWeightRecord> selectListByPage(ScanWeightRecord dto) {
        // 分页查询
        Page<ScanWeightRecord> page = startPage(dto.getPageNum(), dto.getPageSize());

        // 构建查询条件
        QueryWrapper<ScanWeightRecord> queryWrapper = new QueryWrapper<>();

        // 如果有具体查询条件，添加到查询条件中
        if (dto.getRecordId() != null) {
            queryWrapper.eq("record_id", dto.getRecordId());
        }
        if (dto.getProductCode() != null && !dto.getProductCode().isEmpty()) {
            queryWrapper.eq("product_code", dto.getProductCode());
        }
        if (dto.getProductName() != null && !dto.getProductName().isEmpty()) {
            queryWrapper.like("product_name", dto.getProductName());
        }
        if (dto.getProductWeight() != null && !dto.getProductWeight().isEmpty()) {
            queryWrapper.eq("product_weight", dto.getProductWeight());
        }
        if (dto.getActualWeight() != null && !dto.getActualWeight().isEmpty()) {
            queryWrapper.eq("actual_weight", dto.getActualWeight());
        }
        if (dto.getIsQualified() != null && !dto.getIsQualified().isEmpty()) {
            queryWrapper.eq("is_qualified", dto.getIsQualified());
        }
        if (dto.getErrorUpper() != null && !dto.getErrorUpper().isEmpty()) {
            queryWrapper.eq("error_upper", dto.getErrorUpper());
        }
        if (dto.getErrorLower() != null && !dto.getErrorLower().isEmpty()) {
            queryWrapper.eq("error_lower", dto.getErrorLower());
        }
        if (dto.getInvalidFlag() != null && !dto.getInvalidFlag().isEmpty()) {
            queryWrapper.eq("invalid_flag", dto.getInvalidFlag());
        }
        if (dto.getUdi() != null && !dto.getUdi().isEmpty()) {
            queryWrapper.eq("udi", dto.getUdi());
        }
        if (dto.getLocation() != null && !dto.getLocation().isEmpty()) {
            queryWrapper.eq("location", dto.getLocation());
        }

        // 按创建时间倒序排列
        queryWrapper.orderByDesc("create_time");

        List<ScanWeightRecord> list = scanWeightRecordMapper.selectList(queryWrapper);
        PageInfo<ScanWeightRecord> voPage = new PageInfo<>(page);
        return voPage;
    }
}
