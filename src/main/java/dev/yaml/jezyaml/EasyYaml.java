package dev.yaml.jezyaml;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class EasyYaml
{
    private Map<String, Object> yamlData = new LinkedHashMap<String, Object>();

    private EasyYaml()
    {
    }

    @SuppressWarnings("unchecked")
    public static EasyYaml fromString(String yamlString)
    {
        EasyYaml easyYaml = new EasyYaml();

        Yaml yaml = new Yaml();
        easyYaml.yamlData = (Map<String, Object>) yaml.load(yamlString);

        return easyYaml;
    }

    @SuppressWarnings("unchecked")
    public static EasyYaml fromFile(String fileName)
    {
        EasyYaml easyYaml = new EasyYaml();

        InputStream yamlStream = EasyYaml.class.getClassLoader().getResourceAsStream(fileName);

        Yaml yaml = new Yaml();
        easyYaml.yamlData = (Map<String, Object>) yaml.load(yamlStream);

        return easyYaml;
    }

    private Object getProperty(String propertyName)
    {
        Object propertyValue = null;

        if (propertyName != null)
        {
            propertyValue = getNestedProperty(propertyName);
        }

        return propertyValue;
    }

    private Object getNestedProperty(String nestedPropertyName)
    {
        String[] nestedPropertyNames = nestedPropertyName.split("\\.");

        Object value = yamlData.get(nestedPropertyNames[0]);

        for (int nestingLevel = 1; nestingLevel < nestedPropertyNames.length; nestingLevel++)
        {
            if (value == null)
            {
                break;
            }

            @SuppressWarnings("unchecked")
            Map<String, Object> nestedProperties = (Map<String, Object>) value;

            value = nestedProperties.get(nestedPropertyNames[nestingLevel]);
        }

        return value;
    }

    public String getString(String key)
    {
        return getString(key, null);
    }

    public String getString(String key, String defaultValue)
    {
        Object value = getProperty(key);

        return value == null ? defaultValue : value.toString();
    }

    public Integer getInteger(String key)
    {
        return getInteger(key, null);
    }

    public Integer getInteger(String key, Integer defaultValue)
    {
        Object value = getProperty(key);

        return value == null ? defaultValue : Integer.valueOf(value.toString());
    }

    public Boolean getBoolean(String key)
    {
        return getBoolean(key, null);
    }

    public Boolean getBoolean(String key, Boolean defaultValue)
    {
        Object value = getProperty(key);

        return value == null ? defaultValue : Boolean.valueOf(value.toString());
    }
}
