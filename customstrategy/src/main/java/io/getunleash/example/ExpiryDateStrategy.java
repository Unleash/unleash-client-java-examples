package io.getunleash.example;

import io.getunleash.Constraint;
import io.getunleash.UnleashContext;
import io.getunleash.strategy.Strategy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

public class ExpiryDateStrategy implements Strategy {
    private static final DateTimeFormatter iso = DateTimeFormatter.ISO_DATE;
    @Override
    public String getName() {
        return "ExpiryDate";
    }

    @Override
    public boolean isEnabled(Map<String, String> parameters) {
       if (parameters.containsKey("expiryDate")) {
           String expiryDate = parameters.get("expiryDate");
           try {
               LocalDate expiry = LocalDate.parse(expiryDate);
               return !LocalDate.now().isAfter(expiry);
           } catch (DateTimeParseException dpe) {
               return false;
           }
       }
       return false;
    }

    @Override
    public boolean isEnabled(Map<String, String> parameters, UnleashContext unleashContext) {
        return Strategy.super.isEnabled(parameters, unleashContext);
    }

    @Override
    public boolean isEnabled(Map<String, String> parameters, UnleashContext unleashContext, List<Constraint> constraints) {
        return Strategy.super.isEnabled(parameters, unleashContext, constraints);
    }
}
