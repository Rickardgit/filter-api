package se.hh.filterApi.image;

public interface Image {

	Image clone();

	int getWidth();

	int getHeight();

	int getRGB(int x, int y);

	void setRGB(int i, int y, int tmp);

}
