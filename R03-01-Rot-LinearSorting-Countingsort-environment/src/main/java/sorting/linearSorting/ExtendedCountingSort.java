package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && !(array.length == 0 || 
				rightIndex >= array.length || leftIndex < 0 || array == null || rightIndex < 0)) {		
			
			int menor = searchMinor(array, leftIndex, rightIndex);
			int maior = searchBigger(array, leftIndex, rightIndex);
			
			Integer[] contador = counter(array, menor, maior, leftIndex, rightIndex);
			Integer[] acumulador = accumulate(contador);
		
			order(array, leftIndex, rightIndex, menor, acumulador);
		}
	}

	private int searchMinor(Integer[] array, int leftIndex, int rightIndex) {
		
		int menor = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] < menor) {
				menor = array[i];
			}
		}
		return menor;
	}
	
	
	private int searchBigger(Integer[] array, int leftIndex, int rightIndex) {
		
		int maior = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}

	
	private Integer[] counter(Integer[] array, int menor, int maior, int leftIndex, int rightIndex) {
		
		int tamanhoContador = maior - menor + 1;
		Integer[] contador = new Integer[tamanhoContador];
		for (int i = 0; i < contador.length; i++) {
			contador[i] = 0;
		}
		for (int i = leftIndex; i <= rightIndex; i++) {
			contador[array[i] - menor] += 1;
		}
		return contador;
	}
	
	
	private Integer[] accumulate(Integer[] array) {
		
		Integer[] acumulador = Arrays.copyOf(array, array.length);
		for (int i = 1; i < acumulador.length; i++) {
			acumulador[i] += acumulador[i-1];
		}
		return acumulador;
	}
	
	private void order(Integer[] array, int leftIndex, int rightIndex, int menor, Integer[] acumulador) {
		
		Integer[] copiaArray = Arrays.copyOf(array, array.length);
		for (int i = leftIndex; i <= rightIndex; i++) {
			int pos = acumulador[copiaArray[i] - menor];
			array[pos-1] = copiaArray[i];
			acumulador[copiaArray[i] - menor]--;
		}
	}

}
