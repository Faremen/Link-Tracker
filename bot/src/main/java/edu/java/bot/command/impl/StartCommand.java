package edu.java.bot.command.impl;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.command.Command;

public class StartCommand implements Command {
    @Override
    public String command() {
        return "/start";
    }

    @Override
    public String description() {
        return "Зарегистрироваться";
    }

    @Override
    public SendMessage handle(Update update) {

        // TODO Добавить полноценную регистрацию пользователя

        String response = "Вы успешно зарегистрированы!";
        return new SendMessage(getChatId(update), response);
    }
}
