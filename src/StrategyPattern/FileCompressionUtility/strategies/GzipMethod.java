package strategy.filecompressionutils.strategies;


public class GzipMethod implements CompressionStrategy {
	@Override
	public void compress(String fileName) {
		System.out.println(fileName + " compressed using GZIP algorithm");
	}

	@Override
	public void decompress(String fileName) {
		System.out.println(fileName + " decompressed using GZIP algorithm");
	}
}
