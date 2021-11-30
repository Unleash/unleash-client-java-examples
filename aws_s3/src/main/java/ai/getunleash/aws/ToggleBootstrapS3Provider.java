package ai.getunleash.aws;

import io.getunleash.repository.ToggleBootstrapFileProvider;
import io.getunleash.repository.ToggleBootstrapProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;

public class ToggleBootstrapS3Provider implements ToggleBootstrapProvider {
    private static final Logger LOGGER = LogManager.getLogger();
    private final S3Client s3;

    public ToggleBootstrapS3Provider(S3Client s3) {
        this.s3 = s3;
    }

    @Override
    public String read() {
        return awsReadFile();
    }

    public String awsReadFile() {
        try {
            GetObjectRequest featureToggleRequest = GetObjectRequest.builder().key("featuretoggles/heroku.json").bucket("unleashdemotoggles").build();
            ResponseBytes<GetObjectResponse> featureToggleResponse = s3.getObjectAsBytes(featureToggleRequest);
            return featureToggleResponse.asUtf8String();
        } catch (S3Exception ioException) {
            LOGGER.warn("Failed to read file from aws", ioException);
        }
        return null;
    }
}
