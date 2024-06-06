package mmd.assignment.dpa_backend.component;

import mmd.assignment.dpa_backend.aspect.LoggingAspect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "${scheduled.job.cron.expression}")
    public void updateDataSource() {
        // TODO implement datasource update.
        logger.info("Updating datasource.. The time is {}", dateFormat.format(new Date()));
    }
}