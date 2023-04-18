package net.sen.sensmagicmod.common.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.item.ModItems;
import net.sen.sensmagicmod.common.villager.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = SensMagicMod.MODID)
public class ModVillagerEvent
{
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event)
    {
        if (event.getType() == ModVillagers.WIZARD_INGREDIENTS_SELLER.get())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.CRIMSON_STEEL_INGOT.get(), 12);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack, 10, 8, 0.02F
            ));
        }

        if (event.getType() == ModVillagers.WIZARD_POTION_SELLER.get())
        {

        }

        if (event.getType() == ModVillagers.WIZARD_SCROLL_SELLER.get())
        {

        }

        if (event.getType() == ModVillagers.WIZARD_RITUAL_SELLER.get())
        {

        }

        if (event.getType() == ModVillagers.WIZARD_RUNE_SELLER.get())
        {

        }

        if (event.getType() == ModVillagers.WIZARD_FABRIC_SELLER.get())
        {

        }

        if (event.getType() == ModVillagers.WIZARD_SMITH_SELLER.get())
        {

        }

        if (event.getType() == ModVillagers.WIZARD_ASTRONOMER_SELLER.get())
        {

        }

        if (event.getType() == ModVillagers.WIZARD_FARMING_SELLER.get())
        {

        }
    }
}
