
/*
this is a simple implementation of Quick Find disjoint set
it just focused on integers and made indexes of an array items
 */

import java.util.HashSet;
import java.util.Iterator;

public class disjointSetQF extends disjointSet{

    public disjointSetQF(){
        this(10);
    }

    public disjointSetQF(int size){
        super(size);
    }



    public void connect(int x, int y){
        isInputValid(x);
        isInputValid(y);

        if(isConnected(x, y)){
            System.out.println("these two elements are already connected. ");
            return;
        }
        int xSet = getSetNum(x);
        int ySet = getSetNum(y);

        if(xSet > ySet)     refactorGroups(xSet, ySet);
        else                refactorGroups(ySet, xSet);
    }

    /*
    check whether two elements are connected or not.
     */
    @Override
    public boolean isConnected(int x, int y){
        isInputValid(x);
        isInputValid(y);
        return getSetNum(x) == getSetNum(y);
    }

    /*
    return an iterable consists of all members of a group

    public Iterable<Integer> groupMembers(int groupNum){
        if(groupNum >= setNum || groupNum < 0)
            throw new IllegalArgumentException("your input group number is invalid !");
        HashSet<Integer> result = new HashSet<>();
        for(int i = 0; i < size; i += 1)
            if(getSetNum(i) == groupNum)    result.add(i);
        return result;
    }
  */
    /*
    refactor those groups with larger group numbers than this prev group
    by adding -1, in order to keep small group numbers
    at the same time, total quantity of groups minus 1
     */

    /*
    private void refactorGroup(int prev, int newG){
        for(int i = 0; i < set.length; i += 1){
            if(getSetNum(i) == prev)    setNumber(i, newG);
        }
        for(int i = 0; i < set.length; i += 1)
            if(getSetNum(i) > prev)     setNumber(i, getSetNum(i) -1 );
        setNum -= 1;
    }

    private void setNumber(int index, int groupNum){
        set[index] = groupNum;
    }

    private int getSetNum(int item){
        return set[item];
    }

    private boolean checkValidInput(int x){
        return x >= 0 && x < setNum;
    } */
}
