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

package vg.jadvancednoise.modifiers;

import vg.jadvancednoise.modifiers.util.ModParameter;

/**
 * @author BlueChaos
 */
public abstract class Modifier
{
	protected ModParameter src = null;

	/**
	 * Return a noise value from a 1D value
	 *
	 * @param x The x value to sample
	 * @return The calculated noise value
	 */
	public abstract float get(float x);

	/**
	 * Return a noise value from a 2D value
	 *
	 * @param x The x value to sample
	 * @param y The y value to sample
	 * @return The calculated noise value
	 */
	public abstract float get(float x, float y);

	/**
	 * Return a noise value from a 3D value
	 *
	 * @param x The x value to sample
	 * @param y The y value to sample
	 * @param z The z value to sample
	 * @return The calculated noise value
	 */
	public abstract float get(float x, float y, float z);

	public Modifier setSrc(Modifier src)
	{
		this.src = new ModParameter(src);
		return this;
	}

	public Modifier setSrc(float src)
	{
		this.src = new ModParameter(src);
		return this;
	}

	public ModParameter getSrc()
	{
		return src;
	}

	@Override
	public String toString()
	{
		return src.toString();
	}

}
