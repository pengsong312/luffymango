package luffy.user;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

import java.util.Date;
import java.util.List;

/**
 * Created by luffy on 2017/7/17.
 */
@DB
public interface UserDao {

    @SQL("select id,name,phone,city,address,is_yixia,create_at from luffy_user where id=:1")
    User findUserById(int id);

    @ReturnGeneratedId
    @SQL("insert into luffy_user(name,phone,city,address,is_yixia,create_at) values(:1, :2, :3, :4, :5,:6)")
    int insertUser(String name, String phone, String city, String address, boolean isYixia, Date createAt);

    @ReturnGeneratedId
    @SQL("insert into luffy_user(name,phone,city,address,is_yixia,create_at) values(:1.name,:1.phone,:1.city,:1.address,:1.isYixia,:1.createAt)")
    int insertUserEntity(User user);

    @SQL("delete from luffy_user where id = :1")
    void deleteUserById(int id);

    @SQL("update luffy_user set name = :1.name,city=:1.city where id = :1.id")
    int updateUser(User user);

    @SQL("select id,name,phone,city,address,is_yixia,create_at from luffy_user where id in (:1) ")
    List<User> findUsersByIds(List<Integer> ids);
}
