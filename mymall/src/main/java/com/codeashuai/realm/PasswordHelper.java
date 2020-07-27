package com.codeashuai.realm;

import com.codeashuai.entity.Admin;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import javax.xml.ws.handler.HandlerResolver;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/27 15:36
 */
public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    public static final String ALGORITHM_NAME = "md5"; // 基础散列算法
    public static final int HASH_ITERATIONS = 2; // 自定义散列次数

    public void encryptPassword(Admin admin) {
        // 随机字符串作为salt因子，实际参与运算的salt我们还引入其它干扰因子
//        String solt = randomNumberGenerator.nextBytes().toHex();
        String newPassword = new SimpleHash(ALGORITHM_NAME, admin.getAdminPwd(),
                ByteSource.Util.bytes(admin.getAdminName()), HASH_ITERATIONS)
                .toHex();
        admin.setAdminPwd(newPassword);
    }

    public static void main(String[] args) {
        PasswordHelper helper = new PasswordHelper();
        Admin admin = new Admin();
        admin.setAdminName("admin");
        admin.setAdminPwd("123");
        helper.encryptPassword(admin);
        System.out.println(admin.getAdminPwd());
    }
}
