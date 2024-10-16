package org.example.pojo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author Michael
 * @date 2024-10-15
 */
@Data
@ToString
@EqualsAndHashCode
public class PageDTO<T> {
    private Long total;
    private Long pages;
    private List<T> list;
}
