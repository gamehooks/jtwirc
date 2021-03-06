package jtwirc;

import jtwirc.Twirc.BotType;
import jtwirc.types.action.ActionBuilder;
import jtwirc.types.action.DefaultActionBuilder;
import jtwirc.types.clearChat.ClearChatBuilder;
import jtwirc.types.clearChat.DefaultClearChatBuilder;
import jtwirc.types.globaluserstate.DefaultGlobalStateBuilder;
import jtwirc.types.globaluserstate.GlobalUserStateBuilder;
import jtwirc.types.hostTarget.DefaultHostTargetBuilder;
import jtwirc.types.hostTarget.HostTargetBuilder;
import jtwirc.types.mode.DefaultModeBuilder;
import jtwirc.types.mode.ModeBuilder;
import jtwirc.types.notice.DefaultNoticeBuilder;
import jtwirc.types.notice.NoticeBuilder;
import jtwirc.types.roomstate.DefaultRoomstateBuilder;
import jtwirc.types.roomstate.RoomstateBuilder;
import jtwirc.types.subscriberEvent.DefaultSubscriberEventBuilder;
import jtwirc.types.subscriberEvent.SubscriberEventBuilder;
import jtwirc.types.twitchMessage.DefaultTwitchMessageBuilder;
import jtwirc.types.twitchMessage.TwitchMessageBuilder;
import jtwirc.types.usernotice.DefaultUsernoticeBuilder;
import jtwirc.types.usernotice.UsernoticeBuilder;
import jtwirc.types.users.DefaultTwitchUserBuilder;
import jtwirc.types.users.DefaultUserstateBuilder;
import jtwirc.types.users.TwitchUserBuilder;
import jtwirc.types.users.UserstateBuilder;

/**
 * Class for creating instances of {@link Twirc}.<br>
 * To build an instance of {@link Twirc}, the user has to supply the bot's nick and
 * oAuth token. To generate a oAuth token, visit <a href="https://twitchapps.com/tmi/">https://twitchapps.com/tmi/</a><br><br>
 * <p>
 * If you want to change any setting except the required once, use one of the
 * setter methods related to this object. When all settings are performed, use the
 * {@link #build()} method.
 */
public class TwircBuilder
{
    //***********************************************************
    // 				VARIABLES
    //***********************************************************
    boolean verboseMode = false;

    String server = "irc.chat.twitch.tv";
    int port = 80;
    boolean useSSL = false;

    BotType type;

    String nick = "";
    String oauth = "";
    String channel = "";

    private ClearChatBuilder clearChatBuilder;
    private HostTargetBuilder hostTargetBuilder;
    private ModeBuilder modeBuilder;
    private NoticeBuilder noticeBuilder;
    private RoomstateBuilder roomstateBuilder;
    private TwitchMessageBuilder twitchMessageBuilder;
    private TwitchUserBuilder twitchUserBuilder;
    private UserstateBuilder userstateBuilder;
    private SubscriberEventBuilder subEventBuilder;
    private UsernoticeBuilder usernoticeBuilder;
    private GlobalUserStateBuilder globalUserStateBuilder;
    private ActionBuilder actionBuilder;

    //***********************************************************
    // 				CONSTRUCTOR
    //***********************************************************

    /**
     * Creates a new {@link TwircBuilder}. To build an instance of {@link Twirc}, we must have
     * the bot's account nick, and the bot's IRC oAuth token (which can be retrieved from Twitch).
     * See {@link TwircBuilder}
     *
     * @param channel The channel the bot should join
     * @param nick    The bot's account name (on Twitch)
     * @param oauth   The bot's IRC oAuth token (on Twitch)
     * @param type    bot type
     */
    public TwircBuilder(String channel, String nick, String oauth, BotType type)
    {
        this.channel = channel;
        this.nick = nick;
        this.oauth = oauth;
        this.type = type;
    }

    //***********************************************************
    // 				PUBLIC
    //***********************************************************

    /**
     * Sets the server which {@link Twirc} will try to connect to Twitch via
     *
     * @param server The server adress
     * @return this
     */
    public TwircBuilder setServer(String server)
    {
        this.server = server;
        return this;
    }

    /**
     * Sets the port which the {@link Twirc} object will try to connect to Twitch via
     *
     * @param port The port number
     * @return this
     */
    public TwircBuilder setPort(int port)
    {
        this.port = port;
        return this;
    }

    /**
     * Decides whether we should use a SSL connection or not. Default is {@code true}. If you do
     * change this, remember to change the port too, since Twitch listens for SSL and non-SSL traffic
     * on different ports.
     * See <a href="https://github.com/justintv/Twitch-API/blob/master/IRC.md">
     * https://github.com/justintv/Twitch-API/blob/master/IRC.md </a>
     *
     * @param ssl Whether we should use SSL connection or not.
     * @return this
     */
    public TwircBuilder setSSL(boolean ssl)
    {
        this.useSSL = ssl;
        return this;
    }

