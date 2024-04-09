package desigin_pattern;

/**
 * @Author CuiChengLong
 * @Date 2024/4/7 17:42
 * @Description 饿汉式，不管会不会用到该实例对象，先创建了再说，很着急的样子
 */

public class SingletonHungry {

    // 将自身实例化对象设置为一个属性，static final修饰
    private static final SingletonHungry instance = new SingletonHungry();

    // 构造方法私有化
    private SingletonHungry(){}

    // 静态方法返回该实例
    public static SingletonHungry getInstance() {
        return instance;
    }

}
