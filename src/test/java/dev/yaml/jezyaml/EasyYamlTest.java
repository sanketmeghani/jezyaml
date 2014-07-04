package dev.yaml.jezyaml;

import org.junit.Assert;
import org.junit.Test;

public class EasyYamlTest
{
    @Test
    public void shouldCreateUsingString()
    {
        String yaml = "a: 'string'\nb: 2\nc:\n  - aaa\n  - bbb";
        EasyYaml easyYaml = new EasyYaml(yaml);

        Assert.assertNotNull("Could not instantiate EasyYaml with String.", easyYaml);
    }

    @Test
    public void shouldReturnStringProperty()
    {
        String yaml = "a: 'string'\nb: 2\nc:\n  - aaa\n  - bbb";
        EasyYaml easyYaml = new EasyYaml(yaml);

        String value = easyYaml.getString("a");
        Assert.assertEquals("Unexpected string value.", "string", value);
    }

    @Test
    public void shouldReturnNullForUnknownStringKey()
    {
        String yaml = "a: 'string'\nb: 2\nc:\n  - aaa\n  - bbb";
        EasyYaml easyYaml = new EasyYaml(yaml);

        String value = easyYaml.getString("unknown");
        Assert.assertNull("Unexpected string value.", value);
    }
    
    @Test
    public void shouldReturnDefaultStringValue()
    {
        String yaml = "a: 'string'\nb: 2\nc:\n  - aaa\n  - bbb";
        EasyYaml easyYaml = new EasyYaml(yaml);

        String value = easyYaml.getString("unknown", "known");
        Assert.assertEquals("Unexpected string value.", "known",value);
    }
}
