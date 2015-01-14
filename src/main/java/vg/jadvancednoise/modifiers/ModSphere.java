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

import java.util.Random;

/**
 * @author BlueChaos
 */
public class ModSphere extends Modifier
{
	/** Center values of the sphere */
	protected ModParameter centerX = new ModParameter(0f), centerY = new ModParameter(0f), centerZ = new ModParameter
			(0f), radius = new ModParameter(1f);
	protected float volatility = 0f;
	protected long seed = 10000L;
	protected Random random = new Random();

	@Override
	public void init()
	{
	}

	@Override
	public float get(float x)
	{
		float dx = centerX.get(x) - x;
		float dis = Math.abs(dx);
		float val = ((radius.get(x) - dis) / radius.get(x)) + (volatility / 2 * rand());
		if (val < 0) val = 0;
		if (val > 1) val = 1;
		return val;
	}

	@Override
	public float get(float x, float y)
	{
		float dx = centerX.get(x, y) - x, dy = centerY.get(x, y) - y;
		float dis = (float) (Math.sqrt(dx * dx + dy * dy));
		float val = ((radius.get(x, y) - dis) / radius.get(x, y)) + (volatility / 2 * rand());
		if (val < 0) val = 0;
		if (val > 1) val = 1;
		return val;
	}

	@Override
	public float get(float x, float y, float z)
	{
		float dx = centerX.get(x, y, z) - x, dy = centerY.get(x, y, z) - y, dz = centerZ.get(x, y, z) - z;
		float dis = (float) (Math.sqrt(dx * dx + dy * dy + dz * dz));
		float val = ((radius.get(x, y, z) - dis) / radius.get(x, y, z)) + (volatility / 2 * rand());
		if (val < 0) val = 0;
		if (val > 1) val = 1;
		return val;
	}

	@Override
	public void dispose()
	{
		centerX = null;
		centerY = null;
		centerZ = null;
		radius = null;
		random = null;
	}

	public ModSphere setCenterX(float centerX)
	{
		this.centerX.set(centerX);
		return this;
	}

	public ModSphere setCenterX(Modifier centerX)
	{
		this.centerX.set(centerX);
		return this;
	}

	public ModSphere setCenterY(float centerY)
	{
		this.centerY.set(centerY);
		return this;
	}

	public ModSphere setCenterY(Modifier centerY)
	{
		this.centerY.set(centerY);
		return this;
	}

	public ModSphere setCenterZ(float centerZ)
	{
		this.centerZ.set(centerZ);
		return this;
	}

	public ModSphere setCenterZ(Modifier centerZ)
	{
		this.centerZ.set(centerZ);
		return this;
	}

	public ModSphere setRadius(float radius)
	{
		this.radius = new ModParameter(radius);
		return this;
	}

	public ModSphere setRadius(Modifier radius)
	{
		this.radius = new ModParameter(radius);
		return this;
	}

	public ModSphere setVolatility(float volatility)
	{
		this.volatility = volatility;
		return this;
	}

	public ModSphere setSeed(long seed)
	{
		this.seed = seed;
		random.setSeed(seed);
		return this;
	}

	/**
	 * @return A random number from -1 (inclusive) to 1 (exclusive) based on the <code>seed</code>.
	 */
	protected float rand()
	{
		return random.nextFloat() - 0.5f * 2f;
	}

	@Override
	public String toString()
	{
		String m = "\n    ";
		return ("SPHERE: " + m + "cx:" + centerX + m + "cy:" + centerY + m + "cz:" + centerZ + m + "r:" + radius + m +
				"vol:" + volatility + m + "s:" + seed);
	}
}
