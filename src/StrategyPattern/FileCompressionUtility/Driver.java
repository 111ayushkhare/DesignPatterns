package strategy.filecompressionutils;


import strategy.filecompressionutils.enums.CompressionModes;


public class Driver {
	public static void main(String[] args) {
		CompressionContext compressionContext = new CompressionContext();

		// Zip Compression 
		compressionContext.executeCompress(CompressionModes.ZIP, "JINN.pdf");
		compressionContext.executeDecompress(CompressionModes.ZIP, "JINN.zip");

		// Bzip2 Compression 
		compressionContext.executeCompress(CompressionModes.BZIP2, "Garisons.csv");
		compressionContext.executeDecompress(CompressionModes.BZIP2, "Garisons.bzip2");

		// Invalid decompression
		compressionContext.executeDecompress(CompressionModes.PNG, "ABC.java");
	}
}