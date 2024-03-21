/*
 * This file is part of Discord4J.
 *
 * Discord4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Discord4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Discord4J. If not, see <http://www.gnu.org/licenses/>.
 */

package discord4j.common.store;

import discord4j.common.annotations.Experimental;
import discord4j.common.store.action.gateway.ChannelCreateAction;
import discord4j.common.store.action.gateway.ChannelDeleteAction;
import discord4j.common.store.action.gateway.ChannelUpdateAction;
import discord4j.common.store.action.gateway.CompleteGuildMembersAction;
import discord4j.common.store.action.gateway.GuildCreateAction;
import discord4j.common.store.action.gateway.GuildDeleteAction;
import discord4j.common.store.action.gateway.GuildEmojisUpdateAction;
import discord4j.common.store.action.gateway.GuildMemberAddAction;
import discord4j.common.store.action.gateway.GuildMemberRemoveAction;
import discord4j.common.store.action.gateway.GuildMemberUpdateAction;
import discord4j.common.store.action.gateway.GuildMembersChunkAction;
import discord4j.common.store.action.gateway.GuildRoleCreateAction;
import discord4j.common.store.action.gateway.GuildRoleDeleteAction;
import discord4j.common.store.action.gateway.GuildRoleUpdateAction;
import discord4j.common.store.action.gateway.GuildScheduledEventCreateAction;
import discord4j.common.store.action.gateway.GuildScheduledEventDeleteAction;
import discord4j.common.store.action.gateway.GuildScheduledEventUpdateAction;
import discord4j.common.store.action.gateway.GuildScheduledEventUserAddAction;
import discord4j.common.store.action.gateway.GuildScheduledEventUserRemoveAction;
import discord4j.common.store.action.gateway.GuildStickersUpdateAction;
import discord4j.common.store.action.gateway.GuildUpdateAction;
import discord4j.common.store.action.gateway.InvalidateShardAction;
import discord4j.common.store.action.gateway.MessageCreateAction;
import discord4j.common.store.action.gateway.MessageDeleteAction;
import discord4j.common.store.action.gateway.MessageDeleteBulkAction;
import discord4j.common.store.action.gateway.MessageReactionAddAction;
import discord4j.common.store.action.gateway.MessageReactionRemoveAction;
import discord4j.common.store.action.gateway.MessageReactionRemoveAllAction;
import discord4j.common.store.action.gateway.MessageReactionRemoveEmojiAction;
import discord4j.common.store.action.gateway.MessageUpdateAction;
import discord4j.common.store.action.gateway.PresenceUpdateAction;
import discord4j.common.store.action.gateway.ReadyAction;
import discord4j.common.store.action.gateway.UserUpdateAction;
import discord4j.common.store.action.gateway.VoiceStateUpdateDispatchAction;
import discord4j.common.store.action.read.CountChannelsInGuildAction;
import discord4j.common.store.action.read.CountEmojisInGuildAction;
import discord4j.common.store.action.read.CountExactMembersInGuildAction;
import discord4j.common.store.action.read.CountInGuildAction;
import discord4j.common.store.action.read.CountMembersInGuildAction;
import discord4j.common.store.action.read.CountMessagesInChannelAction;
import discord4j.common.store.action.read.CountPresencesInGuildAction;
import discord4j.common.store.action.read.CountRolesInGuildAction;
import discord4j.common.store.action.read.CountStickersInGuildAction;
import discord4j.common.store.action.read.CountTotalAction;
import discord4j.common.store.action.read.CountTotalChannelsAction;
import discord4j.common.store.action.read.CountTotalEmojisAction;
import discord4j.common.store.action.read.CountTotalGuildsAction;
import discord4j.common.store.action.read.CountTotalMembersAction;
import discord4j.common.store.action.read.CountTotalMessagesAction;
import discord4j.common.store.action.read.CountTotalPresencesAction;
import discord4j.common.store.action.read.CountTotalRolesAction;
import discord4j.common.store.action.read.CountTotalStickersAction;
import discord4j.common.store.action.read.CountTotalUsersAction;
import discord4j.common.store.action.read.CountTotalVoiceStatesAction;
import discord4j.common.store.action.read.CountVoiceStatesInChannelAction;
import discord4j.common.store.action.read.CountVoiceStatesInGuildAction;
import discord4j.common.store.action.read.GetChannelByIdAction;
import discord4j.common.store.action.read.GetChannelsAction;
import discord4j.common.store.action.read.GetChannelsInGuildAction;
import discord4j.common.store.action.read.GetEmojiByIdAction;
import discord4j.common.store.action.read.GetEmojisAction;
import discord4j.common.store.action.read.GetEmojisInGuildAction;
import discord4j.common.store.action.read.GetExactMembersInGuildAction;
import discord4j.common.store.action.read.GetGuildByIdAction;
import discord4j.common.store.action.read.GetGuildScheduledEventByIdAction;
import discord4j.common.store.action.read.GetGuildScheduledEventUsersInEventAction;
import discord4j.common.store.action.read.GetGuildScheduledEventsInGuildAction;
import discord4j.common.store.action.read.GetGuildsAction;
import discord4j.common.store.action.read.GetMemberByIdAction;
import discord4j.common.store.action.read.GetMembersAction;
import discord4j.common.store.action.read.GetMembersInGuildAction;
import discord4j.common.store.action.read.GetMessageByIdAction;
import discord4j.common.store.action.read.GetMessagesAction;
import discord4j.common.store.action.read.GetMessagesInChannelAction;
import discord4j.common.store.action.read.GetPresenceByIdAction;
import discord4j.common.store.action.read.GetPresencesAction;
import discord4j.common.store.action.read.GetPresencesInGuildAction;
import discord4j.common.store.action.read.GetRoleByIdAction;
import discord4j.common.store.action.read.GetRolesAction;
import discord4j.common.store.action.read.GetRolesInGuildAction;
import discord4j.common.store.action.read.GetStickerByIdAction;
import discord4j.common.store.action.read.GetStickersAction;
import discord4j.common.store.action.read.GetStickersInGuildAction;
import discord4j.common.store.action.read.GetUserByIdAction;
import discord4j.common.store.action.read.GetUsersAction;
import discord4j.common.store.action.read.GetVoiceStateByIdAction;
import discord4j.common.store.action.read.GetVoiceStatesAction;
import discord4j.common.store.action.read.GetVoiceStatesInChannelAction;
import discord4j.common.store.action.read.GetVoiceStatesInGuildAction;
import discord4j.common.store.api.ActionMapper;
import discord4j.common.store.api.StoreAction;
import discord4j.common.store.api.StoreFlag;
import discord4j.common.store.api.layout.DataAccessor;
import discord4j.common.store.api.layout.GatewayDataUpdater;
import discord4j.common.store.api.layout.StoreLayout;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A {@link Store} represents a container that holds, retrieves, and updates data received from Discord throughout the
 * life of a bot application. Any operation performed on a {@link Store} (whether it's to read data, update data upon
 * receiving a gateway event, etc) is represented by a {@link StoreAction} object, that can be passed to the
 * {@link Store#execute(StoreAction)} method. Actions are in charge of encoding all information needed for the store
 * to operate on the data accordingly.
 *
 * <p>A {@link Store} is constructed by passing a {@link StoreLayout}, which defines handlers for the different types of
 * actions, whether they are Discord4J-specific or user-defined. The layout interface allows to enforce support for a
 * minimal set of actions in order to fulfill the caching expectations of the Discord client.
 *
 * @see Store#fromLayout(StoreLayout)
 */
public final class Store {

    private static final Store NO_OP = new Store(ActionMapper.empty());

    private final ActionMapper actionMapper;

    private Store(ActionMapper actionMapper) {
        this.actionMapper = actionMapper;
    }

    /**
     * Returns a {@link Store} that will ignore all actions.
     *
     * @return a no-op {@link Store}
     */
    public static Store noOp() {
        return NO_OP;
    }

    /**
     * Creates a new {@link Store} that will handle actions according to the given layout.
     *
     * @param layout a {@link StoreLayout}
     * @return a new {@link Store}
     */
    public static Store fromLayout(StoreLayout layout) {
        return new Store(layoutToMapper(layout));
    }

    private static ActionMapper layoutToMapper(StoreLayout layout) {
        ActionMapper dataAccessorMapper = dataAccessorToMapper(layout.getDataAccessor(), layout.getEnabledFlags());
        ActionMapper gatewayDataUpdaterMapper = gatewayDataUpdaterToMapper(layout.getGatewayDataUpdater(),
                layout.getEnabledFlags());
        ActionMapper customMapper = layout.getCustomActionMapper();
        return ActionMapper.aggregate(dataAccessorMapper, gatewayDataUpdaterMapper, customMapper);
    }

    private static ActionMapper dataAccessorToMapper(DataAccessor dataAccessor, EnumSet<StoreFlag> enabled) {
        Objects.requireNonNull(dataAccessor);

        ActionMapper.Builder builder = ActionMapper.builder();

        if (EnumSet.allOf(StoreFlag.class).equals(enabled)) {
            builder = builder
                    .map(CountInGuildAction.class, action -> {
                        switch (action.getEntity()) {
                            case CHANNELS:
                                return dataAccessor.countChannelsInGuild(action.getGuildId());
                            case STICKERS:
                                return dataAccessor.countStickersInGuild(action.getGuildId());
                            case EMOJIS:
                                return dataAccessor.countEmojisInGuild(action.getGuildId());
                            case MEMBERS:
                                return dataAccessor.countMembersInGuild(action.getGuildId());
                            case MEMBERS_EXACT:
                                return dataAccessor.countExactMembersInGuild(action.getGuildId());
                            case PRESENCES:
                                return dataAccessor.countPresencesInGuild(action.getGuildId());
                            case ROLES:
                                return dataAccessor.countRolesInGuild(action.getGuildId());
                            case VOICE_STATES:
                                return dataAccessor.countVoiceStatesInGuild(action.getGuildId());
                            default:
                                throw new IllegalArgumentException("Unhandled entity " + action.getEntity());
                        }
                    })
                    .map(CountTotalAction.class, action -> {
                        switch (action.getEntity()) {
                            case CHANNELS:
                                return dataAccessor.countChannels();
                            case STICKERS:
                                return dataAccessor.countStickers();
                            case EMOJIS:
                                return dataAccessor.countEmojis();
                            case GUILDS:
                                return dataAccessor.countGuilds();
                            case MEMBERS:
                                return dataAccessor.countMembers();
                            case MESSAGES:
                                return dataAccessor.countMessages();
                            case PRESENCES:
                                return dataAccessor.countPresences();
                            case ROLES:
                                return dataAccessor.countRoles();
                            case USERS:
                                return dataAccessor.countUsers();
                            case VOICE_STATES:
                                return dataAccessor.countVoiceStates();
                            default:
                                throw new IllegalArgumentException("Unhandled entity " + action.getEntity());
                        }
                    });
        }

        if (enabled.contains(StoreFlag.CHANNEL)) {
            builder = builder
                    .map(CountTotalChannelsAction.class, action -> dataAccessor.countChannels())
                    .map(CountChannelsInGuildAction.class,
                            action -> dataAccessor.countChannelsInGuild(action.getGuildId()))
                    .map(GetChannelsAction.class, action -> dataAccessor.getChannels())
                    .map(GetChannelsInGuildAction.class, action -> dataAccessor.getChannelsInGuild(action.getGuildId()))
                    .map(GetChannelByIdAction.class, action -> dataAccessor.getChannelById(action.getChannelId()));
        }

        if (enabled.contains(StoreFlag.EMOJI)) {
            builder = builder
                    .map(CountTotalEmojisAction.class, action -> dataAccessor.countEmojis())
                    .map(CountEmojisInGuildAction.class, action -> dataAccessor.countEmojisInGuild(action.getGuildId()))
                    .map(GetEmojisAction.class, action -> dataAccessor.getEmojis())
                    .map(GetEmojisInGuildAction.class, action -> dataAccessor.getEmojisInGuild(action.getGuildId()))
                    .map(GetEmojiByIdAction.class, action -> dataAccessor.getEmojiById(action.getGuildId(),
                            action.getEmojiId()));
        }

        if (enabled.contains(StoreFlag.GUILD)) {
            builder = builder
                    .map(CountTotalGuildsAction.class, action -> dataAccessor.countGuilds())
                    .map(GetGuildsAction.class, action -> dataAccessor.getGuilds())
                    .map(GetGuildByIdAction.class, action -> dataAccessor.getGuildById(action.getGuildId()));
        }

        if (enabled.contains(StoreFlag.MEMBER)) {
            builder = builder
                    .map(CountTotalMembersAction.class, action -> dataAccessor.countMembers())
                    .map(CountMembersInGuildAction.class,
                            action -> dataAccessor.countMembersInGuild(action.getGuildId()))
                    .map(CountExactMembersInGuildAction.class,
                            action -> dataAccessor.countExactMembersInGuild(action.getGuildId()))
                    .map(GetMembersAction.class, action -> dataAccessor.getMembers())
                    .map(GetMembersInGuildAction.class, action -> dataAccessor.getMembersInGuild(action.getGuildId()))
                    .map(GetExactMembersInGuildAction.class,
                            action -> dataAccessor.getExactMembersInGuild(action.getGuildId()))
                    .map(GetMemberByIdAction.class, action -> dataAccessor.getMemberById(action.getGuildId(),
                            action.getUserId()));
        }

        if (enabled.contains(StoreFlag.MESSAGE)) {
            builder = builder
                    .map(CountTotalMessagesAction.class, action -> dataAccessor.countMessages())
                    .map(CountMessagesInChannelAction.class,
                            action -> dataAccessor.countMessagesInChannel(action.getChannelId()))
                    .map(GetMessagesAction.class, action -> dataAccessor.getMessages())
                    .map(GetMessagesInChannelAction.class,
                            action -> dataAccessor.getMessagesInChannel(action.getChannelId()))
                    .map(GetMessageByIdAction.class, action -> dataAccessor.getMessageById(action.getChannelId(),
                            action.getMessageId()));
        }

        if (enabled.contains(StoreFlag.PRESENCE)) {
            builder = builder
                    .map(CountTotalPresencesAction.class, action -> dataAccessor.countPresences())
                    .map(CountPresencesInGuildAction.class,
                            action -> dataAccessor.countPresencesInGuild(action.getGuildId()))
                    .map(GetPresencesAction.class, action -> dataAccessor.getPresences())
                    .map(GetPresencesInGuildAction.class,
                            action -> dataAccessor.getPresencesInGuild(action.getGuildId()))
                    .map(GetPresenceByIdAction.class, action -> dataAccessor.getPresenceById(action.getGuildId(),
                            action.getUserId()));
        }

        if (enabled.contains(StoreFlag.ROLE)) {
            builder = builder
                    .map(CountTotalRolesAction.class, action -> dataAccessor.countRoles())
                    .map(CountRolesInGuildAction.class, action -> dataAccessor.countRolesInGuild(action.getGuildId()))
                    .map(GetRolesAction.class, action -> dataAccessor.getRoles())
                    .map(GetRolesInGuildAction.class, action -> dataAccessor.getRolesInGuild(action.getGuildId()))
                    .map(GetRoleByIdAction.class, action -> dataAccessor.getRoleById(action.getGuildId(),
                            action.getRoleId()));
        }

        if (enabled.contains(StoreFlag.USER)) {
            builder = builder
                    .map(CountTotalUsersAction.class, action -> dataAccessor.countUsers())
                    .map(GetUsersAction.class, action -> dataAccessor.getUsers())
                    .map(GetUserByIdAction.class, action -> dataAccessor.getUserById(action.getUserId()));
        }

        if (enabled.contains(StoreFlag.VOICE_STATE)) {
            builder = builder
                    .map(CountTotalVoiceStatesAction.class, action -> dataAccessor.countVoiceStates())
                    .map(CountVoiceStatesInGuildAction.class,
                            action -> dataAccessor.countVoiceStatesInGuild(action.getGuildId()))
                    .map(CountVoiceStatesInChannelAction.class,
                            action -> dataAccessor.countVoiceStatesInChannel(action.getGuildId(),
                                    action.getChannelId()))
                    .map(GetVoiceStatesAction.class, action -> dataAccessor.getVoiceStates())
                    .map(GetVoiceStatesInChannelAction.class,
                            action -> dataAccessor.getVoiceStatesInChannel(action.getGuildId(), action.getChannelId()))
                    .map(GetVoiceStatesInGuildAction.class,
                            action -> dataAccessor.getVoiceStatesInGuild(action.getGuildId()))
                    .map(GetVoiceStateByIdAction.class, action -> dataAccessor.getVoiceStateById(action.getGuildId(),
                            action.getUserId()));
        }

        if (enabled.contains(StoreFlag.STICKER)) {
            builder = builder
                    .map(CountTotalStickersAction.class, action -> dataAccessor.countStickers())
                    .map(CountStickersInGuildAction.class,
                            action -> dataAccessor.countStickersInGuild(action.getGuildId()))
                    .map(GetStickersAction.class, action -> dataAccessor.getStickers())
                    .map(GetStickersInGuildAction.class, action -> dataAccessor.getStickersInGuild(action.getGuildId()))
                    .map(GetStickerByIdAction.class, action -> dataAccessor.getStickerById(action.getGuildId(),
                            action.getStickerId()));
        }

        if (enabled.contains(StoreFlag.SCHEDULED_EVENT)) {
            builder = builder
                    .map(GetGuildScheduledEventsInGuildAction.class,
                            action -> dataAccessor.getScheduledEventsInGuild(action.getGuildId()))
                    .map(GetGuildScheduledEventByIdAction.class,
                            action -> dataAccessor.getScheduledEventById(action.getGuildId(), action.getEventId()))
                    .map(GetGuildScheduledEventUsersInEventAction.class,
                            action -> dataAccessor.getScheduledEventUsersInEvent(action.getGuildId(),
                                    action.getEventId()));
        }

        return builder.build();
    }

    private static ActionMapper gatewayDataUpdaterToMapper(GatewayDataUpdater gatewayDataUpdater,
                                                           EnumSet<StoreFlag> enabled) {
        Objects.requireNonNull(gatewayDataUpdater);

        ActionMapper.Builder builder = ActionMapper.builder()
                .map(ReadyAction.class, action -> gatewayDataUpdater.onReady(action.getReady()))
                .map(InvalidateShardAction.class,
                        action -> gatewayDataUpdater.onShardInvalidation(action.getShardIndex(), action.getCause()));

        if (enabled.contains(StoreFlag.CHANNEL)) {
            builder = builder
                    .map(ChannelCreateAction.class,
                            action -> gatewayDataUpdater.onChannelCreate(action.getShardIndex(),
                                    action.getChannelCreate()))
                    .map(ChannelDeleteAction.class,
                            action -> gatewayDataUpdater.onChannelDelete(action.getShardIndex(),
                                    action.getChannelDelete()))
                    .map(ChannelUpdateAction.class,
                            action -> gatewayDataUpdater.onChannelUpdate(action.getShardIndex(),
                                    action.getChannelUpdate()));
        }

        if (enabled.contains(StoreFlag.EMOJI)) {
            builder = builder
                    .map(GuildEmojisUpdateAction.class,
                            action -> gatewayDataUpdater.onGuildEmojisUpdate(action.getShardIndex(),
                                    action.getGuildEmojisUpdate()));
        }

        if (enabled.contains(StoreFlag.GUILD)) {
            builder = builder
                    .map(GuildCreateAction.class, action -> gatewayDataUpdater.onGuildCreate(action.getShardIndex(),
                            action.getGuildCreate()))
                    .map(GuildDeleteAction.class, action -> gatewayDataUpdater.onGuildDelete(action.getShardIndex(),
                            action.getGuildDelete()))
                    .map(GuildUpdateAction.class, action -> gatewayDataUpdater.onGuildUpdate(action.getShardIndex(),
                            action.getGuildUpdate()));
        }

        if (enabled.contains(StoreFlag.MEMBER)) {
            builder = builder
                    .map(GuildMemberAddAction.class,
                            action -> gatewayDataUpdater.onGuildMemberAdd(action.getShardIndex(),
                                    action.getGuildMemberAdd()))
                    .map(GuildMemberRemoveAction.class,
                            action -> gatewayDataUpdater.onGuildMemberRemove(action.getShardIndex(),
                                    action.getGuildMemberRemove()))
                    .map(GuildMembersChunkAction.class,
                            action -> gatewayDataUpdater.onGuildMembersChunk(action.getShardIndex(),
                                    action.getGuildMembersChunk()))
                    .map(GuildMemberUpdateAction.class,
                            action -> gatewayDataUpdater.onGuildMemberUpdate(action.getShardIndex(),
                                    action.getGuildMemberUpdate()))
                    .map(CompleteGuildMembersAction.class,
                            action -> gatewayDataUpdater.onGuildMembersCompletion(action.getGuildId()));
        }

        if (enabled.contains(StoreFlag.MESSAGE)) {
            builder = builder
                    .map(MessageCreateAction.class,
                            action -> gatewayDataUpdater.onMessageCreate(action.getShardIndex(),
                                    action.getMessageCreate()))
                    .map(MessageDeleteAction.class,
                            action -> gatewayDataUpdater.onMessageDelete(action.getShardIndex(),
                                    action.getMessageDelete()))
                    .map(MessageDeleteBulkAction.class,
                            action -> gatewayDataUpdater.onMessageDeleteBulk(action.getShardIndex(),
                                    action.getMessageDeleteBulk()))
                    .map(MessageReactionAddAction.class,
                            action -> gatewayDataUpdater.onMessageReactionAdd(action.getShardIndex(),
                                    action.getMessageReactionAdd()))
                    .map(MessageReactionRemoveAction.class,
                            action -> gatewayDataUpdater.onMessageReactionRemove(action.getShardIndex(),
                                    action.getMessageReactionRemove()))
                    .map(MessageReactionRemoveAllAction.class,
                            action -> gatewayDataUpdater.onMessageReactionRemoveAll(action.getShardIndex(),
                                    action.getMessageReactionRemoveAll()))
                    .map(MessageReactionRemoveEmojiAction.class,
                            action -> gatewayDataUpdater.onMessageReactionRemoveEmoji(action.getShardIndex(),
                                    action.getMessageReactionRemoveEmoji()))
                    .map(MessageUpdateAction.class,
                            action -> gatewayDataUpdater.onMessageUpdate(action.getShardIndex(),
                                    action.getMessageUpdate()));
        }

        if (enabled.contains(StoreFlag.PRESENCE)) {
            builder = builder
                    .map(PresenceUpdateAction.class,
                            action -> gatewayDataUpdater.onPresenceUpdate(action.getShardIndex(),
                                    action.getPresenceUpdate()));
        }

        if (enabled.contains(StoreFlag.ROLE)) {
            builder = builder
                    .map(GuildRoleCreateAction.class,
                            action -> gatewayDataUpdater.onGuildRoleCreate(action.getShardIndex(),
                                    action.getGuildRoleCreate()))
                    .map(GuildRoleDeleteAction.class,
                            action -> gatewayDataUpdater.onGuildRoleDelete(action.getShardIndex(),
                                    action.getGuildRoleDelete()))
                    .map(GuildRoleUpdateAction.class,
                            action -> gatewayDataUpdater.onGuildRoleUpdate(action.getShardIndex(),
                                    action.getGuildRoleUpdate()));
        }

        if (enabled.contains(StoreFlag.USER)) {
            builder = builder
                    .map(UserUpdateAction.class, action -> gatewayDataUpdater.onUserUpdate(action.getShardIndex(),
                            action.getUserUpdate()));
        }

        if (enabled.contains(StoreFlag.VOICE_STATE)) {
            builder = builder
                    .map(VoiceStateUpdateDispatchAction.class,
                            action -> gatewayDataUpdater.onVoiceStateUpdateDispatch(action.getShardIndex(),
                                    action.getVoiceStateUpdateDispatch()));
        }

        if (enabled.contains(StoreFlag.STICKER)) {
            builder = builder
                    .map(GuildStickersUpdateAction.class,
                            action -> gatewayDataUpdater.onGuildStickersUpdate(action.getShardIndex(),
                                    action.getGuildStickersUpdate()));
        }

        if (enabled.contains(StoreFlag.SCHEDULED_EVENT)) {
            builder = builder
                    .map(GuildScheduledEventCreateAction.class,
                            action -> gatewayDataUpdater.onGuildScheduledEventCreate(action.getShardIndex(),
                                    action.getGuildScheduledEventCreate()))
                    .map(GuildScheduledEventUpdateAction.class,
                            action -> gatewayDataUpdater.onGuildScheduledEventUpdate(action.getShardIndex(),
                                    action.getGuildScheduledEventUpdate()))
                    .map(GuildScheduledEventDeleteAction.class,
                            action -> gatewayDataUpdater.onGuildScheduledEventDelete(action.getShardIndex(),
                                    action.getGuildScheduledEventDelete()))
                    .map(GuildScheduledEventUserAddAction.class,
                            actions -> gatewayDataUpdater.onGuildScheduledEventUserAdd(actions.getShardIndex(),
                                    actions.getUserAdd()))
                    .map(GuildScheduledEventUserRemoveAction.class,
                            actions -> gatewayDataUpdater.onGuildScheduledEventUserRemove(actions.getShardIndex(),
                                    actions.getUserRemove()));
        }

        return builder.build();
    }

    /**
     * Creates a new {@link Store} that will merge actions from multiple layouts. Overlapping
     * {@link StoreAction StoreActions} from each layout will be merged by keeping the <strong>first</strong> layout
     * that declared it.
     *
     * @param layouts a {@link StoreLayout} array
     * @return a new {@link Store}
     */
    @Experimental
    public static Store fromLayouts(StoreLayout... layouts) {
        return new Store(ActionMapper.mergeFirst(Arrays.stream(layouts)
                .map(Store::layoutToMapper)
                .collect(Collectors.toList())));
    }

    /**
     * Executes the given action. The action will be routed based on the concrete type of the action, and handled
     * according to the layout given when creating this {@link Store}. If the concrete type of the action is unknown
     * and no custom mapping was defined for it, it will return empty.
     *
     * @param action the action to execute
     * @param <R> the type of data returned by the action
     * @return a {@link Publisher} where, upon successful completion, emits the result(s) produced by the execution of
     * the action, if any. If an error is received, it is emitted through the {@link Publisher}.
     */
    public <R> Publisher<R> execute(StoreAction<R> action) {
        return actionMapper.findHandlerForAction(action)
                .<Publisher<R>>map(h -> h.apply(action))
                .orElse(Flux.empty());
    }
}
