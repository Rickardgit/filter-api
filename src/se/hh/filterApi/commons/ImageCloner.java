package se.hh.filterApi.commons;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public final class ImageCloner {

	public BufferedImage clone(BufferedImage image) {
		ColorModel colorModel = image.getColorModel();
		boolean isAlphaPremultiplied = colorModel.isAlphaPremultiplied();
		WritableRaster imageRaster = image.getRaster();
		WritableRaster newRaster = image.copyData(imageRaster.createCompatibleWritableRaster());
		return new BufferedImage(colorModel, newRaster, isAlphaPremultiplied, new Hashtable<>());
	}
}
