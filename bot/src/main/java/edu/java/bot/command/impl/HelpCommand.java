package edu.java.bot.command.impl;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.command.Command;
import java.util.List;

public class HelpCommand implements Command {

    private List<Command> commands;

    public HelpCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public String command() {
        return "/help";
    }

    @Override
    public String description() {
        return "Вывести доступные команды";
    }

    @Override
    public SendMessage handle(Update update) {
        StringBuilder response = new StringBuilder();
        response.append("Команды:\n");

        for (Command command : commands) {
            response.append(command.command()).append(" - ").append(command.description()).append("\n");
        }

        return new SendMessage(getChatId(update), response.toString());
    }
}
