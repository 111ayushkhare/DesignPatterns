package strategy.filecompressionutils; 


import strategy.filecompressionutils.enums.CompressionModes;
import strategy.filecompressionutils.strategies.*;


class CompressionContext {
	private CompressionStrategy compressionStrategy; 

	private void setStrategy(CompressionStrategy compressionStrategy) {
		this.compressionStrategy = compressionStrategy; 
	}

	public void executeCompress(CompressionModes compressionMode, String fileName) {
		switch (compressionMode) {
			case CompressionModes.ZIP -> this.setStrategy(new ZipMethod());
			case CompressionModes.GZIP -> this.setStrategy(new GzipMethod());
			case CompressionModes.BZIP2 -> this.setStrategy(new Bzip2Method());
			default -> { 
				System.out.println("Invalid compression method"); 
				return;
			}
		}

		this.compressionStrategy.compress(fileName);
	}

	public void executeDecompress(CompressionModes decompressionMode, String fileName) {
		switch (decompressionMode) {
			case CompressionModes.ZIP -> this.setStrategy(new ZipMethod());
			case CompressionModes.GZIP -> this.setStrategy(new GzipMethod());
			case CompressionModes.BZIP2 -> this.setStrategy(new Bzip2Method());
			default -> { 
				System.out.println("Invalid decompression method"); 
				return;
			}
		}

		this.compressionStrategy.decompress(fileName);
	}
}