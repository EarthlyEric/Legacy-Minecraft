package wily.legacy.mixin.base.client.sign;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.SignEditScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SignEditScreen.class)
public abstract class SignEditScreenMixin extends Screen {


    protected SignEditScreenMixin(Component component) {
        super(component);
    }

    @Redirect(method = "offsetSign", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V"))
    private void offsetSign(PoseStack instance, float x, float y, float z){
        instance.translate(x, 42,z);
    }

    @Redirect(method = "renderSignBackground", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;scale(FFF)V"))
    private void renderSignBackground(PoseStack instance, float x, float y, float z){
        instance.scale(x * 144/93,y * 144/93,z * 144/93);
    }
}
