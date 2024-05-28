package utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestConfig {

    private Application application;
    private Tests tests;
    private Browser browser;
    private String testerName;
    private Thy thy;

    @Data
    public class Application {
        private String name;
        private String url;
        private String username;
        private String password;
    }

    @Data
    public class Browser {
        private String name;
        private List<String> options = new ArrayList<String>();
    }

    @Data
    public class Tests {
        private Boolean dryrun;
        private String tag;
        private String features;
        private String screenshots = "failure";
        //private List<String> xmlfiles;
    }

    @Data
    public class Thy {
        private List<String> info = new ArrayList<String>();


    }
}
