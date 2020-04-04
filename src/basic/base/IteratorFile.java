package basic.base;

import java.io.File;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/29 16:42
 */
public class IteratorFile {

    public static void main(String[] args) {
        String path = "F:\\GitHub\\Python";
        File file = new File(path);
        iteratorFile(file,0);
    }

    public static void outExcel(File file,int count){


    }

    /**
     *  遍历文件夹所有文件
     * @param file 传入的文件/文件夹
     * @param count 所在的层级(默认为0)
     */
    public static void iteratorFile(File file,int count){
        File[] files = file.listFiles();
        if(files != null){
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < count; i++) {
                str.append(" ");
            }
                str
                        .append(count)
                        .append("文件类型+文件")
                        .append(",文件名称:")
                        .append(file.getName())
                        .append(",全路径:")
                        .append(file.getAbsolutePath());
                System.out.println(str.toString());


                if(file.isDirectory()){
                    File[] listFiles = file.listFiles();
                    if(listFiles != null){
                        for (File f : listFiles) {
                            iteratorFile(f,count+1);
                        }
                    }
                }
            }
    }
}
