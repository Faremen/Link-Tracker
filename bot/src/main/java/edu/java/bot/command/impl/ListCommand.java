package edu.java.bot.command.impl;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.command.Command;
import java.util.ArrayList;
import java.util.List;

public class ListCommand implements Command {
    @Override
    public String command() {
        return "/list";
    }

    @Override
    public String description() {
        return "Показать список отслеживаемых ссылок";
    }

    @Override
    public SendMessage handle(Update update) {

        // TODO Добавить список отслеживаемых ссылок
        List<String> urls = new ArrayList<>();

        StringBuilder response = new StringBuilder();
        if (urls.isEmpty()) {
            response.append("Нет отслеживаемых ссылок");
        } else {
            response.append("Отслеживаемые ссылки:");
            for (String url : urls) {
                response.append(url).append("\n");
            }
        }

        return new SendMessage(getChatId(update), response.toString());
    }
}
