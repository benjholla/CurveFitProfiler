package loops;

public class Loop4 {
	
	public static int run(int n){
		int c = 0;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=i; j++){
				for(int k=1; k<=j; k++){
					for(int l=1; l<=j; l++){
						c = c+1;
					}
				}
			}
		}
		return c;
	}
	
}
