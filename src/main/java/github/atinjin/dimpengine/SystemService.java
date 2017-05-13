package github.atinjin.dimpengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ryanjin on 12/05/2017.
 */
@Component
public class SystemService {

    @Autowired
    private SystemRepository systemRepository;

    public SystemInformation getSystemInfo(String id) {
        return systemRepository.findOne(id);
    }

    public SystemInformation saveSystemInfo(SystemInformation systemInformation) {
        return systemRepository.save(systemInformation);
    }
}
