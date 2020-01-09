#Java反射
Java反射给我们提供了在运行时检查甚至修改应用行为的机制，反射是Java高级核心技术，每个Java程序员都应该理解。

通过反射机制，我们可以在运行时检视类，接口，枚举，获得他们的结构，方法和属性信息。即使是在编译器不可访问的，
我们也可以通过反射创建类实例，调用他的方法，或者改变属性值。

##Java中的反射
Java的反射是一种很强大的机制，在正常的编程中可能用的不多，但是他是Java的主干，很多JavaEE框架中都是用了反射技术：
- JUnit 利用反射技术解析@Test注解，从而得到测试的方法并调用他们；
- Spring 依赖注入是反射的最经典应用之一；
- Tomcat web容器通过解析web.xml文件和请求url，将请求正确的转发到对应的模块；
- Eclipse 自动完成方法的名称输入
以上这个清单只是小部分，它们全部使用了反射技术，因为正常情况下，它们无法访问用户编写的类、接口以及方法等。

但是我们不建议在正常编程中滥用反射技术，因为我们拥有自己编写的类的访问权限了，反射存在以下几个缺陷：

- **性能较差**   尽管反射解决了动态类型的问题，但是也引入了在classpath 扫描类进行加
载的过程，会影响性能。
- **安全限制**  反射需要在运行时获得访问权限，但是在security manager中可能是不允许的。
  这可能会导致应用运行失败。
- **安全问题**  通过反射我们可以访问那些不建议我们访问的类，例如我们可以访问private
的属性并修改其值。  这可能引发安全问题导致应用异常。
- **较高的维护代价**  反射相关的代码难以理解以及调试，代码的错误不能在编译期展现出来，
使用反射的代码灵活性不高并难以维护。

任何技术都有优缺点，在好的位置，好的应用下使用它。

##反射在类中的使用
在Java中，任何对象要不是原始类型或者引用类型，所有的类，枚举，数据和其他引用类型都继承自
Object类。

java.lang.class是所有反射操作的入口。对于任何类型的对象，JVM会初始化一个不可变的java.lang.Class
实例来提供检查对象的运行时的属性，创建新对象，调用方法，get/set属性等。

Class的重要方法有：

为了方便起见，我们先创建了一些类和接口。

```java
package com.byron4j.hightLevel.reflection;

public interface BaseInterface {
	
	public int interfaceInt=0;
	
	void method1();
	
	int method2(String str);
}

```

```java
package com.byron4j.hightLevel.reflection;

public class BaseClass {
	
public int baseInt;
	
	private static void method3(){
		System.out.println("Method3");
	}
	
	public int method4(){
		System.out.println("Method4");
		return 0;
	}
	
	public static int method5(){
		System.out.println("Method5");
		return 0;
	}
	
	void method6(){
		System.out.println("Method6");
	}
	
	// piblic 的内部类
	public class BaseClassInnerClass{}
		
	// public 的枚举
	public enum BaseClassMemberEnum{}
	
}

```

```java
package com.byron4j.hightLevel.reflection;

public class ConcreteClass extends BaseClass implements BaseInterface{

	public int publicInt;
	private String privateString="private string";
	protected boolean protectedBoolean;
	Object defaultObject;
	
	public ConcreteClass(int i){
		this.publicInt=i;
	}

	@Override
	public void method1() {
		System.out.println("Method1 impl.");
	}

	@Override
	public int method2(String str) {
		System.out.println("Method2 impl.");
		return 0;
	}
	
	@Override
	public int method4(){
		System.out.println("Method4 overriden.");
		return 0;
	}
	
	public int method5(int i){
		System.out.println("Method4 overriden.");
		return 0;
	}
	
	// inner classes
	public class ConcreteClassPublicClass{}
	private class ConcreteClassPrivateClass{}
	protected class ConcreteClassProtectedClass{}
	class ConcreteClassDefaultClass{}
	
	//member enum
	enum ConcreteClassDefaultEnum{}
	public enum ConcreteClassPublicEnum{}
	
	//member interface
	public interface ConcreteClassPublicInterface{}

	
}

```
下面我们来看看反射的常用方法。
###获取Class对象
我们有三种方式来获取Class对象：
1. 通过静态变量class；
2. 通过示例的getClass()方法；
3. java.lang.Class.forName(String类型->完整的类名)，完整的类名包含包名。

Class的getCanonicalName()方法返回类的名称。在泛型中使用 java.lang.Class，可以帮助框架获取子类。

###获取超类SuperClass

getSuperClass()方法，返回类的超类(基类、父类)的class实例，如果该类是java.lang.Object、
原始类型、接口则返回null。如果该class是数组形式，则该方法返回java.lang.Object。

```java
Class<?> superClass = Class.forName("com.byron4j.hightLevel.reflection.ConcreteClass").getSuperclass();
System.out.println(superClass); 
System.out.println(Object.class.getSuperclass());
System.out.println(String[][].class.getSuperclass());
```

输入如下：

```
class com.byron4j.hightLevel.reflection.BaseClass
null
class java.lang.Object
```







