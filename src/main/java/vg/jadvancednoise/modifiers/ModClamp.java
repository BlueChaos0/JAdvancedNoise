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

/**
 * Clamps the source value
 * <ul>
 *
 * </ul>
 * @author BlueChaos
 */
public class ModClamp extends Modifier
{
	protected static final float DEFAULT_MIN = 0f;
	protected static final float DEFAULT_MAX = 1f;
	protected float min, max;

	public ModClamp()
	{
		min = DEFAULT_MIN;
		max = DEFAULT_MAX;
	}

	public ModClamp(float min, float max)
	{
		this.min = min;
		this.max = max;
	}

	@Override
	public float get(float x)
	{
		return Math.max(min, Math.min(max, src.get(x)));
	}

	@Override
	public float get(float x, float y)
	{
		return Math.max(min, Math.min(max, src.get(x, y)));
	}

	@Override
	public float get(float x, float y, float z)
	{
		return Math.max(min, Math.min(max, src.get(x, y, z)));
	}

	@Override
	public String toString()
	{
		String m = "\n    ";
		return ("CLAMP: " + m + "min:" + min + m + "max:" + max);
	}
}
