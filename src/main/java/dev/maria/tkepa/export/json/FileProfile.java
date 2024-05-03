package dev.maria.tkepa.export.json;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FileProfile {
    public String cellPhoneNumber;
    public CoreData coreData;
    public String dataMigrationState;
    public String encryptionKeyPair;
    public ExtendedCoreData extendedCoreData;
    public String id;
    public String insuredAt;
    public String intermediateEncryptionKeyPairForKeyChange;
    public LocalDateTime lastLogin;
    public LocalDateTime[] loginPerQuarter;
    public String partnerId;
    public LocalDateTime registrationDate;
    public String revision;
    public String terminationStatus;
    public String vauPublicKey;

    public static class CoreData {
        public DataSignaturePair family;
        public DataSignaturePair given;
        public DataSignaturePair insuranceNumber;
        public String metaInformation;
        public String prefix;
        public String securityModel;
    }

    public static class ExtendedCoreData {
        public LocalDate birthDate;
        public String gender;
        public String metaInformation;
        public String placeOfResidence;
        public String placeOfResidencePostalCode;
        public String securityModel;
        public String state;
    }
}
