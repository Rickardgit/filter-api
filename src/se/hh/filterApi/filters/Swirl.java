package se.hh.filterApi.filters;

import se.hh.filterApi.Filter;
import se.hh.filterApi.image.Image;

public final class Swirl implements Filter {

	@Override
	public Image apply(Image image) {
		Image swirledImage = image.clone();

		int height = swirledImage.getHeight();
		int width = swirledImage.getWidth();
		double x0 = 0.5 * (width - 1);
		double y0 = 0.5 * (height - 1);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				double dx = x - x0;
				double dy = y - y0;
				double r = Math.sqrt(dx * dx + dy * dy);
				double angle = Math.PI / 256 * r;
				int tx = (int) (+dx * Math.cos(angle) - dy * Math.sin(angle) + x0);
				int ty = (int) (+dx * Math.sin(angle) + dy * Math.cos(angle) + y0);

				if (tx >= 0 && tx < width && ty >= 0 && ty < height)
					swirledImage.setRGB(x, y, swirledImage.getRGB(tx, ty));
			}
		}
		return swirledImage;
	}

}
