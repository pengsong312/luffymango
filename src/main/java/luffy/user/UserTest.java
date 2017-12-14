package luffy.user;

import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by luffy on 2017/7/17.
 */
public class UserTest {

    public static void main(String[] args) {

        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example";
        String username = "root"; // 这里请使用您自己的用户名
        String password = "root"; // 这里请使用您自己的密码
        DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
        Mango mango = Mango.newInstance(ds); // 使用数据源初始化mango

        UserDao userDao = mango.create(UserDao.class);


        User user1 = new User();
        user1.setName("luffy");
        user1.setPhone("12345678901");
        user1.setAddress("haidian");
        user1.setCity("beijing");
        user1.setYixia(true);
        user1.setCreateAt(new Date());

        userDao.insertUserEntity(user1);

        userDao.insertUser("luffy_1","18322535235","chongqing", "yibei",true,new Date());

        User user = userDao.findUserById(4);
        System.out.println(user);

        List ids = new ArrayList<Integer>(3);
        ids.add(4);
        ids.add(5);
        ids.add(6);
        System.out.println(userDao.findUsersByIds(ids));
    }
}
