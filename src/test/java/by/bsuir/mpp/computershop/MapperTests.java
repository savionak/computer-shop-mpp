package by.bsuir.mpp.computershop;

import by.bsuir.mpp.computershop.config.PrimaryConfiguration;
import by.bsuir.mpp.computershop.dto.full.AssemblyComponentFullDto;
import by.bsuir.mpp.computershop.dto.full.UserAuthFullDto;
import by.bsuir.mpp.computershop.entity.Assembly;
import by.bsuir.mpp.computershop.entity.AssemblyComponent;
import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.utils.TestHelper;
import by.bsuir.mpp.computershop.utils.supplier.entity.dto.full.UserAuthFullDtoSupplier;
import ma.glasnost.orika.MapperFacade;
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
public class MapperTests {

    @Autowired
    private MapperFacade mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserAuthFullDtoSupplier fullDtoSupplier = new UserAuthFullDtoSupplier();

    @Test
    public void assemblyComponentMappingTest() {
        Assembly asm = new Assembly();
        asm.setId(TestHelper.nextLongId());

        AssemblyComponent expected = new AssemblyComponent();
        expected.setAssembly(asm);

        AssemblyComponentFullDto intermediate = mapper.map(expected, AssemblyComponentFullDto.class);
        Assert.assertEquals(expected.getAssembly().getId(), intermediate.getAssemblyId());

        AssemblyComponent result = mapper.map(intermediate, AssemblyComponent.class);

        Assert.assertEquals(expected.getId(), result.getId());
        Assert.assertEquals(expected.getAssembly().getId(), result.getAssembly().getId());
    }

    @Test
    public void userAuthConverterTest() {
        UserAuthFullDto sourceAuthDto = fullDtoSupplier.getFullDto();
        UserAuth entity = mapper.map(sourceAuthDto, UserAuth.class);

        Assert.assertEquals(entity.getEmail(), sourceAuthDto.getEmail());
        Assert.assertEquals(entity.getRole(), sourceAuthDto.getRole());
        Assert.assertEquals(entity.getUserInfo().getFirstName(), sourceAuthDto.getUserInfo().getFirstName());

        Assert.assertTrue(passwordEncoder.matches(sourceAuthDto.getPass(), entity.getPassHash()));
    }

    @Test(expected = NullPointerException.class)
    public void userAutExceptionConverterTest() {
        UserAuthFullDto sourceAuthDto = fullDtoSupplier.getFullDto();
        sourceAuthDto.setUserInfo(null);

        mapper.map(sourceAuthDto, UserAuth.class);
    }
}
