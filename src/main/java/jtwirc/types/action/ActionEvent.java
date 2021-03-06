package jtwirc.types.action;

import jtwirc.enums.USER_TYPE;
import jtwirc.types.AbstractType;
import jtwirc.types.emote.Emote;
import jtwirc.types.emote.EmoteImpl;

import java.util.List;

public interface ActionEvent extends AbstractType
{

    /**
     * Retrieves this users name, as displayed in Twitch chat
     *
     * @return The user name
     */
    String getName();

    /**
     * Retrieves info whether this user is a mod in this channel or not
     *
     * @return {@code true} if the user is mod, {@code false} if not
     */
    boolean isMod();

    /**
     * Retrieves info whether this user has turbo or not
     *
     * @return {@code true} if the user has turbo, {@code false} if not
     */
    boolean isTurbo();

    /**
     * Retrieves info whether this user is a sub to this channel or not
     *
     * @return {@code true} if the user is a sub, {@code false} if not
     */
    boolean isSub();

    /**
     * Retrieves info whether this user is the broadcaster or not
     *
     * @return {@code true} if the user is the broadcaster, {@code false} if not
     */
    boolean isBroadcaster();

    /**
     * Retrieves info whether this user is an admin on twitch or not
     *
     * @return {@code true} if the user is an admin, {@code false} if not
     */
    boolean isAdmin();

    /**
     * Retrieves info whether this user is a global mod on twitch or not
     *
     * @return {@code true} if the user is a global mod, {@code false} if not
     */
    boolean isGlobalMod();

    /**
     * Retrieves info whether this user is staff on twitch or not
     *
     * @return {@code true} if the user is staff, {@code false} if not
     */
    boolean isStaff();

    /**
     * Retrieves this users {@link USER_TYPE} <br>
     * There are six USER_TYPEs: OWNER, MOD, GLOBAL_MOD, ADMIN, STAFF, DEFAULT.
     *
     * @return The user's USER_TYPE
     */
    USER_TYPE getUserType();

    /**
     * Retrieves this users display color, as seen in Twitch chat.<br>
     * The color is a hexadecimal number.
     *
     * @return The users display color, as a hex number
     */
    int getColor();

    /**
     * Retrieves the users set of badges in Twitch chat. A badge looks like this: <br>
     * {@code broadcaster/1} <br><br>
     * <p>
     * There are several different badges, such as {@code broadcaster/1}, {@code turbo/1} and so on. I do
     * not know all of them explicitly, or what to do with them.
     * <p>
     * TODO: Find out more about badges
     *
     * @return Arrays of strings, representing this users badges. Might be empty if user has none.
     */
    String[] getBadges();

    /**
     * Retrieves this user's unique user ID. This ID is decided by Twitch, and will
     * always be the same for the same user
     *
     * @return The users unique user ID
     */
    int getUserID();

    /**
     * Retrieves the re-subscribing users login name. At the moment, this is the users display name in lower cases. It might
     * change in the future, if Twitch implements name changes.
     *
     * @return The users login name
     */
    String getLogin();

    /**
     * Tells us if this message contained emotes or not. Only PRIVMSG and WHISPER can contain emotes.
     *
     * @return {@code true} if the message contained emotes, <code>false</code> otherwise
     */
    boolean hasEmotes();

    /**
     * Fetches a list of all all emotes in this message. Each emote is encapsulated in a {@link EmoteImpl}.
     * The list might be empty, if the message contained no emotes.
     *
     * @return List of emotes (might be empty)
     */
    List<Emote> getEmotes();
}
