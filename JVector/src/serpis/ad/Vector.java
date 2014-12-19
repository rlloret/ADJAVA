package serpis.ad;

public class Vector {

	public static void main(String[] args) {

		int[] v=new int[] {4,7,3,9,45,21,12,2};
		int resultado = min(v);
		System.out.println(resultado);
		
	}

	public static int min(int[] v){
		int minimo=v[0];
		
		for(int i=1; i < v.length;i++){
			
			if(v[i] < minimo){
				minimo=v[i];
			}
			
		}
		return minimo;
	}
}
