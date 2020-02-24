package basic.jaxb.objtoxml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname ObjToXml
 * @description TODO
 * @date 2020/2/23 14:44
 */
public class ObjXmlUtils {

    public static void javaToXml(Student student) throws JAXBException, FileNotFoundException {
        // 获取JAXB的上下文环境，需要传入具体的 Java bean -> 这里使用Student
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        // 创建 Marshaller 实例
        Marshaller marshaller = jaxbContext.createMarshaller();
        // 设置转换参数 -> 这里举例是告诉序列化器是否格式化输出
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // 构建输出环境 -> 这里使用标准输出，输出到控制台Console
        OutputStream out = new FileOutputStream("src/basic/jaxb/student.xml");
        // PrintStream out = System.out;
        marshaller.marshal(student, out);
    }

    public static void xmlToJava() throws JAXBException, FileNotFoundException {
        // 获取JAXB的上下文环境，需要传入具体的 Java bean -> 这里使用Student
        JAXBContext context = JAXBContext.newInstance(Student.class);
        // 创建 UnMarshaller 实例
        Unmarshaller unmarshaller = context.createUnmarshaller();
        // 加载需要转换的XML数据
        InputStream stream = new FileInputStream(new File("src/basic/jaxb/student.xml"));
        // 将XML数据序列化 -> 该方法的返回值为Object基类，需要强转类型
        Student student = (Student) unmarshaller.unmarshal(stream);
        // 将结果打印到控制台
        System.out.println(student);
    }
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Student student = new Student();
        student.setAge(23);
        student.setId("1");
        student.setName("magic");
        ObjXmlUtils.javaToXml(student);
//        ObjXmlUtils.xmlToJava();
    }
}
