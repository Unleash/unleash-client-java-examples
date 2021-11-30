package io.getunleash.example;

import io.getunleash.strategy.Strategy;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;

public class ActiveFromDateStrategy implements Strategy {

    @Override
    public String getName() {
        return "ActiveFromDate";
    }

    @Override
    public boolean isEnabled(Map<String, String> parameters) {
        if (parameters.containsKey("expiryDate")) {
            String expiryDate = parameters.get("expiryDate");
            try {
                LocalDate expiry = LocalDate.parse(expiryDate);
                return !LocalDate.now().isBefore(expiry);
            } catch (DateTimeParseException dpe) {
                return false;
            }
        }
        return false;
    }

}
