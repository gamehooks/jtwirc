package jtwirc.types.clearChat;

import jtwirc.enums.CLEARCHAT_MODE;
import jtwirc.types.twitchMessage.DefaultTwitchMessageBuilder;
import jtwirc.types.twitchMessage.TwitchMessage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestClearChat
{
    private static String CLEAR_CHAT_TOTAL = ":tmi.twitch.tv CLEARCHAT #gikkman";
    private static String CLEAR_CHAT_USER_1 = "@ban-duration=1;ban-reason= :tmi.twitch.tv CLEARCHAT #gikkman :gikkbot";
    private static String CLEAR_CHAT_USER_2 = "@ban-duration=2;ban-reason= :tmi.twitch.tv CLEARCHAT #gikkman :gikkbot";
    private static String CLEAR_CHAT_USER_3 = "@ban-duration=1;ban-reason=Bad :tmi.twitch.tv CLEARCHAT #gikkman :gikkbot";
    private static String CLEAR_CHAT_USER_4 = "@ban-duration=1;ban-reason=Bad\\sargument :tmi.twitch.tv CLEARCHAT #gikkman :gikkbot";


    @Test
    public void test()
    {
        testMessage(CLEAR_CHAT_TOTAL, CLEARCHAT_MODE.COMPLETE, "", -1, "");
        testMessage(CLEAR_CHAT_USER_1, CLEARCHAT_MODE.USER, "gikkbot", 1, "");
        testMessage(CLEAR_CHAT_USER_2, CLEARCHAT_MODE.USER, "gikkbot", 2, "");
        testMessage(CLEAR_CHAT_USER_3, CLEARCHAT_MODE.USER, "gikkbot", 1, "Bad");
        testMessage(CLEAR_CHAT_USER_4, CLEARCHAT_MODE.USER, "gikkbot", 1, "Bad argument");
    }


    private static void testMessage(String MESSAGE, CLEARCHAT_MODE mode, String target, int duration, String reason)
    {
        TwitchMessage message = new DefaultTwitchMessageBuilder().build(MESSAGE);
        ClearChatEvent clearChat = new DefaultClearChatBuilder().build(message);

        assertTrue("Got: " + clearChat.getMode() + " Expected: " + mode, clearChat.getMode() == mode);
        assertTrue("Got: " + clearChat.getDuration() + " Expected: " + duration, clearChat.getDuration() == duration);
        assertTrue("Got: " + clearChat.getTarget() + " Expected: " + target, clearChat.getTarget().equals(target));
        assertTrue("Got: " + clearChat.getReason() + " Expected: " + reason, clearChat.getReason().equals(reason));
        String raw = clearChat.getRaw();
        assertTrue("Got: " + clearChat.getRaw() + " Expected: " + MESSAGE, MESSAGE.equals(raw));
    }
}
