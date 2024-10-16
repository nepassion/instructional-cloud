package org.example.pojo.query;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.config.OrderItemEnhance;

/**
 * page query object
 *
 * @author Michael
 * @date 2024-10-15
 */
@Data
public class PageQuery<T> {
    //起始页
    @JsonProperty(defaultValue = "1")
    private Integer pageNo;
    //数量
    private Integer pageSize;
    //排序字段
    private String sortBy;
    //排序规则
    private Integer isAsc;

    /**
     * 获取page
     *
     * @return
     */
    public Page<T> getPage() {
        Page<T> page = new Page<>(pageNo, pageSize);
        if (StrUtil.isNotEmpty(sortBy)) {
            page.addOrder(OrderItemEnhance.buildCols(isAsc, sortBy));
        } else {
            page.addOrder(OrderItemEnhance.buildCols(isAsc, "update_time"));
        }
        return page;
    }
}
