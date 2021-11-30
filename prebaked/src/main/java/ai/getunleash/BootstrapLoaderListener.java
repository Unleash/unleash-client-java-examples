package ai.getunleash;

import io.getunleash.event.UnleashSubscriber;
import io.getunleash.repository.ToggleCollection;

import static java.lang.String.format;

public class BootstrapLoaderListener implements UnleashSubscriber {
    @Override
    public void togglesBootstrapped(ToggleCollection toggleCollection) {
        System.out.println(format("Bootstrapped with %d toggles", toggleCollection.getFeatures().size()));
    }
}
