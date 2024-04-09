package desigin_pattern;

/**
 * @Author CuiChengLong
 * @Date 2024/4/7 17:51
 * @Description
 *
 * 懒汉式单例模式
 * 延迟加载，先不急着实例化对象，等到要用的时候才创建
 * 优点：实现起来比较简单，节省内存
 * 缺点：多线程下无法保证是单例的状态
 *
 */

public class SingletonLazy {

    private static SingletonLazy instance;

    private SingletonLazy(){}

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
