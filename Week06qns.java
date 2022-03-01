import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Week06qns {
    public void addAndSort(LinkedList<Integer> list, int value) {
        System.out.println("LinkedList before addAndSort: \n" + Arrays.toString(list.toArray()));
        list.addLast(value);
        Collections.sort(list);
        System.out.println("LinkedList after addAndSort: \n" + Arrays.toString(list.toArray()));
    }

    public void addAndSortHash(HashMap<Integer, Integer> map, int value) {
        System.out.println("Hashmap before addAndSort: ");
        for (int i = 0; i < map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println("\nHashmap after addAndSort: ");
        map.put(map.size(), value);
        List<Integer> sorted = new ArrayList<Integer>(map.values());
        Collections.sort(sorted);
        for (int i = 0; i < map.size(); i++) {
            map.put(i, sorted.get(i));
            System.out.print(map.get(i) + " ");
        }
        System.out.println("");
    }

    public void swapValues(LinkedList<Integer> list, int firstIndex, int secondIndex) {
        int ele1 = list.get(firstIndex);
        int ele2 = list.get(secondIndex);
        list.set(firstIndex, ele2);
        list.set(secondIndex, ele1);
        System.out.println("LinkedList swapValues at index " + firstIndex + " and " + secondIndex + ": \n"  + Arrays.toString(list.toArray()));
    }

    public void swapValuesHash(HashMap<Integer, Integer> map, int firstIndex, int secondIndex) {
        int ele1 = map.get(firstIndex);
        int ele2 = map.get(secondIndex);
        map.put(firstIndex, ele2);
        map.put(secondIndex, ele1);
        System.out.println("Hashmap swapValues at index " + firstIndex + " and " + secondIndex + ": ");
        for (int i = 0; i < map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println("");
    }

    public int findValue(LinkedList<Integer> list, int searchVal) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == searchVal) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int findValueHash(HashMap<Integer, Integer> map, int searchVal) {
        int index = -1;
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i) == searchVal) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(1, 3, 5, 7, 9, 11));
        Week06qns wk = new Week06qns();
        wk.addAndSort((LinkedList<Integer>) list, 6);
        wk.swapValues((LinkedList<Integer>) list, 1, 5);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 3);
        map.put(2, 5);
        map.put(3, 7);
        map.put(4, 9);
        map.put(5, 11);
        wk.addAndSortHash(map, 6);
        wk.swapValuesHash(map, 1, 5);

        List<Integer> randlist = new LinkedList<Integer>();
        HashMap<Integer, Integer> randMap = new HashMap<>();
        int randNo;
        int randValToSearch = ThreadLocalRandom.current().nextInt(1000, 9999+1);

        for (int i = 0; i < 500; i++) {
            randNo = ThreadLocalRandom.current().nextInt(1000, 9999+1);
            randlist.add(randNo);
            randMap.put(i, randNo);
        }
        System.out.println("Index of random value in linked list: " + wk.findValue((LinkedList<Integer>) randlist, randValToSearch));
        System.out.println("Index of random value in hash map: " + wk.findValueHash(randMap, randValToSearch));
    }
}
