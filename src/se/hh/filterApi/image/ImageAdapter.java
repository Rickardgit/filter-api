package se.hh.filterApi.image;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public final class ImageAdapter implements Image {

	private final BufferedImage image;

	public ImageAdapter(BufferedImage image) {
		this.image = image;
	}

	@Override
	public Image clone() {
		ColorModel colorModel = image.getColorModel();
		boolean isAlphaPremultiplied = colorModel.isAlphaPremultiplied();
		WritableRaster imageRaster = image.getRaster();
		WritableRaster newRaster = image.copyData(imageRaster.createCompatibleWritableRaster());
		BufferedImage clone = new BufferedImage(colorModel, newRaster, isAlphaPremultiplied, new Hashtable<>());
		return new ImageAdapter(clone);
	}

	@Override
	public int getWidth() {
		return image.getWidth();
	}

	@Override
	public int getHeight() {
		return image.getHeight();
	}

	@Override
	public int getRGB(int x, int y) {
		return image.getRGB(x, y);
	}

	@Override
	public void setRGB(int x, int y, int rgb) {
		image.setRGB(x, y, rgb);
	}

	public BufferedImage getImage() {
		return image;
	}
}
