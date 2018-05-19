package se.hh.filterApi.filters;

import java.awt.Color;

import se.hh.filterApi.Filter;
import se.hh.filterApi.image.Image;

public final class Red implements Filter {

	@Override
	public Image apply(Image image) {
		Image redImage = image.clone();

		int width = redImage.getWidth();
		int height = redImage.getHeight();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color c = new Color(redImage.getRGB(j, i));
				int red = (int) (c.getRed());
				Color newColor = new Color(red, 0, 0);
				redImage.setRGB(j, i, newColor.getRGB());
			}
		}
		return redImage;
	}

}
