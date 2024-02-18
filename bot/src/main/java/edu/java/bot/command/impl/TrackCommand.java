package edu.java.bot.command.impl;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.command.Command;

public class TrackCommand implements Command {
    @Override
    public String command() {
        return "/track";
    }

    @Override
    public String description() {
        return "Начать отслеживание изменение по ссылке";
    }

    @Override
    public SendMessage handle(Update update) {
        String commandText = update.message().text();
        String url = commandText.substring(command().length()).trim();

        // TODO Добавить проверку и добавление ссылки

        String response = "Ссылка успешно добавлена: " + url;

        return new SendMessage(getChatId(update), response);
    }
}
