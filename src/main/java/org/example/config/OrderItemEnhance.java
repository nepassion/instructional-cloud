package org.example.config;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderItem增强类
 *
 * @author Michael
 * @date 2024-10-16
 */
public class OrderItemEnhance extends OrderItem {

    /**
     * 增强方法
     *
     * @param asc
     * @param columns
     * @return
     */
    public static List<OrderItem> buildCols(Integer asc, String... columns) {
        if (ObjectUtil.isNull(asc)) {
            asc = 1;
        }
        if (asc.equals(1)) {
            return Arrays.stream(columns).map(OrderItem::asc).collect(Collectors.toList());
        } else {
            return Arrays.stream(columns).map(OrderItem::desc).collect(Collectors.toList());
        }
    }

}
