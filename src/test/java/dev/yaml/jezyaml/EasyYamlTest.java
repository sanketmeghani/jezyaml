package dev.yaml.jezyaml;

import org.junit.Assert;
import org.junit.Test;

public class EasyYamlTest
{
    private String yaml = "a: 'string'\nb: 2\nc:\n  - aaa\n  - bbb";

    @Test
    public void shouldCreateUsingString()
    {
        EasyYaml easyYaml = new EasyYaml(yaml);

        Assert.assertNotNull("Could not instantiate EasyYaml with String.", easyYaml);
    }

    @Test
    public void shouldReturnStringProperty()
    {
        EasyYaml easyYaml = new EasyYaml(yaml);

        String value = easyYaml.getString("a");
        Assert.assertEquals("Unexpected string value.", "string", value);
    }

    @Test
    public void shouldReturnNullForUnknownStringKey()
    {
        EasyYaml easyYaml = new EasyYaml(yaml);

        String value = easyYaml.getString("unknown");
        Assert.assertNull("Unexpected string value.", value);
    }

    @Test
    public void shouldReturnPassedString()
    {
        EasyYaml easyYaml = new EasyYaml(yaml);

        String value = easyYaml.getString("unknown", "known");
        Assert.assertEquals("Unexpected string value.", "known", value);
    }

    @Test
    public void shouldReturnIntegerProperty()
    {
        EasyYaml easyYaml = new EasyYaml(yaml);

        Integer value = easyYaml.getInteger("b");
        Assert.assertEquals("Unexpected integer value.", Integer.valueOf(2), value);
    }

    @Test
    public void shouldReturnNullForUnknownIntegerKey()
    {
        EasyYaml easyYaml = new EasyYaml(yaml);

        Integer value = easyYaml.getInteger("unknown");
        Assert.assertNull("Unexpected integer value.", value);
    }

    @Test
    public void shouldReturnPassedInteger()
    {
        EasyYaml easyYaml = new EasyYaml(yaml);

        Integer value = easyYaml.getInteger("unknown", 5);
        Assert.assertEquals("Unexpected integer value.", Integer.valueOf(5), value);
    }
}