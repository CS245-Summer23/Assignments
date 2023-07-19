package Utils;

import java.util.*;
public class PQ<Item extends Comparable>{
    Comparator c;
    int heapSize;
    ArrayList<Item> heap;

    public PQ(){
        heapSize = 0;
        c = null;
        heap = new ArrayList<>();
        heap.add(null);
    }

    public void insert(Item value){
        heap.add(value);
        heapSize += 1;
        bubbleUp(heapSize);
    }

    public Item peek(){
        if(heapSize == 0){
            return null;
        }
        return heap.get(1);
    }

    public Item remove(){
        if(heapSize == 0){
            return null;
        }
        Item value = heap.get(1);
        heap.set(1, heap.get(heapSize));
        heap.remove(heapSize);
        heapSize -= 1;

        bubbleDown(1);
        return value;
    }

    public void bubbleUp(int nodeIdx){
        int parentIdx = nodeIdx / 2;
        if(parentIdx != 0){
            Item parentValue = heap.get(parentIdx);
            Item childValue = heap.get(nodeIdx);
            if(childValue.compareTo(parentValue) < 0){
                swap(nodeIdx, parentIdx);
                bubbleUp(parentIdx);
            }
        }
    }

    public void bubbleDown(int nodeIdx){
        int size = heapSize + 1;
        while(nodeIdx * 2 < size){
            int childIdx = 2 * nodeIdx;

            if(2 * nodeIdx + 1 < size){
                Item leftChild = heap.get(2 * nodeIdx);
                Item rightChild = heap.get(2 * nodeIdx + 1);
                if(leftChild.compareTo(rightChild) > 0){
                    childIdx = 2 * nodeIdx + 1;
                }
            }

            if(heap.get(nodeIdx).compareTo(heap.get(childIdx)) > 0){
                swap(nodeIdx, childIdx);
                nodeIdx = childIdx;
            } else {
                break;
            }
        }

    }

    public void swap(int a, int b){
        Item temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    public int size(){
        return heapSize;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int i = 1; i < 1 + heapSize; i ++){
            result.append(heap.get(i).toString());
            if(i < heapSize){
                result.append(",");
            }
        }
        return result.toString();
    }

}
