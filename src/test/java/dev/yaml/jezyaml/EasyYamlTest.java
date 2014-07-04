package dev.yaml.jezyaml;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dev.yaml.jezyaml.exception.YAMLParsingException;

public class EasyYamlTest
{
    private String yamlString = "a: 'string'\nb: 2\nc:\n  - aaa\n  - bbb\nd: false\nlevel1:\n  level2:\n    level3: 'Level 3 Value'";

    @Test
    public void shouldCreateUsingString() throws YAMLParsingException
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Assert.assertNotNull("Could not instantiate EasyYaml with String.", easyYaml);
    }

    @Test
    public void shouldReturnStringProperty() throws YAMLParsingException
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        String value = easyYaml.getString("a");
        Assert.assertEquals("Unexpected string value.", "string", value);
    }

    @Test
    public void shouldReturnNullForUnknownStringKey() throws YAMLParsingException
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        String value = easyYaml.getString("unknown");
        Assert.assertNull("Unexpected string value.", value);
    }

    @Test
    public void shouldReturnPassedString() throws YAMLParsingException
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        String value = easyYaml.getString("unknown", "known");
        Assert.assertEquals("Unexpected string value.", "known", value);
    }

    @Test
    public void shouldReturnIntegerProperty() throws YAMLParsingException
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Integer value = easyYaml.getInteger("b");
        Assert.assertEquals("Unexpected integer value.", Integer.valueOf(2), value);
    }

    @Test
    public void shouldReturnNullForUnknownIntegerKey() throws YAMLParsingException
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Integer value = easyYaml.getInteger("unknown");
        Assert.assertNull("Unexpected integer value.", value);
    }

    @Test
    public void shouldReturnPassedInteger() throws YAMLParsingException
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Integer value = easyYaml.getInteger("unknown", 5);
        Assert.assertEquals("Unexpected integer value.", Integer.valueOf(5), value);
    }

    @Test
    public void shouldReturnBooleanProperty() throws YAMLParsingException
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Boolean value = easyYaml.getBoolean("d");
        Assert.assertEquals("", Boolean.FALSE, value);
    }

    @Test
    public void shouldReturnNullForUnknownBooleanKey() throws YAMLParsingException
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Boolean value = easyYaml.getBoolean("unknown");
        Assert.assertNull("Unexpected integer value.", value);
    }

    @Test
    public void shouldReturnPassedBoolean() throws YAMLParsingException
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Boolean value = easyYaml.getBoolean("unknown", Boolean.TRUE);
        Assert.assertEquals("Unexpected integer value.", Boolean.TRUE, value);
    }

    @Test
    public void shouldReturnNestedStringProperty() throws YAMLParsingException
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        String value = easyYaml.getString("level1.level2.level3");
        Assert.assertEquals("", "Level 3 Value", value);
    }

    @Test
    public void shouldLoadFromFile() throws YAMLParsingException
    {
        EasyYaml easyYaml = EasyYaml.fromFile("simple.yml");
        Assert.assertNotNull("Could not instantiate EasyYaml from file.", easyYaml);

        String value = easyYaml.getString("customer.given");
        Assert.assertEquals("Unexpected string value.", "Dorothy", value);
    }

    @Test
    public void shouldReturnListProperty() throws YAMLParsingException
    {
        EasyYaml easyYaml = EasyYaml.fromFile("simple.yml");

        List<Object> values = easyYaml.getList("items");
        Assert.assertNotNull("Unexpected list value.", values);
        Assert.assertFalse("Unexpected list returned.", values.isEmpty());
    }
}
