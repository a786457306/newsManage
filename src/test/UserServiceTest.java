import com.nenu.newsManage.entity.User;
import com.nenu.newsManage.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * UserServiceTest
 *
 * @author Daydreamer
 * @date 2018/6/25 10:11
 */

public class UserServiceTest extends AbstractTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void newUser() throws Exception{
        User user = new User();
        user.setUserName("zhangzw");
        user.setPassword("123456");
        user.setUserState(1);

        userService.newUser(user);
    }

    @Test
    public void delUser() throws Exception{
        userService.delUser(2);
    }

    @Test
    public void updateUser() throws Exception{
        User user = new User();
        user.setUserId(2);
        user.setUserName("zhangzw");
        user.setPassword("12345");
        user.setUserState(1);

        userService.updateUser(user);
    }

    @Test
    public void listUser() throws Exception{
        List<User> userList = userService.listUser();
        for (User user : userList){
            System.out.println(user.getUserId() + " " + user.getUserName());
        }
    }

    @Test
    public void queryUserById() throws Exception{
        User user = userService.queryUserById(2);
        System.out.println(user.getUserName() + " " + user.getPassword());
    }

    @Test
    public void checkLogin() throws Exception{
        User user = new User();
        user.setUserName("admin");
        user.setPassword("admin");
//        user.setUserState(1);
        if (userService.checkLogin(user)){
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
}
