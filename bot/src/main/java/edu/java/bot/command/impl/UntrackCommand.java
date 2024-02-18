package edu.java.bot.command.impl;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.command.Command;

public class UntrackCommand implements Command {
    @Override
    public String command() {
        return "/untrack";
    }

    @Override
    public String description() {
        return "Прекратить отслеживание изменений по ссылке";
    }

    @Override
    public SendMessage handle(Update update) {
        String commandText = update.message().text();
        String url = commandText.substring(command().length()).trim();

        // TODO Добавить проверку и удаление ссылки

        String response = "Ссылка успешно удалена: " + url;

        return new SendMessage(getChatId(update), response);
    }
}
