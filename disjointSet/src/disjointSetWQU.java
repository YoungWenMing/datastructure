/*
implementation of disjoint set with weighted quick union
 */

public class disjointSetWQU extends disjointSet{
    private int[] setWeight;

    public disjointSetWQU(){
        super(10);
        initializeWeightArray(10);
    }

    public disjointSetWQU(int size){
        super(size);
        initializeWeightArray(size);
    }

    @Override
    public void connect(int x, int y) {

    }

    @Override
    public void refactorGroups(int prev, int newGroup){

    }

    @Override
    public String toString(){
        return "";
    }


    public int getFinalSetNum(int item){
        isInputValid(item);
        while(item != getSetNum(item))
            item = getSetNum(item);
        return item;
    }

    /*
    get the weight of a group which contains the item
     */
    private int getGroupWeight(int item){
        return setWeight[getSetNum(item)];
    }


    /*
    to initialize the weight array
     */
    private void initializeWeightArray(int size){
        setWeight = new int[size];
        for(int i =0; i< size; i += 1)
            setWeight[i] = 1;
    }
}
