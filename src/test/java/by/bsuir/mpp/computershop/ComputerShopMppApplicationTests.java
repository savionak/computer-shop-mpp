package by.bsuir.mpp.computershop;

import by.bsuir.mpp.computershop.config.PrimaryConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PrimaryConfiguration.class})
@SpringBootTest
public class ComputerShopMppApplicationTests {

    @Test
    public void contextLoads() {
    }

}
