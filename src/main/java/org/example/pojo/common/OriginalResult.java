package org.example.pojo.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.pojo.common.status.ResultCode;

/**
 * 返回
 *
 * @author Michael
 * @date 2024-10-15
 */
@Data
@ToString
@EqualsAndHashCode
public class OriginalResult<T> {
    //状态码
    private int code;
    //消息
    private String message;
    //分页
    private Page<T> page;
    //返回数据
    private T data;
    //时间戳
    private long timestamp;


    public OriginalResult() {
    }

    /**
     * 通用返回
     *
     * @param code
     * @param message
     * @param data
     */
    public OriginalResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public OriginalResult(int code, String message, Page<T> page, T data) {
        this.code = code;
        this.message = message;
        this.page = page;
        this.data = data;
    }

    public OriginalResult(int code, String message, Page<T> page, T data, long timestamp) {
        this.code = code;
        this.message = message;
        this.page = page;
        this.data = data;
        this.timestamp = timestamp;
    }

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> OriginalResult<T> success(T data) {
        return new OriginalResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    /**
     * 失败
     *
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> OriginalResult<T> error(int code, String message, T data) {
        return new OriginalResult<>(code, message, data);
    }

}
