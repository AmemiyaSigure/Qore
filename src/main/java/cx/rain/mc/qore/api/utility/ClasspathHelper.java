package cx.rain.mc.qore.api.utility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClasspathHelper {
    public static void addUrlToClasspath(ClassLoader loader, URL url) {
        Class<?> clazz = URLClassLoader.class;
        try {
            Method method = clazz.getDeclaredMethod("addURL", URL.class);
            method.setAccessible(true);
            method.invoke(loader, url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
