#include <cstdio>
#include <algorithm>
#include <climits>

using namespace std;

/*
    Reverse Integer
*/

int reverse(int x) {
    int rev = 0, tmp = 0;

    while(x){
        tmp = rev * 10 + x % 10;
        if((tmp - x % 10) / 10 != rev)
            return 0;
        rev = tmp;
        x /= 10;
    }

    return rev;
}