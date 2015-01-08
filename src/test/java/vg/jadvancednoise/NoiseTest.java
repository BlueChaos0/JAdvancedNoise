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

import org.junit.Test;
import vg.jadvancednoise.modifiers.ModifierConstant;
import vg.jadvancednoise.modifiers.ModifierSin;
import vg.jadvancednoise.modifiers.ModifierSquareRoot;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class NoiseTest
{

	@Test
	public void testConstantSin() throws Exception
	{
		Noise n = new Noise();
		n.applyModifier(new ModifierSquareRoot());
		n.applyModifier(new ModifierSin());
		System.out.println(n.get(1f, 3f, 6f));
	}

	@Test
	public void testImage() throws Exception
	{
		BufferedImage bufferedImage = new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);

		Noise n = new Noise();
		n.applyModifier(new ModifierSquareRoot());
		n.applyModifier(new ModifierSin());

		for(int x = 0; x < 640; x++) {
			for(int y = 0; y < 480; y++) {

			}
		}
	}

}