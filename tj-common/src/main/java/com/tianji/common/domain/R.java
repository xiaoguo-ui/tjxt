package com.tianji.common.domain;

import com.tianji.common.constants.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.slf4j.MDC;

import static com.tianji.common.constants.ErrorInfo.Code.FAILED;
import static com.tianji.common.constants.ErrorInfo.Code.SUCCESS;
import static com.tianji.common.constants.ErrorInfo.Msg.OK;

/**
 * 通用响应结果类，泛型 T 来表示响应数据的类型。
 */
@Data
@ApiModel(description = "通用响应结果")
public class R<T> {
    @ApiModelProperty(value = "业务状态码，200-成功，其它-失败")
    private int code;
    @ApiModelProperty(value = "响应消息", example = "OK")
    private String msg;
    @ApiModelProperty(value = "响应数据")
    private T data;
    @ApiModelProperty(value = "请求id", example = "1af123c11412e")
    private String requestId;

    // 创建一个没有数据的成功响应
    public static R<Void> ok() {
        return new R<Void>(SUCCESS, OK, null);
    }

    // 创建一个包含数据的成功响应，二次泛型，可以自己定义
    public static <T> R<T> ok(T data) {
        return new R<>(SUCCESS, OK, data);
    }

    // 创建一个失败的响应。
    public static <T> R<T> error(String msg) {
        return new R<>(FAILED, msg, null);
    }

    // 创建一个失败的响应，可以指定状态码
    public static <T> R<T> error(int code, String msg) {
        return new R<>(code, msg, null);
    }

    public R() {
    }

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.requestId = MDC.get(Constant.REQUEST_ID_HEADER);
    }

    public boolean success() {
        return code == SUCCESS;
    }

    public R<T> requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
}
