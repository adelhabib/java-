package com.phase1_project;

import com.phase1_projec.tMyLinkedListImple.node;

public class MyLinkedListImple {
	
	node head = null;
    static class node {
        String val;
        node next;
        public node(String val)
        {
            this.val = val;
        }
    }

    node sortedMerge(node a, node b)
    {
        node result = null;
        if (a == null) return b;
        if (b == null) return a;

        if ( (a.val).compareToIgnoreCase(b.val)   < 0) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    node mergeSort(node h)
    {
        if (h == null || h.next == null) {
            return h;
        }
        node middle = getMiddle(h);
        node nextofmiddle = middle.next;
        middle.next =  null;
        node left   =  mergeSort(h);
        node right  =  mergeSort(nextofmiddle);
        node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }
    public static node getMiddle(node head)
    {
        if (head == null)
            return head;
        node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    void push(String new_data)
    {
        node new_node = new node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList(node headref)
    {
        while (headref != null) {
            System.out.print(headref.val + "\n");
            headref = headref.next;
        }
    }
    
    static node middleNode(node start, node last)
    {
        if (start == null)
            return null;
 
        node slow = start;
        node fast = start.next;
 
        while (fast != last)
        {
            fast = fast.next;
            if (fast != last)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    
    static String binarySearch(node head, String value)
    {
    	node start = head;
    	node last = null;
        do
        {
        	node mid = middleNode(start, last);
        	
            if (mid == null) return null;
            if ( ((mid.val).compareTo(value))  == 0 )
                return mid.val;
 
            else if ((mid.val).compareTo(value) < 0)
            {
                start = mid.next;
            }
 
            else
                last = mid;
        } while (last == null || last != start);
 
        return null;
    }

}

