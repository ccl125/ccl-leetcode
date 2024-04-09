package desigin_pattern;

/**
 * @Author CuiChengLong
 * @Date 2024/4/7 17:59
 * @Description
 */

public class SingletonLazyDoubleCheck {

    private static volatile SingletonLazyDoubleCheck instance;

    private SingletonLazyDoubleCheck(){}

    private static SingletonLazyDoubleCheck getInstance() {
        if (instance == null) {
            synchronized(SingletonLazyDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingletonLazyDoubleCheck();
                }
            }
        }
        return instance;
    }

}
