//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.thedamstex21.lightBlockCraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class LightBlockCraft extends JavaPlugin implements Listener {
    public LightBlockCraft() {
    }

    public void onEnable() {
        this.createCustomLightBlockRecipe();
        Bukkit.getPluginManager().registerEvents(this, this);
        this.getLogger().info("LightBlockCraft плагин включен!");
    }

    public void onDisable() {
        this.getLogger().info("LightBlockCraft плагин выключен.");
    }

    private void createCustomLightBlockRecipe() {
        NamespacedKey key = new NamespacedKey(this, "light_block_custom");
        ItemStack placeholderItem = new ItemStack(Material.BARRIER);
        ShapedRecipe recipe = new ShapedRecipe(key, placeholderItem);
        recipe.shape(new String[]{"GGG", "GDG", "GGG"});
        recipe.setIngredient('G', Material.GLASS);
        recipe.setIngredient('D', Material.GLOWSTONE);
        Bukkit.addRecipe(recipe);
    }

    @EventHandler
    public void onPrepareCraft(PrepareItemCraftEvent event) {
        ItemStack[] matrix = event.getInventory().getMatrix();
        if (this.matchesLightBlockRecipe(matrix)) {
            event.getInventory().setResult(new ItemStack(Material.LIGHT));
        }

    }

    private boolean matchesLightBlockRecipe(ItemStack[] matrix) {
        return this.isGlass(matrix[0]) && this.isGlass(matrix[1]) && this.isGlass(matrix[2]) && this.isGlass(matrix[3]) && this.isGlowstoneDust(matrix[4]) && this.isGlass(matrix[5]) && this.isGlass(matrix[6]) && this.isGlass(matrix[7]) && this.isGlass(matrix[8]);
    }

    private boolean isGlass(ItemStack item) {
        return item != null && item.getType() == Material.GLASS;
    }

    private boolean isGlowstoneDust(ItemStack item) {
        return item != null && item.getType() == Material.GLOWSTONE;
    }
}
