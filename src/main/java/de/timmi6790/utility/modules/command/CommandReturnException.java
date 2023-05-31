package de.timmi6790.utility.modules.command;


import de.timmi6790.utility.utils.MessageBuilder;

public class CommandReturnException extends RuntimeException {
    private static final long serialVersionUID = 3487256066110092596L;
    private final MessageBuilder message;

    public CommandReturnException(final MessageBuilder message) {
        super("");

        this.message = message;
    }

    public MessageBuilder getMessageBuilder() {
        return this.message;
    }
}
