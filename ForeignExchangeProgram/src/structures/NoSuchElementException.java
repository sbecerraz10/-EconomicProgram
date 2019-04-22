package structures;


public class NoSuchElementException extends Exception {
	
	public NoSuchElementException(String message) {
		super(message);
	}
	
	
//	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//	
//	ArrayList<Integer> solutions = new ArrayList<Integer>();
//	
//	int testCases;
//	try {
//		testCases = Integer.parseInt(reader.readLine());
//		int i = 0;
//		while(i < testCases) {
//			String []aux = reader.readLine().split(" ");
//			int num = Integer.parseInt(aux[0]);
//			int n = Integer.parseInt(aux[1]);
//			int [] arr = new int [n];
//			for (int j = 0; j < n; j++) {
//				arr[j] = Integer.parseInt(reader.readLine());
//			}
//			 
//			solutions.add(procesador1(arr,0,arr.length-1,num,Integer.MAX_VALUE));
//			i++;
//		}
//		for (int j = 0; j < solutions.size(); j++) {
//			System.out.println(solutions.get(j));
//		}
//	} catch (NumberFormatException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

	
//	try {
//		FileReader fr = new FileReader("files/Characters.txt");
//		BufferedReader br = new BufferedReader(fr);
//		String cadena = "";
//		while((cadena= br.readLine())!= null) {
//			String[] character = cadena.split(";");
//			int healt = Integer.parseInt(character[0]);
//			int power = Integer.parseInt(character[1]);
//			String name = character[2];
//			String image = character[3];
//			Character ch = new Character(healt,power,name,image);
//			saveCharacters(ch,this.headCharacter,null);
//		}
//		br.close();
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
}