    /**
     * Sets the {@link Twirc} object to VerboseMode<br>
     * In VerboseMode, every message that is received by {@link Twirc} will be printed to console. Default value is {@code false}
     *
     * @param verboseMode {@code true} is you want {@link Twirc} in VerboseMode
     * @return this
     */
    public TwircBuilder setVerboseMode(boolean verboseMode)
    {
        this.verboseMode = verboseMode;
        return this;
    }

    /**
     * Retrieves the assigned {@link ClearChatBuilder}, or the default one, if none is assigned.
     *
     * @return This builders current {@link ClearChatBuilder}
     */
    ClearChatBuilder getClearChatBuilder()
    {
        return clearChatBuilder != null ? clearChatBuilder : new DefaultClearChatBuilder();
    }

    /**
     * Sets the {@link ClearChatBuilder}. Useful if you want to use your custom implementations of a {@link ClearChatBuilder}. If
     * no {@link ClearChatBuilder} is assigned, the created {@link Twirc} object will use the default implementation.
     *
     * @param clearChatBuilder The {@link UserstateBuilder} you want the {@link Twirc} object to use
     * @return this
     */
    public TwircBuilder setClearChatBuilder(ClearChatBuilder clearChatBuilder)
    {
        this.clearChatBuilder = clearChatBuilder;
        return this;
    }

    /**
     * Retrieves the assigned {@link HostTargetBuilder}, or the default one, if none is assigned.
     *
     * @return This builders current {@link HostTargetBuilder}
     */
    HostTargetBuilder getHostTargetBuilder()
    {
        return hostTargetBuilder != null ? hostTargetBuilder : new DefaultHostTargetBuilder();
    }

    /**
     * Sets the HostTargetBuilder. Useful if you want to use your custom implementations of a HostTargetBuilder. If
     * no HostTargetBuilder is assigned, the created {@link Twirc} object will use the default implementation.
     *
     * @param hostTargetBuilder The {@link HostTargetBuilder} you want the {@link Twirc} object to use
     * @return this
     */
    public TwircBuilder setHostTargetBuilder(HostTargetBuilder hostTargetBuilder)
    {
        this.hostTargetBuilder = hostTargetBuilder;
        return this;
    }

    /**
     * Retrieves the assigned {@link ModeBuilder}, or the default one, if none is assigned.
     *
     * @return This builders current {@link ModeBuilder}
     */
    ModeBuilder getModeBuilder()
    {
        return modeBuilder != null ? modeBuilder : new DefaultModeBuilder();
    }

    /**
     * Sets the {@link ModeBuilder}. Useful if you want to use your custom implementations of a {@link ModeBuilder}. If
     * no {@link ModeBuilder} is assigned, the created {@link Twirc} object will use the default implementation.
     *
     * @param modeBuilder The {@link ModeBuilder} you want the {@link Twirc} object to use
     * @return this
     */
    public TwircBuilder setModeBuilder(ModeBuilder modeBuilder)
    {
        this.modeBuilder = modeBuilder;
        return this;
    }

    /**
     * Retrieves the assigned {@link NoticeBuilder}, or the default one, if none is assigned.
     *
     * @return This builders current {@link NoticeBuilder}
     */
    NoticeBuilder getNoticeBuilder()
    {
        return noticeBuilder != null ? noticeBuilder : new DefaultNoticeBuilder();
    }

    /**
     * Sets the {@link NoticeBuilder}. Useful if you want to use your custom implementations of a {@link NoticeBuilder}. If
     * no {@link NoticeBuilder} is assigned, the created {@link Twirc} object will use the default implementation.
     *
     * @param noticeBuilder The {@link NoticeBuilder} you want the {@link Twirc} object to use
     * @return this
     */
    public TwircBuilder setNoticeBuilder(NoticeBuilder noticeBuilder)
    {
        this.noticeBuilder = noticeBuilder;
        return this;
    }

    /**
     * Retrieves the assigned {@link RoomstateBuilder}, or the default one, if none is assigned.
     *
     * @return This builders current {@link RoomstateBuilder}
     */
    RoomstateBuilder getRoomstateBuilder()
    {
        return roomstateBuilder != null ? roomstateBuilder : new DefaultRoomstateBuilder();
    }

    /**
     * Sets the {@link RoomstateBuilder}. Useful if you want to use your custom implementations of a {@link RoomstateBuilder}. If
     * no {@link RoomstateBuilder} is assigned, the created {@link Twirc} object will use the default implementation.
     *
     * @param roomstateBuilder The {@link RoomstateBuilder} you want the {@link Twirc} object to use
     * @return this
     */
    public TwircBuilder setRoomstateBuilder(RoomstateBuilder roomstateBuilder)
    {
        this.roomstateBuilder = roomstateBuilder;
        return this;
    }

    /**
     * Retrieves the assigned {@link TwitchMessageBuilder}, or the default one, if none is assigned.
     *
     * @return This builders current {@link TwitchMessageBuilder}
     */
    TwitchMessageBuilder getTwitchMessageBuilder()
    {
        return twitchMessageBuilder != null ? twitchMessageBuilder : new DefaultTwitchMessageBuilder();
    }

