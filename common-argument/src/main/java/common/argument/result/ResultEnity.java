package common.argument.result;

import java.io.Serializable;

/**
 * @author JialinLiu
 * @date 2019/4/17 0017 14:34
 */
public class ResultEnity implements Serializable {


    private static final long serialVersionUID = 1L;
    // 成功返回码
    public static final int SUCCESS = 10000000;

    // 成功返回消息
    public static final String SUCCESS_MSG = "成功";
    // 通用异常返回消息
    public static final String ERROR_MSG = "系统异常";
    // 参数异常返回消息
    public static final String PARAM_ERROR_MSG = "无效的参数";

    // 返回码
    private Integer code;
    // 返回消息
    private String msg;
    // 返回数据
    private Object data;

    /**
     * 构造并返回自定义内容的JSON对象
     *
     * @param code 返回码
     * @param msg  返回消息
     * @param data 返回数据
     * @return {@link ResultEnity} 对象
     */
    public ResultEnity create(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        return this;
    }

    /**
     * 构造并返回自定义内容的JSON对象，返回数据将会设置为<b>NULL</b>
     *
     * @param code 返回码
     * @param msg  返回消息
     * @return {@link ResultEnity} 对象
     */
    public ResultEnity create(Integer code, String msg) {
        return create(code, msg, null);
    }

    // 成功返回模板

    /**
     * 构造并返回请求成功的JSON对象，返回码将会被设置为 <b>10000000</b>
     *
     * @param msg  返回消息
     * @param data 返回数据
     * @return {@link ResultEnity} 对象
     */
    public ResultEnity success(String msg, Object data) {
        return create(SUCCESS, msg, data);
    }

    /**
     * 构造并返回请求成功的JSON对象，返回码将会被设置为 <b>10000000</b>，
     * 返回消息将会设置为默认成功消息（SUCCESS_MSG）
     *
     * @param data 返回数据
     * @return {@link ResultEnity} 对象
     */
    public ResultEnity success(Object data) {
        return create(SUCCESS, SUCCESS_MSG, data);
    }

    /**
     * 构造并返回请求成功的JSON对象，返回码将会被设置为 <b>10000000</b>，
     * 返回消息将会设置为<b>默认成功消息</b>（SUCCESS_MSG），返回数据将会
     * 设置为<b>NULL</b>
     *
     * @return {@link ResultEnity} 对象
     */
    public ResultEnity success() {
        return create(SUCCESS, SUCCESS_MSG, null);
    }

    // 通用异常返回模板

    /**
     * 构造并返回通用请求失败的JSON对象，返回码将会被设置为 <b>19999999</b>
     *
     * @param msg  返回消息
     * @param data 返回数据
     * @return {@link ResultEnity} 对象
     */
    public ResultEnity failure(String msg, Object data) {
        return create(400, msg, data);
    }

    /**
     * 构造并返回通用请求失败的JSON对象，返回码将会被设置为 <b>19999999</b>，
     * 返回消息将会设置为<b>默认失败消息</b>（ERROR_MSG）
     *
     * @param data 返回数据
     * @return {@link ResultEnity} 对象
     */
    public ResultEnity failure(Object data) {
        return create(400, ERROR_MSG, data);
    }

    /**
     * 构造并返回通用请求失败的JSON对象，返回码将会被设置为 <b>19999999</b>，
     * 返回数据将会设置为<b>NULL</b>
     *
     * @param msg 返回消息
     * @return {@link ResultEnity} 对象
     */
    public ResultEnity failure(String msg) {
        return create(400, msg, null);
    }

    /**
     * 构造并返回通用请求失败的JSON对象，返回码将会被设置为 <b>19999999</b>，
     * 返回消息将会设置为<b>默认失败消息</b>（ERROR_MSG），返回数据将会设置
     * 为<b>NULL</b>
     *
     * @return {@link ResultEnity} 对象
     */
    public ResultEnity failure() {
        return create(400, ERROR_MSG, null);
    }

    // 参数异常模板

    /**
     * 构造并返回参数异常请求失败的JSON对象，返回码将会被设置为 <b>401</b>
     *
     * @param msg  返回消息
     * @param data 返回数据
     * @return {@link ResultEnity} 对象
     */
    public ResultEnity paramFailure(String msg, Object data) {
        return create(401, msg, data);
    }

    /**
     * 构造并返回参数异常请求失败的JSON对象，返回码将会被设置为 <b>401</b>，
     * 返回消息将会设置为<b>默认参数异常消息</b>(PARAM_ERROR_MSG)
     *
     * @param data 返回数据
     * @return {@link ResultEnity} 对象
     */
    public ResultEnity paramFailure(Object data) {
        return create(401, PARAM_ERROR_MSG, data);
    }

    /**
     * 构造并返回参数异常请求失败的JSON对象，返回码将会被设置为 <b>401</b>，
     * 返回数据将会设置为<b>NULL</b>
     *
     * @param msg 返回消息
     * @return {@link ResultEnity} 对象
     */
    public ResultEnity paramFailure(String msg) {
        return create(401, msg, null);
    }

    /**
     * 构造并返回参数异常请求失败的JSON对象，返回码将会被设置为 <b>401</b>，
     * 返回消息将会设置为<b>默认参数异常消息</b>(PARAM_ERROR_MSG)，返回数据将
     * 会设置为<b>NULL</b>
     *
     * @return {@link ResultEnity} 对象
     */
    public ResultEnity paramFailure() {
        return create(401, PARAM_ERROR_MSG, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
