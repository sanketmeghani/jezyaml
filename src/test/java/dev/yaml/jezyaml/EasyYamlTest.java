package dev.yaml.jezyaml;

import org.junit.Assert;
import org.junit.Test;

public class EasyYamlTest
{
    private String yamlString = "a: 'string'\nb: 2\nc:\n  - aaa\n  - bbb\nd: false\nlevel1:\n  level2:\n    level3: 'Level 3 Value'";

    @Test
    public void shouldCreateUsingString()
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Assert.assertNotNull("Could not instantiate EasyYaml with String.", easyYaml);
    }

    @Test
    public void shouldReturnStringProperty()
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        String value = easyYaml.getString("a");
        Assert.assertEquals("Unexpected string value.", "string", value);
    }

    @Test
    public void shouldReturnNullForUnknownStringKey()
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        String value = easyYaml.getString("unknown");
        Assert.assertNull("Unexpected string value.", value);
    }

    @Test
    public void shouldReturnPassedString()
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        String value = easyYaml.getString("unknown", "known");
        Assert.assertEquals("Unexpected string value.", "known", value);
    }

    @Test
    public void shouldReturnIntegerProperty()
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Integer value = easyYaml.getInteger("b");
        Assert.assertEquals("Unexpected integer value.", Integer.valueOf(2), value);
    }

    @Test
    public void shouldReturnNullForUnknownIntegerKey()
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Integer value = easyYaml.getInteger("unknown");
        Assert.assertNull("Unexpected integer value.", value);
    }

    @Test
    public void shouldReturnPassedInteger()
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Integer value = easyYaml.getInteger("unknown", 5);
        Assert.assertEquals("Unexpected integer value.", Integer.valueOf(5), value);
    }

    @Test
    public void shouldReturnBooleanProperty()
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Boolean value = easyYaml.getBoolean("d");
        Assert.assertEquals("", Boolean.FALSE, value);
    }

    @Test
    public void shouldReturnNullForUnknownBooleanKey()
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Boolean value = easyYaml.getBoolean("unknown");
        Assert.assertNull("Unexpected integer value.", value);
    }

    @Test
    public void shouldReturnPassedBoolean()
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);

        Boolean value = easyYaml.getBoolean("unknown", Boolean.TRUE);
        Assert.assertEquals("Unexpected integer value.", Boolean.TRUE, value);
    }
    
    @Test
    public void shouldReturnNestedStringProperty()
    {
        EasyYaml easyYaml = EasyYaml.fromString(yamlString);
        
        String value = easyYaml.getString("level1.level2.level3");
        Assert.assertEquals("", "Level 3 Value", value);
    }
}
