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
 * @author BlueChaos
 */
public class ModSin extends Modifier
{
	public ModSin()
	{
	}

	@Override
	public void init()
	{

	}

	@Override
	public float get(float x)
	{
		return (float) Math.sin(src.get(x));
	}

	@Override
	public float get(float x, float y)
	{
		return (float) Math.sin(src.get(x, y));
	}

	@Override
	public float get(float x, float y, float z)
	{
		return (float) Math.sin(src.get(x, y, z));
	}

	@Override
	public void dispose()
	{

	}
}
