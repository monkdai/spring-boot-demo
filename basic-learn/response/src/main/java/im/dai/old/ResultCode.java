package im.dai.old;

public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(0, "成功"),

    /* 系统500错误*/
    SYSTEM_ERROR(10000, "系统异常，请稍后重试"),


    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),


    /* 用户错误：20001-29999*/
    USER_HAS_EXISTED(20001, "用户已存在");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

}
