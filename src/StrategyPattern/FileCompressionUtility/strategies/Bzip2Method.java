package strategy.filecompressionutils.strategies;


public class Bzip2Method implements CompressionStrategy {
	@Override
	public void compress(String fileName) {
		System.out.println(fileName + " compressed using BZIP2 algorithm");
	}

	@Override
	public void decompress(String fileName) {
		System.out.println(fileName + " decompressed using BZIP2 algorithm");
	}
}
