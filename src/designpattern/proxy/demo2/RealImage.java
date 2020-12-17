package designpattern.proxy.demo2;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName RealImage
 * @date 2020/1/6 15:22
 */
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }
    @Override
    public void display() {
        System.out.println("Displaying:"+fileName);
    }

    public void loadFromDisk(String fileName){
        System.out.println("loading:"+fileName);
    }
}
