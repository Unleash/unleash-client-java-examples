package ai.getunleash;

import ai.getunleash.aws.ToggleBootstrapS3Provider;
import no.finn.unleash.DefaultUnleash;
import no.finn.unleash.Unleash;
import no.finn.unleash.util.UnleashConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

public class UnleashExample {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        S3Client s3Client = S3Client.builder().region(Region.EU_CENTRAL_1).build();
        ToggleBootstrapS3Provider s3Provider = new ToggleBootstrapS3Provider(s3Client);
        UnleashConfig config = UnleashConfig.builder()
                .unleashAPI("https://unleash.herokuapp.com")
                .subscriber(new BootstrapListener())
                .appName("aws_s3_example")
                .toggleBootstrapProvider(s3Provider)
                .build();
        Unleash unleash = new DefaultUnleash(config);
        LOGGER.info(unleash.getVariant("unleash_aws_s3"));
    }
}
