#include <cstdio>

using namespace std;

/*
    Reverse Linked List
*/

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
ListNode* res1(ListNode* head);
ListNode* res2(ListNode* head);

ListNode* reverseList(ListNode* head) {
    if(!head) return NULL;
    // return res1(head);
    ListNode* ans = res2(head), *h = ans;
    while(h&&h->next&&h->next->next!=h) h = h->next;
    if(h->next) h->next->next = NULL;
    return ans;
    
}
    
ListNode* res1(ListNode* head){
    ListNode* l = head, *n = head->next;
    while(n){
        ListNode* tmp = n->next;
        n->next = l;
        l = n;
        n = tmp;
    }
    head->next = NULL;
    return l;
}
    
ListNode* res2(ListNode* head){
    if(!head->next)
        return head;
    ListNode* n = res2(head->next);
    ListNode* tmp = head->next;
    tmp->next = head;
    return n;
}