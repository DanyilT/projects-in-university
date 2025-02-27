#include <stdio.h>

void printIterations(int n)
{
    for (int i = 1; i <= n; i++) {
        printf("This is iteration %d\n", i);
    }
}

int main()
{
    printIterations(20);
    printf("Goodbye\n");
    return 0;
}
