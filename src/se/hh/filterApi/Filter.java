package se.hh.filterApi;

import java.awt.image.BufferedImage;

@FunctionalInterface
public interface Filter {

	BufferedImage apply(BufferedImage image);

	default String getName() {
		return getClass().getSimpleName();
	}

}
