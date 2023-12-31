package com.example.crac;


import org.crac.CheckpointException;
import org.crac.Core;
import org.crac.RestoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckPointController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/checkpoint")
    void checkpoint() {
        logger.info("Triggering JVM checkpoint/restore");
        try {
            Core.checkpointRestore();
        }
        catch (UnsupportedOperationException ex) {
            throw new ApplicationContextException("CRaC checkpoint not supported on current JVM", ex);
        }
        catch (CheckpointException ex) {
            throw new ApplicationContextException("Failed to take CRaC checkpoint on refresh", ex);
        }
        catch (RestoreException ex) {
            throw new ApplicationContextException("Failed to restore CRaC checkpoint on refresh", ex);
        }
    }
}


