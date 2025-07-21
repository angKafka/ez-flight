package org.rdutta.ezflight.infrastructure.exceptions.error;

public interface BrandError {
    String brandNotFound = "Brand not found";
    String brandAlreadyExists = "Brand already present in database.";
    String brandDeletionError= "Brand can't be deleted.";
}
