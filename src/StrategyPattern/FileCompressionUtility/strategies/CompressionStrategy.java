package strategy.filecompressionutils.strategies;


public interface CompressionStrategy {
	void compress(String fileName);
	void decompress(String fileName);
}
