package wily.legacy.network;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import wily.factoryapi.FactoryAPI;
import wily.factoryapi.base.network.CommonNetwork;
import wily.legacy.Legacy4J;

import java.util.function.Supplier;

public class ServerPlayerMissHitPayload extends CommonNetwork.EmptyPayload {
    public static final CommonNetwork.Identifier<ServerPlayerMissHitPayload> ID = CommonNetwork.Identifier.create(Legacy4J.createModLocation("server_player_miss_hit"), ServerPlayerMissHitPayload::new);

    public ServerPlayerMissHitPayload() {
        super(ID);
    }

    @Override
    public void apply(Context context) {
        if (!context.player().isSpectator()) context.player().level().playSound(null,context.player(),SoundEvents.PLAYER_ATTACK_WEAK, SoundSource.PLAYERS,1.0f,1.0f);
    }
}
