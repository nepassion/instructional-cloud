package org.example.pojo.common.status;

/**
 * 通用状态码
 *
 * @author Michael
 * @date 2024-10-15
 */
public enum CommonCode {
    ASC(1, "asc"),
    DESC(2, "desc");


    private final Integer code;
    private final String name;

    CommonCode(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
