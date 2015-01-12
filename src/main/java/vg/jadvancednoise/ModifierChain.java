/*
 * Java Advanced Noise - A java library for producing pseudorandom values
 * Copyright (C) 2015  Vorsutus Games
 *
 * This program is free software: you can redistribute it and/or modify
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package vg.jadvancednoise;

import vg.jadvancednoise.modifiers.Modifier;

import java.util.ArrayList;

/**
 * ModifierChain is a list of Modifiers that keeps track of the order that the Modifiers should be kept in.
 * TODO: Change ModifierChain to extend Stack IF it is more efficient.
 * @see vg.jadvancednoise.modifiers.Modifier
 * @author BlueChaos
 */
public class ModifierChain extends ArrayList<Modifier>
{
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Modifiers: \n  ");
		forEach(m -> sb.append(m.toString() + "\n  "));
		return (sb.toString());
	}
}
