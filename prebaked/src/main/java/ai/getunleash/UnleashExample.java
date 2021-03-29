package ai.getunleash;

import no.finn.unleash.DefaultUnleash;
import no.finn.unleash.Unleash;
import no.finn.unleash.repository.ToggleBootstrapFileProvider;
import no.finn.unleash.util.UnleashConfig;

public class UnleashExample {

    public static void main(String[] args) {
        System.out.println(System.getenv("UNLEASH_BOOTSTRAP_FILE"));
        UnleashConfig config = UnleashConfig.builder().subscriber(new BootstrapLoaderListener())
                .instanceId("prebaked-example")
                .appName("prebaked")
                .unleashAPI("https://unleash.herokuapp.com/api")
                .build();
        Unleash unleash = new DefaultUnleash(config);
        for (String featureToggleName : unleash.more().getFeatureToggleNames()) {
            System.out.println(String.format("Found feature %s", featureToggleName));
        }
        if (unleash.isEnabled("CoffeeShop")) {
            System.out.println("CoffeeShop was enabled");
        } else {
            System.out.println("CoffeeShop was not enabled");
        }
    }

}
