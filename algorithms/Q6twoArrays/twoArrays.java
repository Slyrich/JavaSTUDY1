package Q6twoArrays;

public class twoArrays{
	private int len;
	private int[] top, bottom;
	
	public twoArrays(int len){
		this.len = len;
		this.top = new int[len];
		this.bottom = new int[len];
		for(int i = 0; i < len; i++){
			this.top[i] = i;
			this.bottom[i] = 0;
		}

		
	}
	
	public int[] updateBottom(){
		boolean success = false;
		while(!success){
			success = true;
			for(int i : top){
				if(!(checkFrequency(i)==bottom[i])){
					bottom[i] = checkFrequency(i);
					success = false;
				}
			}	
		}
		return bottom;
	}
	
	private int checkFrequency(int top1){
		int counter = 0;
		for(int j : bottom){
			if(j == top1) counter++;			
		}
		return counter ;
		
	}
	
	public void printArray(){
		for(int i : top){
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i : bottom){
			System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args){
		twoArrays test = new twoArrays(14);
		// �㷨��ȱ�ݣ�n=5ʱ���н��2,1,2,0,0�ģ����½�������2�����ֵ�����������־��㲻����  
		test.printArray();
		test.updateBottom();
		System.out.println();
		System.out.println();
		test.printArray();

	}
	
}