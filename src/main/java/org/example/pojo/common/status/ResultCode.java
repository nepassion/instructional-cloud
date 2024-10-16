package org.example.pojo.common.status;

/**
 * @author Michael
 * @date 2024-10-15
 */
public enum ResultCode {
    SUCCESS(200, "Success"),
    FAILED(500, "Internal Failed"),
    VALIDATE_FAILED(422, "Validation Failed"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found");

    private final Integer code;
    private final String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
