package ai.getunleash;

import no.finn.unleash.event.UnleashSubscriber;
import no.finn.unleash.repository.ToggleCollection;

import static java.lang.String.format;

public class BootstrapLoaderListener implements UnleashSubscriber {
    @Override
    public void togglesBootstrapped(ToggleCollection toggleCollection) {
        System.out.println(format("Bootstrapped with %d toggles", toggleCollection.getFeatures().size()));
    }
}
