## java代理用例

client主要实现了

* 静态代理
* JDK动态代理： 跟静态代理比较像， 必须要定义接口interface
* Cglib 动态代理方式，继承方式， final, private获取不到对应的方法， 需要规避
* 探寻jdk动态代理中invoke第一个参数proxy的使用意义(获取代理对象this， 如果链式， 可以直接返回该proxy)


主要参考资料:

1. https://wsk1103.github.io/2019/07/20/%E7%90%86%E8%A7%A3%E4%BB%A3%E7%90%86%E6%A8%A1%E5%BC%8F/
2. https://cloud.tencent.com/developer/article/1464103

3. https://blog.csdn.net/yaomingyang/article/details/81040390
4. https://blog.csdn.net/bu2_int/article/details/60150319