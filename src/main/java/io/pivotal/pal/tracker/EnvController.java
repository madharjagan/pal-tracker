package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    // These are public variables
    String port;
    String memory;
    String instanceIndex;
    String instanceAddr;


    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memory,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}")String instanceIndex,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}")String instanceAddr) {
        this.port = port;
        this.memory = memory;
        this.instanceIndex = instanceIndex;
        this.instanceAddr = instanceAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> env = new HashMap<>();

        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memory);
        env.put("CF_INSTANCE_INDEX", instanceIndex);
        env.put("CF_INSTANCE_ADDR", instanceAddr);

        return env;

    }
}
