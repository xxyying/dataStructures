package com.xxyying.algoFB;

public class L021MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null || l2 == null) {
            return l1 == null ? l2: l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        if(l1 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        
        if(l2 != null) {
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        
       return dummy.next; 
    }
	
	//recursion
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(6);
		
		ListNode l2 = new ListNode(1);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(7);
		
		l1.next = a;
		a.next = b;
		b.next = c;
		
		l2.next = d;
		d.next = e;
		e.next = f;
		
		ListNode l3 = new ListNode(0);
		ListNode g = new ListNode(3);
		ListNode h = new ListNode(6);
		ListNode i = new ListNode(8);
		
		ListNode l4 = new ListNode(1);
		ListNode j = new ListNode(2);
		ListNode k = new ListNode(3);
		ListNode l = new ListNode(9);
		
		l3.next = g;
		g.next = h;
		h.next = i;
		
		l4.next = j;
		j.next = k;
		k.next = l;
			

		L021MergeTwoSortedLists test = new L021MergeTwoSortedLists();
		System.out.println("Solu 1: ");

		ListNode res1 = test.mergeTwoLists(l1, l2);
		while(res1 != null) {
			System.out.print(res1.val);
			res1 = res1.next;
		}
		System.out.println("");
		System.out.println("Solu 2: ");

		ListNode res2 = test.mergeTwoLists(l3, l4);
		while(res2 != null) {
			System.out.print(res2.val);
			res2 = res2.next;
		}

	}

}
