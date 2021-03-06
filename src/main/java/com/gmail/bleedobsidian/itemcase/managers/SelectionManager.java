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
package com.gmail.bleedobsidian.itemcase.managers;

import com.gmail.bleedobsidian.itemcase.managers.interfaces.SelectionListener;
import com.gmail.bleedobsidian.itemcase.managers.itemcase.Itemcase;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;

/**
 * A manager to handle all selection listeners. (Only used internally, please
 * use API)
 *
 * @author BleedObsidian (Jesse Prescott)
 */
public class SelectionManager {

    /**
     * Pending selections.
     */
    private final Map<Player, SelectionListener> pending = new HashMap<Player, SelectionListener>();

    /**
     * On player select Itemcase.
     *
     * @param player Player.
     * @param itemcase Itemcase.
     */
    public void onPlayerSelect(Player player, Itemcase itemcase) {
        if (pending.containsKey(player)) {
            pending.get(player).selected(player, itemcase);
            pending.remove(player);
        }
    }

    /**
     * Add a pending selection to the open list.
     *
     * @param listener Listener.
     * @param player Player.
     */
    public void addPendingSelection(SelectionListener listener, Player player) {
        this.pending.put(player, listener);
    }

    /**
     * Remove a pending selection to the closed list.
     *
     * @param player Player.
     */
    public void removePendingSelection(Player player) {
        this.pending.remove(player);
    }

    /**
     * If player is pending an Itemcase selection.
     *
     * @param player Player.
     * @return If pending selection or not.
     */
    public boolean isPendingSelection(Player player) {
        return this.pending.get(player) != null;
    }
}
