package estimadores;

public interface Estimator {
	//estimates the number of slots necessary for the next scan iteration
	
	int estimateEtiquetas(int numReads, int numCollisions);
}
