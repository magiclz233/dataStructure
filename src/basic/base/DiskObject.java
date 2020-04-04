package basic.base;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/29 17:37
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *注意:只能在getAllDiskObjects()和printDiskObject()方法体内编写代码,不可调整已定义的对象属性。
 **/
public class DiskObject {

    public static final String FILE = "文件";
    public static final String FOLDER = "文件夹";


    /**
     * 层级,根文件夹为0,依次加1
     */
    private int level;

    /**
     * 完整路径
     */
    private String path;

    /**
     * 文件或文件夹名称
     */
    private String name;

    /**
     * 类型,对于文件,type值设置为"文件";对于文件夹:type值设置为"文件夹"
     */
    private String type;
    /**
     * 当前对象的第一级(非所有层级)子文件或文件夹对象,要求按文件名称自然排序(升序)
     */
    private List<DiskObject> subDiskObjects;

    public static void main(String args[]){
        /**
         * 请在此处输出测试,控制台输出效果见图片
         *修改path参数为本人电脑文件夹路径,其他内容不允许修改
         */
        DiskObject diskObject = getAllDiskObjects("F:\\GitHub\\Python",0);
        printDiskObject(diskObject);
    }

    /********************************************完成以下两个方法(注意:不可调整方法参数及返回值)********************************/
    /**
     *
     * 1、依据文件夹查询子文件夹及文件,将所有文件夹及文件夹封装到一个DiskObject对象中返回,此对象为rootPath对应的根节点
     * @param rootPath
     * @param level 根文件夹层级为0,逐层加1
     * @return
     */
    public static DiskObject getAllDiskObjects(String rootPath,int level){
        DiskObject diskObject = new DiskObject();
        //TODO,此处完成获取逻辑
        File file = new File(rootPath);
        if(file.isFile()){
            diskObject.setLevel(level);
            diskObject.setName(file.getName());
            diskObject.setPath(file.getAbsolutePath());
            diskObject.setType(FILE);
        }else if(file.isDirectory()) {
            diskObject.setLevel(level);
            diskObject.setName(file.getName());
            diskObject.setPath(file.getAbsolutePath());
            diskObject.setType(FOLDER);
            File[] files = file.listFiles();
            if(files != null){
                List<DiskObject> list = new ArrayList<>(files.length);
                for (File f : files) {
                    list.add(getAllDiskObjects(f.getAbsolutePath(),level+1));
                }
                diskObject.setSubDiskObjects(list);
            }
        }
        return diskObject;
    }

    /**2、将getAllDiskObjects()方法获取的DiskObject对象里的信息输出到控制台,包括所有层级和全部属性
     * @param diskObject
     */
    public static void printDiskObject(DiskObject diskObject){

        System.out.println(diskObject.toString());
        if(diskObject.getSubDiskObjects() != null){
            List<DiskObject> subDiskObjects = diskObject.getSubDiskObjects();
            for (DiskObject childDiskObject: subDiskObjects) {
                printDiskObject(childDiskObject);
            }
        }
        //TODO,此处完成输处逻辑
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<DiskObject> getSubDiskObjects() {
        return subDiskObjects;
    }

    public void setSubDiskObjects(List<DiskObject> subDiskObjects) {
        this.subDiskObjects = subDiskObjects;
    }

    @Override
    public String toString() {
        return "层级:" + this.getLevel() + ",文件名称:" + this.getName() +
                ",文件类型:" + this.getType() + ",全路径:" + this.getPath();
    }

}