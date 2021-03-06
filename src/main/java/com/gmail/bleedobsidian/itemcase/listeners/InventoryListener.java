/*
 * Copyright (C) 2013 Jesse Prescott <BleedObsidian@gmail.com>
 *
 * ItemCase is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/gpl.html>.
 */
package com.gmail.bleedobsidian.itemcase.listeners;

import com.gmail.bleedobsidian.itemcase.ItemCase;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

/**
 * Inventory related event listener. (Only used internally)
 *
 * @author BleedObsidian (Jesse Prescott)
 */
public class InventoryListener implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getPlayer() instanceof Player) {
            if (ItemCase.getInstance().getInventoryManager().hasOpenInventory(
                    (Player) event.getPlayer())) {
                ItemCase.getInstance().getItemcaseManager().saveItemcase(
                        ItemCase.getInstance().getInventoryManager().
                        getItemcaseForPlayer(
                                (Player) event.getPlayer()));
                ItemCase.getInstance().getInventoryManager().
                        removeOpenInventory(
                                (Player) event.getPlayer());
            }
        }
    }
}
