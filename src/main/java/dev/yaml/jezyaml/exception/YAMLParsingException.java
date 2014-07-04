package dev.yaml.jezyaml.exception;

public class YAMLParsingException extends Exception
{
    private static final long serialVersionUID = 1L;

    public YAMLParsingException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