    /**
     * Sets the {@link TwitchMessageBuilder}. Useful if you want to use your custom implementations of a {@link TwitchMessageBuilder}. If
     * no {@link TwitchMessageBuilder} is assigned, the created {@link Twirc} object will use the default implementation.
     *
     * @param twitchMessageBuilder The {@link TwitchMessageBuilder} you want the {@link Twirc} object to use
     * @return this
     */
    public TwircBuilder setTwitchMessageBuilder(TwitchMessageBuilder twitchMessageBuilder)
    {
        this.twitchMessageBuilder = twitchMessageBuilder;
        return this;
    }

    /**
     * Retrieves the assigned {@link TwitchUserBuilder}, or the default one, if none is assigned.
     *
     * @return This builders current {@link TwitchUserBuilder}
     */
    TwitchUserBuilder getTwitchUserBuilder()
    {
        return twitchUserBuilder != null ? twitchUserBuilder : new DefaultTwitchUserBuilder();
    }

    /**
     * Sets the {@link TwitchUserBuilder}. Useful if you want to use your custom implementations of a {@link TwitchUserBuilder}. If
     * no {@link TwitchUserBuilder} is assigned, the created {@link Twirc} object will use the default implementation.
     *
     * @param twitchUserBuilder The {@link TwitchUserBuilder} you want the {@link Twirc} object to use
     * @return this
     */
    public TwircBuilder setTwitchUserBuilder(TwitchUserBuilder twitchUserBuilder)
    {
        this.twitchUserBuilder = twitchUserBuilder;
        return this;
    }

    /**
     * Retrieves the assigned {@link UserstateBuilder}, or the default one, if none is assigned.
     *
     * @return This builders current {@link UserstateBuilder}
     */
    UserstateBuilder getUserstateBuilder()
    {
        return userstateBuilder != null ? userstateBuilder : new DefaultUserstateBuilder();
    }

    /**
     * Sets the {@link UserstateBuilder}. Useful if you want to use your custom implementations of a {@link UserstateBuilder}. If
     * no {@link UserstateBuilder} is assigned, the created {@link Twirc} object will use the default implementation.
     *
     * @param userstateBuilder The {@link UserstateBuilder} you want the {@link Twirc} object to use
     * @return this
     */
    public TwircBuilder setUserstateBuilder(UserstateBuilder userstateBuilder)
    {
        this.userstateBuilder = userstateBuilder;
        return this;
    }

    /**
     * Retrieves the assigned {@link SubscriberEventBuilder}, or the default one, if none is assigned.
     *
     * @return This builders current {@link SubscriberEventBuilder}
     */
    SubscriberEventBuilder getSubscriberEventBuilder()
    {
        return subEventBuilder != null ? subEventBuilder : new DefaultSubscriberEventBuilder();
    }

    /**
     * Sets the {@link SubscriberEventBuilder}. Useful if you want to use your custom implementations of a {@link SubscriberEventBuilder}. If
     * no {@link SubscriberEventBuilder} is assigned, the created {@link Twirc} object will use the default implementation.
     *
     * @param subEventBuilder The {@link SubscriberEventBuilder} you want the {@link Twirc} object to use
     * @return this
     */
    public TwircBuilder setSubscriberEventBuilder(SubscriberEventBuilder subEventBuilder)
    {
        this.subEventBuilder = subEventBuilder;
        return this;
    }

    /**
     * Retrieves the assigned {@link UsernoticeBuilder}, or the default one, if none is assigned.
     *
     * @return This builders current {@link UsernoticeBuilder}
     */
    UsernoticeBuilder getUsernoticeBuilder()
    {
        return usernoticeBuilder != null ? usernoticeBuilder : new DefaultUsernoticeBuilder();
    }

    GlobalUserStateBuilder getGlobalUserStateBuilder()
    {
        return globalUserStateBuilder != null ? globalUserStateBuilder : new DefaultGlobalStateBuilder();
    }

    /**
     * Retrieves the assigned {@link ActionBuilder}, or the default one, if none is assigned.
     *
     * @return This builders current {@link ActionBuilder}
     */
    ActionBuilder getActionBuilder()
    {
        return actionBuilder != null ? actionBuilder : new DefaultActionBuilder();
    }

    /**
     * Sets the {@link ActionBuilder}. Useful if you want to use your custom implementations of a {@link ActionBuilder}. If
     * no {@link ActionBuilder} is assigned, the created {@link Twirc} object will use the default implementation.
     *
     * @param actionBuilder The {@link ActionBuilder} you want the {@link Twirc} object to use
     * @return this
     */
    public TwircBuilder setActionBuilder(ActionBuilder actionBuilder)
    {
        this.actionBuilder = actionBuilder;
        return this;
    }

    /**
     * Creates a Twirc object, with the parameters assigned to this
     * builder.
     *
     * @return A configured Twirc object
     */
    public Twirc build()
    {
        return new Twirc(this);
    }

}
