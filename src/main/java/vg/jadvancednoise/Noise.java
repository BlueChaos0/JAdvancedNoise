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

/**
 * @author BlueChaos
 */
public class Noise
{
	/** List of Modifiers that make up this Noise object */
	private ModifierChain modifiers;

	/**
	 * Create a Noise object.
	 * <p>
	 * Noise objects hold a {@link vg.jadvancednoise.ModifierChain} to control the algorithm used to create Noise.
	 */
	public Noise()
	{
		modifiers = new ModifierChain();
	}

	/**
	 * Adds the <code>modifier</code> to this Noise object's {@link vg.jadvancednoise.ModifierChain}. Also ensures that
	 * <code>modifier</code> has a valid source.
	 *
	 * @param modifier
	 * 		Adds <code>modifier</code> to the {@link vg.jadvancednoise.ModifierChain}
	 *
	 * @return The Noise object this modifier was applied to
	 *
	 * @see vg.jadvancednoise.modifiers.Modifier
	 */
	public Noise applyModifier(Modifier modifier)
	{
		if (modifier.getSrc() == null)
			if (modifiers.isEmpty()) {
				modifier.setSrc(0f);
			} else {
				modifier.setSrc(modifiers.get(modifiers.size() - 1));
			}
		modifiers.add(modifier);
		return this;
	}

	public void init()
	{
		modifiers.forEach(m -> m.init());
	}

	/**
	 * Executes the following code:
	 *
	 * <code>
	 *     return modifiers.get(modifiers.size() - 1).get(x);
	 * </code>
	 *
	 * @param x The x value to sample from the {@link vg.jadvancednoise.ModifierChain}
	 * @return The calculated noise value
	 */
	public float get(float x)
	{
		return modifiers.get(modifiers.size() - 1).get(x);
	}

	/**
	 * Executes the following code:
	 *
	 * <code>
	 *     return modifiers.get(modifiers.size() - 1).get(x, y);
	 * </code>
	 *
	 * @param x The x value to sample from the {@link vg.jadvancednoise.ModifierChain}
	 * @param y The y value to sample from the {@link vg.jadvancednoise.ModifierChain}
	 * @return The calculated noise value
	 */
	public float get(float x, float y)
	{
		return modifiers.get(modifiers.size() - 1).get(x, y);
	}

	/**
	 * Executes the following code:
	 *
	 * <code>
	 *     return modifiers.get(modifiers.size() - 1).get(x, y, z);
	 * </code>
	 *
	 * @param x The x value to sample from the {@link vg.jadvancednoise.ModifierChain}
	 * @param y The y value to sample from the {@link vg.jadvancednoise.ModifierChain}
	 * @param z The z value to sample from the {@link vg.jadvancednoise.ModifierChain}
	 * @return The calculated noise value
	 */
	public float get(float x, float y, float z)
	{
		return modifiers.get(modifiers.size() - 1).get(x, y, z);
	}

	public void dispose()
	{
		modifiers.forEach(m -> m.dispose());
	}

	@Override
	public String toString()
	{
		return ("Noise " + modifiers.toString());
	}
}
