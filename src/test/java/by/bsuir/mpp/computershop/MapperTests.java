package by.bsuir.mpp.computershop;

import by.bsuir.mpp.computershop.config.PrimaryConfiguration;
import by.bsuir.mpp.computershop.dto.full.AssemblyComponentFullDto;
import by.bsuir.mpp.computershop.entity.Assembly;
import by.bsuir.mpp.computershop.entity.AssemblyComponent;
import ma.glasnost.orika.MapperFacade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PrimaryConfiguration.class})
@SpringBootTest
public class MapperTests {

    private final Random rnd = new Random();

    @Autowired
    private MapperFacade mapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void assemblyComponentMappingTest() {
        Assembly asm = new Assembly();
        asm.setId(getNextId());

        AssemblyComponent expected = new AssemblyComponent();
        expected.setAssembly(asm);

        AssemblyComponentFullDto intermediate = mapper.map(expected, AssemblyComponentFullDto.class);
        Assert.assertEquals(expected.getAssembly().getId(), intermediate.getAssemblyId());

        AssemblyComponent result = mapper.map(intermediate, AssemblyComponent.class);
        Assert.assertEquals(expected.getId(), result.getId());
        Assert.assertEquals(expected.getAssembly().getId(), result.getAssembly().getId());
    }

    private Long getNextId() {
        return rnd.nextLong() + 1;
    }
}
