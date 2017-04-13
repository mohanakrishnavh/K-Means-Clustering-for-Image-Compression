/**
 *
 * @author Mohanakrishna
 */
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class KMeans 
{
	public static void main(String[] args) 
	{
		if (args.length < 2) 
		{
			System.out.println("Usage: Kmeans <input-image> <k>");
			return;
		}
		try {
			double bytes,kilobytes,input_image_size = 0.0,output_image_size = 0.0;
			BufferedImage inputImage = ImageIO.read(new File(args[0]));
			int k = Integer.parseInt(args[1]);
			String outputImage = args[0].substring(0, args[0].length() - 4) + "_output_k" + args[1]+ args[0].substring(args[0].length() - 4, args[0].length());
			System.out.println("Original Image:" + args[0]);
			System.out.println("Output Image:" + outputImage);
			
			BufferedImage kmeansJpg = kmeans_helper(inputImage, k);
			ImageIO.write(kmeansJpg, "jpg", new File(outputImage));
			
			File input_file = new File(args[0]);
			if(input_file.exists())
			{

				bytes = input_file.length();
				input_image_size = (bytes / 1024);
				//input_image_size = (kilobytes / 1024);
			}
			System.out.println("Input Image size: " + input_image_size+" KB");
			
			File output_file = new File(outputImage);
			if(output_file.exists())
			{

				bytes = output_file.length();
				output_image_size = (bytes / 1024);
				//input_image_size = (kilobytes / 1024);
			}
			System.out.println("Output Image size: " + output_image_size+" KB");
			double comp_ratio = 100 - ((output_image_size/input_image_size)*100);
			System.out.println("Compression Ratio : " +comp_ratio);
			
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	private static BufferedImage kmeans_helper(BufferedImage inputImage, int k) 
	{
		int width = inputImage.getWidth();
		int height = inputImage.getHeight();
		System.out.println("Image width:\t" + width);
		System.out.println("Image height:\t" + height);
		BufferedImage kmeansImage = new BufferedImage(width, height, inputImage.getType());
		Graphics2D g = kmeansImage.createGraphics();
		g.drawImage(inputImage, 0, 0, width, height, null);
		// Read rgb values from the image
		int[] rgb = new int[width * height];
		int count = 0;
		for (int i = 0; i < width; i++) 
		{
			for (int j = 0; j < height; j++) 
			{
				rgb[count++] = kmeansImage.getRGB(i, j);
				//System.out.println(rgb);
			}
		}
		// Call kmeans algorithm: update the rgb values
		kmeans(rgb, k);

		// Write the new rgb values to the image
		count = 0;
		for (int i = 0; i < width; i++) 
		{
			for (int j = 0; j < height; j++) 
			{
				kmeansImage.setRGB(i, j, rgb[count++]);
			}
		}
		return kmeansImage;
	}
	
	private static void kmeans(int[] rgb, int k) 
	{
		int[] k_values = new int[k];
		Random rand = new Random();
		for (int i = 0; i < k_values.length; i++) 
		{
			int randomNum;
			boolean dupFlag = true;
			if (i == 0) 
			{
				randomNum = rand.nextInt(rgb.length);
				k_values[i] = rgb[randomNum];
			} 
			else 
			{
				do {
					randomNum = rand.nextInt(rgb.length);
					for (int j = 0; j < i; j++) 
					{
						if (j == i - 1 && k_values[j] != rgb[randomNum]) 
						{

							k_values[i] = rgb[randomNum];
							dupFlag = false;
						} 
						else if (k_values[j] == rgb[randomNum]) 
						{
							j = i;
						}
					}
				} while (dupFlag);
			}
			
		}

		int[] pixel_assignments = new int[rgb.length];
		int[] num_assignments = new int[k];

		// Cluster sums for current cluster values (represented by index)
		int[] alphaSum = new int[k];
		int[] redSum = new int[k];
		int[] greenSum = new int[k];
		int[] blueSum = new int[k];

		int max_iterations = 100;
		int num_of_iterations = 1;

		while (num_of_iterations <= max_iterations) 
		{
			for (int i = 0; i < k_values.length; i++) 
			{
				num_assignments[i] = 0;
				alphaSum[i] = 0;
				redSum[i] = 0;
				greenSum[i] = 0;
				blueSum[i] = 0;
			}

			// Checking all pixel values
			for (int i = 0; i < rgb.length; i++) 
			{
				double min_dist = Double.MAX_VALUE;
				int idx = 0;
				// compare instance's RGB value to each cluster point
				for (int j = 0; j < k_values.length; j++) 
				{
					int a_dist = (alpha(rgb[i]) - alpha(k_values[j]));
					int r_dist = (red(rgb[i]) - red(k_values[j]));
					int g_dist = (green(rgb[i]) - green(k_values[j]));
					int b_dist = (blue(rgb[i]) - blue(k_values[j]));
					double distance = Math.sqrt(a_dist * a_dist + r_dist * r_dist + g_dist * g_dist + b_dist * b_dist);
					if (distance < min_dist) {
						min_dist = distance;
						idx = j;
					}
				}
				
				// Assigning pixel to cluster
				pixel_assignments[i] = idx;
				num_assignments[idx]++;
				
				// Add pixel's individual argb values to respective sums
				alphaSum[idx] += alpha(rgb[i]);
				redSum[idx] += red(rgb[i]);
				greenSum[idx] += green(rgb[i]);
				blueSum[idx] += blue(rgb[i]);
			}

			// update previous assignments list
			for (int i = 0; i < k_values.length; i++) 
			{
				int avgAlpha = (int) ((double) alphaSum[i] / (double) num_assignments[i]);
				int avgRed = (int) ((double) redSum[i] / (double) num_assignments[i]);
				int avgGreen = (int) ((double) greenSum[i] / (double) num_assignments[i]);
				int avgBlue = (int) ((double) blueSum[i] / (double) num_assignments[i]);

				k_values[i] = ((avgAlpha & 0x000000FF) << 24) | ((avgRed & 0x000000FF) << 16) | ((avgGreen & 0x000000FF) << 8) | ((avgBlue & 0x000000FF) << 0);
			}
			num_of_iterations++;
		}

		// update RGB array
		for (int i = 0; i < rgb.length; i++) {
			rgb[i] = k_values[pixel_assignments[i]];
		}
	}
	
	//To get individual Red, Green, and Blue values
	public static int alpha(int pixel) 
	{
		return (pixel >> 24) & 0xFF;
	}
	
	public static int red(int pixel) 
	{
		return (pixel >> 16) & 0xFF;
	}
	
	public static int blue(int pixel) 
	{
		return pixel & 0xFF;
	}

	public static int green(int pixel) 
	{
		return (pixel >> 8) & 0xFF;
	}
}