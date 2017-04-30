package by.bsuir.mpp.computershop.specific;

import by.bsuir.mpp.computershop.config.PrimaryConfiguration;
import by.bsuir.mpp.computershop.dto.full.UserAuthFullDto;
import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.repository.UserAuthRepository;
import by.bsuir.mpp.computershop.utils.TestHelper;
import ma.glasnost.orika.MapperFacade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PrimaryConfiguration.class})
@SpringBootTest
public class UserAuthRepositoryTest {

    @Autowired
    private MapperFacade mapper;

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Test
    public void userAuthInfoSaveDeleteTest() {
        UserAuthFullDto sourceAuthDto = TestHelper.nextUserAuthFullDto();
        UserAuth entity = mapper.map(sourceAuthDto, UserAuth.class);
        entity.setId(null); // to save new

        UserAuth result = null;
        try {
            result = userAuthRepository.save(entity);
            Assert.assertEquals(result.getUserInfo().getFirstName(), sourceAuthDto.getUserInfo().getFirstName());
        }
        finally {
            if (result != null) {
                userAuthRepository.delete(result.getId());
                Assert.assertFalse(userAuthRepository.exists(result.getId()));
            }
        }
    }
}
