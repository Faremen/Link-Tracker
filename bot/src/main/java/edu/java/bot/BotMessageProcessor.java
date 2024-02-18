package edu.java.bot;

import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SetMyCommands;
import edu.java.bot.command.Command;
import edu.java.bot.command.impl.HelpCommand;
import edu.java.bot.command.impl.ListCommand;
import edu.java.bot.command.impl.StartCommand;
import edu.java.bot.command.impl.TrackCommand;
import edu.java.bot.command.impl.UntrackCommand;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BotMessageProcessor implements MessageProcessor {

    private final HashMap<String, Command> commandHashMap = new HashMap<>();

    private final List<Command> commandList = new ArrayList<>(Arrays.asList(
        new StartCommand(),
        new ListCommand(),
        new TrackCommand(),
        new UntrackCommand()
    ));

    public BotMessageProcessor() {
        commandList.addFirst(new HelpCommand(commandList));

        for (Command command : commandList) {
            commandHashMap.put(command.command(), command);
        }
    }

    @Override
    public List<Command> getCommands() {
        return commandList;
    }

    @Override
    public SendMessage process(Update update) {
        SendMessage response = null;

        String messageText = update.message().text();
        if (!messageText.isEmpty()) {
            String commandName = messageText.split(" ")[0];

            if (commandHashMap.containsKey(commandName)) {
                response = commandHashMap.get(commandName).handle(update);
            } else {
                response = createSendMessage(update, "Команда не найдена!");
            }
        } else {
            response = createSendMessage(update, "Введена пустая строка!");
        }

        return response;
    }

    @Override
    public SetMyCommands getCommandsMenu() {
        return new SetMyCommands(commandList.stream()
            .map(Command::getBotCommand)
            .toArray(BotCommand[]::new)
        );
    }

    private SendMessage createSendMessage(Update update, String message) {
        return new SendMessage(update.message().chat().id(), message);
    }
}
