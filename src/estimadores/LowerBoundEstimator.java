package estimadores;

public class LowerBoundEstimator implements Estimator{

	@Override
	public int estimateEtiquetas(int numReads, int numCollisions) {
		return numReads + (numCollisions*2);
	}

}
