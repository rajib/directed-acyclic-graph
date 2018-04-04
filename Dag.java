
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Dag {
    public static void main(String[] args) {
        int intArray[][] = {{0,1},{0,2},{1,3},{1,5},{2,5},{6,2}};
        List<DagPath> dagPathList = new ArrayList<>();

        System.out.println("DAG - directed acyclic graph paths for the following data!");
        System.out.println(Arrays.deepToString(intArray));
        System.out.println();

        for(int i = 0; i < intArray.length; i++){
            int e[] = intArray[i];

            for(int j = 0; j < intArray.length; j++){
                int f[] = intArray[j];

                if (((e[0] == f[0]) || (e[1] == f[0])) && (e != f)){ // compare between array element for match
                    if (e[1] == f[0]) { // check if both the array having common values in the middle like 1223, 0225 like that
                        DagPath dagPath = new DagPath();
                        dagPath.setVal1(e[0]);
                        dagPath.setVal2(e[1]);
                        dagPath.setVal3(f[1]);
                        dagPathList.add(dagPath);
                    }
                }
            }
        }

        for (Iterator<DagPath> i = dagPathList.iterator(); i.hasNext();) {
            DagPath dagPath = i.next();
            System.out.println(dagPath.getVal1() + "->" + dagPath.getVal2() + "->" + dagPath.getVal3());
        }

        System.out.println(dagPathList.size()); // Total Node count
    }

    private static class DagPath {
        private int val1;
        private int val2;
        private int val3;

        public void setVal1(int val1) {
            this.val1 = val1;
        }

        public void setVal2(int val2) {
            this.val2 = val2;
        }

        public void setVal3(int val3) {
            this.val3 = val3;
        }

        public int getVal1() {
            return val1;
        }

        public int getVal2() {
            return val2;
        }

        public int getVal3() {
            return val3;
        }
    }
}