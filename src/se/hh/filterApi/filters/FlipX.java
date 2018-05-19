package se.hh.filterApi.filters;

import se.hh.filterApi.Filter;
import se.hh.filterApi.image.Image;

public final class FlipX implements Filter {

	@Override
	public Image apply(Image image) {
		Image flippedImage = image.clone();

		int width = flippedImage.getWidth();
		int height = flippedImage.getHeight();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width / 2; x++) {
				int rgb = flippedImage.getRGB(x, y);
				flippedImage.setRGB(x, y, flippedImage.getRGB(width - 1 - x, y));
				flippedImage.setRGB(width - 1 - x, y, rgb);
			}
		}
		return flippedImage;
	}

}
