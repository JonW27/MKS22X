public class RunningMedian{
	MyHeap max;
	MyHeap min;
	public RunningMedian(){
		max = new MyHeap();
		min = new MyHeap(false);
	}
	public void add(int num){
		//////////////////////
		if(max.size() > min.size() + 1){
			min.add(max.remove());
		}
		else if(min.size() > max.size() + 1){
			max.add(min.remove());
		}
		///////////////////////
		if(max.size() != 0 && num > getMedian()){
			min.add(num); 
		}
		else{
			max.add(num);
		}
		////////////////////////
		if(max.size() > min.size() + 1){
			min.add(max.remove());
		}
		else if(min.size() > max.size() + 1){
			max.add(min.remove());
		}
		System.out.println("MAX:"+max.toString());
		System.out.println("Min:"+min.toString());
	}
	public double getMedian(){
		if(max.size() > min.size()){
			return max.peek();
		}
		else if(min.size() > max.size()){
			return min.peek();
		}
		else{
			return (max.peek()+min.peek())/2;
		}
	}
}
