#include <cstdio>

using namespace std;

/*
    Remove Nth Node From End of List
*/

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode *removeNthFromEnd(ListNode *head, int n)
{
    if (!head->next)
        return NULL;
    if (!head->next->next)
    {
        if (n == 1)
        {
            head->next = NULL;
            return head;
        }
        else
            return head->next;
    }

    ListNode *s = head, *p = head;
    while (n-- > 0)
        p = p->next;
    if (!p)
        return head->next;
    while (p->next)
    {
        s = s->next;
        p = p->next;
    }
    s->next = s->next->next;
    return head;
}