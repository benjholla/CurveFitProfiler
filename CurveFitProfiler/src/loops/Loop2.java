package loops;

public class Loop2 {
	
	public static int run(int n){
		int c = 0;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=i; j++){
				c = c+1;
			}
		}
		return c;
	}

}
