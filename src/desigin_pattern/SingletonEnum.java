package desigin_pattern;

/**
 * @Author CuiChengLong
 * @Date 2024/4/7 18:13
 * @Description
 */
public enum SingletonEnum {
    ENUM_SINGLE;
    public static SingletonEnum getInstance() {
        return ENUM_SINGLE;
    }

}
