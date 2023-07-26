package linklist;

/**
 * @author 小宇
 * @date {2023}-{07}-{26}:{11:22}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 设计链表(单链表形式)
 */


public class t707 {
    int size;
    listNode head;
    public t707(){
        size = 0;
        head = new listNode(0);
    }
    public int get(int index) {
        if(index<0||index>=size){
            return -1;
        }
        listNode cur = head.next;
        while (index!=0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        listNode newNode = new listNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        listNode newNode = new listNode(val);
        newNode.next = null;
        listNode cur = head;
        while (cur.next!=null){
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index<0||index>size) return;
        listNode newNode = new listNode(val);
        listNode cur = head;
        while (index!=0){
            cur = cur.next;
            index--;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index<0||index>size-1) return;
        listNode cur = head;
        while (index!=0){
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
        size--;
    }
}
