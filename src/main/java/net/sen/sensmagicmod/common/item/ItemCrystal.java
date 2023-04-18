package net.sen.sensmagicmod.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.INBTSerializable;
import net.sen.sensmagicmod.common.magic.IMagicProperties;
import net.sen.sensmagicmod.common.magic.ModMagicElements;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Properties;

public class ItemCrystal extends Item implements IMagicProperties, INBTSerializable<CompoundTag>
{
    private static int maxMagicCapacity;
    private static ModMagicElements magicElement;

    private static Properties properties;

    private ItemCrystal itemCrystal = null;

    private static int magicEnergy;

    private ItemCrystal createItemCrystal()
    {
        if (this.itemCrystal == null)
        {
            this.itemCrystal = new ItemCrystal(properties, maxMagicCapacity, magicElement);
        }

        return this.itemCrystal;
    }

    public ItemCrystal(Properties properties, int amount, ModMagicElements magicElement)
    {
        super(properties.stacksTo(1));

        ItemCrystal.properties = properties;

        setMagicElements(magicElement);
        ItemCrystal.maxMagicCapacity = amount;
        //setCurrentMagicCapacity(, getMaxMagicCapacity());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        if (player.isCrouching())
        {
            this.chargeMagic(10, player.getUseItem());
        }
        else
        {
            this.useMagic(10, player.getUseItem());
        }

        return super.use(level, player, hand);
    }

    public static final List<ChatFormatting> ELEMENT_COLOUR = List.of(ChatFormatting.GRAY, ChatFormatting.DARK_PURPLE);

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag)
    {
        super.appendHoverText(stack, level, tooltip, flag);

        if (Screen.hasShiftDown())
        {
            tooltip.add(Component.translatable("item.sensmagicmod.crystal.magic.element", getMagicElements()).withStyle(ELEMENT_COLOUR.get(getMagicElements().ordinal()), ChatFormatting.ITALIC, ChatFormatting.BOLD));
            tooltip.add(Component.translatable("item.sensmagicmod.crystal.magic.capacity", getCurrentMagicCapacity(), getMaxMagicCapacity(stack)).withStyle(ChatFormatting.BLUE, ChatFormatting.UNDERLINE));
        }
        else
        {
            tooltip.add(Component.translatable("item.sensmagicmod.crystal.guide").withStyle(ChatFormatting.BLUE));
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int p_41407_, boolean p_41408_)
    {
        if (level.isClientSide())
        {
            return;
        }

        int magicEnergy = getCurrentMagicCapacity();
    }

    @Override
    public int getMaxStackSize(ItemStack stack)
    {
        return 1;
    }

    public static ModMagicElements getMagicElements()
    {
        return magicElement;
    }

    public static int getMaxMagicCapacity(ItemStack stack)
    {
        return maxMagicCapacity;
    }

    public static int getCurrentMagicCapacity()
    {
        return magicEnergy;
    }

    @Override
    public void setMagicElements(ModMagicElements element)
    {
        magicElement = element;
    }

    @Override
    public void setCurrentMagicCapacity(int value)
    {
        this.magicEnergy = value;
    }

    public void useMagic(int cost, ItemStack stack)
    {
        if (getCurrentMagicCapacity() >= cost)
        {
            //setCurrentMagicCapacity(getCurrentMagicCapacity() - cost);
            this.magicEnergy =  Math.max(magicEnergy - cost, 0);
        }
    }

    public void chargeMagic(int cost, ItemStack stack)
    {
        this.magicEnergy =  Math.min(magicEnergy - cost, getMaxMagicCapacity(stack));
        /*
        if (getCurrentMagicCapacity() < getMaxMagicCapacity(stack))
        {
            setCurrentMagicCapacity(getCurrentMagicCapacity() + cost);
        }
        else
        {
            return;
        }

        if (getCurrentMagicCapacity() > getMaxMagicCapacity(stack))
        {
            setCurrentMagicCapacity(getMaxMagicCapacity(stack));
        }*/
    }

    @Override
    public CompoundTag serializeNBT()
    {
        CompoundTag nbt = new CompoundTag();
        createItemCrystal().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt)
    {
        createItemCrystal().loadNBTData(nbt);
    }



    public void saveNBTData(CompoundTag nbt)
    {
        nbt.putInt("magic_energy", magicEnergy);
    }

    public void loadNBTData(CompoundTag nbt)
    {
        magicEnergy = nbt.getInt("magic_energy");
    }
}
