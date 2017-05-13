import github.atinjin.dimpengine.Dimpengine;
import github.atinjin.dimpengine.SystemInformation;
import github.atinjin.dimpengine.SystemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by ryanjin on 12/05/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Dimpengine.class , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SystemControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private SystemService systemService;

    @Test
    public void systemRestControllerTest() throws Exception {
        SystemInformation si = new SystemInformation("TestingSystem", "123.123.123.123");
        given(systemService.getSystemInfo("TestingSystem")).willReturn(si);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "TestAuth");
        HttpEntity<SystemInformation> entity = new HttpEntity<>(null, headers);

        ResponseEntity<SystemInformation> systemEntity = testRestTemplate.exchange("/system/TestingSystem", HttpMethod.GET, entity, SystemInformation.class);

        SystemInformation resBody = systemEntity.getBody();
        assertThat(resBody.getId()).isEqualTo(si.getId());
        assertThat(resBody.getIpAddress()).isEqualTo(si.getIpAddress());

    }


}
