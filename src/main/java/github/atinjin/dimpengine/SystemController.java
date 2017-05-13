package github.atinjin.dimpengine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * (C) Copyright ${year} Ryan Donghyun Jin (http://ryanjin.net/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     ryanjin
 */
@RestController
public class SystemController {

    private static Logger logger = LoggerFactory.getLogger("jin.system.controller");

    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "/system/{id}")
    public SystemInformation getSystemInfo(@PathVariable("id") String id, HttpServletRequest request) {
        logger.info("[request] HEADER - Authorization : {}", request.getHeader("Authorization"));
        return systemService.getSystemInfo(id);
    }

    @RequestMapping(value = "/system", method = RequestMethod.POST)
    public SystemInformation postSystemInfo(@RequestBody SystemInformation systemInformation) {
        return systemService.saveSystemInfo(systemInformation);
    }
}
