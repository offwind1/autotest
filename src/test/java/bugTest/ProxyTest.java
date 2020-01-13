package bugTest;

import com.mizholdings.me2.user.serve.App;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by brian on 2015/12/27.
 */
public class ProxyTest {
    public static void main(String[] args) throws Exception {
//        Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
//        System.out.println(clazzProxy1);
//        printConstructors(clazzProxy1);
//        printMethods(clazzProxy1);
        createProxyInstanceTest();

    }

    /**
     * 打印构造方法列表
     *
     * @param clazz
     */
    public static void printConstructors(Class clazz) {
        System.out.println("-------------constructors list-------------");
        Constructor[] constructors = clazz.getConstructors();
        System.out.print(getExecutableList(constructors));
    }

    /**
     * 打印成员方法列表
     *
     * @param clazz
     */
    public static void printMethods(Class clazz) {
        System.out.println("-------------methods list-------------");
        Method[] methods = clazz.getMethods();
        System.out.print(getExecutableList(methods));
    }

    /**
     * 获取要打印的列表数据
     * 每行一个方法,按照func(arg1,arg2)的格式
     *
     * @param executables
     * @return
     */
    public static String getExecutableList(Executable[] executables) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Executable executable : executables) {
            String name = executable.getName();
            stringBuilder.append(name);
            stringBuilder.append("(");
            Class[] clazzParams = executable.getParameterTypes();
            for (Class clazzParam : clazzParams) {
                stringBuilder.append(clazzParam.getName()).append(",");
            }
            if (clazzParams != null && clazzParams.length != 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(")\n");
        }
        return stringBuilder.toString();
    }


    /**
     * 测试创建实例对象
     *
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private static void createProxyInstance() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         * 方法1：先创建代理类，再使用反射创建实例对象
         */
        Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        Constructor constructor = clazzProxy1.getConstructor(InvocationHandler.class);
        Collection proxy1 = (Collection) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });

        /**
         * 方法2：直接使用newProxyInstance方法创建实例对象
         */
        Collection proxy2 = (Collection) Proxy.newProxyInstance(
                Collection.class.getClassLoader(),
                new Class[]{Collection.class},
                new InvocationHandler() {
                    ArrayList target = new ArrayList();

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //ArrayList targetTmp = new ArrayList();
                        System.out.println("before invoke method: " + method.getName());
                        return method.invoke(target, args);

                    }
                });


        proxy2.add("aaa");
        proxy2.add("bbb");
        System.out.println(proxy2.size());
        System.out.println(proxy2);
        System.out.println(proxy2.getClass().getName());
    }

    private static void createProxyInstanceTest() {

        TestInterface app = (TestInterface) Proxy.newProxyInstance(TestInterface.class.getClassLoader(), new Class[]{TestInterface.class}, new InvocationHandler() {
            A a = new A();
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("asd");
                return method.invoke(a,args);
            }
        });

        app.getA();
    }
}

interface TestInterface {
    void getA();
}


class A implements TestInterface {

    @Override
    public void getA() {
        System.out.println("A");
    }
}