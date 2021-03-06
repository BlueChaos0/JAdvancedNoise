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

package vg.jadvancednoise.modifiers.util;

import vg.jadvancednoise.modifiers.Modifier;

/**
 * @author BlueChaos
 */
public class ModParameter extends Modifier
{
	private Modifier modifier;
	private float value;

	public ModParameter(Modifier modifier)
	{
		this.modifier = modifier;
	}

	public ModParameter(float value)
	{
		this.value = value;
	}

	public boolean isModifier()
	{
		return modifier != null;
	}

	public void set(Modifier modifier)
	{
		this.modifier = modifier;
		this.value = 0f;
	}

	public void set(float value)
	{
		this.value = value;
		this.modifier = null;
	}

	@Override
	public void init()
	{

	}

	@Override
	public float get(float x)
	{
		if(isModifier())
			return modifier.get(x);
		return value;
	}

	@Override
	public float get(float x, float y)
	{
		if(isModifier())
			return modifier.get(x, y);
		return value;
	}

	@Override
	public float get(float x, float y, float z)
	{
		if(isModifier())
			return modifier.get(x, y, z);
		return value;
	}

	@Override
	public void dispose()
	{

	}

	@Override
	public String toString()
	{
		if(isModifier())
			return modifier.toString();
		else
			return new StringBuilder().append("VALUE: " + value).toString();
	}
}
