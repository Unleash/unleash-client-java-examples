package io.getunleash.example;

import io.getunleash.DefaultUnleash;
import io.getunleash.Unleash;
import io.getunleash.util.UnleashConfig;

public class Runner {
    public static void main(String[] args) {
        UnleashConfig config = UnleashConfig.builder().appName("customstrategy").unleashAPI("http://localhost:4242")
                .customHttpHeader("Authentication", System.getenv("UNLEASH_API_KEY")).build();
        Unleash unleash = new DefaultUnleash(config, new ExpiryDateStrategy());
        unleash.isEnabled("my.expired.date.toggle");
    }
}
