package common.argument.exception.constant;

/**
 * @author JialinLiu
 * @date 2019/4/17 0017 14:37
 */
public class CommonException extends RuntimeException{
    /**
     * 异常信息
     */
    protected String msg;
    /**
     * 具体异常码
     */
    protected int code = 400;
    public CommonException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public CommonException() {
        super();
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public CommonException newInstance(String msgFormat, Object... args) {
        return new CommonException(this.code, msgFormat, args);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
        this.msg = message;
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public CommonException(String message) {
        super(message);
        this.msg = message;
    }
}
