package github.atinjin.dimpengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/system", method = RequestMethod.POST)
    public SystemInformation postSystemInfo(@RequestBody SystemInformation systemInformation) {
        return systemService.saveSystemInfo(systemInformation);
    }
}
