package by.bsuir.mpp.computershop;

import by.bsuir.mpp.computershop.config.PrimaryConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PrimaryConfiguration.class})
@SpringBootTest
public class ComputerShopMppApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void contextLoads() {
    }

    @Test
    public void passwordEncoderTest() {
        String source = "some password";

        String one = passwordEncoder.encode(source);
        String two = passwordEncoder.encode(source);

        Assert.assertTrue(passwordEncoder.matches(source, one));
        Assert.assertTrue(passwordEncoder.matches(source, two));
    }

}
