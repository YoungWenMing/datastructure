
import java.util.HashSet;

public abstract class disjointSet {
     private int[] set;
     private int setNum;
     private int size;

     /*
     make the constructor protected that the
      */
    protected   disjointSet(int size){
        set = new int[size];
        this.size = size;
        setNum = size;
        for(int i = 0; i < size; i += 1)
            setNewGroup(i, i);
    }

    protected disjointSet(){
        this(10);
    }

    public abstract void connect(int x, int y);


    /*
    refactor those groups with larger group numbers than this prev group
    by adding -1, in order to keep small group numbers
    at the same time, total quantity of groups minus 1
     */
    public void refactorGroups(int prev, int newG){
        for(int i = 0; i < set.length; i += 1){
            if(getSetNum(i) == prev)    setNewGroup(i, newG);
        }
        for(int i = 0; i < set.length; i += 1)
            if(getSetNum(i) > prev)     setNewGroup(i, getSetNum(i) -1 );
        setNum -= 1;
    }

    public boolean isConnected(int x, int y){
        isInputValid(x);
        isInputValid(y);
        return getSetNum(x) == getSetNum(y);
    }


    private void setNewGroup(int item, int newGroup){
        set[item] = newGroup;
    }

    public int getSetNum(int item){
        isInputValid(item);
        return set[item];
    }

    public void isInputValid(int x){
        if(size <= x || x < 0)
            throw new IllegalArgumentException("invalid input! ");
    }

    public HashSet<Integer> groupSet(){
        HashSet<Integer> groups = new HashSet<>();
        for(int i =0; i < setNum; i += 1){
            groups.add(i);
        }
        return groups;
    }

    /*
    get all groups and their items inside HashSets in an array
     */
    private HashSet<Integer>[] getAllMembers(){
        HashSet<Integer>[] groups = new HashSet[setNum];
        for(int i = 0; i< size; i += 1){
            int x = getSetNum(i);
            if(groups[x] == null)
                groups[x] = new HashSet<>();
            groups[x].add(i);
        }
        return groups;
    }

    /*
    return a hashset of items in side group indexed "groupNum"
     */
    public HashSet<Integer> getGroupMembers(int groupNum){
        if(groupNum >= setNum || groupNum < 0)
            throw new IllegalArgumentException("no such group indexed " + groupNum + ", please input an valid number");
        return getAllMembers()[groupNum];
    }

    public String toString(){
        HashSet<Integer>[] groups = getAllMembers();
        String result = "";
        for(int i = 0; i < setNum; i += 1){
            result += "Group " + i + " :";
            for(int x : groups[i])
                result = result + " " + x;
            result += "\n";
        }
        return result;
    }
}
