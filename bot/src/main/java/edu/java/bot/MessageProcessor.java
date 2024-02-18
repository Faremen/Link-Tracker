package edu.java.bot;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SetMyCommands;
import edu.java.bot.command.Command;
import java.util.List;

public interface MessageProcessor {
    List<Command> getCommands();

    SendMessage process(Update update);

    SetMyCommands getCommandsMenu();
}
