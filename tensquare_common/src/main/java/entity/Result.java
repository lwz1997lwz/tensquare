package entity;

/**
 * @program: tensquare_parent
 * @description:结果类
 * @author: Linweizhe
 * @create: 2018-12-05 14:32
 **/
public class Result {
    private boolean flag;//是否成功
    private int code;//状态码
    private String message;//信息
    private Object data;//具体数据

    public Result() {
    }

    public Result(boolean flag, int code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, int code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
