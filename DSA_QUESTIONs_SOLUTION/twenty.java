








/*With Space O(n)*/
/*solution:
class Solution {
    void rearrange(int arr[], int n) {
        int res[] = new int[arr.length];
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        for(int i=0;i<n;i++){
          if(arr[i] <0) l1.add(arr[i]);
          else l2.add(arr[i]);
          
            
        }
        //System.out.println(l1+""+l2);
        int j=0;
        Iterator<Integer> it1 = l1.iterator();
        Iterator<Integer> it2 = l2.iterator();
        while(it1.hasNext() && it2.hasNext()){
            res[j]=it2.next();
            res[j+1]=it1.next();
            j=j+2;
        }
        while(it2.hasNext()){
            res[j++]=it2.next();
        }
         while(it1.hasNext()){
            res[j++]=it1.next();
        }
        for(int i=0;i<n;i++){
            arr[i]=res[i];
        }
        
    }
}*/