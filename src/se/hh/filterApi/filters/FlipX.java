package se.hh.filterApi.filters;

import java.awt.image.BufferedImage;

import se.hh.filterApi.Filter;
import se.hh.filterApi.commons.ImageCloner;

public final class FlipX implements Filter {

	@Override
	public BufferedImage apply(BufferedImage image) {
		BufferedImage flippedImage = new ImageCloner().clone(image);

		int width = flippedImage.getWidth();
		int height = flippedImage.getHeight();
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width / 2; x++) {
				int tmp = flippedImage.getRGB(x, y);
				flippedImage.setRGB(x, y, flippedImage.getRGB(width - 1 - x, y));
				flippedImage.setRGB(width - 1 - x, y, tmp);
			}
		return flippedImage;
	}

}
