
public class Main {

	private static ProtocoloEnum protocolo = ProtocoloEnum.LOWER_BOUND;
	private static int inicioEtiquetas = 100;
	private static int incrEtiquetas;
	private static int maxEtiquetas;
	//quantas vezes vai repetir para cada configuracao
	private static int numRepeticoes;
	private static int quadroInicial = 64;
	
	
	public static void main(String[] args){
		
		Simulator simulator = new Simulator(inicioEtiquetas, quadroInicial, protocolo);
		simulator.simulateRead();
		
//		//vao haver x simulações, cada simulação
//		for(int nEtiquetas = inicioEtiquetas; nEtiquetas<=maxEtiquetas; nEtiquetas = nEtiquetas+incrEtiquetas){
//			Simulator simulator = new Simulator();
//			simulator.simulate();
//			
//		}
		
	}
	
	
	
	
	
	
}
