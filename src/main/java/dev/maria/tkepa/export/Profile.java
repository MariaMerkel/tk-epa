package dev.maria.tkepa.export;

import dev.maria.tkepa.exception.CorruptedExportException;
import dev.maria.tkepa.export.json.FileProfile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Profile {
    private final FileProfile profile;

    public Profile (FileProfile profile) throws CorruptedExportException, IOException {
        this.profile = profile;

        if (profile.id == null) {
            throw new CorruptedExportException("The profile file is corrupted");
        }
    }

    public String getCellPhoneNumber () {
        return profile.cellPhoneNumber;
    }

    public String getDataMigrationState () {
        return profile.dataMigrationState;
    }

    public LocalDate getDateOfBirth () {
        return profile.extendedCoreData.birthDate;
    }

    public String getEncryptionKeyPair () {
        return profile.encryptionKeyPair;
    }

    public String getExtendedMetaInformation () {
        return profile.extendedCoreData.metaInformation;
    }

    public String getExtendedSecurityModel () {
        return profile.extendedCoreData.securityModel;
    }

    public LocalDateTime[] getFirstLoginsPerQuarter () {
        return profile.loginPerQuarter;
    }

    public String getFirstName () {
        return profile.coreData.given.data;
    }

    public String getGender () {
        return profile.extendedCoreData.gender;
    }

    public String getId () {
        return profile.id;
    }

    public String getInsuranceNumber () {
        return profile.coreData.insuranceNumber.data;
    }

    public String getInsurer () {
        return profile.insuredAt;
    }

    public String getIntermediateEncryptionKeyPairForKeyChange () {
        return profile.intermediateEncryptionKeyPairForKeyChange;
    }

    public LocalDateTime getLastLogin () {
        return profile.lastLogin;
    }

    public String getLastName () {
        return profile.coreData.family.data;
    }

    public String getMetaInformation () {
        return profile.coreData.metaInformation;
    }

    public String getPartnerId () {
        return profile.partnerId;
    }

    public String getPrefix () {
        return profile.coreData.prefix;
    }

    public String getPlaceOfResidence () {
        return profile.extendedCoreData.placeOfResidence;
    }

    public String getPlaceOfResidencePostCode () {
        return profile.extendedCoreData.placeOfResidencePostalCode;
    }

    public LocalDateTime getRegistrationDate () {
        return profile.registrationDate;
    }

    public String getRevision () {
        return profile.revision;
    }

    public String securityModel () {
        return profile.coreData.securityModel;
    }

    public String getState () {
        return profile.extendedCoreData.state;
    }

    public String getTerminationStatus () {
        return profile.terminationStatus;
    }

    public String getVauPublicKey () {
        return profile.vauPublicKey;
    }
}
