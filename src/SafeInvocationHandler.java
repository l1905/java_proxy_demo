import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SafeInvocationHandler implements InvocationHandler {

    private Object target;
    public SafeInvocationHandler(Object object) {
        target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before safety check. ==");
        System.out.println(method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after safety check.==");

        // return proxy, 这里相当于返回this方法， 如果链式调用，可以采用返回proxy
        // TODO 如果自己返回this, 那代理对象返回的是啥， 猜测返回的是代理proxy TODO 这里需要回家验证

        return result;
    }
}
