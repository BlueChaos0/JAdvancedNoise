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
import vg.jadvancednoise.modifiers.ModSphere;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class NoiseTest
{
	@Test
	public void testSphere() throws Exception
	{
		Noise n = new Noise().applyModifier(new ModSphere().setCenterX(5).setRadius(10).setSeed(404L).setVolatility(
				.2f));
		System.out.println(n.toString());
		System.out.println(n.get(5f));
	}

	@Test
	public void testImage() throws Exception
	{
		BufferedImage bufferedImage = new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);

		Noise n = new Noise();
		n.applyModifier(new ModSphere().setCenterX(320f).setCenterY(240f).setRadius(200f).setVolatility(0.2f));

		float g;
		for (int x = 0; x < 640; x++) {
			for (int y = 0; y < 480; y++) {
				g = n.get(x, y);
				bufferedImage.setRGB(x, y, new Color(g, g, g).getRGB());
			}

		}

		File outFile = new File("image.png");
		ImageIO.write(bufferedImage, "png", outFile);
	}

}