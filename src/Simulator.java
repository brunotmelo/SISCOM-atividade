import java.util.Random;

import estimadores.Estimator;
import estimadores.LowerBoundEstimator;

public class Simulator {

	// classe vai simular as colisões das etiquetas e vai retornar
	// nova quantidade de etiquetas
	private int quantEtiquetas;
	private int quantSlots;
	
	private Estimator estimator;
	
	private int quantLeituras;
	
	 
	public Simulator(int quantEtiquetas, int quantSlots, ProtocoloEnum protocolo){
		this.quantEtiquetas = quantEtiquetas;
		this.quantSlots = quantSlots;
		switch(protocolo){
		case LOWER_BOUND: 
			estimator = new LowerBoundEstimator();
			break;
		}
		quantLeituras = 0;
	}
	
	public void simulateRead(){
		readAttempt();
		while(quantEtiquetas > 0){
			readAttempt();
		}
		System.out.println(quantLeituras);
	}
	
	// vai dar os randoms no array
	private void readAttempt(){
		int numReads = 0;
		int numCollisions = 0;
		int numEmpty = quantSlots;
		quantLeituras++;
		
		TimeSlot[] timeSlots = new TimeSlot[quantSlots];
		
		Random random = new Random();
		for(int i = 0; i< quantEtiquetas; i++){
			
			int selectedSlot = random.nextInt(quantSlots);
			
			TimeSlot selected = timeSlots[selectedSlot];
			if(selected == null){
				selected = new TimeSlot();
				timeSlots[selectedSlot] = selected;
				selected.read = true;
				numEmpty--;
				numReads++;
			}else{
				if(selected.read){
					if(!selected.collision){
						selected.collision = true;
						numCollisions++;
						numReads--;
					}
				}
			}
		}
		
		quantEtiquetas -= numReads;
		
		quantSlots = estimateNext(numReads, numCollisions, numEmpty);	
	}
	
	//funcao que utiliza metodos de estimação para
	//dizer quantos slots serão necessários na próxima leitura
	private int estimateNext(int numReads, int numCollisions, int numEmpty){
		int nextSlots = estimator.estimateEtiquetas(numReads, numCollisions);
		return nextSlots;
	}
	
	
	
	
}
