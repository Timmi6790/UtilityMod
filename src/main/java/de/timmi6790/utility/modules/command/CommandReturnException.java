package de.timmi6790.utility.modules.command;


import de.timmi6790.utility.utils.MessageBuilder;

public class CommandReturnException extends RuntimeException {
    private final MessageBuilder message;

    public CommandReturnException(final MessageBuilder message) {
        super("");

        this.message = message;
    }

    public MessageBuilder getMessageBuilder() {
        return this.message;
    }
}
