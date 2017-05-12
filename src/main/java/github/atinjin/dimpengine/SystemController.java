package github.atinjin.dimpengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ryanjin on 12/05/2017.
 */
@RestController
public class SystemController {

    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "/system/{id}")
    public SystemInformation getSystemInfo(@PathVariable("id") String id) {
        return systemService.getSystemInfo(id);
    }
}
