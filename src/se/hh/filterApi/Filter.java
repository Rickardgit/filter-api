package se.hh.filterApi;

import se.hh.filterApi.image.Image;

@FunctionalInterface
public interface Filter {

	Image apply(Image image);

	default String getName() {
		return getClass().getSimpleName();
	}

}
