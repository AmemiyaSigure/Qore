package cx.rain.mc.qore.api.config;

import java.util.ArrayList;
import java.util.List;

public class ConfigBuilder {
    public List<Element> configStack = new ArrayList<>();

    private ConfigBuilder() {

    }

    public static class Element {
        public List<String> comments = new ArrayList<>();

        public String name;

    }
}
