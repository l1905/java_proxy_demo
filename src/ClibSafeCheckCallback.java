import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ClibSafeCheckCallback implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before safety check.");
        // 方法1， 这里和2调用方式不一样， 这里隐式继承对象
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after safety check.");
        return result;
    }
}
