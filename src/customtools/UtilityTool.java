package customtools;



import java.awt.image.BufferedImage;

import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;


public class UtilityTool {
	
	public BufferedImage setImage(String fileName, int width, int height) {
		try{
		BufferedImage originalImage = ImageIO.read(getClass().getResourceAsStream(fileName));
		 return Thumbnails.of(originalImage)
		        .forceSize(width, height)
		        .asBufferedImage();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
//	public BufferedImage forceTransparentImage(String fileName, int width, int height) {
//		try{
//			BufferedImage originalImage = ImageIO.read(getClass().getResourceAsStream(fileName));
//			BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//			Graphics2D g2 = outputImage.createGraphics();
//			g2.drawImage(originalImage, 0, 0, width, height, null);
//			g2.dispose();
//			return outputImage;
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
}
