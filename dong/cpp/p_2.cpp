#include <cstdio>

/*
    Add Two Numbers
*/

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

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
