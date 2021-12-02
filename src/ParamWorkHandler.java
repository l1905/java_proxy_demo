import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ParamWorkHandler implements InvocationHandler {
    private Object target;

    public ParamWorkHandler(Object obj) {
        this.target = obj;
    }

    // 常规调用方式
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("before 动态代理第一个参数proxy...");
//        Object result = method.invoke(target, args);
//        System.out.println("after 动态代理第一个参数proxy...");
//
//        return result;
//    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before 动态代理第一个参数proxy...");
        // 代理对象
        System.out.println(proxy.getClass().getName());
        // 真实对象
        System.out.println(this.target.getClass().getName());
        if(method.getName() == "work") {
            method.invoke(target, args);
            // 这里可以直接返回代理对象本身， 即代理对象的this
            return proxy;
        } else {
            Object result = method.invoke(target, args);
            System.out.println("after 动态代理第一个参数proxy...");
            return result;

        }


    }
}
