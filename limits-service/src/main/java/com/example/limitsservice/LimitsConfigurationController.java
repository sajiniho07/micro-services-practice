package com.example.limitsservice;

import com.example.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/getHardCodedLimitsConfig")
    public LimitConfiguration getHardCodedLimitsConfig() {
        LimitConfiguration limitConfiguration = new LimitConfiguration(100,0);
        return limitConfiguration;
    }

    @GetMapping("/getFromPropertiesLimitsConfig")
    public LimitConfiguration getFromPropertiesLimitsConfig() {
        LimitConfiguration limitConfiguration = new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
        return limitConfiguration;
    }
}
