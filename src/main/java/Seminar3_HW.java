import org.example.Lectures;

public class Seminar3_HW {
    public static void main(String[] args) {
        int[] array1 = new int[]{89, 5, 2, 1, 89, 234, 23, 1, 65, 100};
        TwoLinkList twoLinkList = new TwoLinkList();
        for (int i = 0; i < array1.length; i++) {
            twoLinkList.addToHead(array1[i]);
        }
        twoLinkList.revert();
    }
    public static class TwoLinkList {
        private static class Node {
            private int value; // текущее значение
            private Node next;  // следующее значение
            private Node previous;
        }
        static Node head;   // начальный (корневой) элемент
        static Node tail;
        public static void addToHead(int value) {  // добавление элементов в начало списка
            Node newNode = new Node();
            newNode.value = value;
            if (head != null) {
                newNode.next = head;
                head.previous = newNode;
            }
            else { tail = newNode; }
            head = newNode;
        }
        public void revert(){
            Node currentNode = head;
            while (currentNode != null) {
                Node next =currentNode.next;
                Node previous = currentNode.previous;
                currentNode.next = previous;
                currentNode.previous = next;
                if (previous == null) {tail = currentNode;}
                if (next == null) {head = currentNode;}
                currentNode = next;
            }
        }
    }
}

