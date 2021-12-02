import javafx.animation.TranslateTransition;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
//        testDynamicProxy();
//        testClibProxy();
        JDKinvoke();
    }

    // 1. 静态代理
    public void testStaticProxy() {
        // 静态代理模式
        // 优点： 类都已生成， 效率最高
        // 缺点:  如果需要多个代理类， 则需要定义多个代理类
        ISubject subject = new SubjectImpl();
        ISubject proxy = new SubjectProxy(subject);
        proxy.request();

        IUpdate update = new UpdateImpl();
        IUpdate  proxy2 = new UpdateProxy(update);
        proxy2.update();
    }

    // 2. 动态sdk代理
    public static void testDynamicProxy() {
        ISubject subject = new SubjectImpl();
        // 最后一个参数 可以直接 new invocationHandler 匿名方式，但是不推荐
        ISubject proxySubject = (ISubject) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{ISubject.class}, new SafeInvocationHandler(subject));

        proxySubject.request();


        IUpdate update = new UpdateImpl();
        IUpdate proxyUpdate = (IUpdate) Proxy.newProxyInstance(IUpdate.class.getClassLoader(), new Class[]{IUpdate.class}, new SafeInvocationHandler(update));
        proxyUpdate.update();

    }

    // 3. Cglib代理
    public static void testClibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ClibSubject.class);
        enhancer.setCallback(new ClibSafeCheckCallback());

        ClibSubject clibSubjectProxy = (ClibSubject) enhancer.create();
        clibSubjectProxy.request();
    }

    // 4. CGlib代理第二种实现方式， 显示new出基础对象
    public static void testClibProxy2() {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ClibSubject.class);
        enhancer.setCallback(new ClibSafeCheckCallback2(new ClibSubject()));

        ClibSubject clibSubjectProxy = (ClibSubject) enhancer.create();
        clibSubjectProxy.request();
    }


    public static void JDKinvoke() {
        ParamPeople people = new ParamStudent();
        ParamPeople p = (ParamPeople)Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{ParamPeople.class}, new ParamWorkHandler(people));
        p.work("test").work("data");
        p.time();

    }
}
