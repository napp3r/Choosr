package org.example;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class ChoosrBot implements LongPollingSingleThreadUpdateConsumer {

    private TelegramClient telegramClient;

    public ChoosrBot(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();


            if (messageText.equals("Помощь")) {
                SendMessage helpMessage = SendMessage.builder()
                        .chatId(chatId)
                        .text("Нажмите \"Запуск\"")
                        .build();
                executeTelegramClient(helpMessage);
            } else if (messageText.equals("Запустить приложение")) {
                WebAppInfo webAppInfo = WebAppInfo.builder().url("https://napp3r.github.io/item-picker/").build();

                InlineKeyboardButton button = InlineKeyboardButton.builder()
                        .text("Choosr")
                        .webApp(webAppInfo)
                        .build();

                InlineKeyboardRow inlineKeyboardRow = new InlineKeyboardRow();
                inlineKeyboardRow.add(button);

                InlineKeyboardMarkup markup = InlineKeyboardMarkup.builder()
                        .keyboardRow(inlineKeyboardRow)
                        .build();

                SendMessage launchAppMessage = SendMessage.builder()
                        .chatId(chatId)
                        .text("Запуск")
                        .replyMarkup(markup)
                        .build();
                executeTelegramClient(launchAppMessage);
            } else {
                SendMessage initialMessage = SendMessage.builder()
                        .chatId(chatId)
                        .text("Приветствую вас в игре Choosr! Ваша задача выбрать лучший предмет из двух.")
                        .replyMarkup(ReplyKeyboardMarkup.builder()
                                .keyboardRow(new KeyboardRow() {{
                                    add("Запустить приложение");
                                    add("Помощь");
                                }})
                                .build())
                        .build();
                executeTelegramClient(initialMessage);
            }
        }
    }

    private void executeTelegramClient(SendMessage message){
        try {
            telegramClient.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
