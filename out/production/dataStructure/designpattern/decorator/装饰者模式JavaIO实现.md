## 
Java IO使用了装饰者模式来实现,以InputStream为例:

- InputStream是抽象组件;
- FileInputStream是InputStream的子类,属于具体组件,提供字节流的输入操作;
- FilterInputStream属于抽象装饰者,装饰者用于装饰组件,为组件提供额外的功能,
例如:BufferedInputStream 为FileInputStream提供缓存的功能

```java
FileInputStream fileInputStream = new FileInputStream(filePath);
BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
```

