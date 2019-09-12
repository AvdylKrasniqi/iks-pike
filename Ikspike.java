import java.util.Scanner;
class Ikspike {

	String[][] tabela = new String[3][3]; 
	public boolean rendi = true;
	public boolean stillalive = true;
	public void toggleRendi(){
		rendi = !rendi; 
	}
	public boolean kushfitoj(){
		for(int i = 0; i < 3; i++){	
			if(tabela[i][0] == null)
				continue;
			else if(tabela[i][0] == tabela[i][1] && tabela[i][0] == tabela[i][2]){
				System.out.println("Lojtari me " + (rendi ? "X" : "O") + " ka fituar lojen");

				return true;
			}
		}
		for(int i = 0; i < 3; i++){	
			if(tabela[0][i] == null)
				continue;
			else if(tabela[0][i] == tabela[1][i] && tabela[0][i] == tabela[2][i]){
				System.out.println("Lojtari me " + (rendi ? "X" : "O") + " ka fituar lojen");
				return true;
			}
		}
		if(tabela[1][1] == null)
			return false;
		else if((tabela[0][0] == tabela[1][1] && tabela[0][0] ==  tabela[2][2]) || (tabela[0][2] == tabela[1][1] && tabela[0][2] == tabela[2][0])){
			System.out.println("Lojtari me " + (rendi ? "X" : "O") + " ka fituar lojen");
			return true;
		}
		else 
			return false;
	}
	public boolean kontrolloAKaVendTeLire(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(tabela[i][j] == null)
					return true;
			}
		}
		return false;
	}
	public void vendos(int x, int y){
		if(x < 3 && x >= 0 && y < 3 && y >= 0){
			
			if(tabela[x][y] == null){
				tabela[x][y] = rendi ? "X" : "O";
				if(!kushfitoj()) 
					toggleRendi();
				else
					stillalive = false;
			}
			else {
				System.out.println("Egziston nje vlere ne kete qeli. Ju lutem provoni nje tjeter");
			}
		}
		else {
			System.out.println("Nuk mundeni me vendos jashte kornizes");
		}
	}
	public void resetTabelen() {
		tabela	 = new String[3][3];
		stillalive = true;
	}
	public void shfaqLevizjet(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++) {
				System.out.print("[" + (tabela[i][j] == null ? " " : tabela[i][j]) + "]");
			}
			System.out.println(""); 
		}
	}
	public static void main(String[] args) {
		Scanner am = new Scanner(System.in);
		int x;
		int y;
		Ikspike loja = new Ikspike();
		while(true){
			loja.shfaqLevizjet();
			if(loja.kontrolloAKaVendTeLire() && loja.stillalive){
				System.out.println("Rendi per " + (loja.rendi ? "X" : "O"));
				System.out.println("Shtypni rreshtin: ");
				x = am.nextInt(); 
				System.out.println("Shtypni kolonen: ");
				y = am.nextInt(); 
				loja.vendos(x-1,y-1);
			}
			else {
				System.out.println("Loja ka perfunduar. Deshironi te luani edhe nje? PO/JO");
				String zgjedhja;
				zgjedhja = am.nextLine();
				if(zgjedhja == "JO")
					break;
				loja.resetTabelen();
			}
		}
	}
}
