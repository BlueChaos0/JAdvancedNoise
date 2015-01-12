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
public class ModConstant extends Modifier
{
	protected static final float DEFAULT_CONSTANT = 0f;
	protected float constant;

	public ModConstant()
	{
		constant = DEFAULT_CONSTANT;
	}

	public ModConstant(float constant)
	{
		this.constant = constant;
	}

	@Override
	public float get(float x)
	{
		return constant;
	}

	@Override
	public float get(float x, float y)
	{
		return constant;
	}

	@Override
	public float get(float x, float y, float z)
	{
		return constant;
	}
}
