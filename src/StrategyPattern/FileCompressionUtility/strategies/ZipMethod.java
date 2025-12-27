package strategy.filecompressionutils.strategies;


public class ZipMethod implements CompressionStrategy {
	@Override
	public void compress(String fileName) {
		System.out.println(fileName + " compressed using ZIP algorithm");
	}

	@Override
	public void decompress(String fileName) {
		System.out.println(fileName + " decompressed using ZIP algorithm");
	}
}
