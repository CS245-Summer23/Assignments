package lists;
import java.util.*;
public class SList<T extends Comparable> implements Iterable<T> {
    private static class ListNode<T extends Comparable>{
        T item;
        ListNode next;

        private ListNode(T value){
            this.item = value;
            this.next = null;
        }

        private ListNode(T value, ListNode next){
            this.item = value;
            this.next = next;
        }
    }

    private class SListIterator<T> implements Iterator<T>{
        ListNode runner;
        private SListIterator(ListNode first){
            runner = first;
        }
        public boolean hasNext(){
            return runner != null;
        }

        public T next(){
            T valToReturn = (T) runner.item;
            runner = runner.next;
            return valToReturn;
        }
    }

    ListNode sentinelNode;

    public SList(){
        sentinelNode = new ListNode(null);
    }
    public SList(T value){
        ListNode headNode = new ListNode(value);
        sentinelNode = new ListNode(null, headNode);
    }

    public void addFirst(T value){
        ListNode currentHead = sentinelNode.next;
        ListNode newheadNode = new ListNode(value, currentHead);
        sentinelNode.next = newheadNode;
    }

    public T getFirst(){
        if(sentinelNode.next == null){
            return null;
        }
        return (T) sentinelNode.next.item;
    }

    public void removeFirst(){
        if(sentinelNode.next == null){
            return;
        }
        ListNode currentHead = sentinelNode.next;
        ListNode newHead = currentHead.next;
        currentHead.next = null;
        sentinelNode.next = newHead;
    }

    public int size(){
        return size(sentinelNode.next);
    }

    private int size(ListNode node){
        if(node == null){
            return 0;
        }
        return 1 + size(node.next);
    }

    public boolean equals(Object other){
        if(!(other instanceof SList)){
            return false;
        } else if(this.size() != ((SList) other).size()){
            return false;
        }

        ListNode thisRunner = sentinelNode.next;
        ListNode otherRunner = ((SList) other).sentinelNode.next;
        while(thisRunner != null && otherRunner != null){
            if(!thisRunner.item.equals(otherRunner.item)){
                return false;
            }
            thisRunner = thisRunner.next;
            otherRunner = otherRunner.next;
        }
        return true;
    }
    public String toString(){
        StringBuilder stringRepr = new StringBuilder();
        ListNode runner = sentinelNode.next;
        while(runner != null){
            stringRepr.append(runner.item.toString());
            if(runner.next != null){
                stringRepr.append(",");
            }
            runner = runner.next;
        }
        return stringRepr.toString();
    }
    public void printList() {
        System.out.println(this.toString());
    }

    public SListIterator<T> iterator(){
        return new SListIterator<T>(this.sentinelNode.next);
    }

    // Question 2
    public void mergeNodes(){
        // TODO
    }

    // Question 3
    public static SList<Integer> linkedIntersection(SList s1, SList s2){
        // TODO
        return null;
    }


}

