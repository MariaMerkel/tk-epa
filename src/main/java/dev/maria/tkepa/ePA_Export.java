package dev.maria.tkepa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import dev.maria.tkepa.activity.xml.ActivityFile;
import dev.maria.tkepa.exception.CorruptedExportException;
import dev.maria.tkepa.export.Profile;

import dev.maria.tkepa.export.json.FileProfile;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ePA_Export {
    private final ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    private final ZipFile activityFile;
    private final ZipFile exportFile;

    private final Profile[] profiles;

    public ePA_Export (ZipFile activityFile, ZipFile exportFile) throws CorruptedExportException {
        this.activityFile = activityFile;
        this.exportFile = exportFile;

        // TODO: Check if the activity file is valid
        if (activityFile != null) {
            try {
                JAXBContext activityContext = JAXBContext.newInstance(ActivityFile.class);
            } catch (JAXBException e) {
                throw new CorruptedExportException("The activity file is corrupted");
            }
        }

        if (exportFile != null) {
            ZipEntry profileEntry = exportFile.getEntry("Profildaten.json");

            if (profileEntry != null) {
                try {
                    ArrayList<Profile> profilesList = new ArrayList<>();
                    FileProfile[] fileProfiles = objectMapper.readValue(exportFile.getInputStream(profileEntry), FileProfile[].class);

                    for (FileProfile fileProfile : fileProfiles) {
                        profilesList.add(new Profile(fileProfile));
                    }

                    profiles = profilesList.toArray(new Profile[0]);
                } catch (IOException exception) {
                    exception.printStackTrace();
                    throw new CorruptedExportException("The export file is corrupted");
                }
            } else {
                profiles = new Profile[0];
            }
        } else {
            profiles = new Profile[0];
        }
    }

    public Profile[] getProfiles() {
        return profiles;
    }
}
