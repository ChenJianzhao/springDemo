import org.demo.model.UserInfo;
import org.demo.service.ISignUpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by jzchen on 2017/1/10 0010.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestAddUser {

    ISignUpService signUpService = null;

    public ISignUpService getSignUpService() {
        return signUpService;
    }

    @Resource
    public void setSignUpService(ISignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @Test
    public void testAddUser(){

//        TestAddUser testAddUser = new TestAddUser();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test");
        userInfo.setPassword("1234");
        String id = getSignUpService().signUp(userInfo);
        System.out.println(id);
    }
}
