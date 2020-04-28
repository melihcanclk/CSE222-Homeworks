public class Main {
    public static void main(String[] args) {
        MaxHeap<AgeData> maxHeap = new MaxHeap<>();
        maxHeap.add(new AgeData(10));
        maxHeap.add(new AgeData(5));
        maxHeap.add(new AgeData(70));
        maxHeap.add(new AgeData(10));
        maxHeap.add(new AgeData(50));
        maxHeap.add(new AgeData(5));
        maxHeap.add(new AgeData(64));
        maxHeap.add(new AgeData(76));
        maxHeap.add(new AgeData(3));
        maxHeap.add(new AgeData(654));
        maxHeap.add(new AgeData(23));
        maxHeap.add(new AgeData(64));
        maxHeap.add(new AgeData(65));

        System.out.println(maxHeap);
        System.out.println(maxHeap.find(new AgeData(10)).toString());
    }
}
