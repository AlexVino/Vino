package by.vino.mygarage.rest.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

//@SpringBootTest
//@RunWith(SpringRunner.class)
public class UserControllerImplTest {

    private UserControllerImpl userController = new UserControllerImpl();

    @Test
    public void checkUsernameWithNullShouldReturnedFalse() {
        // when
        boolean result = userController.checkUsername(null);

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void checkUsernameWithShortNameLengthShouldReturnedFalse() {
        // given
        String username = "tt";

        // when
        boolean result = userController.checkUsername(username);

        // then
        Assert.assertFalse(result);
    }
}