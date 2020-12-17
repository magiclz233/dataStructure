package basic.annotation.demo;

import java.util.List;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName PasswordUtils
 * @date 2020/1/8 11:21
 */
public class PasswordUtils {

    @UseCase(id = 47,description = "密码必须至少包含一个数字")
    public boolean validatePassword(String pwd){
        return pwd.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 49,description = "新密码不能等于以前使用的密码")
    public boolean checkForNewPassword(List<String> prevPasswords,String pwd){
        return !prevPasswords.contains(pwd);
    }

    /*
     *加密密码
     */
    @UseCase(id = 48)
    public String encryptPassword(String pwd){
        return new StringBuilder(pwd).reverse().toString();
    }
}
