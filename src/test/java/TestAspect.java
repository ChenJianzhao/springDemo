import org.demo.model.UserInfo;
import org.demo.service.IFindUserService;
import org.demo.service.ISignUpService;
import org.demo.service.impl.FindUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by jzchen on 2017/1/15 0015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestAspect {

    @Resource
    IFindUserService findUserService = null;

    public IFindUserService getFindUserService() {
        return findUserService;
    }

    @Resource
    public void setFindUserService(IFindUserService findUserService) {
        this.findUserService = findUserService;
    }

    @Test
    public void testAspect(){
        UserInfo userInfo = getFindUserService().findUser(1);
        System.out.println("out of service : " +  userInfo.getUsername() + " which id is " + userInfo.getId() + "\n");

    }
}
