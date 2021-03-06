package jtwirc.types.twitchMessage;

import jtwirc.types.AbstractType;
import jtwirc.types.emote.Emote;
import jtwirc.types.emote.EmoteImpl;

import java.util.List;

/**
 * An encapsulation of a message sent via Twitch chat. <br><br>
 * <p>
 * A message can have many different structures, but since they are based on the
 * IRC protocol, they will have 1 to 5 different segments, each segment separated
 * with a space (the last segment, the actual message, may contain any amount of spaces).
 * <ul>
 * <li>Tag - This segment is not always present. It is Twitch's own specialized segment which contains data relevant
 * to the message in questing. Example of content is UserColor, Emotes and such. The order which elements appear in a Tag
 * is not guaranteed. A Tag always begins with a @
 * <li>Prefix - This segment usually contains knowledge about the sender of the message.
 * <li>Command - This segment usually specifies what command the message issued
 * <li>Target - This segment tells about whom the message is targeted at (a person, a channel)
 * <li>Content - This segment contains the actual text, intended for the receiver to read.
 * </ul>
 * In some cases, the message will contain less segments than 5. In that case that a segments
 * aren't present, their content will be empty.<br><br>
 */
public interface TwitchMessage extends AbstractType
{

    /**
     * Retrieves the entire message, exactly as received from the server.
     *
     * @return The unformatted chat line
     */
    String getRaw();

    /**
     * Retrieves this message's tag segment. Should always starts with a @. Note that the
     * Tag segment will look vastly different for different Twitch commands, and some won't
     * even have a tag.
     *
     * @return The tag segment, or {@code ""} if no tag was present
     */
    String getTag();

    /**
     * Retrieves the message's prefix.<br><br>
     * <p>
     * A typical Twitch message looks something line this:<br>
     * <code>:name!name@name.tmi.twitch.tv COMMAND #channel :message</code> <br><br>
     * <p>
     * The prefix is the part before the first space. It usually only contains data about the sender of
     * the message, but it might sometimes contain other information (PING messages for example just have PING as
     * their prefix).<br><br>
     *
     * @return The messages prefix
     */
    String getPrefix();

    /**
     * Retrieves the message's command.<br>
     * The command tells us what action triggered this message being sent.<br><br>
     *
     * @return The message's command
     */
    String getCommand();

    /**
     * Retrieves the message's target.<br>
     * The target tells us whom the message is intended towards. It can be a user, a channel, or something else.<br><br>
     * <p>
     * This segment is not always present.
     *
     * @return The message's target, or {@code ""} if no target
     */
    String getTarget();

    /**
     * Retrieves the message's content.<br>
     * The content is the commands parameters. Most often, this is the actual chat message, but it may be many
     * other things for other commands.<br><br>
     * <p>
     * This segment is not always present.
     *
     * @return The message's content, or {@code ""} if no content
     */
    String getContent();

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

    String toString();

    boolean containBits();

    int getTotalBits();

    int getBitsThisCheer();

}
