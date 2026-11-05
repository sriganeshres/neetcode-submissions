/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* head1 = list1, *head2 = list2;
        if(!head1) return list2;
        if(!head2) return list1;
        ListNode dummy = ListNode(0), *tmp = &dummy;
        while(head1 && head2) {
            if(head1->val <= head2->val) {
                tmp->next = head1;
                head1 = head1->next;
            } else {
                tmp->next = head2;
                head2 = head2->next;
            }
            tmp = tmp->next;
        }
        if(head1) {
            tmp->next = head1;
        } 
        if(head2) {
            tmp->next = head2;
        }

        return dummy.next;
    }
};
