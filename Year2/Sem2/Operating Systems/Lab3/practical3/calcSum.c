#include <stdio.h>

int main()
{
    int array[10], sum = 0;
    for (int i = 0; i < 10; i++) {
        array[i] = i*i;
        sum += array[i];
        printf("%d\n", array[i]);
    }
    printf("Sum: %d\n", sum);
    return 0;
}
