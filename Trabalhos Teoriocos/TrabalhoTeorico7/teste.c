#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define MAXTAM 100

int main(void)
{
    // int *x1 ;
    // int x2 ;
    // int *x3 ;
    // x1 = (int *)malloc(sizeof(int));
    // printf("\nx1(%p)(%d)(%p) x2(%d)(%p) )", x1, *x1, &x1, x2, &x2);
    //*x1 = 20;
    // printf("\nx1(%p)(%d)(%p) x2(%d)(%p) x3(%p)(%d)(%p)", x1, *x1, &x1, x2, &x2, x3, *x3, &x3);
    // x2 = *x1;
    // printf("\nx1(%p)(%d)(%p) x2(%d)(%p) x3(%p)(%d)(%p)", x1, *x1, &x1, x2, &x2, x3, *x3, &x3);
    // *x3 = x2 * *x1;
    // printf("\nx1(%p)(%d)(%p) x2(%d)(%p) x3(%p)(%d)(%p)", x1, *x1, &x1, x2, &x2, x3, *x3, &x3);
    // x3 = &x2;
    // printf("\nx1(%p)(%d)(%p) x2(%d)(%p) x3(%p)(%d)(%p)", x1, *x1, &x1, x2, &x2, x3, *x3, &x3);
    // x2 = 15;
    // printf("\nx1(%p)(%d)(%p) x2(%d)(%p) x3(%p)(%d)(%p)", x1, *x1, &x1, x2, &x2, x3, *x3, &x3);

    double M[3][3];
    double *p = M[0];
    for (int i = 0; i < pow(MAXTAM, 2); i++, p++)
    {
        *p = 0.0;
    }
    return 0;
}