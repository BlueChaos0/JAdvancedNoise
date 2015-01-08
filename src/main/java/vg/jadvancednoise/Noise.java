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
import java.util.List;

/**
 * @author BlueChaos
 */
public class Noise
{
	private List<Modifier> modifiers;

	public Noise()
	{
		modifiers = new ArrayList<Modifier>();
	}

	public void applyModifier(Modifier modifier)
	{
		modifiers.add(modifier);
	}

	public float get(float x)
	{
		float i = x;
		for (Modifier m : modifiers) {
			i = m.get(i);
			System.out.println(modifiers.get(0) + " " + m);
//			modifiers.remove(0);
		}
		return i;
	}

	public float get(float x, float y)
	{
		return get(Compounder.defaultCompound(x, y));
	}

	public float get(float x, float y, float z)
	{
		return get(Compounder.defaultCompound(x, y, z));
	}
}
