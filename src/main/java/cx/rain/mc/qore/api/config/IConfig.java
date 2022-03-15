package cx.rain.mc.qore.api.config;

public interface IConfig {
    <T> T get(String key);
    <T> T get(String key, T defaultValue);

    boolean getBool(String key);
    byte getByte(String key);
    short getShort(String key);
    int getInt(String key);
    long getLong(String key);

    float getFloat(String key);
    double getDouble(String key);

    char getChar(String key);
    String getString(String key);

    <T> void set(String key, T value);
}