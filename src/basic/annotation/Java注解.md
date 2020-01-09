##注解
注解是一种特殊的接口,注解继承自 ```java.lang.annotation.Annotation```。

```java
/*
由所有注释类型扩展的公共接口。
请注意，手动扩展该接口的接口未定义注释类型。
另请注意，此接口本身并不定义注释类型。
有关注释类型的更多信息，可以在Java™语言规范的9.6节中找到。
当将注释类型从不可重复变为可重复时，reflect.AnnotatedElement接口讨论了兼容性问题。
*/
public interface Annotation {
    ...
}
```
```Annotation```接口的文档描述

- 所有注解类型都会继承Annotation接口；
- 手工显示继承Annotation接口，不会定义成一个注解类型；
- Annotation本身并不会定义成一个注解类型

###编写一个注解
```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Demo{
}
```

###注解的用处
我们要学习一个东西，肯定要知道它的作用。相信没有 Java 程序猿不知道 Spring 框架的，Spring 框架中定义了大量的注解，基于注解，我们可以做到几乎零配置的开发商业项目，如 SpringBoot 就将原来 Spring 使用 XML 进行配置全部转换为使用注解达到相同的功效。
如以下是部分注解：

- @RestController
- @RequestMapping
- @Configuration
- @SpringBootApplication
- @ConfigurationProperties

###了解注解
注解分为**元注解**，**内置注解**，**用户自定义注解**
####元注解
元注解就是一种基本注解，可以应用在其他注解上面。可以理解为：元注解是用于标注注解的注解。

元注解有：
```java
 java.lang.annotation.Retention
 java.lang.annotation.Target
 java.lang.annotation.Documented
 java.lang.annotation.Inherited
 java.lang.annotation.Repeatable
 java.lang.annotation.Native
```
#####@Retention
Retention是保留的意思，表明注解产生的时间范围。他的值是 ```java.lang.RetentionPolicy```枚举。

- RetentionPolicy.SOURCE：只在源代码级别保留有用，在编译器就丢弃了；
- RetentionPolicy.CLASS：在编译器有效，在运行期（JVM中）开始丢弃，这是默认的保留策略；
- RetentionPolicy.RUNTIME：在编译器，运行期都有效，所以可以在反射中使用。

#####@Documented
@Documented表示注解的类型将会包含到Javadoc中去。
#####@Target
@Target标明注解使用约束的应用上下文，是数组形式，可以标记多个范围使用，值由```java.lang.annotation.ElementType``` 指定。

```java.lang.annotation.ElementType``` 可用值如下：
- TYPE ： 类、接口、注解、枚举的声明中
- FIELD ： 成员变量，包含枚举的常量的声明中
- METHOD ： 方法的声明中
- PARAMETER ： 正式的参数的声明中
- CONSTRUCTOR ： 构造器的声明中
- LOCAL_VARIABLE ： 局部变量的声明中
- ANNOTATION_TYPE ： 注解类型的声明中
- PACKAGE ： 包的声明中
- TYPE_PARAMETER ： 类型参数的声明中（since JDK8）
- TYPE_USE ： 类型的使用（since JDK8）

```java
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
public @interface Demo {
}
```
#####@Inherited
Inherited的字面意思是继承的意思，这个注解将会被自动继承。

**要求子类没有被任何注解标记**

只会在extends时生效，实现接口是不会生效的。
```java
import java.lang.annotation.Inherited;

@Inherited
public @interface Demo{
}
//////
@Demo
public class SuperClass{
}
//////
public class ChildClass extends SuperClass{
}
```
父类SuperClass被@Demo标记了，Demo注解又被元注解@Inherited标记，子类ChildClass继承父类并且
子类没有被任何注解标记过，那么子类会继承父类的注解@Demo.

等效于：
```java
@Demo
public class ChildClass extends SuperClass{
}
```
#####@Repeatable
该元注解标明声明的注解是可以多次使用的，@Repeatable 属性要求是 注解的class。
以下是一个 Demo注解，表示用户角色的等级，SSS---》B 共5个等级。

**注意：** 使用了 @Repeatable 标记了 Demo注解，指定了 Role.class 作为属性值，
并且 Role 注解必须属性名为 value， 且类型为 Demo 数组形式
```java
@Repeatable(Role.class)
public @interface Demo {
    String role();
}


public @interface Role {
    Demo[] value();
}


public @interface Td {
}

@Demo(role="SSS")
@Demo(role="SS")
@Demo(role="S")
@Demo(role="A")
@Demo(role="B")
public class FK1 {
}


@Demo(role="SSS")
@Demo(role="SS")
@Demo(role="S")
@Demo(role="A")
@Demo(role="B")
@Td // 错误
@Td // 错误  Td注解不能重复出现
public class FK1 {
}
```
- 没有被@Repeatable标记的注解不能多次出现

####注解的属性
注解只有变量（属性），没有方法，注解的属性是以无参方法的形式声明的。


```java
public @interface Demo {
    String role();
}
```

@Demo 注解声明了一个属性 role。

#####属性的默认值
属性后面使用default关键字可以给属性设置默认值。
```java
public @interface Demo {
    String role() default "SS";
}
```
#####注解的使用
如果只有一个名为value的属性，则使用注解时候可以直接赋值；
没有属性的注解，使用时直接标记就可以了；
多个属性的注解，那么就需要带上对应的属性名字，然后再赋值。
###Java内置注解
- @Deprecated:表示废弃，在编译期会发出警告。
- @FunctionalInterface:函数式接口，一个具有一个方法的普通接口。
- @Override ： 实现类要重写父类或者接口的方法
- @SafeVarargs ： 参数安全类型注解，告诉开发者不要用参数做一些不安全的操作
- @SuppressWarnings ： 阻止编译器发出告警，比如调用了使用了 @Deprecated 标记的方法编译器会发出警告，可以使用 @SuppressWarnings 压制警告
- @overrides ： 压制没有覆盖父类的方法的警告

###如何使用注解
注解在标记之后，想要发挥他的真正作用，需要利用Java的反射机制编写注解解析器，来进行真正的业务需要。

####注解与反射（java.lang.reflect）
- 可以通过 ```java.lang.reflect.Class``` 的 ```isAnnotationPresent()``` 得知是否存在注解。
- 可以通过 ```<T extends Annotation> T getAnnotation(Class<T> annotationClass)``` 方法获取注解对象
- 可以通过 ```Annotation[] getAnnotations()``` 方法获取注解列表
```java
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface ByronAnno{
    String value() default "ok";
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ByronAnno {
    String value() default "ok";
}
```
