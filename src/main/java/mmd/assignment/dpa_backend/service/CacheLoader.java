package mmd.assignment.dpa_backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CacheLoader  implements CommandLineRunner {

    @Autowired
    private Environment env;

    @Override
    public void run(String... args) throws Exception {
        // TODO implement this datasource decision point.
        boolean readDataFromDb = Boolean.parseBoolean(env.getProperty("read.data.from.db"));
        if(readDataFromDb) {
            // set postgresql datasource
        }
        else{
            // set json data source
        }
    }
}
