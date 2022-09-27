package xyz.sadli.exception;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 17:04.
 * Editored:
 */
public class SysException extends RuntimeException {

    private static final long serialVersionUID = 29695942793488621L;

    private Integer code;

    public SysException(Integer code) {
        this.code = code;
    }

    public SysException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
