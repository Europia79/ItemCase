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

package com.gmail.bleedobsidian.itemcase.command.listeners;

import org.bukkit.entity.Player;

import com.gmail.bleedobsidian.itemcase.ItemCase;
import com.gmail.bleedobsidian.itemcase.command.commands.StorageCommand;
import com.gmail.bleedobsidian.itemcase.managers.interfaces.SelectionListener;
import com.gmail.bleedobsidian.itemcase.managers.itemcase.Itemcase;

/**
 * Storage Command Selection Listen
 * 
 * @author BleedObsidian (Jesse Prescott)
 */
public class StorageSelectionListener implements SelectionListener {
    private final ItemCase plugin;

    /**
     * New StorageSelectionListener.
     * 
     * @param plugin
     *            - ItemCase plugin.
     */
    public StorageSelectionListener(ItemCase plugin) {
        this.plugin = plugin;
    }

    /**
     * On selection.
     */
    public void selected(Player player, Itemcase itemcase) {
        StorageCommand.selected(plugin, player, itemcase);
    }
}