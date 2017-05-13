import github.atinjin.dimpengine.Dimpengine;
import github.atinjin.dimpengine.SystemInformation;
import github.atinjin.dimpengine.SystemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by ryanjin on 13/05/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = Dimpengine.class)
public class SystemRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SystemRepository repository;

    @Test
    public void findByNameTest() {
        this.entityManager.persist(new SystemInformation("TestRepository", "123.123.123.123"));
        SystemInformation si = this.repository.findOne("TestRepository");
        assertThat(si.getId()).isEqualTo("TestRepository");
        assertThat(si.getIpAddress()).isEqualTo("123.123.123.123");

    }


}
