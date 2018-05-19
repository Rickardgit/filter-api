package se.hh.filterApi.filters;

import java.awt.Color;

import se.hh.filterApi.Filter;
import se.hh.filterApi.image.Image;

public final class Grayscale implements Filter {

	@Override
	public Image apply(Image image) {
		Image grayscaledImage = image.clone();

		int width = grayscaledImage.getWidth();
		int height = grayscaledImage.getHeight();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color color = new Color(grayscaledImage.getRGB(j, i));
				int red = (int) (color.getRed() * 0.2126);
				int green = (int) (color.getGreen() * 0.7152);
				int blue = (int) (color.getBlue() * 0.0722);
				int grayscale = red + green + blue;
				Color newColor = new Color(grayscale, grayscale, grayscale);
				grayscaledImage.setRGB(j, i, newColor.getRGB());
			}
		}
		return grayscaledImage;
	}

}
