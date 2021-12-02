import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ClibSafeCheckCallback2 implements MethodInterceptor {

    private Object target;

    public ClibSafeCheckCallback2(Object o) {
        this.target = o;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before safety check.222");

        // 这里和1调用方式不一样
        Object result = method.invoke(target, objects);
        System.out.println("after safety check.222");
        return result;
    }
}
