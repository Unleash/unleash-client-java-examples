package ai.getunleash;

import io.getunleash.event.UnleashSubscriber;
import io.getunleash.repository.ToggleCollection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BootstrapListener implements UnleashSubscriber {
    private static final Logger LOGGER = LogManager.getLogger(BootstrapListener.class);
    @Override
    public void togglesBootstrapped(ToggleCollection toggleCollection) {
        LOGGER.info("Bootstrapped successfully with {} toggles", toggleCollection.getFeatures().size());
    }
}
