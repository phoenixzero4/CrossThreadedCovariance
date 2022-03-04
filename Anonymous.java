/**
 * Phoenix Mar. 4, 2022 
 *
 */

package february;

	interface Citrus{
		int totalCitrus(int lemons, int oranges, int grapefruits);
	}
	
public class Anonymous {
	
	public static void main(String[] args){
		Citrus citrusFruits = new Citrus(){
			
			// define the interface method
			@Override
			public int totalCitrus(int lemons, int oranges, int grapefruits){
			return (lemons + oranges + grapefruits); }};
		
			System.out.println(citrusFruits.totalCitrus(5,10, 28));
	}
	
}
