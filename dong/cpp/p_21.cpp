#include <cstdio>

using namespace std;

/*
    Merge Two Sorted Lists
*/

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode *mergeTwoLists(ListNode *l1, ListNode *l2)
{
    if (!l1)
        return l2;
    if (!l2)
        return l1;
    ListNode *p1 = l1, *p2 = l2, *p3, *nh = NULL;
    // nh = p1->val<p2<val? p1->val: p2->val;
    if (p1->val < p2->val)
    {
        nh = new ListNode(p1->val);
        p1 = p1->next;
    }
    else
    {
        nh = new ListNode(p2->val);
        p2 = p2->next;
    }

    p3 = nh;
    while (p1 && p2)
    {
        if (p1->val < p2->val)
        {
            ListNode *tmp = new ListNode(p1->val);
            p3->next = tmp;
            p3 = p3->next;
            p1 = p1->next;
        }
        else
        {
            ListNode *tmp = new ListNode(p2->val);
            p3->next = tmp;
            p3 = p3->next;
            p2 = p2->next;
        }
    }

    if (p1)
        p3->next = p1;
    if (p2)
        p3->next = p2;
    return nh;
}