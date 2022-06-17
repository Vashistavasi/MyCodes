


import java.util.List;

public class GasStation {

}

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int n=A.size();
        int ans=-1;
       
        for(int i=0;i<n;i++){
            int fuel=0;
            int j=i;
            do{
                int a=j%n;
            fuel+=A.get(a);
            if(fuel<B.get(a)){
               fuel-=B.get(a);
                break;
            }
            else{
                fuel-=B.get(a);
            }
            j++;
            }while(j%n!=i);
            if(fuel>=0)
            return i;
        }
        return -1;
    }
