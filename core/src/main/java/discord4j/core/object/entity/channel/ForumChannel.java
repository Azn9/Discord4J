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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Discord4J.  If not, see <http://www.gnu.org/licenses/>.
 */
package discord4j.core.object.entity.channel;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.spec.ForumChannelEditMono;
import discord4j.core.spec.ForumChannelEditSpec;
import discord4j.core.spec.legacy.LegacyForumChannelEditSpec;
import discord4j.core.util.EntityUtil;
import discord4j.discordjson.json.ChannelData;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * A Discord text channel.
 */
public final class ForumChannel extends BaseTopLevelGuildChannel implements TopLevelGuildMessageChannel {

    /**
     * Constructs an {@code ForumChannel} with an associated {@link GatewayDiscordClient} and Discord data.
     *
     * @param gateway The {@link GatewayDiscordClient} associated to this object, must be non-null.
     * @param data The raw data as represented by Discord, must be non-null.
     */
    public ForumChannel(GatewayDiscordClient gateway, ChannelData data) {
        super(gateway, data);
    }

    /**
     * Gets the amount of seconds an user has to wait before sending another message (0-120).
     * <p>
     * Bots, as well as users with the permission {@code manage_messages} or {@code manage_channel}, are unaffected.
     *
     * @return The amount of seconds an user has to wait before sending another message (0-120).
     */
    public int getRateLimitPerUser() {
        return getData().rateLimitPerUser().toOptional()
                .orElseThrow(IllegalStateException::new); // this should be safe for all ForumChannels
    }

    /**
     * Gets whether this channel is considered NSFW (Not Safe For Work).
     *
     * @return {@code true} if this channel is considered NSFW (Not Safe For Work), {@code false} otherwise.
     */
    public boolean isNsfw() {
        return getData().nsfw().toOptional().orElse(false);
    }

    /**
     * Requests to edit this text channel.
     *
     * @param spec A {@link Consumer} that provides a "blank" {@link LegacyForumChannelEditSpec} to be operated on.
     * @return A {@link Mono} where, upon successful completion, emits the edited {@link ForumChannel}. If an error is
     * received, it is emitted through the {@code Mono}.
     * @deprecated use {@link #edit(ForumChannelEditSpec)} or {@link #edit()} which offer an immutable approach to build
     * specs
     */
    @Deprecated
    public Mono<ForumChannel> edit(final Consumer<? super LegacyForumChannelEditSpec> spec) {
        return Mono.defer(
                () -> {
                    LegacyForumChannelEditSpec mutatedSpec = new LegacyForumChannelEditSpec();
                    spec.accept(mutatedSpec);
                    return getClient().getRestClient().getChannelService()
                            .modifyChannel(getId().asLong(), mutatedSpec.asRequest(), mutatedSpec.getReason());
                })
                .map(bean -> EntityUtil.getChannel(getClient(), bean))
                .cast(ForumChannel.class);
    }

    /**
     * Requests to edit this text channel. Properties specifying how to edit this channel can be set via the {@code
     * withXxx} methods of the returned {@link ForumChannelEditMono}.
     *
     * @return A {@link ForumChannelEditMono} where, upon successful completion, emits the edited {@link ForumChannel}. If
     * an error is received, it is emitted through the {@code ForumChannelEditMono}.
     */
    public ForumChannelEditMono edit() {
        return ForumChannelEditMono.of(this);
    }

    /**
     * Requests to edit this text channel.
     *
     * @param spec an immutable object that specifies how to edit this text channel
     * @return A {@link Mono} where, upon successful completion, emits the edited {@link ForumChannel}. If an error is
     * received, it is emitted through the {@code Mono}.
     */
    public Mono<ForumChannel> edit(ForumChannelEditSpec spec) {
        Objects.requireNonNull(spec);
        return Mono.defer(
                () -> getClient().getRestClient().getChannelService()
                        .modifyChannel(getId().asLong(), spec.asRequest(), spec.reason()))
                .map(bean -> EntityUtil.getChannel(getClient(), bean))
                .cast(ForumChannel.class);
    }

    @Override
    public String toString() {
        return "ForumChannel{} " + super.toString();
    }

    /** Represents the sort order of the forum channel. */
    public enum SortOrderType {

        /** Unknown sort order type. */
        UNKNOWN(-1),

        /** Sort by the time of the last message. */
        LATEST_ACTIVITY(0),

        /** Sort by the time of the thread creation. */
        CREATION_DATE(1);

        /** The underlying value as represented by Discord. */
        private final int value;

        /** Constructs a {@code SortOrderType} with the given value.
         *
         * @param value The underlying value of the sort order type.
         */
        SortOrderType(int value) {
            this.value = value;
        }

        /** Gets the underlying value of the sort order type.
         *
         * @return The underlying value of the sort order type.
         */
        public int getValue() {
            return value;
        }

        /**
         * Gets the sort order from its underlying value as represented by Discord.
         * It is guaranteed that invoking {@link #getValue()} from the returned enum will
         * equal ({@code ==}) the supplied {@code value}.
         *
         * @param value The underlying value as represented by Discord.
         * @return The sort order type.
         */
        public static SortOrderType of(final int value) {
            switch (value) {
                case 0: return LATEST_ACTIVITY;
                case 1: return CREATION_DATE;
                default: return UNKNOWN;
            }
        }
    }

    /** Represents the layout of the forum channel. */
    public enum ForumLayoutType {

        /** Unknown layout type. */
        UNKNOWN(-1),

        /** No default has been set for forum channel. */
        NOT_SET(0),

        /** Display posts as a list. */
        LIST_VIEW(1),

        /** Display posts as a collection of tiles. */
        GALLERY_VIEW(2);

        /** The underlying value as represented by Discord. */
        private final int value;

        /** Constructs a {@code ForumLayoutType} with the given value.
         *
         * @param value The underlying value of the forum layout type.
         */
        ForumLayoutType(int value) {
            this.value = value;
        }

        /** Gets the underlying value of the forum layout type.
         *
         * @return The underlying value of the forum layout type.
         */
        public int getValue() {
            return value;
        }

        /**
         * Gets the forum layout from its underlying value as represented by Discord.
         * It is guaranteed that invoking {@link #getValue()} from the returned enum will
         * equal ({@code ==}) the supplied {@code value}.
         *
         * @param value The underlying value as represented by Discord.
         * @return The forum layout type.
         */
        public static ForumLayoutType of(final int value) {
            switch (value) {
                case 0: return NOT_SET;
                case 1: return LIST_VIEW;
                case 2: return GALLERY_VIEW;
                default: return UNKNOWN;
            }
        }
    }
}
