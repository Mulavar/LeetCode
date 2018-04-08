// Definition for singly-linked list.
#include <cstdio>

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


class Solution
{
  public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        int c = 0;
        ListNode *n1 = l1, *n2 = l2, *pre = NULL;
        while (n1 != NULL && n2 != NULL)
        {
            int tmp = n1->val + n2->val + c;
            n1->val = tmp % 10;
            c = tmp / 10;
            pre = n1;
            n1 = n1->next;
            n2 = n2->next;
        }
        if (n2 != NULL)
        {
            pre->next = n2;
            n1 = n2;
        }
        while (n1 != NULL)
        {
            int tmp = n1->val + c;
            n1->val = tmp % 10;
            c = tmp / 10;
            pre = n1;
            n1 = n1->next;
        }
        if (c != 0)
        {
            ListNode *node = new ListNode(c);
            pre->next = node;
        }
        return l1;
    }
};


int main(){
    Solution s;
    ListNode *l1 = new ListNode(2);
    ListNode *l2 = new ListNode(5);

    l1->next = new ListNode(4);
    l1->next->next = new ListNode(3);
    l2->next = new ListNode(6);
    l2->next->next = new ListNode(4);

    ListNode *ans = s.addTwoNumbers(l1, l2);
    ListNode *p = ans;
    while(p!=NULL){
        printf("%d", p->val);
        if(p->next!=NULL) printf("->");
        p = p->next;
    }
    printf("\n");
}
