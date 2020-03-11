package cn.gov.gzst.common.exception;

/**
 * 公用的异常类
 */
public class WebException extends RuntimeException {
    private static final long serialVersionUID = 8604424364318396626L;
    private String code;
    private String desc;

    public WebException() {
    }

    public WebException(String message) {
        super(message);
        this.desc = message;
    }

    public WebException(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public WebException(String code, String desc, Throwable cause) {
        super(cause);
        this.code = code;
        this.desc = desc;
    }

    public WebException(String code, String desc, String message) {
        super(message);
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getMessage() {
        return super.getMessage() == null ? this.desc : super.getMessage();
    }
}
