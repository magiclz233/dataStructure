# Jaxb
## 简介
一般地，我们将Java对象转换为XML的过程称之为Marshal，将XML转换为Java对象的过程称之为UnMarshal。 
为了能告诉转换器使用什么样的规则进行转换，JAXB提供了如下两种方式：

JAXB 的 xjc 工具定义 schema 通过XSD（XML Schema Definition）文档生成Java类的方式。

Java Annotation 注解 JAXB通过分析java类中的标记（annotation），将java类转换为相应的XML文档。
在方案一中，通过XSD文件生成的java类，已经被编译器（xjc）进行了标注，因此无需手工标注，
而对应第二种方案，必须是编程人员手工添加这些标记。JAXB定义的标记比较多，也很复杂，
要想灵活的控制转换过程，可以使用直接标注的方式。

使用XSD转换的方式，相对比较简单，但需要使用者具有熟练的XSD编写经验，
此外，使用XSD方式生成XML文档还有一大优势，就是在分布式系统中，
不能保证XML信息的发送端和接收端都是使用的java运行环境，因此，
XSD实际上将会成为端到端通信的一个标准，规定了通信的信息格式，
因此，一般在分布式系统中可以先编写XSD文件，之后通信两端根据XSD
提供的协议各自根据自身的情况，实现对XML文档的处理。
## JAXB相关的重要类与接口
JAXB 提供了如下几个类、接口供开发者与之交互。

JAXBContext 类
应用的入口，用于管理XML/Java绑定信息。

Marshaller 接口
将Java对象序列化为XML数据。

Unmarshaller 接口
将XML数据反序列化为Java对象。

> 别看只有区区几个对外的类，但是它们借助特定的‘注解’，可以实现千变万化的功能。

[参考文章](https://www.w3cschool.cn/jaxb2/)